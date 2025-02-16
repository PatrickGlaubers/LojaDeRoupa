

package com.toedter.calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.MaskFormatter;


public class JTextFieldDateEditor extends JFormattedTextField implements IDateEditor,
		CaretListener, FocusListener, ActionListener {

	private static final long serialVersionUID = -8901842591101625304L;

	protected Date date;

	protected SimpleDateFormat dateFormatter;

	protected MaskFormatter maskFormatter;

	protected String datePattern;

	protected String maskPattern;

	protected char placeholder;

	protected Color darkGreen;
        
        protected Color normalColor;

	protected DateUtil dateUtil;

	private boolean isMaskVisible;

	private boolean ignoreDatePatternChange;

	private int hours;

	private int minutes;

	private int seconds;

	private int millis;

	private Calendar calendar;

	public JTextFieldDateEditor() {
		this(false, null, null, ' ');
	}

	public JTextFieldDateEditor(String datePattern, String maskPattern, char placeholder) {
		this(true, datePattern, maskPattern, placeholder);
	}

	public JTextFieldDateEditor(boolean showMask, String datePattern, String maskPattern,
			char placeholder) {
		dateFormatter = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM);
		dateFormatter.setLenient(false);

		setDateFormatString(datePattern);
		if (datePattern != null) {
			ignoreDatePatternChange = true;
		}

		this.placeholder = placeholder;

		if (maskPattern == null) {
			this.maskPattern = createMaskFromDatePattern(this.datePattern);
		} else {
			this.maskPattern = maskPattern;
		}

		setToolTipText(this.datePattern);
		setMaskVisible(showMask);

		addCaretListener(this);
		addFocusListener(this);
		addActionListener(this);
		darkGreen = new Color(0, 190, 0);

		calendar = Calendar.getInstance();

		dateUtil = new DateUtil();
                normalColor = (getForeground() != null) ? getForeground() : Color.BLACK;
	}

	
	public Date getDate() {
		try {
			calendar.setTime(dateFormatter.parse(getText()));
			calendar.set(Calendar.HOUR_OF_DAY, hours);
			calendar.set(Calendar.MINUTE, minutes);
			calendar.set(Calendar.SECOND, seconds);
			calendar.set(Calendar.MILLISECOND, millis);
			date = calendar.getTime();
		} catch (ParseException e) {
			date = null;
		}
		return date;
	}

	
	public void setDate(Date date) {
		setDate(date, true);
	}

	
	protected void setDate(Date date, boolean firePropertyChange) {
		Date oldDate = this.date;
		this.date = date;

		if (date == null) {
			setText("");
		} else {
			calendar.setTime(date);
			hours = calendar.get(Calendar.HOUR_OF_DAY);
			minutes = calendar.get(Calendar.MINUTE);
			seconds = calendar.get(Calendar.SECOND);
			millis = calendar.get(Calendar.MILLISECOND);

			String formattedDate = dateFormatter.format(date);
			try {
				setText(formattedDate);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
		if (date != null && dateUtil.checkDate(date)) {
			setForeground(normalColor);

		}

		if (firePropertyChange) {
			firePropertyChange("date", oldDate, date);
		}
	}
        
        public void setNormalColor(Color color) {
            this.normalColor = color;
        }

	
	public void setDateFormatString(String dateFormatString) {
		if (ignoreDatePatternChange) {
			return;
		}

		try {
			dateFormatter.applyPattern(dateFormatString);
		} catch (RuntimeException e) {
			dateFormatter = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM);
			dateFormatter.setLenient(false);
		}
		this.datePattern = dateFormatter.toPattern();
		setToolTipText(this.datePattern);
		setDate(date, false);
	}

	
	public String getDateFormatString() {
		return datePattern;
	}

	
	public JComponent getUiComponent() {
		return this;
	}

	
	public void caretUpdate(CaretEvent event) {
		String text = getText().trim();
		String emptyMask = maskPattern.replace('#', placeholder);

		if (text.length() == 0 || text.equals(emptyMask)) {
			setForeground(normalColor);
			return;
		}

		try {
			Date date = dateFormatter.parse(getText());
			if (dateUtil.checkDate(date)) {
				setForeground(darkGreen);
			} else {
				setForeground(Color.RED);
			}
		} catch (Exception e) {
			setForeground(Color.RED);
		}
	}

	
	public void focusLost(FocusEvent focusEvent) {
		checkText();
	}

	private void checkText() {
		try {
			Date date = dateFormatter.parse(getText());
			setDate(date, true);
		} catch (Exception e) {
					}
	}

	
	public void focusGained(FocusEvent e) {
	}

	
	public void setLocale(Locale locale) {
		if (locale == getLocale() || ignoreDatePatternChange) {
			return;
		}

		super.setLocale(locale);
		dateFormatter = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		setToolTipText(dateFormatter.toPattern());

		setDate(date, false);
		doLayout();
	}

	
	public String createMaskFromDatePattern(String datePattern) {
		String symbols = "GyMdkHmsSEDFwWahKzZ";
		String mask = "";
		for (int i = 0; i < datePattern.length(); i++) {
			char ch = datePattern.charAt(i);
			boolean symbolFound = false;
			for (int n = 0; n < symbols.length(); n++) {
				if (symbols.charAt(n) == ch) {
					mask += "#";
					symbolFound = true;
					break;
				}
			}
			if (!symbolFound) {
				mask += ch;
			}
		}
		return mask;
	}

	
	public boolean isMaskVisible() {
		return isMaskVisible;
	}

	
	public void setMaskVisible(boolean isMaskVisible) {
		this.isMaskVisible = isMaskVisible;
		if (isMaskVisible) {
			if (maskFormatter == null) {
				try {
					maskFormatter = new MaskFormatter(createMaskFromDatePattern(datePattern));
					maskFormatter.setPlaceholderCharacter(this.placeholder);
					maskFormatter.install(this);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	public Dimension getPreferredSize() {
		if (datePattern != null) {
			return new JTextField(datePattern).getPreferredSize();
		}
		return super.getPreferredSize();
	}

	
	public void actionPerformed(ActionEvent e) {
		checkText();
	}

	
	public void setEnabled(boolean b) {
		super.setEnabled(b);
		if (!b) {
			super.setBackground(UIManager.getColor("TextField.inactiveBackground"));
		}
	}

	
	public Date getMaxSelectableDate() {
		return dateUtil.getMaxSelectableDate();
	}

	
	public Date getMinSelectableDate() {
		return dateUtil.getMinSelectableDate();
	}

	
	public void setMaxSelectableDate(Date max) {
		dateUtil.setMaxSelectableDate(max);
		checkText();
	}

	
	public void setMinSelectableDate(Date min) {
		dateUtil.setMinSelectableDate(min);
		checkText();
	}

	
	public void setSelectableDateRange(Date min, Date max) {
		dateUtil.setSelectableDateRange(min, max);
		checkText();
	}

	
	public static void main(String[] s) {
		JFrame frame = new JFrame("JTextFieldDateEditor");
		JTextFieldDateEditor jTextFieldDateEditor = new JTextFieldDateEditor();
		jTextFieldDateEditor.setDate(new Date());
		frame.getContentPane().add(jTextFieldDateEditor);
		frame.pack();
		frame.setVisible(true);
	}
}

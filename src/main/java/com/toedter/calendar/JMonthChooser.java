
package com.toedter.calendar;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class JMonthChooser extends JPanel implements ItemListener,
		ChangeListener {
	private static final long serialVersionUID = -2028361332231218527L;

	
	protected boolean hasSpinner;

	private Locale locale;

	private int month;

	private int oldSpinnerValue = 0;

		private JDayChooser dayChooser;

	private JYearChooser yearChooser;

	private JComboBox comboBox;

	private JSpinner spinner;

	private boolean initialized;

	private boolean localInitialize;

	
	public JMonthChooser() {
		this(true);
	}

	
	public JMonthChooser(boolean hasSpinner) {
		super();
		setName("JMonthChooser");
		this.hasSpinner = hasSpinner;

		setLayout(new BorderLayout());

		comboBox = new JComboBox();
		comboBox.addItemListener(this);

				locale = Locale.getDefault();
		initNames();

		if (hasSpinner) {
			spinner = new JSpinner() {
				private static final long serialVersionUID = 1L;

				private JTextField textField = new JTextField();

				public Dimension getPreferredSize() {
					Dimension size = super.getPreferredSize();
					return new Dimension(size.width, textField
							.getPreferredSize().height);
				}
			};
			spinner.addChangeListener(this);
			spinner.setEditor(comboBox);
			comboBox.setBorder(new EmptyBorder(0, 0, 0, 0));
			updateUI();

			add(spinner, BorderLayout.WEST);
		} else {
			add(comboBox, BorderLayout.WEST);
		}

		initialized = true;
		setMonth(Calendar.getInstance().get(Calendar.MONTH));
	}

	
	public void initNames() {
		localInitialize = true;

		DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
		String[] monthNames = dateFormatSymbols.getMonths();

		if (comboBox.getItemCount() == 12) {
			comboBox.removeAllItems();
		}

		for (int i = 0; i < 12; i++) {
			comboBox.addItem(monthNames[i]);
		}

		localInitialize = false;
		comboBox.setSelectedIndex(month);
	}

	
	public void stateChanged(ChangeEvent e) {
		SpinnerNumberModel model = (SpinnerNumberModel) ((JSpinner) e
				.getSource()).getModel();
		int value = model.getNumber().intValue();
		boolean increase = (value > oldSpinnerValue) ? true : false;
		oldSpinnerValue = value;

		int month = getMonth();

		if (increase) {
			month += 1;

			if (month == 12) {
				month = 0;

				if (yearChooser != null) {
					int year = yearChooser.getYear();
					year += 1;
					yearChooser.setYear(year);
				}
			}
		} else {
			month -= 1;

			if (month == -1) {
				month = 11;

				if (yearChooser != null) {
					int year = yearChooser.getYear();
					year -= 1;
					yearChooser.setYear(year);
				}
			}
		}

		setMonth(month);
	}

	
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			int index = comboBox.getSelectedIndex();

			if ((index >= 0) && (index != month)) {
				setMonth(index, false);
			}
		}
	}

	
	private void setMonth(int newMonth, boolean select) {
		if (!initialized || localInitialize) {
			return;
		}

		int oldMonth = month;
		month = newMonth;

		if (select) {
			comboBox.setSelectedIndex(month);
		}

		if (dayChooser != null) {
			dayChooser.setMonth(month);
		}

		firePropertyChange("month", oldMonth, month);
	}

	
	public void setMonth(int newMonth) {
		if (newMonth < 0 || newMonth == Integer.MIN_VALUE) {
			setMonth(0, true);
		} else if (newMonth > 11) {
			setMonth(11, true);
		} else {
			setMonth(newMonth, true);
		}
	}

	
	public int getMonth() {
		return month;
	}

	
	public void setDayChooser(JDayChooser dayChooser) {
		this.dayChooser = dayChooser;
	}

	
	public void setYearChooser(JYearChooser yearChooser) {
		this.yearChooser = yearChooser;
	}

	
	public Locale getLocale() {
		return locale;
	}

	
	public void setLocale(Locale l) {
		if (!initialized) {
			super.setLocale(l);
		} else {
			locale = l;
			initNames();
		}
	}

	
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		comboBox.setEnabled(enabled);

		if (spinner != null) {
			spinner.setEnabled(enabled);
		}
	}

	
	public Component getComboBox() {
		return this.comboBox;
	}

	
	public Component getSpinner() {
				return spinner;
	}

	
	public boolean hasSpinner() {
		return hasSpinner;
	}

    
	public void setFont(Font font) {
		if (comboBox != null) {
			comboBox.setFont(font);
		}
		super.setFont(font);
	}

	
	public void updateUI() {
		final JSpinner testSpinner = new JSpinner();
		if (spinner != null) {
			if ("Windows".equals(UIManager.getLookAndFeel().getID())) {
				spinner.setBorder(testSpinner.getBorder());
			} else {
				spinner.setBorder(new EmptyBorder(0, 0, 0, 0));
			}
		}
	}

	
	public static void main(String[] s) {
		JFrame frame = new JFrame("MonthChooser");
		frame.getContentPane().add(new JMonthChooser());
		frame.pack();
		frame.setVisible(true);
	}
}
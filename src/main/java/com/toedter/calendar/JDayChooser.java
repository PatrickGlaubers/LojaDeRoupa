
package com.toedter.calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import kotlin.jvm.Synchronized;


public class JDayChooser extends JPanel implements ActionListener, KeyListener{
	private static final long serialVersionUID = 5876398337018781820L;

	protected JButton[] days;

	protected JButton[] weeks;

	protected JButton selectedDay;

	protected JPanel weekPanel;

	protected JPanel dayPanel;

	protected int day;

	protected Color oldDayBackgroundColor;

	protected Color selectedColor;

	protected Color sundayForeground;

	protected Color weekdayForeground;

	protected Color decorationBackgroundColor;

	protected String[] dayNames;

	protected Calendar calendar;

	protected Calendar today;

	protected Locale locale;

	protected boolean initialized;

	protected boolean weekOfYearVisible;

	protected boolean decorationBackgroundVisible = true;

	protected boolean decorationBordersVisible;

	protected boolean dayBordersVisible;

	private boolean alwaysFireDayProperty;

	protected int maxDayCharacters;

	protected List dateEvaluators;
	
	protected MinMaxDateEvaluator minMaxDateEvaluator;

	
	public JDayChooser() {
		this(false);
	}

	
	public JDayChooser(boolean weekOfYearVisible) {
		setName("JDayChooser");
		setBackground(Color.blue);

		dateEvaluators = new ArrayList(1);
		minMaxDateEvaluator = new MinMaxDateEvaluator();
		addDateEvaluator(minMaxDateEvaluator);

		this.weekOfYearVisible = weekOfYearVisible;
		locale = Locale.getDefault();
		days = new JButton[49];
		selectedDay = null;
		calendar = Calendar.getInstance(locale);
		today = (Calendar) calendar.clone();

		setLayout(new BorderLayout());

		dayPanel = new JPanel();
		dayPanel.setLayout(new GridLayout(7, 7));

		sundayForeground = new Color(164, 0, 0);
		weekdayForeground = new Color(0, 90, 164);

						decorationBackgroundColor = new Color(210, 228, 238);

		for (int y = 0; y < 7; y++) {
			for (int x = 0; x < 7; x++) {
				int index = x + (7 * y);

				if (y == 0) {
																				days[index] = new DecoratorButton();
				} else {
					days[index] = new JButton("x") {
						private static final long serialVersionUID = -7433645992591669725L;

						public void paint(Graphics g) {
							if ("Windows".equals(UIManager.getLookAndFeel()
									.getID()) && selectedDay == this) {
							
									g.setColor(selectedColor);
									g.fillRect(0, 0, getWidth(), getHeight());
								
							}
							super.paint(g);
						}

					};
					days[index].addActionListener(this);
					days[index].addKeyListener(this);
									}

				days[index].setMargin(new Insets(0, 0, 0, 0));
				days[index].setFocusPainted(false);
				dayPanel.add(days[index]);
			}
		}

		weekPanel = new JPanel();
		weekPanel.setLayout(new GridLayout(7, 1));
		weeks = new JButton[7];

		for (int i = 0; i < 7; i++) {
			weeks[i] = new DecoratorButton();
			weeks[i].setMargin(new Insets(0, 0, 0, 0));
			weeks[i].setFocusPainted(false);
			weeks[i].setForeground(new Color(100, 100, 100));

			if (i != 0) {
				weeks[i].setText("0" + (i + 1));
			}

			weekPanel.add(weeks[i]);
		}

		init();

		setDay(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		add(dayPanel, BorderLayout.CENTER);

		if (weekOfYearVisible) {
			add(weekPanel, BorderLayout.WEST);
		}

		initialized = true;
		updateUI();
	}

	
	protected void init() {
		JButton testButton = new JButton();
		oldDayBackgroundColor = testButton.getBackground();
		selectedColor = new Color(160, 160, 160);

		Date date = calendar.getTime();
		calendar = Calendar.getInstance(locale);
		calendar.setTime(date);

		drawDayNames();
		drawDays();
	}

	
	private void drawDayNames() {
		int firstDayOfWeek = calendar.getFirstDayOfWeek();
		DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
		dayNames = dateFormatSymbols.getShortWeekdays();

		int day = firstDayOfWeek;

		for (int i = 0; i < 7; i++) {
			if (maxDayCharacters > 0 && maxDayCharacters < 5) {
				if (dayNames[day].length() >= maxDayCharacters) {
					dayNames[day] = dayNames[day]
							.substring(0, maxDayCharacters);
				}
			}

			days[i].setText(dayNames[day]);

			if (day == 1) {
				days[i].setForeground(sundayForeground);
			} else {
				days[i].setForeground(weekdayForeground);
			}

			if (day < 7) {
				day++;
			} else {
				day -= 6;
			}
		}
	}

	
	protected void initDecorations() {
		for (int x = 0; x < 7; x++) {
			days[x].setContentAreaFilled(decorationBackgroundVisible);
			days[x].setBorderPainted(decorationBordersVisible);
			days[x].invalidate();
			days[x].repaint();
			weeks[x].setContentAreaFilled(decorationBackgroundVisible);
			weeks[x].setBorderPainted(decorationBordersVisible);
			weeks[x].invalidate();
			weeks[x].repaint();
		}
	}

	
	protected void drawWeeks() {
		Calendar tmpCalendar = (Calendar) calendar.clone();

		for (int i = 1; i < 7; i++) {
			tmpCalendar.set(Calendar.DAY_OF_MONTH, (i * 7) - 6);

			int week = tmpCalendar.get(Calendar.WEEK_OF_YEAR);
			String buttonText = Integer.toString(week);

			if (week < 10) {
				buttonText = "0" + buttonText;
			}

			weeks[i].setText(buttonText);

			if ((i == 5) || (i == 6)) {
				weeks[i].setVisible(days[i * 7].isVisible());
			}
		}
	}

	
	protected void drawDays() {
		Calendar tmpCalendar = (Calendar) calendar.clone();
		tmpCalendar.set(Calendar.HOUR_OF_DAY, 0);
		tmpCalendar.set(Calendar.MINUTE, 0);
		tmpCalendar.set(Calendar.SECOND, 0);
		tmpCalendar.set(Calendar.MILLISECOND, 0);

		int firstDayOfWeek = tmpCalendar.getFirstDayOfWeek();
		tmpCalendar.set(Calendar.DAY_OF_MONTH, 1);

		int firstDay = tmpCalendar.get(Calendar.DAY_OF_WEEK) - firstDayOfWeek;

		if (firstDay < 0) {
			firstDay += 7;
		}

		int i;

		for (i = 0; i < firstDay; i++) {
			days[i + 7].setVisible(false);
			days[i + 7].setText("");
		}

		tmpCalendar.add(Calendar.MONTH, 1);

		Date firstDayInNextMonth = tmpCalendar.getTime();
		tmpCalendar.add(Calendar.MONTH, -1);

		Date day = tmpCalendar.getTime();
		int n = 0;
		Color foregroundColor = getForeground();

		while (day.before(firstDayInNextMonth)) {
			days[i + n + 7].setText(Integer.toString(n + 1));
			days[i + n + 7].setVisible(true);

			if ((tmpCalendar.get(Calendar.DAY_OF_YEAR) == today
					.get(Calendar.DAY_OF_YEAR))
					&& (tmpCalendar.get(Calendar.YEAR) == today
							.get(Calendar.YEAR))) {
				days[i + n + 7].setForeground(sundayForeground);
			} else {
				days[i + n + 7].setForeground(foregroundColor);
			}

			if ((n + 1) == this.day) {
				days[i + n + 7].setBackground(selectedColor);
				selectedDay = days[i + n + 7];
			} else {
				days[i + n + 7].setBackground(oldDayBackgroundColor);
			}

			Iterator iterator = dateEvaluators.iterator(); 
			days[i + n + 7].setEnabled(true);
			while (iterator.hasNext()) {
				IDateEvaluator dateEvaluator = (IDateEvaluator) iterator.next();
				if (dateEvaluator.isSpecial(day)) {
					days[i + n + 7].setForeground(dateEvaluator
							.getSpecialForegroundColor());
					days[i + n + 7].setBackground(dateEvaluator
							.getSpecialBackroundColor());
					days[i + n + 7].setToolTipText(dateEvaluator.getSpecialTooltip());
					days[i + n + 7].setEnabled(true);
				} 
				if (dateEvaluator.isInvalid(day)){
					days[i + n + 7].setForeground(dateEvaluator
							.getInvalidForegroundColor());
					days[i + n + 7].setBackground(dateEvaluator
							.getInvalidBackroundColor());
					days[i + n + 7].setToolTipText(dateEvaluator.getInvalidTooltip());
					days[i + n + 7].setEnabled(false);
				}
			}

			n++;
			tmpCalendar.add(Calendar.DATE, 1);
			day = tmpCalendar.getTime();
		}

		for (int k = n + i + 7; k < 49; k++) {
			days[k].setVisible(false);
			days[k].setText("");
		}

		drawWeeks();
	}

	
	public Locale getLocale() {
		return locale;
	}

	
	public void setLocale(Locale locale) {
		if (!initialized) {
			super.setLocale(locale);
		} else {
			this.locale = locale;
			super.setLocale(locale);
			init();
		}
	}

	
	public void setDay(int d) {
		if (d < 1) {
			d = 1;
		}
		Calendar tmpCalendar = (Calendar) calendar.clone();
		tmpCalendar.set(Calendar.DAY_OF_MONTH, 1);
		tmpCalendar.add(Calendar.MONTH, 1);
		tmpCalendar.add(Calendar.DATE, -1);

		int maxDaysInMonth = tmpCalendar.get(Calendar.DATE);

		if (d > maxDaysInMonth) {
			d = maxDaysInMonth;
		}

		int oldDay = day;
		day = d;

		if (selectedDay != null) {
			selectedDay.setBackground(oldDayBackgroundColor);
			selectedDay.repaint();
		}

		for (int i = 7; i < 49; i++) {
			if (days[i].getText().equals(Integer.toString(day))) {
				selectedDay = days[i];
				selectedDay.setBackground(selectedColor);
				break;
			}
		}

		if (alwaysFireDayProperty) {
			firePropertyChange("day", 0, day);
		} else {
			firePropertyChange("day", oldDay, day);
		}
	}

	
	public void setAlwaysFireDayProperty(boolean alwaysFire) {
		alwaysFireDayProperty = alwaysFire;
	}

	
	public int getDay() {
		return day;
	}

	
	public void setMonth(int month) {
		calendar.set(Calendar.MONTH, month);
		int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		if (day > maxDays) {
			day = maxDays;
		}

		drawDays();
	}

	
	public void setYear(int year) {
		calendar.set(Calendar.YEAR, year);
		drawDays();
	}

	
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
		drawDays();
	}

	
	public void setFont(Font font) {
		if (days != null) {
			for (int i = 0; i < 49; i++) {
				days[i].setFont(font);
			}
		}
		if (weeks != null) {
			for (int i = 0; i < 7; i++) {
				weeks[i].setFont(font);
			}
		}
	}

	
	public void setForeground(Color foreground) {
		super.setForeground(foreground);

		if (days != null) {
			for (int i = 7; i < 49; i++) {
				days[i].setForeground(foreground);
			}

			drawDays();
		}
	}

	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String buttonText = button.getText();
		int day = new Integer(buttonText).intValue();
		setDay(day);
	}

	
	
	

	
	public void keyPressed(KeyEvent e) {
		int offset = verifyButtonsPressioneds(e);
                                                
		int newDay = getDay() + offset;

		if ((newDay >= 1)
				&& (newDay <= calendar.getMaximum(Calendar.DAY_OF_MONTH))) {
			setDay(newDay);
		}
	}
        
        public int verifyButtonsPressioneds(KeyEvent e){
            int offset;
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP -> {
                    offset = -7;
                    break;
                }
                case KeyEvent.VK_DOWN -> {
                    offset = +7;
                    break;
                }
                case KeyEvent.VK_LEFT -> {
                    offset = -1;
                    break;
                }
                case KeyEvent.VK_RIGHT -> {
                    offset = +1;
                    break;
                }
                default -> {
                    offset = 0;
                    break;
                }
            }
            return offset;
        }

	
	public void keyTyped(KeyEvent e) {
	}

	
	public void keyReleased(KeyEvent e) {
	}

	
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);

		for (short i = 0; i < days.length; i++) {
			if (days[i] != null) {
				days[i].setEnabled(enabled);
			}
		}

		for (short i = 0; i < weeks.length; i++) {
			if (weeks[i] != null) {
				weeks[i].setEnabled(enabled);
			}
		}
	}

	
	public boolean isWeekOfYearVisible() {
		return weekOfYearVisible;
	}

	
	public void setWeekOfYearVisible(boolean weekOfYearVisible) {
		if (weekOfYearVisible == this.weekOfYearVisible) {
			return;
		} else if (weekOfYearVisible) {
			add(weekPanel, BorderLayout.WEST);
		} else {
			remove(weekPanel);
		}

		this.weekOfYearVisible = weekOfYearVisible;
		validate();
		dayPanel.validate();
	}

	
	public JPanel getDayPanel() {
		return dayPanel;
	}

	
	public Color getDecorationBackgroundColor() {
		return decorationBackgroundColor;
	}

	
	public void setDecorationBackgroundColor(Color decorationBackgroundColor) {
		this.decorationBackgroundColor = decorationBackgroundColor;

		if (days != null) {
			for (int i = 0; i < 7; i++) {
				days[i].setBackground(decorationBackgroundColor);
			}
		}

		if (weeks != null) {
			for (int i = 0; i < 7; i++) {
				weeks[i].setBackground(decorationBackgroundColor);
			}
		}
	}

	
	public Color getSundayForeground() {
		return sundayForeground;
	}

	
	public Color getWeekdayForeground() {
		return weekdayForeground;
	}

	
	public void setSundayForeground(Color sundayForeground) {
		this.sundayForeground = sundayForeground;
		drawDayNames();
		drawDays();
	}

	
	public void setWeekdayForeground(Color weekdayForeground) {
		this.weekdayForeground = weekdayForeground;
		drawDayNames();
		drawDays();
	}

	
	public void setFocus() {
		if (selectedDay != null) {
			this.selectedDay.requestFocus();
		}
	}

	
	public boolean isDecorationBackgroundVisible() {
		return decorationBackgroundVisible;
	}

	
	public void setDecorationBackgroundVisible(
			boolean decorationBackgroundVisible) {
		this.decorationBackgroundVisible = decorationBackgroundVisible;
		initDecorations();
	}

	
	public boolean isDecorationBordersVisible() {
		return decorationBordersVisible;
	}

	public boolean isDayBordersVisible() {
		return dayBordersVisible;
	}

	
	public void setDecorationBordersVisible(boolean decorationBordersVisible) {
		this.decorationBordersVisible = decorationBordersVisible;
		initDecorations();
	}

	public void setDayBordersVisible(boolean dayBordersVisible) {
		this.dayBordersVisible = dayBordersVisible;
		if (initialized) {
			for (int x = 7; x < 49; x++) {
				if ("Windows".equals(UIManager.getLookAndFeel().getID())) {
					days[x].setContentAreaFilled(dayBordersVisible);
				} else {
					days[x].setContentAreaFilled(true);
				}
				days[x].setBorderPainted(dayBordersVisible);
			}
		}
	}

	
	public void updateUI() {
		super.updateUI();
		setFont(Font.decode("Dialog Plain 11"));

		if (weekPanel != null) {
			weekPanel.updateUI();
		}
		if (initialized) {
			if ("Windows".equals(UIManager.getLookAndFeel().getID())) {
				setDayBordersVisible(false);
				setDecorationBackgroundVisible(true);
				setDecorationBordersVisible(false);
			} else {
				setDayBordersVisible(true);
				setDecorationBackgroundVisible(decorationBackgroundVisible);
				setDecorationBordersVisible(decorationBordersVisible);
			}
		}
	}

	
	public void setSelectableDateRange(Date min, Date max) {
		minMaxDateEvaluator.setMaxSelectableDate(max);
		minMaxDateEvaluator.setMinSelectableDate(min);
		drawDays();
	}

	
	public Date setMaxSelectableDate(Date max) {
		Date maxSelectableDate = minMaxDateEvaluator.setMaxSelectableDate(max);
		drawDays();
		return maxSelectableDate;
	}

	
	public Date setMinSelectableDate(Date min) {
		Date minSelectableDate = minMaxDateEvaluator.setMinSelectableDate(min);
		drawDays();
		return minSelectableDate;
	}

	
	public Date getMaxSelectableDate() {
		return minMaxDateEvaluator.getMaxSelectableDate();
	}

	
	public Date getMinSelectableDate() {
		return minMaxDateEvaluator.getMinSelectableDate();
	}

	
	public int getMaxDayCharacters() {
		return maxDayCharacters;
	}

	
	public void setMaxDayCharacters(int maxDayCharacters) {
		if (maxDayCharacters == this.maxDayCharacters) {
			return;
		}

		if (maxDayCharacters < 0 || maxDayCharacters > 4) {
			this.maxDayCharacters = 0;
		} else {
			this.maxDayCharacters = maxDayCharacters;
		}
		drawDayNames();
		drawDays();
		invalidate();
	}

	
	public static void main(String[] s) {
		JFrame frame = new JFrame("JDayChooser");
		frame.getContentPane().add(new JDayChooser());
		frame.pack();
		frame.setVisible(true);
	}

	class DecoratorButton extends JButton {
		private static final long serialVersionUID = -5306477668406547496L;

		public DecoratorButton() {
			setBackground(decorationBackgroundColor);
			setContentAreaFilled(decorationBackgroundVisible);
			setBorderPainted(decorationBordersVisible);
		}

                @Override
		 public synchronized void addMouseListener(MouseListener l) {
		}

		public boolean isFocusable() {
			return false;
		}

		public void paint(Graphics g) {
			if ("Windows".equals(UIManager.getLookAndFeel().getID())) {
												if (decorationBackgroundVisible) {
					g.setColor(decorationBackgroundColor);
				} else {
					g.setColor(days[7].getBackground());
				}
				g.fillRect(0, 0, getWidth(), getHeight());
				if (isBorderPainted()) {
					setContentAreaFilled(true);
				} else {
					setContentAreaFilled(false);
				}
			}
			super.paint(g);
		}
	};

	public void addDateEvaluator(IDateEvaluator dateEvaluator) {
		dateEvaluators.add(dateEvaluator);
	}

	public void removeDateEvaluator(IDateEvaluator dateEvaluator) {
		dateEvaluators.remove(dateEvaluator);
	}
}


package com.toedter.calendar;

import com.toedter.components.JSpinField;

import java.util.Calendar;

import javax.swing.JFrame;



public class JYearChooser extends JSpinField {
	private static final long serialVersionUID = 2648810220491090064L;
	protected JDayChooser dayChooser;
    protected int oldYear;
    protected int startYear;
    protected int endYear;

    
    public JYearChooser() {
        setName("JYearChooser");
        Calendar calendar = Calendar.getInstance();
        dayChooser = null;
        setMinimum(calendar.getMinimum(Calendar.YEAR));
        setMaximum(calendar.getMaximum(Calendar.YEAR));
        setValue(calendar.get(Calendar.YEAR));
    }

    
    public void setYear(int y) {
        super.setValue(y, true, false);

        if (dayChooser != null) {
            dayChooser.setYear(value);
        }
        Integer valueConverted = value;
        spinner.setValue(value);
        firePropertyChange("year", oldYear, value);
        oldYear = value;
    }

    
    public void setValue(int value) {
        setYear(value);
    }

    
    public int getYear() {
        return super.getValue();
    }

    
    public void setDayChooser(JDayChooser dayChooser) {
        this.dayChooser = dayChooser;
    }

    
    public int getEndYear() {
        return getMaximum();
    }

    
    public void setEndYear(int endYear) {
        setMaximum(endYear);
    }

    
    public int getStartYear() {
        return getMinimum();
    }

    
    public void setStartYear(int startYear) {
        setMinimum(startYear);
    }

    
    static public void main(String[] s) {
        JFrame frame = new JFrame("JYearChooser");
        frame.getContentPane().add(new JYearChooser());
        frame.pack();
        frame.setVisible(true);
    }
}

package com.toedter.calendar;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class JSpinnerDateEditor extends JSpinner implements IDateEditor,
		FocusListener, ChangeListener {

	private static final long serialVersionUID = 5692204052306085316L;

	protected Date date;

	protected String dateFormatString;

	protected SimpleDateFormat dateFormatter;

	public JSpinnerDateEditor() {
		super(new SpinnerDateModel());
		dateFormatter = (SimpleDateFormat) DateFormat
				.getDateInstance(DateFormat.MEDIUM);
		((JSpinner.DateEditor) getEditor()).getTextField().addFocusListener(
				this);
		DateUtil dateUtil = new DateUtil();
		setMinSelectableDate(dateUtil.getMinSelectableDate());
		setMaxSelectableDate(dateUtil.getMaxSelectableDate());
		((JSpinner.DateEditor)getEditor()).getTextField().setFocusLostBehavior(JFormattedTextField.PERSIST);
		addChangeListener(this);
	}

	public Date getDate() {
		if (date == null) {
			return null;
		}
		return ((SpinnerDateModel) getModel()).getDate();
	}

	public void setDate(Date date) {
		setDate(date, true);
	}
	
	public void setDate(Date date, boolean updateModel) {
		Date oldDate = this.date;
		this.date = date;
		if (date == null) {
			((JSpinner.DateEditor) getEditor()).getFormat().applyPattern("");
			((JSpinner.DateEditor) getEditor()).getTextField().setText("");
		} else if (updateModel) {
			if (dateFormatString != null) {
				((JSpinner.DateEditor) getEditor()).getFormat().applyPattern(
						dateFormatString);
			}
			((SpinnerDateModel) getModel()).setValue(date);
		}
		firePropertyChange("date", oldDate, date);
	}

	public void setDateFormatString(String dateFormatString) {
		try {
			dateFormatter.applyPattern(dateFormatString);
		} catch (RuntimeException e) {
			dateFormatter = (SimpleDateFormat) DateFormat
					.getDateInstance(DateFormat.MEDIUM);
			dateFormatter.setLenient(false);
		}
		this.dateFormatString = dateFormatter.toPattern();
		setToolTipText(this.dateFormatString);

		if (date != null) {
			((JSpinner.DateEditor) getEditor()).getFormat().applyPattern(
					this.dateFormatString);
		} else {
			((JSpinner.DateEditor) getEditor()).getFormat().applyPattern("");
		}

		if (date != null) {
			String text = dateFormatter.format(date);
			((JSpinner.DateEditor) getEditor()).getTextField().setText(text);
		}
	}

	public String getDateFormatString() {
		return dateFormatString;
	}

	public JComponent getUiComponent() {
		return this;
	}

	public void setLocale(Locale locale) {
		super.setLocale(locale);
		dateFormatter = (SimpleDateFormat) DateFormat.getDateInstance(
				DateFormat.MEDIUM, locale);
		setEditor(new JSpinner.DateEditor(this, dateFormatter.toPattern()));
		setDateFormatString(dateFormatter.toPattern());
	}

	
	public void focusLost(FocusEvent focusEvent) {
		String text = ((JSpinner.DateEditor) getEditor()).getTextField()
				.getText();
		if (text.length() == 0) {
			setDate(null);
		}
	}

	
	public void focusGained(FocusEvent e) {
	}

	
	public void setEnabled(boolean b) {
		super.setEnabled(b);
		if (!b) {
			((JSpinner.DateEditor) getEditor()).getTextField().setBackground(
					UIManager.getColor("TextField.inactiveBackground"));
		}
	}

	
	public Date getMaxSelectableDate() {
		return (Date) ((SpinnerDateModel) getModel()).getEnd();
	}

	
	public Date getMinSelectableDate() {
		return (Date) ((SpinnerDateModel) getModel()).getStart();
	}

	
	public void setMaxSelectableDate(Date max) {
		((SpinnerDateModel) getModel()).setEnd(max);
	}

	
	public void setMinSelectableDate(Date min) {
		((SpinnerDateModel) getModel()).setStart(min);
	}

	
	public void setSelectableDateRange(Date min, Date max) {
		setMaxSelectableDate(max);
		setMinSelectableDate(min);
	}

	
	public void stateChanged(ChangeEvent e) {
		setDate(((SpinnerDateModel) getModel()).getDate(), false);
	}

    @Override
    public void setNormalColor(Color color) {
        throw new UnsupportedOperationException("Not supported yet.");     }

}

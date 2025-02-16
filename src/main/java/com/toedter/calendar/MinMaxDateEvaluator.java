package com.toedter.calendar;

import java.awt.Color;
import java.util.Date;

public class MinMaxDateEvaluator implements IDateEvaluator {

	private DateUtil dateUtil = new DateUtil();
	
	public boolean isSpecial(Date date) {
		return false;
	}

	public Color getSpecialForegroundColor() {
		return null;
	}

	public Color getSpecialBackroundColor() {
		return null;
	}

	public String getSpecialTooltip() {
		return null;
	}

	public boolean isInvalid(Date date) {
		return !dateUtil.checkDate(date);
	}

	public Color getInvalidForegroundColor() {
		return null;
	}

	public Color getInvalidBackroundColor() {
		return null;
	}

	public String getInvalidTooltip() {
		return null;
	}

	
	public Date setMaxSelectableDate(Date max) {
		return dateUtil.setMaxSelectableDate(max);
	}

	
	public Date setMinSelectableDate(Date min) {
		return dateUtil.setMinSelectableDate(min);
	}

	
	public Date getMaxSelectableDate() {
		return dateUtil.getMaxSelectableDate();
	}

	
	public Date getMinSelectableDate() {
		return dateUtil.getMinSelectableDate();
	}

}

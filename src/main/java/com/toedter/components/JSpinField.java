

package com.toedter.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class JSpinField extends JPanel implements ChangeListener, CaretListener, ActionListener,
		FocusListener {
	private static final long serialVersionUID = 1694904792717740650L;

	protected JSpinner spinner;

	
	protected JTextField textField;
	protected int min;
	protected int max;
	protected int value;
	protected Color darkGreen;

	
	public JSpinField() {
		this(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	
	public JSpinField(int min, int max) {
		super();
		setName("JSpinField");
		this.min = min;
		if (max < min)
			max = min;
		this.max = max;
		value = 0;
		if (value < min)
			value = min;
		if (value > max)
			value = max;

		darkGreen = new Color(0, 150, 0);
		setLayout(new BorderLayout());
		textField = new JTextField();
		textField.addCaretListener(this);
		textField.addActionListener(this);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBorder(BorderFactory.createEmptyBorder());
		textField.setText(Integer.toString(value));
		textField.addFocusListener(this);
		spinner = new JSpinner() {
			private static final long serialVersionUID = -6287709243342021172L;
			private JTextField textField = new JTextField();

			public Dimension getPreferredSize() {
				Dimension size = super.getPreferredSize();
				return new Dimension(size.width, textField.getPreferredSize().height);
			}
		};
		spinner.setEditor(textField);
		spinner.addChangeListener(this);
				add(spinner, BorderLayout.CENTER);
	}

	public void adjustWidthToMaximumValue() {
		JTextField testTextField = new JTextField(Integer.toString(max));
		int width = testTextField.getPreferredSize().width;
		int height = testTextField.getPreferredSize().height;
		textField.setPreferredSize(new Dimension(width, height));
		textField.revalidate();
	}

	
	public void stateChanged(ChangeEvent e) {
		SpinnerNumberModel model = (SpinnerNumberModel) spinner.getModel();
		int value = model.getNumber().intValue();
		setValue(value);
	}

	
	protected void setValue(int newValue, boolean updateTextField, boolean firePropertyChange) {
		int oldValue = value;
		if (newValue < min) {
			value = min;
		} else if (newValue > max) {
			value = max;
		} else {
			value = newValue;
		}

		if (updateTextField) {
			textField.setText(Integer.toString(value));
			textField.setForeground(Color.black);
		}

		if (firePropertyChange) {
			firePropertyChange("value", oldValue, value);
		}
	}

	
	public void setValue(int newValue) {
		setValue(newValue, true, true);
		spinner.setValue(new Integer(value));
	}

	
	public int getValue() {
		return value;
	}

	
	public void setMinimum(int newMinimum) {
		min = newMinimum;
	}

	
	public int getMinimum() {
		return min;
	}

	
	public void setMaximum(int newMaximum) {
		max = newMaximum;
	}

	
	public void setHorizontalAlignment(int alignment) {
		textField.setHorizontalAlignment(alignment);
	}

	
	public int getMaximum() {
		return max;
	}

	
	public void setFont(Font font) {
		if (textField != null) {
			textField.setFont(font);
		}
	}

	
	public void setForeground(Color fg) {
		if (textField != null) {
			textField.setForeground(fg);
		}
	}

	
	public void caretUpdate(CaretEvent e) {
		try {
			int testValue = Integer.valueOf(textField.getText()).intValue();

			if ((testValue >= min) && (testValue <= max)) {
				textField.setForeground(darkGreen);
				setValue(testValue, false, true);
			} else {
				textField.setForeground(Color.red);
			}
		} catch (Exception ex) {
			if (ex instanceof NumberFormatException) {
				textField.setForeground(Color.red);
			}

					}

		textField.repaint();
	}

	
	public void actionPerformed(ActionEvent e) {
		if (textField.getForeground().equals(darkGreen)) {
			setValue(Integer.valueOf(textField.getText()).intValue());
		}
	}

	
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		spinner.setEnabled(enabled);
		textField.setEnabled(enabled);
		
		if (!enabled) {
			textField.setBackground(UIManager.getColor("TextField.inactiveBackground"));
		}
	}

	
	public Component getSpinner() {
		return spinner;
	}

	
	public static void main(String[] s) {
		JFrame frame = new JFrame("JSpinField");
		frame.getContentPane().add(new JSpinField());
		frame.pack();
		frame.setVisible(true);
	}

	
	public void focusGained(FocusEvent e) {
	}

	
	public void focusLost(FocusEvent e) {
		actionPerformed(null);
	}
}
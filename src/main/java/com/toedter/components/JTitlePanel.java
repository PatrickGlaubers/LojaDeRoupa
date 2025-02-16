
package com.toedter.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;



public class JTitlePanel extends JPanel {
	private static final long serialVersionUID = 9104873267039717087L;
	protected JPanel northPanel;
    protected JLabel label;
    
    
    public JTitlePanel(String title, Icon icon, JComponent content, Border outerBorder) {
        setLayout(new BorderLayout());

        label = new JLabel(title, icon, JLabel.LEADING);
        label.setForeground(Color.WHITE);

        GradientPanel titlePanel = new GradientPanel(Color.BLACK);
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(label, BorderLayout.WEST);
        int borderOffset = 2;
        if(icon == null) {
        	borderOffset += 1;
        }
        titlePanel.setBorder(BorderFactory.createEmptyBorder(borderOffset, 4, borderOffset, 1));
        add(titlePanel, BorderLayout.NORTH);
        
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(content,BorderLayout.NORTH);
        northPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        add(northPanel, BorderLayout.CENTER);

        if (outerBorder == null) {
            setBorder(BorderFactory.createLineBorder(Color.GRAY));
        } else {
            setBorder(BorderFactory.createCompoundBorder(outerBorder,
                    BorderFactory.createLineBorder(Color.GRAY)));
        }
    }
  
    public void setTitle(String label, Icon icon) {
    	this.label.setText(label);
    	this.label.setIcon(icon);
    }
    
    private static class GradientPanel extends JPanel {
		private static final long serialVersionUID = -6385751027379193053L;

		private GradientPanel(Color background) {
            setBackground(background);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (isOpaque()) {
                                Color controlColor = new Color(165, 201, 215);
                                int width = getWidth();
                int height = getHeight();

                Graphics2D g2 = (Graphics2D) g;
                Paint oldPaint = g2.getPaint();
                g2.setPaint(new GradientPaint(0, 0, getBackground(), width, 0,
                        controlColor));
                g2.fillRect(0, 0, width, height);
                g2.setPaint(oldPaint);
            }
        }
    }
}

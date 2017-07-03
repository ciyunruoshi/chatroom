package com.TestServerSocketServer.view;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

import sun.swing.SwingUtilities2;

public class MyButtonUI extends BasicButtonUI {

	@Override
	public void paint(Graphics g, JComponent c) {
		// TODO Auto-generated method stub
		super.paint(g, c);
	}

	@Override
	protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
		// TODO Auto-generated method stub
		super.paintIcon(g, c, iconRect);
	}

	@Override
	protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
		// TODO Auto-generated method stub
		//super.paintText(g, c, textRect, text);
		AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();
        FontMetrics fm = SwingUtilities2.getFontMetrics(c, g);
        int mnemonicIndex = b.getDisplayedMnemonicIndex();

        /* Draw the Text */
        if(model.isEnabled()) {
            /*** paint the text normally */
//            g.setColor(b.getForeground());
        	g.setColor(Color.PINK);
            SwingUtilities2.drawStringUnderlineCharAt(c, g,text, mnemonicIndex,
                                          textRect.x + getTextShiftOffset(),
                                          textRect.y + fm.getAscent() + getTextShiftOffset());
        }
        else {
            /*** paint the text disabled ***/
            g.setColor(b.getBackground().brighter());
            SwingUtilities2.drawStringUnderlineCharAt(c, g,text, mnemonicIndex,
                                          textRect.x, textRect.y + fm.getAscent());
            g.setColor(b.getBackground().darker());
            SwingUtilities2.drawStringUnderlineCharAt(c, g,text, mnemonicIndex,
                                          textRect.x - 1, textRect.y + fm.getAscent() - 1);
        }
	}

	@Override
	protected void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) {
		// TODO Auto-generated method stub
		super.paintText(g, b, textRect, text);
	}

	@Override
	protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect,
			Rectangle iconRect) {
		// TODO Auto-generated method stub
		super.paintFocus(g, b, viewRect, textRect, iconRect);
	}

	@Override
	protected void paintButtonPressed(Graphics g, AbstractButton b) {
		// TODO Auto-generated method stub
		super.paintButtonPressed(g, b);
	}
	
}

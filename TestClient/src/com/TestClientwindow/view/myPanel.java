package com.TestClientwindow.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class myPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public myPanel() {

	}

	@Override
	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setColor(new Color(255, 255, 255, 140));
		g2d.fillRoundRect(3, 3, getWidth()-7, getHeight()-7, 20, 20);
		
		g2d.setColor(Color.white);
		g2d.setClip(0, 0, getWidth(), 30);
		g2d.fillRoundRect(3, 3, getWidth()-7, getHeight()-7, 20, 20);
		g2d.setClip(null);
		
		g2d.setColor(Color.darkGray);
		g2d.setStroke(new BasicStroke(6));
		g2d.drawRoundRect(3, 3, getWidth()-7, getHeight()-7, 20, 20);
		
		g2d.setFont(new Font("Arial", Font.BOLD, 16));
		g2d.setColor(Color.DARK_GRAY);
		g2d.drawString("please sign", 15, 24);
		
		
		
		
	}

	@Override
	protected void paintChildren(Graphics g) {
		// TODO Auto-generated method stub
		super.paintChildren(g);
	}

	@Override
	protected void paintBorder(Graphics g) {
		
		super.paintBorder(g);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}

	@Override
	public void paintImmediately(int x, int y, int w, int h) {
		// TODO Auto-generated method stub
		super.paintImmediately(x, y, w, h);
	}

	@Override
	public void paintImmediately(Rectangle r) {
		// TODO Auto-generated method stub
		super.paintImmediately(r);
	}
	

}

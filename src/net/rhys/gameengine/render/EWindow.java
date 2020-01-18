package net.rhys.gameengine.render;

import javax.swing.JFrame;

public class EWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public EWindow(String title, ECanvas c) {
		setResizable(false);
		setTitle(title);
		add(c);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	


}

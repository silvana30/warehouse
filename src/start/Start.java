package start;

import java.awt.EventQueue;

import java.util.logging.Logger;


import presentation.View;

public class Start {

	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

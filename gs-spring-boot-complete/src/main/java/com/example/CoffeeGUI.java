package com.example;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;



@SuppressWarnings({ "unused", "serial" })
public class CoffeeGUI extends JFrame implements ActionListener{

	private JFrame frame;
	private JLabel headLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private URL url;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeGUI window = new CoffeeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CoffeeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		
		//Designing the frame
		
		frame = new JFrame("Coffee machine controller");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		headLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		headLabel.setBounds(50, 50, 350, 40);
		statusLabel.setBounds(50, 300, 350, 40);
		headLabel.setText("Press button to toggle machine on and off");
		
		frame.add(headLabel);
		frame.add(statusLabel);
		frame.add(controlPanel);
		
		JButton btnNewButton = new JButton("Toggle");
		btnNewButton.setBounds(50, 150, 100, 30);
		btnNewButton.addActionListener(this);
		controlPanel.add(btnNewButton);
		
		JButton btn = new JButton("Status");
		btn.setBounds(100, 150, 100, 30);
		btn.addActionListener( new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				openCoffeePage("http://localhost:8080/isMachineOn");
			}
				});
		controlPanel.add(btn);
				
		
	}
	
	public void openCoffeePage(String url) {
		try {
			Desktop.getDesktop().browse(java.net.URI.create(url));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		openCoffeePage("http://localhost:8080/toggle");
		
	}



}

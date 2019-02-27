
package test;
import java.io.*;
import java.util.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

class MyWindow extends JFrame{
	// create window objects
	private JPanel panel;
	private JPanel buttonPanel;
	private JLabel label;
	private JTextField sumText;
	private JTextField inputText;
	private JButton sumButton, minusButton, multiButton, dividesButton, equalsButton, clearButton;
	private JButton [] nums;
	private int sum, lastUsed;
	private boolean reset, doubleEquals;
	private int lastAction = 0;
	
	public MyWindow() {
		// set basic structure of window
		setTitle("My Calculator");
		setSize(250,  250);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// instantiate window objects and accumulator
		label = new JLabel("Enter a number");
		inputText = new JTextField(10);
		sumButton = new JButton("+");
		minusButton = new JButton("-");
		multiButton = new JButton("*");
		dividesButton = new JButton("/");
		equalsButton = new JButton("=");
		clearButton = new JButton("C");
		
		nums = new JButton[10];
		panel = new JPanel();
		buttonPanel = new JPanel();
		sum = 0;
		int arr [] = new int[10];
		arr[0] = 7;
		arr[1] = 8;
		arr[2] = 9;
		arr[3] = 4;
		arr[4] = 5;
		arr[5] = 6;
		arr[6] = 1;
		arr[7] = 2;
		arr[8] = 3;
		arr[9] = 0;
		
		//set values of objects
		for (int i = 0; i < nums.length - 1; i++) {
			nums[i] = new JButton(Integer.toString(arr[i]));
			nums[i].addActionListener(new NumberButtonListener());
			buttonPanel.add(nums[i]);
		}
		buttonPanel.add(new JLabel());
		nums[nums.length-1] = new JButton("0");
		nums[nums.length-1].addActionListener(new NumberButtonListener());
		buttonPanel.add(nums[nums.length-1]);
		buttonPanel.setLayout(new GridLayout(4,3));
		
		// add action listeners
		sumButton.addActionListener(new AllButtonListener());
		minusButton.addActionListener(new AllButtonListener());
		multiButton.addActionListener(new AllButtonListener());
		equalsButton.addActionListener(new AllButtonListener());
		dividesButton.addActionListener(new AllButtonListener());
		clearButton.addActionListener(new AllButtonListener());
		
		
		
		// add objects to panel
		panel.add(label);
		panel.add(inputText);
		panel.add(sumButton);
		panel.add(minusButton);
		panel.add(multiButton);
		panel.add(dividesButton);
		panel.add(equalsButton);
		panel.add(clearButton);
		panel.setBackground(Color.LIGHT_GRAY);
		
		// add panel to window
		add(buttonPanel, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		
		// display window 
		setVisible(true);
	}
	
	class NumberButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int i = 0;
			boolean flag = false;
			if (reset)
				inputText.setText("");
			reset = false;
			while (i < nums.length && !flag) {
				if (e.getSource() == nums[i]) {
					flag = true;
					inputText.setText(inputText.getText() + nums[i].getText());
				}
				i++;
			}
	
		}
		
	}
	
	class AllButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			reset = true;
			if (e.getSource().equals(sumButton)) {
				lastAction = 1;
				if (sum == 0) {
					sum += Integer.parseInt(inputText.getText());
				}
				else if (doubleEquals) {
					inputText.setText("" + sum);
				}
				else {
					lastUsed = Integer.parseInt(inputText.getText());
					sum += lastUsed;
					inputText.setText("" + sum);
				}
				doubleEquals = false;
			}
			else if (e.getSource().equals(minusButton)) {
				lastAction = 2;
				if (sum == 0) {
					sum += Integer.parseInt(inputText.getText());
				}
				else if (doubleEquals) {
					inputText.setText("" + sum);
				}
				else {
					lastUsed = Integer.parseInt(inputText.getText());
					sum -= lastUsed;
					inputText.setText("" + sum);
				}
				doubleEquals = false;
			}
			else if (e.getSource().equals(multiButton)) {
				lastAction = 3;
				if (sum == 0)
					sum += Integer.parseInt(inputText.getText());
				else if (doubleEquals) {
					inputText.setText("" + sum);
				}
				else {
					lastUsed = Integer.parseInt(inputText.getText());
					sum *= lastUsed;
					inputText.setText("" + sum);
				}
				doubleEquals = false;
			}
			else if (e.getSource().equals(dividesButton)) {
				lastAction = 4;
				if (sum == 0)
					sum += Integer.parseInt(inputText.getText());
				else if (doubleEquals) {
					inputText.setText("" + sum);
				}
				else {
					lastUsed = Integer.parseInt(inputText.getText());
					sum /= lastUsed;
					inputText.setText("" + sum);
				}
				doubleEquals = false;
			}
			else if (e.getSource().equals(equalsButton)) {
				
				if (!doubleEquals) {
					lastUsed = Integer.parseInt(inputText.getText());
				}
				if (lastAction == 1)
					sum += lastUsed;
				else if (lastAction == 2)
					sum -= lastUsed;
				else if (lastAction == 3)
					sum *= lastUsed;
				else if (lastAction == 4)
					sum /= lastUsed;

				inputText.setText("" + sum);
				reset = true;
				doubleEquals = true;
			}
			
			else if (e.getSource().equals(clearButton)) {
				doubleEquals = false;
				reset = true;
				sum = 0;
				inputText.setText("" + sum);
			}
			
			
		}
	}
}

public class InClassGUI{
	public static void main(String[] args){
		MyWindow win = new MyWindow();
		
	}
	
}

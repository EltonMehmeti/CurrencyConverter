package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Start {

	private JFrame frame;
	private JTextField textField;
	private JComboBox startBox;
	private JComboBox endBOX;
	private JButton btnReset;
	private JButton btnConvert;
	private JButton btnExit;
	private JLabel lblResult;
	double result = 0.0;
	double input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
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
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.BLACK);
		frame.getContentPane().setForeground(Color.GREEN);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1124, 605);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Convert:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(428, 69, 56, 34);
		frame.getContentPane().add(lblNewLabel_1);
		// ketu useri vendos numrin
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.GRAY);
		textField.setText("--,--");
		textField.setBounds(486, 70, 145, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("to:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(889, 68, 39, 32);
		frame.getContentPane().add(lblNewLabel);
		
		startBox = new JComboBox();
		startBox.setForeground(Color.BLACK);
		startBox.setBackground(Color.LIGHT_GRAY);
		startBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "EUR", "USD", "POUND"}));
		startBox.setBounds(694, 70, 185, 34);
		frame.getContentPane().add(startBox);
		
		endBOX = new JComboBox();
		endBOX.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "EUR", "USD", "POUND"}));
		endBOX.setBounds(927, 67, 162, 33);
		frame.getContentPane().add(endBOX);
		
		lblResult = new JLabel("RESULT");
		lblResult.setForeground(Color.WHITE);
		lblResult.setBackground(Color.GREEN);
		lblResult.setBounds(729, 153, 125, 26);
		frame.getContentPane().add(lblResult);
		
		btnReset = new JButton("RESET");
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(0, 0, 51));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startBox.setSelectedIndex(0);
				endBOX.setSelectedIndex(0);
				lblResult.setText("0.00");
				textField.setText("--,--");
				
			}
		});
		btnReset.setBounds(512, 241, 136, 46);
		frame.getContentPane().add(btnReset);
		
		btnConvert = new JButton("CONVERT");
		btnConvert.setForeground(Color.WHITE);
		btnConvert.setBackground(new Color(0, 102, 0));
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btn pressed now convert
				try {
					input = Double.parseDouble(textField.getText());
					//
					if(startBox.getSelectedItem().equals("EUR")&& endBOX.getSelectedItem().equals("USD")) {
						result = input*1.0001;
						lblResult.setText("$"+result);
						
					}
					if(startBox.getSelectedItem().equals("USD") && endBOX.getSelectedItem().equals("EUR")) {
						result = input*0.83;
						lblResult.setText(result+"€");
					}
					if(startBox.getSelectedItem().equals("EUR")&&endBOX.getSelectedItem().equals("EUR")) {
						result = input*1.17;
						lblResult.setText(result+"pound");
					}
					if(startBox.getSelectedItem().equals("POUND")&&endBOX.getSelectedItem().equals("EUR")) {
						result = input*1.17;
						lblResult.setText(result+"€");
					}
					if(startBox.getSelectedItem().equals("EUR")&&endBOX.getSelectedItem().equals("POUND")) {
						result = input/1.15;
						lblResult.setText(result+"pound");
					}
					if(startBox.getSelectedItem().equals("USD")&&endBOX.getSelectedItem().equals("USD")) {
						lblResult.setText("Nalu nalu!");
					}
				}catch (Exception e1) {
					//
					JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage());
				}
			}
		});
		btnConvert.setBounds(715, 241, 125, 46);
		frame.getContentPane().add(btnConvert);
		
		btnExit = new JButton("EXIT");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.BLACK);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//tqet prej aplikacioni
				System.exit(0);
			}
		});
		btnExit.setBounds(916, 241, 125, 46);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\px\\Downloads\\conversion.png"));
		lblNewLabel_2.setBounds(10, 10, 533, 529);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("From:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(639, 72, 45, 32);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.WHITE);
		comboBox.setBounds(766, 265, 29, 21);
		frame.getContentPane().add(comboBox);
	}
}

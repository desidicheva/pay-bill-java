//Desislava Dicheva
//Date: 04/20/2014
//Project:The purpose of this assignment is to use Swing components to create a Java application with simple graphical user interface and event handling. 
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/*
 * PayBillGUI is the Frame where in the user enters
 * the amount, tip, tax and calculate the total
 * amount
 */

public class PayBillGUI extends JFrame {

	private JPanel contentPane;
	private JTextField amountField;
	private JTextField taxField;
	private JTextField tipField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayBillGUI frame = new PayBillGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PayBillGUI() {
		setBounds(100, 100, 226, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Total Due");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 22, 72, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblTaxRate = new JLabel("Tax Rate");
		lblTaxRate.setFont(new Font("Century", Font.PLAIN, 14));
		lblTaxRate.setBounds(10, 53, 72, 22);
		contentPane.add(lblTaxRate);
		
		JLabel lblTipRate = new JLabel("Tip Rate");
		lblTipRate.setFont(new Font("Century", Font.PLAIN, 14));
		lblTipRate.setBounds(10, 86, 72, 22);
		contentPane.add(lblTipRate);
		
		JLabel lblTotalOw = new JLabel("Total Owed");
		lblTotalOw.setFont(new Font("Century", Font.PLAIN, 14));
		lblTotalOw.setBounds(10, 119, 79, 22);
		contentPane.add(lblTotalOw);
		
		final JLabel label = new JLabel("$0.0");
		label.setFont(new Font("Century", Font.PLAIN, 14));
		label.setBounds(90, 119, 94, 22);
		contentPane.add(label);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String totalStr = calculateTotalAmount();
				label.setText("$" + totalStr);
			}
		});
		btnCalculate.setFont(new Font("Century", Font.PLAIN, 14));
		btnCalculate.setBounds(10, 152, 105, 23);
		contentPane.add(btnCalculate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Century", Font.PLAIN, 14));
		btnExit.setBounds(125, 152, 72, 23);
		contentPane.add(btnExit);
		
		amountField = new JTextField();
		amountField.setFont(new Font("Century", Font.PLAIN, 14));
		amountField.setBounds(92, 25, 53, 20);
		contentPane.add(amountField);
		amountField.setColumns(10);
		amountField.addFocusListener( new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				validate(amountField);
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		taxField = new JTextField();
		taxField.setFont(new Font("Century", Font.PLAIN, 14));
		taxField.setColumns(10);
		taxField.setBounds(92, 54, 53, 20);
		contentPane.add(taxField);
		
		taxField.addFocusListener( new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				validate(taxField);
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tipField = new JTextField();
		tipField.setFont(new Font("Century", Font.PLAIN, 14));
		tipField.setColumns(10);
		tipField.setBounds(92, 89, 53, 20);
		contentPane.add(tipField);
		
		tipField.addFocusListener( new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				validate(tipField);
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

	}
	
	public void validate(JTextField textField) {
		
		if( textField.getText() == null || textField.getText().trim().equals("") )
			return;
		
		try {
			double amt = Double.parseDouble( textField.getText() );
			if( amt < 0 ) {
				throw new InvalidAmountException("Please enter an amount greater than zero.");
			}
		} catch( NumberFormatException ex ){
			JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a valid amount.");
			textField.setText("");
		} catch( InvalidAmountException ex ){
			JOptionPane.showMessageDialog(this, ex.getMessage());
			textField.setText("");
			textField.requestFocus();
		}
	}
	
	public String calculateTotalAmount() {
		
		try {
			double amountDue = Double.parseDouble(amountField.getText());
			double tax = Double.parseDouble(taxField.getText());
			double tip = Double.parseDouble(tipField.getText());
			
			tax = ( amountDue / 100 ) * tax;
			tip = ( amountDue / 100 ) * tip;
			
			double total = amountDue + tip + tax;

			String totalStr = String.format("%.2f", total);
	
			return totalStr;
		} catch( Exception ex ){
			JOptionPane.showMessageDialog(this, "Please provide valid amount");
			return "0.0";
		}
	}
}

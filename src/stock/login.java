package stock;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 180, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:/Users/mss2015/eclipse-workspace/stock/IMG/images.jpg"));
		lblNewLabel.setBounds(207, 11, 168, 138);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(125, 182, 104, 21);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(125, 241, 83, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(240, 177, 241, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(240, 233, 241, 32);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:/Users/mss2015/eclipse-workspace/stock/IMG/480838868.jpg"));
		label.setBounds(0, 0, 584, 372);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=textField.getText();
				String Password= passwordField.getText();
				DBConnect dbc = new DBConnect();
				if(dbc.checkUserCredentials(Username, Password))
				{
					textField.setText(null);
					passwordField.setText(null);
					
					S so = new S();
					so.main(null);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"invalid login detail");
					textField.setText(null);
					passwordField.setText(null);
				}
				
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setIcon(new ImageIcon("C:/Users/mss2015/eclipse-workspace/stock/IMG/ok.jpg"));
		btnNewButton.setBounds(245, 290, 109, 37);
		contentPane.add(btnNewButton);
		
		
	}
}

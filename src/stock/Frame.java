package stock;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.util.concurrent.locks.*;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Button;

public class Frame extends JFrame {
	String msg= null;
	int Quantity=0;
	int quantity=0;
	private JPanel contentPane;
	Connection con = null;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public JLabel l1,l2,l3,l4,l5;
	
	static Frame frame = new Frame();
	/**
	 * Launch the application.
	 */
	public void fillcombobox()
	{
		try {
			DBConnect abc= new DBConnect();
		Connection con = abc.DBCon();
		Statement stmt3=con.createStatement();  
		ResultSet rs3=stmt3.executeQuery("select * from elec_status");  
		while(rs3.next())  
			{
			comboBox_1.addItem(rs3.getString(1));
			}
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItem = new JLabel("ITEM");
		lblItem.setBounds(10, 160, 93, 42);
		lblItem.setForeground(new Color(0, 0, 0));
		lblItem.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblItem);
		 
		
		
		JLabel lblRegistrationId = new JLabel("REG. ID ");
		lblRegistrationId.setBounds(10, 223, 80, 33);
		lblRegistrationId.setForeground(new Color(0, 0, 0));
		lblRegistrationId.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblRegistrationId);
		
		textField = new JTextField();
		textField.setBounds(101, 223, 183, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setBounds(10, 284, 93, 38);
		lblQuantity.setForeground(new Color(0, 0, 0));
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblQuantity);
		
		textField_1 = new JTextField();
		textField_1.setBounds(101, 289, 182, 32);
		contentPane.add(textField_1);
		
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(101, 164, 183, 38);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== comboBox_1)
				{
					JComboBox cb = (JComboBox)e.getSource();
						msg=(String)cb.getSelectedItem();
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
						LocalDate localDate = LocalDate.now();
						textField_2.setText(dtf.format(localDate));
						try {DBConnect dbc = new DBConnect();
						Connection con = dbc.DBCon();
							Statement stmt1=con.createStatement();  
							ResultSet rs5=stmt1.executeQuery("select * from elec_status where ITEM='"+msg+"' " );
				            String item=null;
							while(rs5.next()) {
							 item=rs5.getString(2);
				            System.out.println(item);}
							textField.setText(item);
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}

				}
			}
		});
		contentPane.add(comboBox_1);
		
		JLabel lblDate = new JLabel("DATE"); 
		lblDate.setBounds(8, 346, 82, 38);
		lblDate.setForeground(new Color(0, 0, 0));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblDate);
		
		JLabel label = new JLabel("");
		label.setBounds(185, 42, 1, 19);
		contentPane.add(label);
		
		textField_2 = new JTextField();
		textField_2.setBounds(101, 349, 182, 36);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblIssueTo = new JLabel("ISSUE to");
		lblIssueTo.setBounds(10, 100, 93, 38);
		lblIssueTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIssueTo.setForeground(new Color(0, 0, 0));
		contentPane.add(lblIssueTo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(101, 106, 183, 32);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 19, 142, 42);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
		S sub = new  S();
           	 frame.dispose();
         	   sub.setVisible(true);
			}
		});
		contentPane.add(btnBack);
		
		JLabel l1 = new JLabel("   ");
		l1.setFont(new Font("Tahoma", Font.BOLD, 16));
		l1.setBounds(448, 47, 101, 14);
		contentPane.add(l1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 83, 700, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(313, 11, 1, 552);
		contentPane.add(separator_1);
		
		JLabel l2 = new JLabel("       ");
		l2.setFont(new Font("Tahoma", Font.BOLD, 16));
		l2.setBounds(324, 100, 350, 19);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("");
		l3.setFont(new Font("Tahoma", Font.BOLD, 16));
		l3.setBounds(324, 139, 350, 14);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("");
		l4.setFont(new Font("Tahoma", Font.BOLD, 16));
		l4.setBounds(327, 175, 347, 14);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("");
		l5.setFont(new Font("Tahoma", Font.BOLD, 16));
		l5.setBounds(405, 223, 122, 14);
		contentPane.add(l5);
		
		Button button = new Button("ISSUE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
					try {
				DBConnect dbc = new DBConnect();
				Connection con = dbc.DBCon();
				Statement stmt1=con.createStatement(); 
				
				ResultSet rs5=stmt1.executeQuery("select * from elec_status where REGISTRATION_ID='"+textField.getText()+"' " );
	            while(rs5.next()) {
				 quantity=rs5.getInt(3);
	            }
	           
	           String text =textField_1.getText();
	           int Q=Integer.parseInt(text);
	           Quantity=quantity-Q;
	           if(Quantity >= 0)
	           {
				System.out.println(textField_1.getText()+"   "+ textField.getText());
	           String query ="Update elec_status set  QUANTITY='"+Quantity+"' ,	LAST_ISSUE_DATE='"+textField_2.getText()+"'  where 	REGISTRATION_ID='"+textField.getText()+"'" ;
	            System.out.println(query);
	            boolean rs1=stmt1.execute(query)  ;
	            System.out.println(rs1);
	            l1.setText("BILL ISSUE");
				l2.setText("NAME :               "+textField_3.getText());
				l3.setText("ITEM :                "+msg);
				l4.setText("QUANTITY :            "+text);
				l5.setText("THANK YOU");
				textField_1.setText(null);
            	textField_3.setText(null);
	           }
	           else 
	           {
	        	   JOptionPane.showMessageDialog(null,"we have "+quantity+" item");
	           }
	           con.close();
	            
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setForeground(Color.BLACK);
		button.setBounds(103, 421, 70, 22);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:/Users/mss2015/eclipse-workspace/stock/IMG/new-hire-forms-422x320-20170919.jpg"));
		label_1.setBounds(313, 0, 367, 511);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:/Users/mss2015/eclipse-workspace/stock/IMG/hfy.jpg"));
		label_2.setBounds(0, 0, 314, 511);
		contentPane.add(label_2);
		
	
		
		fillcombobox();
	}
}


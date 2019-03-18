package stock;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class purchase extends JFrame {

	/**
	 * 
	 */static purchase frame = new purchase();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox_1;
	String msg= null;
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
	public purchase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItem = new JLabel("ITEM");
		lblItem.setForeground(new Color(255, 255, 255));
		lblItem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblItem.setBounds(115, 95, 135, 45);
		contentPane.add(lblItem);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== comboBox_1)
				{
					JComboBox cb = (JComboBox)e.getSource();
						msg=(String)cb.getSelectedItem();
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
		comboBox_1.setBounds(478, 85, 332, 45);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(478, 168, 332, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRegId = new JLabel("REG. ID");
		lblRegId.setForeground(new Color(255, 255, 255));
		lblRegId.setBackground(Color.WHITE);
		lblRegId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegId.setBounds(115, 178, 123, 35);
		contentPane.add(lblRegId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(481, 259, 329, 45);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setForeground(new Color(255, 255, 255));
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQuantity.setBounds(115, 259, 145, 45);
		contentPane.add(lblQuantity);
		
		JButton btnPurchase = new JButton("PURCHASE");
		btnPurchase.setBackground(new Color(255, 255, 255));
		btnPurchase.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {try {
				DBConnect dbc = new DBConnect();
				Connection con = dbc.DBCon();
				Statement stmt1=con.createStatement(); 
				int quantity=0;
				ResultSet rs5=stmt1.executeQuery("select * from elec_status where REGISTRATION_ID='"+textField.getText()+"' " );
	            while(rs5.next()) {
				 quantity=rs5.getInt(3);
	            System.out.println(quantity);}
	           String text =textField_1.getText();
	           int Q=Integer.parseInt(text);
	           quantity=quantity+Q;
				System.out.println(textField_1.getText()+"   "+ textField.getText());
	           String query ="Update elec_status set  QUANTITY='"+quantity+"'  where 	REGISTRATION_ID='"+textField.getText()+"'" ;
	            System.out.println(query);
	            boolean rs1=stmt1.execute(query)  ;
	            System.out.println(rs1);
	            con.close();
	            JFrame frame1 = new JFrame();
	            JOptionPane.showMessageDialog(frame1, "Purchase load Successfully");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
					
				
			}
		});
		btnPurchase.setBounds(268, 346, 181, 50);
		contentPane.add(btnPurchase);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	S sub = new  S();
          	 frame.dispose();
        	   sub.setVisible(true);
			}
		});
		btnBack.setBounds(51, 25, 111, 33);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:/Users/mss2015/eclipse-workspace/stock/IMG/fghfddhfd.jpg"));
		lblNewLabel.setBounds(0, 0, 892, 509);
		contentPane.add(lblNewLabel);
		fillcombobox();
	}
}

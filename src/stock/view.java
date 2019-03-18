package stock;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class view extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnBack;
	static view frame = new view();
	private JLabel label;
	/**
	 * Launch the application.
	 */
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
	public view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 584);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 110, 880, 435);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			DBConnect dbc = new DBConnect();
		Connection con = dbc.DBCon();
			Statement stmt1=con.createStatement();  
			ResultSet rs1=stmt1.executeQuery("select * from elec_status"); 
			table.setModel(DbUtils.resultSetToTableModel(rs1));
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
		table = new JTable();
		table.setBounds(0, 110, 880, 435);
		contentPane.add(table);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				S sub = new  S();
				frame.dispose();
				sub.setVisible(true);
				
			}
		});
		btnBack.setBounds(48, 37, 117, 27);
		contentPane.add(btnBack);
		
		label = new JLabel("");
		label.setBounds(0, 0, 880, 545);
		contentPane.add(label);
	}

}

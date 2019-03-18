package stock;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;

public class S extends JFrame {
	
	static S frame = new S();
	private JPanel contentPane;

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
	public S() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(71, 132, 107, 41);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Current status");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(35, 202, 518, 58);
		contentPane.add(lblNewLabel);
		
		JButton btnView = new JButton("VIEW");
		btnView.setIcon(new ImageIcon("C:\\Users\\mss2015\\eclipse-workspace\\stock\\IMG\\download (1).jpg"));
		btnView.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view obj1 = new view();
				obj1.setVisible(true);
				 frame.dispose();
			}
		});
		btnView.setBounds(573, 210, 191, 58);
		contentPane.add(btnView);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:/Users/mss2015/eclipse-workspace/stock/IMG/is.jpg"));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame obj3 =new Frame();
				obj3.setVisible(true);
				 frame.dispose();
			}
		});

		btnNewButton.setBounds(573, 314, 191, 49);
		contentPane.add(btnNewButton);
		
		JLabel lblUpdate = new JLabel("ISSUE ");
		lblUpdate.setForeground(Color.WHITE);
		lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUpdate.setBounds(35, 303, 518, 58);
		contentPane.add(lblUpdate);
		
		JLabel lblPurchase = new JLabel("PURCHASE");
		lblPurchase.setForeground(new Color(255, 255, 255));
		lblPurchase.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPurchase.setBounds(35, 407, 518, 64);
		contentPane.add(lblPurchase);
		
		JButton btnPurchase = new JButton("");
		btnPurchase.setIcon(new ImageIcon("C:/Users/mss2015/eclipse-workspace/stock/IMG/pf.jpg"));
		btnPurchase.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				purchase ob = new purchase();
			   ob.setVisible(true);
			}
		});
		btnPurchase.setBounds(574, 398, 190, 49);
		contentPane.add(btnPurchase);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:/Users/mss2015/eclipse-workspace/stock/IMG/e5eed445262605.582afe49acac6.jpg"));
		lblNewLabel_1.setBounds(346, 11, 131, 101);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblWelcomeToArpeksha = new JLabel("WELCOME TO lego ELECTRONICS");
		lblWelcomeToArpeksha.setForeground(new Color(255, 0, 0));
		lblWelcomeToArpeksha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		lblWelcomeToArpeksha.setBounds(140, 76, 686, 139);
		contentPane.add(lblWelcomeToArpeksha);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:/Users/mss2015/eclipse-workspace/stock/IMG/download.jpg"));
		lblNewLabel_2.setBounds(0, -31, 848, 571);
		contentPane.add(lblNewLabel_2);
		
	
	}
}

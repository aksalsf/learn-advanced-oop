/*
 * Login Admin
 */

package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Config;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel loginPane;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 256);
		loginPane = new JPanel();
		loginPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(loginPane);
		loginPane.setLayout(null);
		
		JLabel labelUsername = new JLabel("Username");
		labelUsername.setBounds(52, 56, 80, 14);
		loginPane.add(labelUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(142, 53, 234, 20);
		loginPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setBounds(52, 98, 80, 14);
		loginPane.add(labelPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(142, 95, 234, 20);
		loginPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton buttonLogin = new JButton("Login");
		/*
		 * Mengatur action ketika tombol login dipencet
		 */
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/*
					 * Mengambil nilai dari text field
					 */
					String username = textFieldUsername.getText();
					String password = textFieldPassword.getText();
					
					/*
					 * Query untuk memeriksa apakah username & password ada di database
					 */
					String query = "SELECT * FROM tb_admin WHERE username = '"+ username +"' AND password = '" + password + "'";
					
					/*
					 * Memanggil koneksi dari file Config.java
					 */
					java.sql.Connection conn = (Connection) Config.configDB();
					
					/*
					 * Menjalankan query
					 */
					java.sql.Statement stm = conn.createStatement();
					java.sql.ResultSet result = stm.executeQuery(query);
					
					/*
					 * Memeriksa hasil query
					 */
					if (result.next()) {
						/*
						 * Jika username & password benar
						 */
						dispose(); // Menutup frame
						
						DasborUtama frame = new DasborUtama(); // Membuat object DasborUtama berdasarkan file DasborUtama.java
						frame.setVisible(true); // Menampilkan frame dari file DasborUtama.java
					} else {
						/*
						 * Jika username & password salah
						 */
						
						JOptionPane.showMessageDialog(null, "Username atau password salah!"); // Menampilkan pesan dialog
						// Mengosongkan textfield
						textFieldUsername.setText("");
						textFieldPassword.setText("");
					}
				} catch(SQLException e1) {
					/*
					 * Handling eror query
					 */
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		buttonLogin.setBounds(287, 137, 89, 23);
		loginPane.add(buttonLogin);
	}
}

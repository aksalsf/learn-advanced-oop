package jdbc.gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import jdbc.database.*;

public class FormInsertMahasiswa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormInsertMahasiswa frame = new FormInsertMahasiswa();
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
	public FormInsertMahasiswa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NIM");
		lblNewLabel.setBounds(21, 25, 46, 14);
		contentPane.add(lblNewLabel);
		
		JTextPane txtpnNim = new JTextPane();
		txtpnNim.setText("NIM");
		txtpnNim.setBounds(77, 22, 90, 20);
		contentPane.add(txtpnNim);
		
		JLabel lblNama = new JLabel("NAMA");
		lblNama.setBounds(21, 53, 46, 14);
		contentPane.add(lblNama);
		
		JTextPane txtpnNama = new JTextPane();
		txtpnNama.setText("NAMA");
		txtpnNama.setBounds(77, 50, 278, 20);
		contentPane.add(txtpnNama);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setBounds(21, 84, 46, 14);
		contentPane.add(lblGender);
		
		JLabel lblTtl = new JLabel("TTL");
		lblTtl.setBounds(21, 112, 46, 14);
		contentPane.add(lblTtl);
		
		JTextPane txtpnTTL = new JTextPane();
		txtpnTTL.setText("TTL");
		txtpnTTL.setBounds(77, 109, 278, 20);
		contentPane.add(txtpnTTL);
		
		JLabel lblAlamat = new JLabel("ALAMAT");
		lblAlamat.setBounds(21, 140, 46, 14);
		contentPane.add(lblAlamat);
		
		JTextPane txtpnAlamat = new JTextPane();
		txtpnAlamat.setText("ALAMAT");
		txtpnAlamat.setBounds(77, 137, 278, 64);
		contentPane.add(txtpnAlamat);
		
		JRadioButton rdbtnCowok = new JRadioButton("Cowok");
		rdbtnCowok.setBounds(77, 77, 90, 23);
		contentPane.add(rdbtnCowok);
		
		JRadioButton rdbtnCewek = new JRadioButton("Cewek");
		rdbtnCewek.setBounds(169, 77, 100, 23);
		contentPane.add(rdbtnCewek);
		
		JButton btnNewButton = new JButton("SIMPAN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nim = txtpnNim.getText();
				String nama = txtpnNama.getText();
				String alamat = txtpnAlamat.getText();
				String ttl = txtpnTTL.getText();
				if (rdbtnCowok.isSelected()) {
					String gender = rdbtnCowok.getText();
				}
				if (rdbtnCewek.isSelected()) {
					String gender = rdbtnCewek.getText();
				}
				MahasiswaData mhsData = new MahasiswaData();
				mhsData.UpdateMahasiswa(nim, nama, nama, ttl, alamat);
			}
		});
		btnNewButton.setBounds(266, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
}

package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Config;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormulirReservasi extends JFrame {

	private JPanel formulirPane;
	private JTextField textFieldNama;
	private JTextField textFieldKTP;
	private JTextField textFieldTelp;
	private JTextField textFieldEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormulirReservasi frame = new FormulirReservasi();
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
	public FormulirReservasi() {
		setTitle("FormulirReservasi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 437);
		formulirPane = new JPanel();
		formulirPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(formulirPane);
		formulirPane.setLayout(null);
		
		JLabel labelNama = new JLabel("Nama");
		labelNama.setBounds(24, 24, 90, 14);
		formulirPane.add(labelNama);
		
		textFieldNama = new JTextField();
		textFieldNama.setBounds(124, 21, 265, 20);
		formulirPane.add(textFieldNama);
		textFieldNama.setColumns(10);
		
		JLabel labelKTP = new JLabel("No. KTP");
		labelKTP.setBounds(24, 64, 90, 14);
		formulirPane.add(labelKTP);
		
		textFieldKTP = new JTextField();
		textFieldKTP.setBounds(124, 61, 265, 20);
		formulirPane.add(textFieldKTP);
		textFieldKTP.setColumns(10);
		
		JLabel labelTelp = new JLabel("No. Telp");
		labelTelp.setBounds(24, 106, 46, 14);
		formulirPane.add(labelTelp);
		
		textFieldTelp = new JTextField();
		textFieldTelp.setBounds(124, 103, 265, 20);
		formulirPane.add(textFieldTelp);
		textFieldTelp.setColumns(10);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(24, 148, 90, 14);
		formulirPane.add(labelEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(124, 145, 265, 20);
		formulirPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel labelAlamat = new JLabel("Alamat");
		labelAlamat.setBounds(24, 187, 90, 14);
		formulirPane.add(labelAlamat);
		
		JTextArea textAreaAlamat = new JTextArea();
		textAreaAlamat.setBounds(124, 182, 265, 56);
		formulirPane.add(textAreaAlamat);
		
		JLabel labelDurasi = new JLabel("Lama Kunjungan");
		labelDurasi.setBounds(24, 257, 90, 14);
		formulirPane.add(labelDurasi);
		
		JComboBox comboBoxDurasi = new JComboBox();
		// Mengatur opsi untuk combo box durasi reservasi
		comboBoxDurasi.setModel(new DefaultComboBoxModel(new String[] {"1 HARI", "2 HARI", "3 HARI", "4 HARI", "5 HARI", "7 HARI"}));
		comboBoxDurasi.setBounds(124, 253, 265, 22);
		formulirPane.add(comboBoxDurasi);
		
		JLabel labelKamar = new JLabel("Kamar");
		labelKamar.setBounds(24, 296, 90, 14);
		formulirPane.add(labelKamar);
		
		JComboBox comboBoxKamar = new JComboBox();
		
		try {
			/*
			 * Filter agar kamar yang bisa direservasi hanya yang nilai kolom is_available nya true
			 * Berarti kamarnya tersedia
			 */
			String query = "SELECT id_kamar FROM tb_kamar WHERE is_available = 1";
			
			java.sql.Connection conn = (Connection) Config.configDB();
			java.sql.Statement stm = conn.createStatement();
			
			// Menjalankan query
			java.sql.ResultSet result = stm.executeQuery(query);
			
			while(result.next()) {
				// Menambahkan hasil query menjadi opsi combo box/dropdown
				comboBoxKamar.addItem(String.format("Kamar %03d", result.getInt(1)));
			}
			
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		comboBoxKamar.setBounds(124, 292, 265, 22);
		formulirPane.add(comboBoxKamar);
		
		JButton buttonReservasi = new JButton("Reservasi");
		/*
		 * Mengatur action jika tombol reservasi ditekan
		 */
		buttonReservasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nama_pengunjung = textFieldNama.getText();
					String no_ktp = textFieldKTP.getText();
					String no_telp = textFieldTelp.getText();
					String email = textFieldEmail.getText();
					String alamat = textAreaAlamat.getText();
					
					int durasi = Integer.parseInt(String.valueOf(comboBoxDurasi.getSelectedItem().toString().charAt(0)));
					int id_kamar = Integer.parseInt(String.valueOf(comboBoxKamar.getSelectedItem().toString().substring(comboBoxKamar.getSelectedItem().toString().length()-3)));
					
					String query_tambah_reservasi = "INSERT INTO tb_reservasi VALUES"
							+ "("
							+ "null,"
							+ "'" + id_kamar + "',"
							+ "'" + nama_pengunjung + "', "
							+ "'" + no_ktp + "', "
							+ "'" + no_telp + "', "
							+ "'" + email + "', "
							+ "'" + alamat + "', "
							+ "'" + durasi + "', 0, 0, null"
							+ ")";
					String query_status_kamar = "UPDATE tb_kamar SET is_available = 0 WHERE id_kamar = '" + id_kamar + "'";
					
					java.sql.Connection conn = (Connection) Config.configDB();
					java.sql.Statement stmt = conn.createStatement();
					
					// Set auto-commit to false
					conn.setAutoCommit(false);
					
					stmt.addBatch(query_tambah_reservasi);
					stmt.addBatch(query_status_kamar);
					
					stmt.executeBatch();
					conn.commit();
					
					JOptionPane.showMessageDialog(null, "Reservasi berhasil");
					dispose();
					
					// Memanggil frame invoice
					InvoiceReservasi invoice = new InvoiceReservasi(id_kamar, nama_pengunjung, no_ktp, no_telp, email, durasi);
					invoice.setVisible(true);
					
				} catch(HeadlessException | SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		buttonReservasi.setBounds(260, 349, 129, 23);
		formulirPane.add(buttonReservasi);
	}
}

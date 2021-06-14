package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class InvoiceReservasi extends JFrame {

	private JPanel invoicePane;

	/**
	 * Create the frame.
	 */
	public InvoiceReservasi(int id_kamar, String nama_pengunjung, String no_ktp, String no_telp, String email, int durasi) {
		setTitle("Invoice #");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 276);
		invoicePane = new JPanel();
		invoicePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(invoicePane);
		invoicePane.setLayout(null);
		
		JLabel labelNama = new JLabel("Nama: " + nama_pengunjung);
		labelNama.setBounds(24, 24, 253, 14);
		invoicePane.add(labelNama);
		
		JLabel labelKTP = new JLabel("No. KTP: " + no_ktp);
		labelKTP.setBounds(24, 49, 253, 14);
		invoicePane.add(labelKTP);
		
		JLabel labelTelp = new JLabel("No. Telp: " + no_telp);
		labelTelp.setBounds(24, 74, 253, 14);
		invoicePane.add(labelTelp);
		
		JLabel labelEmail = new JLabel("Email: " + email);
		labelEmail.setBounds(24, 99, 253, 14);
		invoicePane.add(labelEmail);
		
		JLabel labelDurasi = new JLabel("Lama Kunjungan: " + durasi + " hari");
		labelDurasi.setBounds(24, 124, 253, 14);
		invoicePane.add(labelDurasi);
		
		JLabel labelKamar = new JLabel("Kamar: "  + String.format("Kamar #%03d", id_kamar));
		labelKamar.setBounds(24, 149, 253, 14);
		invoicePane.add(labelKamar);
		
		JLabel lblNewLabel = new JLabel("*Simpan invoice ini sebagai bukti reservasi");
		lblNewLabel.setBounds(24, 191, 253, 14);
		invoicePane.add(lblNewLabel);
	}

}

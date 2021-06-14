package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.Config;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DasborReservasi extends JFrame {

	private JPanel reservasiPane;
	private JTable tabelReservasi;

	/**
	 * Create the frame.
	 */
	public DasborReservasi() {
		setTitle("Dasbor Reservasi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 360);
		reservasiPane = new JPanel();
		reservasiPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(reservasiPane);
		reservasiPane.setLayout(null);
		
		JLabel labelTabelReservasi = new JLabel("Data Reservasi");
		labelTabelReservasi.setBounds(24, 24, 110, 14);
		reservasiPane.add(labelTabelReservasi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 56, 950, 200);
		reservasiPane.add(scrollPane);
		
		tabelReservasi = new JTable();
		cetak_data();
		scrollPane.setViewportView(tabelReservasi);
		
		JButton buttonSudahBayar = new JButton("Sudah Bayar");
		/*
		 * Mengubah kolom is_paid menjadi true jika tombol Sudah Bayar dipencet
		 * Lalu mengembalikan kolom is_available di tb_kamar menjadi true karena reservasi sudah selesai, jadi kamarnya bisa dipakai yang lain
		 */
		buttonSudahBayar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Menangkap data dari tabel dan disimpan ke dalam variabel
					int id_reservasi = Integer.parseInt(tabelReservasi.getValueAt(tabelReservasi.getSelectedRow(), 0).toString());
					int id_kamar = Integer.parseInt(tabelReservasi.getValueAt(tabelReservasi.getSelectedRow(), 1).toString());
					
					// Query
					String query_pembayaran = "UPDATE tb_reservasi SET is_paid = '1' WHERE id_reservasi = '" + id_reservasi +"'";
					String query_status_kamar = "UPDATE tb_kamar SET is_available = '1' WHERE id_kamar = '" + id_kamar +"'";
					
					java.sql.Connection conn = (Connection) Config.configDB();
					java.sql.Statement stmt = conn.createStatement();
					
					// Set auto-commit to false
					conn.setAutoCommit(false);
					
					// Mengatur biar dua query bisa dijalankan secara batch/bareng-bareng
					stmt.addBatch(query_pembayaran);
					stmt.addBatch(query_status_kamar);
					
					// Menjalankan query
					stmt.executeBatch();
					conn.commit();
					
					JOptionPane.showMessageDialog(null, "Status pembayaran berhasil diperbarui!");
					// Memperbarui tabel
					cetak_data();
					
				} catch (HeadlessException | SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		buttonSudahBayar.setBounds(24, 275, 126, 23);
		reservasiPane.add(buttonSudahBayar);
		
		JButton buttonPembatalan = new JButton("Batalkan");
		/*
		 * Mengubah kolom is_cancel menjadi true jika tombol Batalkan dipencet
		 * Lalu mengembalikan kolom is_available di tb_kamar menjadi true karena reservasi dibatalkan, jadi kamarnya gk jadi dipesan
		 */
		buttonPembatalan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id_reservasi = Integer.parseInt(tabelReservasi.getValueAt(tabelReservasi.getSelectedRow(), 0).toString());
					int id_kamar = Integer.parseInt(tabelReservasi.getValueAt(tabelReservasi.getSelectedRow(), 1).toString());
					
					String query = "";
					
					java.sql.Connection conn = (Connection) Config.configDB();
					java.sql.Statement stmt = conn.createStatement();
					
					// Set auto-commit to false
					conn.setAutoCommit(false);
					
					query = "UPDATE tb_reservasi SET is_cancel = 1 WHERE id_reservasi = '" + id_reservasi + "'";
					stmt.addBatch(query);
					
					query = "UPDATE tb_kamar SET is_available = 1 WHERE id_kamar = '" + id_kamar + "'";
					stmt.addBatch(query);
					
					stmt.executeBatch();
					conn.commit();
					
					JOptionPane.showMessageDialog(null, "Reservasi dibatalkan!");
					cetak_data();
				} catch (HeadlessException | SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		buttonPembatalan.setBounds(160, 275, 110, 23);
		reservasiPane.add(buttonPembatalan);
		
		JButton buttonKembali = new JButton("Kembali");
		/*
		 * Kembali ke frame DasborUtama
		 */
		buttonKembali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DasborUtama frame = new DasborUtama();
				frame.setVisible(true);
			}
		});
		buttonKembali.setBounds(885, 275, 89, 23);
		reservasiPane.add(buttonKembali);
	}
	
	private void cetak_data() {
		DefaultTableModel modelReservasi = new DefaultTableModel();
		// Menambahkan kolom
		modelReservasi.addColumn("ID Reservasi");
		modelReservasi.addColumn("ID Kamar");
		modelReservasi.addColumn("Nama Pengunjung");
		modelReservasi.addColumn("KTP");
		modelReservasi.addColumn("Telp");
		modelReservasi.addColumn("Email");
		modelReservasi.addColumn("Alamat");
		modelReservasi.addColumn("Durasi");
		modelReservasi.addColumn("Status Reservasi");
		modelReservasi.addColumn("Status Pembayaran");
		
		try {
			// Query untuk select semua data di tb_reservasi
			String query = "SELECT * FROM tb_reservasi";
			
			java.sql.Connection conn = (Connection) Config.configDB();
			java.sql.Statement stm = conn.createStatement();
			
			java.sql.ResultSet result = stm.executeQuery(query);
			while(result.next()) {
				
				String status_reservasi = "";
				if (result.getBoolean(9) == false) {
					status_reservasi = "Reservasi";
				} else {
					status_reservasi = "Dibatalkan";
				}
				
				String status_pembayaran = "";
				if (result.getBoolean(10) == false) {
					status_pembayaran = "Belum Bayar";
				} else {
					status_pembayaran = "Sudah Bayar";
				}
				
				// Mengubah data hasil query ke dalam row tabel
				modelReservasi.addRow(new Object[] {result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), result.getString(8) + " hari", status_reservasi, status_pembayaran});
			}
			
			// Mencetak data ke dalam tabel
			tabelReservasi.setModel(modelReservasi);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

}

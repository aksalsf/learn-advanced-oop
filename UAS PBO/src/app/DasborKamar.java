package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.Config;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DasborKamar extends JFrame {

	private JPanel dasborPane;
	private JTable tabelKamar;
	
	/**
	 * Create the frame.
	 */
	public DasborKamar() {
		setResizable(false);
		setTitle("Dasbor Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 240);
		dasborPane = new JPanel();
		dasborPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(dasborPane);
		dasborPane.setLayout(null);
		
		JLabel labelTabelKamar = new JLabel("Data Kamar");
		labelTabelKamar.setBounds(40, 11, 68, 14);
		labelTabelKamar.setLabelFor(tabelKamar);
		dasborPane.add(labelTabelKamar);
		
		JScrollPane tabelKamarPane = new JScrollPane();
		tabelKamarPane.setBounds(40, 33, 398, 97);
		dasborPane.add(tabelKamarPane);
		
		tabelKamar = new JTable();
		tabelKamarPane.setViewportView(tabelKamar);
		tabelKamar.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		tabelKamar.setForeground(Color.BLACK);
		tabelKamar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelKamar.setBackground(Color.WHITE);

		/*
		 * Mencetak data dari database ke tabel
		 */
		cetak_data();
		
		JButton tombolHapusKamar = new JButton("Hapus");
		/*
		 * Mengatur jika tombol hapus dipencet
		 */
		tombolHapusKamar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Menangkap id_kamar dari row tabel yang diseleksi
					int id_kamar = Integer.parseInt(tabelKamar.getValueAt(tabelKamar.getSelectedRow(), 0).toString());
					
					// Query untuk menghapus row yang diseleksi
					String query = "DELETE FROM tb_kamar WHERE id_kamar = '"+id_kamar+"'";
					
					java.sql.Connection conn = (Connection) Config.configDB();
					java.sql.PreparedStatement pstm = conn.prepareStatement(query);
					
					// Menjalankan query
					pstm.execute();
					
					// Pesan dialog jika query berhasil dijalankan
					JOptionPane.showMessageDialog(null, "Data kamar berhasil dihapus");
					// Memperbarui tabel
					cetak_data();
					
				} catch (HeadlessException | SQLException e1) {
					/*
					 * Menampilkan pesan eror jika query gagal dijalankan
					 */
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		tombolHapusKamar.setBounds(150, 154, 89, 23);
		dasborPane.add(tombolHapusKamar);
		
		JButton tombolTambahKamar = new JButton("Tambah");
		tombolTambahKamar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/*
					 * Query untuk menambahkan kamar baru
					 * Karena id_kamar dan timestamp otomatis diisi sistem, maka nilainya diisi null
					 * 1 => true untuk kolom is_available
					 */
					String query = "INSERT INTO tb_kamar VALUES(null, 1 ,null)";
					
					java.sql.Connection conn = (Connection) Config.configDB();
					java.sql.PreparedStatement pstm = conn.prepareStatement(query);
					
					// Menjalankan query
					pstm.execute();
					
					// Menampilkan pesan dialog jika query berhasil dijalankan
					JOptionPane.showMessageDialog(null, "Data kamar berhasil ditambahkan");
					
					// Memperbarui tabel
					cetak_data();
				} catch (HeadlessException | SQLException e2) {
					/*
					 * Menampilkan eror jika query gagal dijalankan
					 */
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		tombolTambahKamar.setBounds(40, 154, 89, 23);
		dasborPane.add(tombolTambahKamar);
		
		JButton buttonKembali = new JButton("Kembali");
		buttonKembali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // Menutup frame jika tombol kembali ditekan
				
				// Lalu menampilkan frame DasborUtama
				DasborUtama frame = new DasborUtama();
				frame.setVisible(true);
			}
		});
		buttonKembali.setBounds(349, 154, 89, 23);
		dasborPane.add(buttonKembali);
	}
	
	/*
	 * Cetak data dari database
	 * */
	
	private void cetak_data() {
		DefaultTableModel modelKamar = new DefaultTableModel(); // Membuat tabel model
		// Menambahkan kolom
		modelKamar.addColumn("ID Kamar");
		modelKamar.addColumn("Status");
		
		try {
			// Query untuk menampilkan data dari tb_kamar
			String query = "SELECT * FROM tb_kamar";
			
			java.sql.Connection conn = (Connection) Config.configDB();
			java.sql.Statement stm = conn.createStatement();
			
			// Menjalankan query
			java.sql.ResultSet result = stm.executeQuery(query);
			
			while(result.next()) {
				// Menyimpan hasil query ke dalam variabel
				String id_kamar = result.getString(1);
				String status_kamar = "";
				
				// Berdasarkan kolom is_available
				if (result.getBoolean(2) == true) {
					status_kamar = "Tersedia";
				} else {
					status_kamar = "Tidak Tersedia";
				}
				
				// Menambahkan data menjadi row ke dalam tabel
				modelKamar.addRow(new Object[] {id_kamar, status_kamar});
			}
			// Menambahkan data ke dalam tabel
			tabelKamar.setModel(modelKamar);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
}

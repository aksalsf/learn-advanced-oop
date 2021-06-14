package jdbc.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import jdbc.database.*;

public class TabelMahasiswa extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	
	private MahasiswaData mhsData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelMahasiswa frame = new TabelMahasiswa();
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
	public TabelMahasiswa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(0, 27, 434, 223);
		contentPane.add(scrollPane);
		
		String[] namaKolom = {"NIM", "Nama", "Jenis Kelamin", "TTL", "Alamat"};
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(namaKolom);
		
		mhsData = new MahasiswaData();
		ArrayList<MahasiswaModel> dataMhs = new ArrayList<>();
		dataMhs = mhsData.getData();
		
		for(int i = 0; i < dataMhs.size();i++) {
			ArrayList<Object> tempMhs = new ArrayList<>();
			tempMhs.add(dataMhs.get(i).getNIM());
			tempMhs.add(dataMhs.get(i).getNama());
			tempMhs.add(dataMhs.get(i).getGender());
			tempMhs.add(dataMhs.get(i).getTTL());
			tempMhs.add(dataMhs.get(i).getAlamat());
			dtm.addRow(tempMhs.toArray());
		}
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
	}
}

package belajarGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import id.ac.uns.vokasi.d3ti.jdbc.*;

public class TampilanDatabase extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private MhsData mhsData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TampilanDatabase frame = new TampilanDatabase();
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
	public TampilanDatabase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 787, 410);
		contentPane.add(scrollPane);
		String[] namaKolom= {"Email","Password","Nim", "Nama", "Gender", "Alamat"};
		DefaultTableModel dtm=new DefaultTableModel();
		dtm.setColumnIdentifiers(namaKolom);
		
		mhsData=new MhsData();
		ArrayList<MhsModel> dataMhs=new ArrayList<>();
		dataMhs=mhsData.getData();
		for(int i=0;i<dataMhs.size();i++) {
			ArrayList<Object> tempMhs=new ArrayList<>();
			tempMhs.add(dataMhs.get(i).getemail());
			tempMhs.add(dataMhs.get(i).getPass());
			tempMhs.add(dataMhs.get(i).getNim());
			tempMhs.add(dataMhs.get(i).getNama());
			tempMhs.add(dataMhs.get(i).getJk());
			tempMhs.add(dataMhs.get(i).getalamat());
			dtm.addRow(tempMhs.toArray());
		}
		
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
	}
}

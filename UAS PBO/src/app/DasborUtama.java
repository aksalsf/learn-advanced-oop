package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DasborUtama extends JFrame {

	private JPanel dasborPane;
	
	/**
	 * Create the frame.
	 */
	public DasborUtama() {
		setTitle("Dasbor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 160);
		dasborPane = new JPanel();
		dasborPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(dasborPane);
		dasborPane.setLayout(null);
		
		JButton buttonKamar = new JButton("Kamar");
		/*
		 * Menampilkan frame DasborKamar jika tombol Kamar dipencet 
		 */
		buttonKamar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // Menutup frame DasborUtama
				DasborKamar frame = new DasborKamar();
				frame.setVisible(true);
			}
		});
		buttonKamar.setBounds(40, 48, 89, 23);
		dasborPane.add(buttonKamar);
		
		JButton buttonReservasi = new JButton("Reservasi");
		/*
		 * Menampilkan frame DasborReservasi jika tombol Reservasi dipencet
		 */
		buttonReservasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // Menutup frame DasborUtama
				DasborReservasi frame = new DasborReservasi();
				frame.setVisible(true);
			}
		});
		buttonReservasi.setBounds(187, 48, 102, 23);
		dasborPane.add(buttonReservasi);
	}

}

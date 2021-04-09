package id.ac.uns.vokasi.d3ti.gui;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Event;
import java.awt.Frame; //asal dari awt
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TampilanAWT extends Frame implements WindowListener {
	
	String nim, nama, jk, alamat, tmp_lahir, tgl_lahir;
	TextField cnim, cnama, ctmp_lahir, ctgl_lahir;
	Choice cjk1;
	TextArea calamat;
	Button b;
	
	public TampilanAWT() { //buat konstraktor
		super("Data Diri");
		Panel p = new Panel();
		add(p);
		p.setLayout(new GridLayout(7,2));
		p.add(new Label("nim"));
		p.add(cnim=new TextField());
		
		p.add(new Label("nama"));
		p.add(cnama=new TextField());
		
		p.add(new Label("jenis kelamin"));
		cjk1=new Choice();
		cjk1.add("Laki-laki");
		cjk1.add("Perempuan");
		p.add(cjk1);
		
		p.add(new Label("tempat lahir"));
		p.add(ctmp_lahir=new TextField());
		
		p.add(new Label("tanggal lahir"));
		p.add(ctgl_lahir=new TextField());
		
		p.add(new Label("alamat"));
		p.add(calamat=new TextArea());
		
		p.add(new Label(""));
		p.add(b=new Button("simpan"));
		
		
		setSize(250,300);
		setVisible(true);
		addWindowListener(this);
	}
	
	//untuk menjalankan harus membuat main method
	public static void main(String[] args) {
		new TampilanAWT();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(ABORT);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean action(Event e, Object obj) {
		if(obj.equals("simpan")) {
			System.out.println("simpan");
			nim=cnim.getText();
			nama=cnama.getText();
			tmp_lahir=ctmp_lahir.getText();
			tgl_lahir=ctgl_lahir.getText();
			alamat=calamat.getText();
			jk=cjk1.getSelectedItem().toString();
			System.out.println(nim);
			System.out.println(nama);
			System.out.println(jk);
			System.out.println(tmp_lahir);
			System.out.println(tgl_lahir);
			System.out.println(alamat);
		}
		return true;
	}
}

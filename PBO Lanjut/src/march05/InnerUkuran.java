package march05;

class BesarUkuran{
	double besar=0.0;
	int awal=0;
	int akhir=0;
	double pengali=1;
	
	public BesarUkuran(String awal,String akhir, double besar) {
		switch(awal) {
		case "km":this.awal=1;break;
		case "hm":this.awal=2;break;
		case "dam":this.awal=3;break;
		case "m":this.awal=4;break;
		case "dm":this.awal=5;break;
		case "cm":this.awal=6;break;
		case "mm":this.awal=7;break;
		}
		
		switch(akhir) {
		case "km":this.akhir=1;break;
		case "hm":this.akhir=2;break;
		case "dam":this.akhir=3;break;
		case "m":this.akhir=4;break;
		case "dm":this.akhir=5;break;
		case "cm":this.akhir=6;break;
		case "mm":this.akhir=7;break;
		}
		
		this.besar=besar;
	}
	public double getBesar() {
		return besar;
	}
	public double getSelisih() {
		int selisih=0;
		selisih=awal-akhir;
		if(selisih>0) {
			for(int i=0;i<selisih;i++) {
				pengali=pengali/10;
			}
		}else if(selisih<0) {
			for(int i=selisih;i<0;i++) {
				pengali=pengali*10;
			}
		}
		return pengali;
	}
}

public class InnerUkuran {
	public static void main(String[]args) {
		BesarUkuran ukuran=new BesarUkuran("m","mm",7);
		double hasil=ukuran.getBesar()*ukuran.getSelisih();
		System.out.println(hasil);
		
	}
}

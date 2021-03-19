package march01;

public class InnerUkuran {
	class KonversiUkuran {
		double nilaiUkuran = 0, selisihUkuran = 1;
		int satuanAwal = 0, satuanKonversi = 0;
		
		KonversiUkuran(String satuanAwal, String satuanKonversi, double nilaiUkuran) {
			switch(satuanAwal) {
			case "km":
				this.satuanAwal = 1;
				break;
			case "hm":
				this.satuanAwal = 2;
				break;
			case "dam":
				this.satuanAwal = 3;
				break;
			case "m":
				this.satuanAwal = 4;
				break;
			case "cm":
				this.satuanAwal = 5;
				break;
			case "dm":
				this.satuanAwal = 6;
				break;
			case "mm":
				this.satuanAwal = 7;
				break;
			}
			
			switch(satuanKonversi) {
			case "km":
				this.satuanAwal = 1;
				break;
			case "hm":
				this.satuanAwal = 2;
				break;
			case "dam":
				this.satuanAwal = 3;
				break;
			case "m":
				this.satuanAwal = 4;
				break;
			case "cm":
				this.satuanAwal = 5;
				break;
			case "dm":
				this.satuanAwal = 6;
				break;
			case "mm":
				this.satuanAwal = 7;
				break;
			}
			
			this.nilaiUkuran = nilaiUkuran;
		}
		
		double getNilaiUkuran() {
			return nilaiUkuran;
		}
		
		double getSelisihUkuran() {
			int bedaSelisih = 0;
			bedaSelisih = this.satuanAwal - this.satuanKonversi;
			if (bedaSelisih > 0) {
				for (int i = 0; i < bedaSelisih; i++) {
					selisihUkuran = selisihUkuran / 10;
				}
			}
			if (bedaSelisih < 0) {
				for (int i = bedaSelisih; i < 0; i++) {
					selisihUkuran = selisihUkuran * 10;
				}
			}
			return selisihUkuran;
		}
	}
}

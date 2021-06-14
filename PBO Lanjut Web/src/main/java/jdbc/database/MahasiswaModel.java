package jdbc.database;

public class MahasiswaModel {
	String nim, nama, gender, ttl, alamat;
	
	// Setter	
	public void setNIM(String nim) {
		this.nim = nim;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setTTL(String ttl) {
		this.ttl = ttl;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	// Getter
	public String getNIM() {
		return nim;
	}
	public String getNama() {
		return nama;
	}
	public String getGender() {
		return gender;
	}
	public String getTTL() {
		return ttl;
	}
	public String getAlamat() {
		return alamat;
	}
	
}

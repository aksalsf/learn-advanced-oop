package jdbc.database;

public class Mahasiswa {
	public static void main(String[] args) {
		MahasiswaData mhsData = new MahasiswaData();
		System.out.println(mhsData.getData().get(0).getNama());
	}
}

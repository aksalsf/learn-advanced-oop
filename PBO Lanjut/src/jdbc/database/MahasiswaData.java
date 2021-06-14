package jdbc.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MahasiswaData {
	Connection conn;
	Statement st;
	ResultSet result;
	ArrayList<MahasiswaModel> dataMahasiswa;
	
	public MahasiswaData() {
		dataMahasiswa = new ArrayList<MahasiswaModel>();
		try {
			String server = "jdbc:mysql://127.0.0.1/belajar_jdbc?user=root&password=";
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(server);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<MahasiswaModel> getData() {
		try {
			st = (Statement) conn.createStatement();
			String query = "SELECT * FROM tb_mhs";
			result = st.executeQuery(query);
			MahasiswaModel mhsModel = new MahasiswaModel();
			while(result.next()) {
				mhsModel.setNIM(result.getString(1));
				mhsModel.setNama(result.getString(2)); 
				mhsModel.setGender(result.getString(3)); 
				mhsModel.setTTL(result.getString(4)); 
				mhsModel.setAlamat(result.getString(5));
				dataMahasiswa.add(mhsModel);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataMahasiswa;
	}
	
	public ArrayList<MahasiswaModel> getSingle(String nim) {
		try {
			st = (Statement) conn.createStatement();
			String query = "SELECT * FROM tb_mhs WHERE nim = '"+ nim +"'";
			result = st.executeQuery(query);
			MahasiswaModel mhsModel = new MahasiswaModel();
			while(result.next()) {
				mhsModel.setNIM(result.getString(1));
				mhsModel.setNama(result.getString(2)); 
				mhsModel.setGender(result.getString(3)); 
				mhsModel.setTTL(result.getString(4)); 
				mhsModel.setAlamat(result.getString(5));
				dataMahasiswa.add(mhsModel);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataMahasiswa;
	}
	
	public void InsertMahasiswa(String nim, String nama, String gender, String ttl, String alamat) {
		try {
			st = (Statement) conn.createStatement();
			String query = "INSERT INTO tb_mhs(nim, nama, gender, ttl, alamat) VALUES ('"+ nim +"', '"+ nama +"', '"+ gender+"', '"+ ttl +"', , '"+ alamat +"')";
			st.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void UpdateMahasiswa(String nim, String nama, String gender, String ttl, String alamat) {
		try {
			st = (Statement) conn.createStatement();
			String query = "UPDATE tb_mhs SET nim = '"+ nim +"',nama = '"+ nama +"', gender = '"+ gender +"', ttl = '"+ ttl +"', alamat = '"+ alamat +"' WHERE nim = '"+ nim +"'";
			st.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteSingle(String nim) {
		try {
			st = (Statement) conn.createStatement();
			String query = "DELETE FROM tb_mhs WHERE nim = '"+ nim +"'";
			st.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

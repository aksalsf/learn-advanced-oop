<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*" %>
    <%@ page import="jdbc.database.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>M3119004 - Aksal Syah Falah</title>
</head>
<body>
	<%
		MahasiswaData mhsData = new MahasiswaData();
		ArrayList<MahasiswaModel> dataMahasiswa = new ArrayList<>();
		dataMahasiswa.addAll(mhsData.getData());
		for(int i=0;i < dataMahasiswa.size();i++) {
			out.print(dataMahasiswa.get(i).getNIM() + " - " + dataMahasiswa.get(i).getNama());
			out.print("<br>");
		}
	 %>
</body>
</html>
package com.mercadona.mercadona;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bloc3StudiApplication {


	public static void main(String[] args) {
		try {
			String URL = "jdbc:postgresql://localhost:5432/mercadona";
			String user = "postgres";
			Connection co = DriverManager.getConnection(URL, user, null);

			Statement st = co.createStatement();
			st.executeUpdate("UPDATE \"articles\" SET prix = 7.5 where libelle = 'Ampoule'");
			ResultSet rs = st.executeQuery("SELECT * FROM \"articles\"");
			while(rs.next()) {
				String libelleArticle = rs.getString("libelle");
				System.out.println(libelleArticle);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}



}

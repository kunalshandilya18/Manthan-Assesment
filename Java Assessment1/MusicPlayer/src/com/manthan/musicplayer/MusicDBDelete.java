package com.manthan.musicplayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MusicDBDelete {
	
	public void delete() {
		Connection con = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;

		Scanner sc=new Scanner(System.in);

		System.out.println("Enter Song_ID: ");
		int songId=sc.nextInt();
		sc.nextLine();


		try {
			//LOAD THE DRIVER
			Class.forName("com.mysql.jdbc.Driver");

			//GET CONNECTION VIA DRIVER
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer", "root", "root");

			//ISSUE SQL QUERY 
			String query = "delete from MusicFiles where Song_Id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, songId);


			int n = pstmt.executeUpdate();
			if(n>0) {

				System.out.println("Song Deleted");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//CLOSE JDBC OBJECTS

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//end of finally
	}//end of delete


}

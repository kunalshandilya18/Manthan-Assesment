package com.manthan.musicplayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MusicDBSearch {
	public void search(String songName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//LOAD THE DRIVER
			Class.forName("com.mysql.jdbc.Driver");

			//GET CONNECTION VIA DRIVER
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer", "root", "root");

			//ISSUE SQL QUERY 
			String query = " select * from MusicFiles where Song_Title=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, songName);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				System.out.println();
				System.out.println("Song Found ");
				
				System.out.println("Song Id: "+rs.getInt(1)+"\t");
				System.out.println("Song Title: "+rs.getString(2)+"\t");
				System.out.println("Artist Name: "+rs.getString(3)+"\t");
				System.out.println("Album Name: "+rs.getString(4)+"\t");
				System.out.println("Song Location: "+rs.getString(5)+"\t");
				System.out.println("Description: "+rs.getString(6)+"\t");
				System.out.println();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//CLOSE JDBC OBJECTS
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
	}//end of search

}

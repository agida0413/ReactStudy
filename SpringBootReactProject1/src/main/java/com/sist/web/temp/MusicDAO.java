package com.sist.web.temp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
public class MusicDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	private final String url="jdbc:mysql://localhost:3306/mydb?autoReconnection=true";
	
	public MusicDAO () {
		
	}
	public void getconnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,"root","root");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void disconnection() {
		try {
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void musicInsert(MusicVO vo) {
		try {
			getconnection();
			String sql="INSERT INTO music(title,singer,album,poster,state,idcrement) "
					+ "VALUES(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getSinger());
			ps.setString(3, vo.getAlbum());
			ps.setString(4, vo.getPoster());
			ps.setString(5, vo.getState());
			ps.setInt(6, vo.getIdcrement());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		
		finally {
			disconnection();
			
		}
	}
	

}

package com.mf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mf.DBManager.DBManager;
import com.mf.dto.ProductVO;
	
	public class StatisticsDAO {
		
		private StatisticsDAO() {}
		
		private static StatisticsDAO instance = new StatisticsDAO();
		
		public static StatisticsDAO getInstance()
		{
			return instance;
		}
		
		
		
		// 판매자/구매자 수를 가져와서 파이형 통계에 보여줌.
		public int countByGrade(int grade) {
	
			String sql = "select count(*) count from member where mgrade=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int count = 0;
			try {
	
				// 연결을 얻어온다.
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, grade);
				rs = pstmt.executeQuery();
	
				if (rs.next()) {
					count = Integer.parseInt(rs.getString("count"));
				}
			}
	
			catch (Exception e) {
				System.out.println("countByGrade 메소드에서 오류 발생");
				e.printStackTrace();
			}
	
			finally {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("countByGrade 메소드에서 닫기 오류 발생");
					e.printStackTrace();
				}
			}
	
			return count;
	
		}//메소드 끝
		
		
		
		//현재 판매페이지에 있는 앨범들의 장르를 카운트해서 막대형 통계에 보여줌.
		public List countByJanre(){
			String sql = "select nvl(sum(decode(pjanre, 'ballad', 1)),0) \"ballad\", \r\n" + 
					"nvl(sum(decode(pjanre, 'dance', 1)),0)\"dance\",\r\n" + 
					"nvl(sum(decode(pjanre, 'rock', 1)),0)\"rock\",\r\n" + 
					"nvl(sum(decode(pjanre, 'hiphop', 1)),0)\"hiphop\"\r\n" + 
					"from product";	
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int ballad;
			int dance;
			int rock;
			int hiphop;
			
			List<Integer> janre = null;

	
			try {			
				
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				rs = pstmt.executeQuery(); 
				
				if(rs.next()) 
				{
					janre = new ArrayList<Integer>();
					
					ballad = Integer.parseInt(rs.getString("ballad"));
					dance = Integer.parseInt(rs.getString("dance"));
					rock = Integer.parseInt(rs.getString("rock"));
					hiphop = Integer.parseInt(rs.getString("hiphop"));
					
					janre.add(ballad);
					janre.add(dance);
					janre.add(rock);
					janre.add(hiphop);
							
										
				}
			} 
						
			catch(Exception e)
			{
				System.out.println("countByJanre 메소드에서 오류 발생");
				e.printStackTrace();
			}
			
			finally {
				try {conn.close();} 
				catch (SQLException e) 
				{
					System.out.println("countByJanre 메소드에서 닫기 오류 발생");
					e.printStackTrace();
				}
			}
				
			return janre;
			
		}//메소드 끝
		
		public List countLikeJanre(int grade) {
			
			String sql = "select nvl(sum(decode(mjanre, 'ballad', 1)),0) \"ballad\", \r\n" + 
					"nvl(sum(decode(mjanre, 'dance', 1)),0)\"dance\",\r\n" + 
					"nvl(sum(decode(mjanre, 'rock', 1)),0)\"rock\",\r\n" + 
					"nvl(sum(decode(mjanre, 'hiphop', 1)),0)\"hiphop\"\r\n" + 
					"from member";	
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int ballad;
			int dance;
			int rock;
			int hiphop;
			
			List<Integer> janre = null;

	
			try {			
				
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				rs = pstmt.executeQuery(); 
				
				if(rs.next()) 
				{
					janre = new ArrayList<Integer>();
					
					ballad = Integer.parseInt(rs.getString("ballad"));
					dance = Integer.parseInt(rs.getString("dance"));
					rock = Integer.parseInt(rs.getString("rock"));
					hiphop = Integer.parseInt(rs.getString("hiphop"));
					
					janre.add(ballad);
					janre.add(dance);
					janre.add(rock);
					janre.add(hiphop);
							
										
				}
			} 
						
			catch(Exception e)
			{
				System.out.println("countLikeJanre 메소드에서 오류 발생");
				e.printStackTrace();
			}
			
			finally {
				try {conn.close();} 
				catch (SQLException e) 
				{
					System.out.println("countLikeJanre 메소드에서 닫기 오류 발생");
					e.printStackTrace();
				}
			}
				
			return janre;
	
		}//메소드 끝

}

package com.mf.dao;

import com.mf.DBManager.DBManager;
import com.mf.dto.MemberVO;

public class ChartDAO {
	
private ChartDAO() {}
	
	private static ChartDAO instance = new ChartDAO();
	
	public static ChartDAO getInstance()
	{
		return instance;
	}
	
	public int countMemberByGrade(int grade){
		String sql = "select count(*) over() as count from member where mgrade=?";			
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {			
			//연결을 얻어온다.
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, grade);//sql문의 첫번째 ?에 userid를 넣는다. 
			rs = pstmt.executeQuery(); //sql 실행하여 얻은 결과를 rs에 저장한다. 
			
			if(rs.next()) {
				result = rs.getInt("count"); 
			}
		} 
		
			
		catch(Exception e)
		{
			System.out.println("countMemberByGrade 메소드에서 오류 발생");
			e.printStackTrace();
		}
		
		finally {
			try {conn.close();} 
			catch (SQLException e) 
			{
				System.out.println("countMemberByGrade 메소드에서 닫기 오류 발생");
				e.printStackTrace();
			}
		}
			
		return result;
		
	}
	
	public int countOrder(){
		String sql = "select count(*) over() as count from ordering";			
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {			
			//연결을 얻어온다.
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);  
			rs = pstmt.executeQuery(); //sql 실행하여 얻은 결과를 rs에 저장한다. 
			
			if(rs.next()) {
				result = rs.getInt("count"); 
			}
		} 
		
			
		catch(Exception e)
		{
			System.out.println("countOrder 메소드에서 오류 발생");
			e.printStackTrace();
		}
		
		finally {
			try {conn.close();} 
			catch (SQLException e) 
			{
				System.out.println("countOrder 메소드에서 닫기 오류 발생");
				e.printStackTrace();
			}
		}
			
		return result;
		
	}
	
	public int countProduct(){
		String sql = "select count(*) over() as count from Product";			
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {			
			//연결을 얻어온다.
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);  
			rs = pstmt.executeQuery(); //sql 실행하여 얻은 결과를 rs에 저장한다. 
			
			if(rs.next()) {
				result = rs.getInt("count"); 
			}
		} 
		
			
		catch(Exception e)
		{
			System.out.println("countProduct 메소드에서 오류 발생");
			e.printStackTrace();
		}
		
		finally {
			try {conn.close();} 
			catch (SQLException e) 
			{
				System.out.println("countProduct 메소드에서 닫기 오류 발생");
				e.printStackTrace();
			}
		}
			
		return result;
		
	}
		
		
}

package com.mf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mf.DBManager.DBManager;
import com.mf.dto.MemberVO;

public class MemberDAO {
	
	private MemberDAO() {}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance()
	{
		return instance;
	}
	
	
	//----------------------------------------------------------------------
	//구현 확인
	//insertMember,selectPwdMember
	//----------------------------------------------------------------------
	
	
	
	
	
	//회원가입(추가)
	//jsp 페이지에서 받아와서 인서트 
	public void insertMember(MemberVO vo) //회원가입 jsp페이지에서 하여튼 뭔가 회원가입정보를 통째로 받아옴
	{
		String sql = "insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			//연결을 얻어온다.
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, vo.getMid());//sql문의 첫번째 ?에 userid를 넣는다. 
			pstmt.setString(2, vo.getMpwd());
			pstmt.setString(3, vo.getMname());
			pstmt.setTimestamp(4, vo.getMbirth());
			pstmt.setString(5, vo.getMemail());
			pstmt.setString(6, vo.getMphone());
			pstmt.setString(7, vo.getMaddr());
			pstmt.setString(8, vo.getMjanre());
			pstmt.setInt(9, vo.getMgrade());
			pstmt.setInt(10, vo.getMopnum()); //사업자등록번호(판매자가 회원가입 후, 최고관리자가 부여)
			pstmt.setInt(11, vo.getMwarning()); //경고점수(회원가입 과정이므로 불필요)
									
			rs = pstmt.executeQuery(); //sql 실행하여 얻은 결과를 rs에 저장한다. 
			System.out.println("확인용// insertMember 메소드 다 읽음");
		} 
		catch(Exception e)
		{
			System.out.println("insertMember 메소드에서 오류 발생");
			e.printStackTrace();
		}
		finally {
			try {conn.close();} 
			catch (SQLException e) 
			{
				System.out.println("insertMember 메소드에서 닫기 오류 발생");
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	//한명의 정보만 가져오는것(회원정보 수정용?? 등등)	
		public MemberVO selectOneMember(String mid){
			if(mid !=null) {
				System.out.println("m id 가 넘어오는강 : "+mid);
			}
			
			String sql = "select * from member where mid=?";			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			MemberVO m = null;
			try {

				//연결을 얻어온다.
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, mid); //sql문의 첫번째 ?에 userid를 넣는다. 				
				rs = pstmt.executeQuery(); //sql 실행하여 얻은 결과를 rs에 저장한다.
				
				if(rs.next()) {
					m = new MemberVO();
					m.setMid(rs.getString("mid"));
					m.setMpwd(rs.getString("mpwd"));
					m.setMname(rs.getString("mname"));
					m.setMbirth(rs.getTimestamp("mbirth"));
					m.setMemail(rs.getString("memail"));
					m.setMphone(rs.getString("mphone"));
					m.setMaddr(rs.getString("maddr"));
					m.setMjanre(rs.getString("mjanre"));
					m.setMgrade(rs.getInt("mgrade"));
					m.setMopnum(rs.getInt("mopnum"));
					m.setMwarning(rs.getInt("mwarning")); // <<-- 이 부분 오타 있음 VO에 worinning 이라고되있네요
				}
			} 
						
			catch(Exception e)
			{
				System.out.println("selectOneMember 메소드에서 오류 발생");
				e.printStackTrace();
			}
			
			finally {
				try {conn.close();} 
				catch (SQLException e) 
				{
					System.out.println("selectOneMember 메소드에서 닫기 오류 발생");
					e.printStackTrace();
				}
			}
				
			if(m != null) {
				System.out.println("m.getId : "+m.getMid());
			}else {
				System.out.println("여기 문제구나");
			}
			
			return m;
			
		}//셀렉트1 끝
			
			
		//로그인 할 때 비밀번호 확인.
		public String selectPwdMember(String id){
			String sql = "select mpwd from member where mid=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			MemberVO m = null;
			String pwd = null;
			try {
				
				//연결을 얻어온다.
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, id);//sql문의 첫번째 ?에 userid를 넣는다. 
				rs = pstmt.executeQuery(); //sql 실행하여 얻은 결과를 rs에 저장한다. 
				while(rs.next())
				{
					pwd = rs.getString("mpwd");
				}
				} 
			
			
			catch(Exception e)
			{
				System.out.println("selectPwd 메소드에서 오류 발생");
				e.printStackTrace();
			}
			
			finally {
				try {conn.close();} 
				catch (SQLException e) 
				{
					System.out.println("selectPwd 메소드에서 닫기 오류 발생");
					e.printStackTrace();
				}
			}
			
			return pwd;
			
		}//셀렉트1 끝
			
			
		//회원탈퇴
		public void deleteMember(String id){
			String sql = "delete from member where mid = ?";			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {							
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, id);//sql문의 첫번째 ?에 userid를 넣는다. 
				pstmt.executeUpdate(); //sql 실행하여 얻은 결과를 rs에 저장한다. 
				} 
						
				catch(Exception e)
				{
					System.out.println("deleteMember 메소드에서 오류 발생");
					e.printStackTrace();
				}
					
				finally {
					try {conn.close();} 
					catch (SQLException e) 
					{
						System.out.println("deleteMember 메소드에서 닫기 오류 발생");
						e.printStackTrace();
					}
				}
			}//딜리트 끝	
		
		
		//회원정보 수정
		public void UpdateMember(MemberVO vo){
			String sql = "update member set mpwd=?, mname=?, mbirth=?, memail=?, mphone=?, maddr=?, mjanre=? where mid=?";			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {							
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, vo.getMpwd());
				pstmt.setString(2, vo.getMname());
				pstmt.setTimestamp(3, vo.getMbirth());
				pstmt.setString(4, vo.getMemail());
				pstmt.setString(5, vo.getMphone());
				pstmt.setString(6, vo.getMaddr());
				pstmt.setString(7, vo.getMjanre());
				pstmt.setString(8, vo.getMid());
				
				pstmt.executeUpdate();
			}
						
				catch(Exception e)
				{
					System.out.println("updateMember 메소드에서 오류 발생");
					e.printStackTrace();
				}
					
				finally {
					try {conn.close();} 
					catch (SQLException e) 
					{
						System.out.println("updateMember 메소드에서 닫기 오류 발생");
						e.printStackTrace();
					}
				}
			}//업데이트 끝		
		
		
		//해당 등급의 사람들 정보를 가져오는 것.
		public List<MemberVO> selectByGradeMember(int grade){
			String sql = "select * from member where mgrade=?";			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<MemberVO> arr = new ArrayList<MemberVO>();		
			
			try {			
				//연결을 얻어온다.
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setInt(1, grade);//sql문의 첫번째 ?에 userid를 넣는다. 
				rs = pstmt.executeQuery(); //sql 실행하여 얻은 결과를 rs에 저장한다. 
				
				while(rs.next()) {
					MemberVO m = new MemberVO();
					m.setMid(rs.getString("mid"));
					m.setMpwd(rs.getString("mpwd"));
					m.setMname(rs.getString("mname"));
					m.setMbirth(rs.getTimestamp("mbirth"));
					m.setMemail(rs.getString("memail"));
					m.setMphone(rs.getString("mphone"));
					m.setMaddr(rs.getString("maddr"));
					m.setMjanre(rs.getString("mjanre"));
					m.setMgrade(rs.getInt("mgrade"));
					m.setMopnum(rs.getInt("mopnum"));
					m.setMwarning(rs.getInt("mwarning")); 
					arr.add(m);
				}
			} 
			
				
			catch(Exception e)
			{
				System.out.println("selectByGradeMember 메소드에서 오류 발생");
				e.printStackTrace();
			}
			
			finally {
				try {conn.close();} 
				catch (SQLException e) 
				{
					System.out.println("selectByGradeMember 메소드에서 닫기 오류 발생");
					e.printStackTrace();
				}
			}
				
			return arr;
			
		}//셀렉트1 끝		
			
		public List<MemberVO> selectAllMember(){
			String sql = "select * from member";			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<MemberVO> arr = new ArrayList<MemberVO>();		
			
			try {			
				//연결을 얻어온다.
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 			
				rs = pstmt.executeQuery(); //sql 실행하여 얻은 결과를 rs에 저장한다. 
				
				if(rs.next()) {
					MemberVO m = new MemberVO();
					m.setMid(rs.getString("mid"));
					m.setMpwd(rs.getString("mpwd"));
					m.setMname(rs.getString("mname"));
					m.setMbirth(rs.getTimestamp("mbirth"));
					m.setMemail(rs.getString("memail"));
					m.setMphone(rs.getString("mphone"));
					m.setMaddr(rs.getString("maddr"));
					m.setMjanre(rs.getString("mjanre"));
					m.setMgrade(rs.getInt("mgrade"));
					m.setMopnum(rs.getInt("mopnum"));
					m.setMwarning(rs.getInt("mwarning")); 
					arr.add(m);
				}
			} 
			
				
			catch(Exception e)
			{
				System.out.println("selectOneMember 메소드에서 오류 발생");
				e.printStackTrace();
			}
			
			finally {
				try {conn.close();} 
				catch (SQLException e) 
				{
					System.out.println("selectOneMember 메소드에서 닫기 오류 발생");
					e.printStackTrace();
				}
			}
				
			return arr;	
			
		}


		public void changeOpnum(String mid, int mopnum) {
			String sql = "update member set mopnum = "+mopnum+" where mid ='"+mid+"'";			
			Connection conn = null;
			PreparedStatement pstmt = null;
			System.out.println(">>>>>><<<<<<>><<"+mid);
			System.out.println(">>>>>><<<<<<>><<"+mopnum);
			
			try {							
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 				
				pstmt.executeUpdate();
			}					
			catch(Exception e)
			{
				System.out.println("changeOpnum 메소드에서 오류 발생");
				e.printStackTrace();
			}
				
			finally {
				try {conn.close();} 
				catch (SQLException e) 
				{
					System.out.println("changeOpnum 메소드에서 닫기 오류 발생");
					e.printStackTrace();
				}
			}
	
		}




		public void changeOpnumZero(String mid) {
			String sql = "update member set mopnum = 0 where mid ='"+mid+"'";			
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {							
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 				
				pstmt.executeUpdate();
			}					
			catch(Exception e)
			{
				System.out.println("changeOpnumZero 메소드에서 오류 발생");
				e.printStackTrace();
			}
				
			finally {
				try {conn.close();} 
				catch (SQLException e) 
				{
					System.out.println("changeOpnumZero 메소드에서 닫기 오류 발생");
					e.printStackTrace();
				}
			}
			
			
		}//끝
		
		
		//경고주기
		public void sendWarning(String mid){
			String sql = "update member set mwarning = mwarning + 1 where mid=?";			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {							
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, mid);

				
				pstmt.executeUpdate();
			}
						
				catch(Exception e)
				{
					System.out.println("sendWarning 메소드에서 오류 발생");
					e.printStackTrace();
				}
					
				finally {
					try {conn.close();} 
					catch (SQLException e) 
					{
						System.out.println("sendWarning 메소드에서 닫기 오류 발생");
						e.printStackTrace();
					}
				}
			
			}//경고 끝.	
		

	
}

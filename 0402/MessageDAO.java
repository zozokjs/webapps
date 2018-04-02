package com.mf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.mf.DBManager.DBManager;
import com.mf.dto.MemberVO;
import com.mf.dto.MessageVO;
import com.mf.dto.OrderingVO;

public class MessageDAO {

	public void insertMessage(String mid, String content) {
		String sql = "insert into Message values(Message_seq.nextval, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = formatter.format(cal.getTime());
		Timestamp gdate = Timestamp.valueOf(today);

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setTimestamp(2, gdate);
			pstmt.setString(3, content);
			rs = pstmt.executeQuery(); // sql 실행하여 얻은 결과를 rs에 저장한다.
			System.out.println("--확인용-- insertMessage 메소드 다 읽음");
		} catch (Exception e) {
			System.out.println("insertMessage 메소드에서 오류 발생");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("insertMessage 메소드에서 닫기 오류 발생");
				e.printStackTrace();
			}
		}
	}

	public MessageVO selectOneMessage(String mid) {

		String sql = "select * from message where mid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MessageVO m = null;
		try {

			// 연결을 얻어온다.
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid); // sql문의 첫번째 ?에 userid를 넣는다.
			rs = pstmt.executeQuery(); // sql 실행하여 얻은 결과를 rs에 저장한다.

			if (rs.next()) {
				m = new MessageVO();
				pstmt.setInt(1, m.getGnumber());
				pstmt.setString(2, m.getGreceiver());
				pstmt.setTimestamp(3, m.getGdate());
				pstmt.setString(4, m.getGcontent());
			}
		}

		catch (Exception e) {
			System.out.println("selectOneMessage 메소드에서 오류 발생");
			e.printStackTrace();
		}

		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("selectOneMessage 메소드에서 닫기 오류 발생");
				e.printStackTrace();
			}
		}

		return m;

	}// 셀렉트1 끝

	// 메세지 하나만 가져오는 것.
	public MessageVO selectMessage(String mid) {

		String sql = "select * from Message where mid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MessageVO m = null;
		try {

			// 연결을 얻어온다.
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				m = new MessageVO();
				m.setGreceiver(rs.getString("greceiver"));
				m.setGdate(rs.getTimestamp("mgdate"));
				m.setGcontent(rs.getString("gcontent"));

			}
		}

		catch (Exception e) {
			System.out.println("selectMessage 메소드에서 오류 발생");
			e.printStackTrace();
		}

		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("selectMessage 메소드에서 닫기 오류 발생");
				e.printStackTrace();
			}
		}

		return m;

	}// 셀렉트1 끝
}

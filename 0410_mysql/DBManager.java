package com.cos.util;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {

	public static Connection getConnection() {
		Connection conn = null;                                        // null로 초기화 한다.



		try{

		String url = "jdbc:mysql://localhost:3306/apiserver";        // 사용하려는 데이터베이스명을 포함한 URL 기술

		String id = "scott";                                                    // 사용자 계정

		String pw = "tiger";                                                // 사용자 계정의 패스워드



		Class.forName("com.mysql.jdbc.Driver");                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.

		conn=DriverManager.getConnection(url,id,pw);              // DriverManager 객체로부터 Connection 객체를 얻어온다.

		System.out.println("제대로 연결되었습니다.");                            // 커넥션이 제대로 연결되면 수행된다.



		}catch(Exception e){                                                    // 예외가 발생하면 예외 상황을 처리한다.

		e.printStackTrace();

		}

		return conn;
	}
}

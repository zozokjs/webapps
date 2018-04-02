package com.mf.action.manger;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mf.action.Action;
import com.mf.dao.MemberDAO;
import com.mf.dao.StatisticsDAO;
import com.mf.dto.MemberVO;

public class goManaging implements Action{
	//manageMain 화면으로 가는 액션
	//(아직 액션팩토리에 들어가있지않음)
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("--확인용-- goManaging 진입");
		
		MemberDAO dao = MemberDAO.getInstance();
		List<MemberVO> member = dao.selectByGradeMember(2); //판매자 등급이 2임;
		
		
		
		//통계페이지 표시를위한 겟인스턴스*************************
		StatisticsDAO sdao = StatisticsDAO.getInstance();
		
		//판매자 구매자 비율 구하기
		int seller = sdao.countByGrade(2);
		int buyer = sdao.countByGrade(3);
		
		request.setAttribute("seller", seller);
		request.setAttribute("buyer", buyer);
		
		//장르비율 구하기
		List<Integer> jan = sdao.countByJanre();
		int ballad = jan.get(0);
		int dance = jan.get(1);
		int rock = jan.get(2);
		int hiphop = jan.get(3);
		
		request.setAttribute("ballad", ballad);
		request.setAttribute("dance", dance);
		request.setAttribute("rock", rock);
		request.setAttribute("hiphop", hiphop);
		
		//선호장르비율 구하기
		List<Integer> likeJan = sdao.countByJanre();
		int likeBallad = likeJan.get(0);
		int likeDance = likeJan.get(1);
		int likeRock = likeJan.get(2);
		int likeHiphop = likeJan.get(3);
		
		request.setAttribute("likeBallad", likeBallad);
		request.setAttribute("likeDance", likeDance);
		request.setAttribute("likeRock", likeHiphop);
		request.setAttribute("likeHiphop", likeHiphop);
		
		//**********************************************
				
		
		
		
		request.setAttribute("member", member);
		
		System.out.println(">>>>>>>>>>    "+member.get(0).getMid());
		System.out.println(">>>>>>>>>>    "+member.get(1).getMid());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Boss/manageMain.jsp");
		dispatcher.forward(request, response);
		
		System.out.println("goManaging 다 읽음");
		
	}
}

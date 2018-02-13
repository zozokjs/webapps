package com.mf.action.manger;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mf.action.Action;
import com.mf.dao.MemberDAO;
import com.mf.dto.MemberVO;

public class goManaging implements Action{
	//manageMain 화면으로 가는 액션
	//(아직 액션팩토리에 들어가있지않음)
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		MemberDAO dao = MemberDAO.getInstance();
		List<MemberVO> member = dao.selectByGradeMember(2); //판매자 등급이 2임;
		
		request.setAttribute("member", member);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("Boss/manageMain.jsp");
		dispatcher.forward(request, response);
		
		
	}
}

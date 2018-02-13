package com.mf.action.manger;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mf.action.Action;
import com.mf.action.IOException;
import com.mf.dao.MemberDAO;

public class ManageSeller implements Action{
	//manageSeller 로 가는 액션(판매자 상세보기)
	//필요한 것 -> 셀러 한명의 정보와 셀러의 게시글 정보
	//(아직 액션팩토리에 들어가있지않음)
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.getAttribute("mid");
		
		MemeberDAO mDao = MemberDAO.getInstance();
		BoardDAO bDao = BoardDAO.getInstance();
					
		MemberVO = mDao.selectOneMember(mid);
		BoardVO = bDao.selectAllBySeller(mid);
		
		request.setAttribute("member", member);
		request.setAttribute("board", board);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("Boss/manageSeller.jsp");
		dispatcher.forward(request, response);
		
		
		
	}
}

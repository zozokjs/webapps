package com.mf.action.manger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendWarning implements Action{
	//해당 판매자에게 경고 점수를 주는 액션
	//(아직 액션팩토리에 들어가있지않음)
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//경고 점수를 올리는 메소드를 만든 다음 여기 적용하고 최종적으로는 메인으로 보내야함.
		
		response.sendRedirect("MFServlet?command=goManaging");
		//아직 고매니징은 액션팩토리에 들어가잇지 않음.
	}
}

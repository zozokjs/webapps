package com.mf.action.manger;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mf.action.Action;
import com.mf.dao.MemberDAO;
import com.mf.dao.MessageDAO;

public class SendWarning implements Action{
	//해당 판매자에게 경고 점수를 주는 액션
	//(아직 액션팩토리에 들어가있지않음)
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//경고 점수를 올리는 메소드를 만든 다음 여기 적용하고 최종적으로는 메인으로 보내야함.
		
		
		String mid = request.getParameter("mid");
		String content = request.getParameter("content");		
		
		MessageDAO m = new MessageDAO();
		m.insertMessage(mid, "경고! : "+content);
		
		///여기서 경고 점수도 올려주어야됨 .
		
		MemberDAO member = MemberDAO.getInstance();
		member.sendWarning(mid);
		
		//
								
   //완료되면 창이 꺼져야한다.
		
		
		System.out.println("SendMessage 다 읽음");
						
		//아직 고매니징은 액션팩토리에 들어가잇지 않음.
	}
}

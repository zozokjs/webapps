package com.mf.action.manger;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mf.action.Action;
import com.mf.dao.MessageDAO;

public class SendMessage implements Action{
	//해당 판매자에게 쪽지를 보내는 액션
	//(아직 액션팩토리에 들어가있지않음)
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("--확인용-- SendMessage 진입");
		
		String mid = request.getParameter("mid");
		String content = request.getParameter("content");

		MessageDAO m = new MessageDAO();
		m.insertMessage(mid, content);
		
   //완료되면 창이 꺼져야한다.
		
		
		System.out.println("SendMessage 다 읽음");
	}
}

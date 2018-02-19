package com.mf.action.manger;

import javax.servlet.ServletException;

public class goChart implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("--확인용-- goManaging 진입");
		
		ChartDAO dao = ChartDAO.getInstance();
		
		
		int sellc = dao.countMemberByGrade(2);
		int buyc = dao.countMemberByGrade(3);
		
		int pcount = dao.countProduct();
		int ocount = dao.countOrder();
		
		
		
		request.setAttribute("sellc", sellc);
		request.setAttribute("buyc", buyc);
		request.setAttribute("pcount", pcount);
		request.setAttribute("ocount", ocount);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Boss/showChart.jsp");
		dispatcher.forward(request, response);
		
		System.out.println("showChart 다 읽음");
		
	}
}

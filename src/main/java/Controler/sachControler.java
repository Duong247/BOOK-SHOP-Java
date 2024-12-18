package Controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loaiModal.loaibo;
import sachModal.sach;
import sachModal.sachbo;

/**
 * Servlet implementation class sachControler
 */
@WebServlet("/sachControler")
public class sachControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sachControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
//			phan trang
			
			
			
//			lay danh sach loai
			loaibo lbo = new loaibo();
			request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");
//	      chuyen ds ve tc.jsp
			request.setAttribute("dsloai", lbo.getloai());
//			lay sach ve
			sachbo sbo = new sachbo();
//			ArrayList<sach> ds = sbo.getsachphantrang(1);
			ArrayList<sach> ds = sbo.getsach();
			
			String ml= request.getParameter("ml");
			String key= request.getParameter("txttk");
			if(ml!=null) ds=sbo.Timma(ml);
			else
				if(key!=null) ds = sbo.Tim(key);
			request.setAttribute("dssach", ds);
//			request.setAttribute("PageCount", PageCount);
			request.setAttribute("txttk",key);
//			RequestDispatcher rd = request.getRequestDispatcher("tc.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("tc2.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package Controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import khachHangModal.khachhang;
import khachHangModal.khachhangbo;
import loaiModal.loaibo;

/**
 * Servlet implementation class dangnhapController
 */
@WebServlet("/dangnhapController")
public class dangnhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			khachhangbo khbo = new khachhangbo();
			
			String un= request.getParameter("txtun");
			String pass= request.getParameter("txtpass");
			String tb=null;
			if(un!=null&&pass!=null){
				for(khachhang kh: khbo.getkh()) {
					if(un.equals(kh.getTendn())&&pass.equals(kh.getPass())) {
						HttpSession session = request.getSession();
						session.setAttribute("dn", un);
						response.sendRedirect("sachControler");
						return;
					}
				}
				tb="Dang nhap sai";
				request.setAttribute("tb", tb);
			  if(un.equals("abc")&&pass.equals("123")){
				  HttpSession session = request.getSession();
				  session.setAttribute("dn", un);
				  RequestDispatcher rd = request.getRequestDispatcher("tc.jsp");
				  rd.forward(request, response);
				  response.sendRedirect("sachControler");
				  return;
			  }else {
				  tb="Dang nhap sai";
				  request.setAttribute("tb", tb);			  
			  }
		  }
			RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
			rd.forward(request, response);
//			response.sendRedirect("htgio")
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

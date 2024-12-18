package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khachHangModal.khachhangbo;
import loaiModal.loaibo;
import sachModal.sachbo;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {
			khachhangbo khbo = new khachhangbo();
			loaibo lbo = new loaibo();
			sachbo sbo = new sachbo();
			request.setAttribute("totalKh", khbo.dẹmkh());
			request.setAttribute("totalLoai", lbo.demLoai());
			request.setAttribute("totalSach", sbo.demSach());			
			if( request.getParameter("direct")!= null) {
				if( request.getParameter("direct").equals("categories")) {
					request.setAttribute("dsloai", lbo.getloai());
					RequestDispatcher rd = request.getRequestDispatcher("AdminCategories.jsp");
					rd.forward(request, response);
				}
				if(request.getParameter("direct").equals("books")) {
					request.setAttribute("dssach", sbo.getsach());
					RequestDispatcher rd = request.getRequestDispatcher("AdminBook.jsp");
					rd.forward(request, response);
				}
				if(request.getParameter("direct").equals("orders")) {
					RequestDispatcher rd = request.getRequestDispatcher("OrderController");
					rd.forward(request, response);
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

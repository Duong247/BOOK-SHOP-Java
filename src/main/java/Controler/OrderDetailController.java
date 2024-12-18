package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chitietdonhang.chitietdonhangBo;
import donhang.donhangBo;

/**
 * Servlet implementation class OrderDetailController
 */
@WebServlet("/OrderDetailController")
public class OrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String action  = request.getParameter("action");
			String cthd = request.getParameter("cthd");
			chitietdonhangBo dhbo = new chitietdonhangBo();
			donhangBo dbo = new donhangBo();
			
			if(request.getParameter("Luu")!=null) {
				int slm =  Integer.parseInt(request.getParameter("slm"));
				String mactHD = request.getParameter("mactHD");
				dhbo.suaSL(slm, mactHD);
			}
			
			
			if(action!=null && action.equals("confirm") && cthd!=null) {
				dhbo.xacnhan(cthd);
				response.sendRedirect("OrderDetailController?id="+id);
			}
			
			if(action!=null && action.equals("delete") && cthd!=null) {
				dhbo.xoachitiet(cthd);
				response.sendRedirect("OrderDetailController?id="+id);
			}
			
			if( action!= null && action.equals("xacnhanHD") && id!=null) {
				dbo.xacnhanHD(id);
				response.sendRedirect("AdminController?direct=orders");
			}
			
			if( id!=null) {
				System.out.println(id);
				request.setAttribute("dshang", dhbo.getdshang(id));
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("Chitietdonhang.jsp");
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

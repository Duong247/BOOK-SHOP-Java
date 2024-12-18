package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import khachHangModal.khachhang;
import lichsuModal.lichsuBo;
import loaiModal.loaibo;

/**
 * Servlet implementation class lichsuControler
 */
@WebServlet("/lichsuControler")
public class lichsuControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsuControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
		        HttpSession session=request.getSession();
		        //Kiem tra xem kh da dang nhap chua
		           if(session.getAttribute("dn")==null)//Chua dang nhap
		               response.sendRedirect("dangnhapController");
		           else {
		               khachhang kh=(khachhang)session.getAttribute("dn");
		               lichsuBo lsbo= new lichsuBo();
		               request.setAttribute("ds", lsbo.getLichsu(kh.getMakh()));
		        loaibo lbo= new loaibo();
		        request.setAttribute("dsloai", lbo.getloai());
		           RequestDispatcher rd= request.getRequestDispatcher("lichsu.jsp");
		            rd.forward(request, response);
		           }
		   } catch (Exception e) {
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

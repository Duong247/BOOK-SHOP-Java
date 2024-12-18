package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dangnhapAdminModal.dangnhapAdminBo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class dangnhapAdminController
 */
@WebServlet("/dangnhapAdminController")
public class dangnhapAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			String tb= null;
			boolean IsloginInf = false;
			boolean Iscaptcha = false;
			Integer countWrong = (Integer)session.getAttribute("countWrong");
			if (countWrong == null) {
				countWrong = 0;
			}
			dangnhapAdminBo dnBo = new dangnhapAdminBo();
			String tendn = (String) request.getParameter("txtun");
			String matkhau = (String) request.getParameter("txtpass");
			if(dnBo.KtDangNhap(tendn,matkhau) != null){
				session.setAttribute("dn", tendn);
				IsloginInf = true;
				if (countWrong <=3) {
					session.setAttribute("countWrong",0);
					response.sendRedirect("sachControler");
					return;
				}
			}else {
				countWrong++;
				tb="tai khoan hoac mat khau sai";
			}
			// capcha
			if (tendn!=null && countWrong>3){
				Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
				request.setCharacterEncoding("UTF-8");
				String answer = request.getParameter("answer");
				if (answer!=null) {
					if (captcha.isCorrect(answer)) {
						Iscaptcha = true;
					} else {
						request.setAttribute("capcha","CaptCha sai!");
					}
				}
			}
			
			if(Iscaptcha && IsloginInf) {
				response.sendRedirect("AdminController");
				session.setAttribute("countWrong",0);
			}
			
			session.setAttribute("countWrong", countWrong);
			request.setAttribute("tb", tb);
			request.setAttribute("tendn", tendn);
			request.setAttribute("mk", matkhau);
			RequestDispatcher rd = request.getRequestDispatcher("dangNhapAdmin.jsp");
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

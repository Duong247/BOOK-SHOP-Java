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

import giohangModal.giohangbo;

/**
 * Servlet implementation class xoasuaController
 */
@WebServlet("/xoasuaController")
public class xoasuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoasuaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//giohangbo gh=(giohangbo) request.getAttribute("gh");
		HttpSession session = request.getSession();
		giohangbo gh=(giohangbo)session.getAttribute("gh");
		String[] gtck=request.getParameterValues("ck");
			
		
		if(request.getParameter("xoachon")!=null && gtck != null){//Can xoa cac sach da chon
			for(String ms: gtck)
				gh.xoa(ms);
		}
		String mssua=request.getParameter("butsuasl");
		String slsua=request.getParameter(mssua);
		if(mssua!=null){//Can sua sl
			gh.Them(mssua, "", (long)0,Long.parseLong(slsua));
		}
//		request.setAttribute("gh", gh);
		session.setAttribute("gh", gh);
		
		response.sendRedirect("htgioController");
//		RequestDispatcher rd = request.getRequestDispatcher("htgio.jsp");
//		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

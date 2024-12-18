package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import loaiModal.loaibo;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String ml = request.getParameter("ml");
			String tl = request.getParameter("tl");
			String id = request.getParameter("id");
			String action=request.getParameter("action");
			request.setAttribute("id",id);
			loaibo lbo = new loaibo();
			if(id != "0") {
				request.setAttribute("tls",lbo.gettl(id) );
			}
			
			
			
			if(ml != null && tl!=null) {
				if (action.equals("add")) {
					if(lbo.themLoai(ml, tl) ) {
						RequestDispatcher rd = request.getRequestDispatcher("AdminController?direct=categories");
						rd.forward(request, response);
//						System.out.println("da them");
					}else {
						//ToDo: thong bao loi
						response.sendRedirect("AdminController");
//						System.out.println("co goi ham");
					}						
				}else if(action.equals("update")) {
					if(lbo.suaLoai(ml, tl)) {
						RequestDispatcher rd = request.getRequestDispatcher("AdminController?direct=categories");
						rd.forward(request, response);
//						System.out.println("da them");
					}else {
						//ToDo: thong bao loi
						response.sendRedirect("AdminController");
//						System.out.println("co goi ham");
					}
				}
			}else {
//				response.sendRedirect("CategoryInput.jsp");
				if(action!=null &&  action.equals("delete")) {
					if(lbo.xoaLoai(id)) {
						RequestDispatcher rd = request.getRequestDispatcher("AdminController?direct=categories");
						rd.forward(request, response);
						System.out.println("da xoa");
					}
				}else {
					System.out.println("chua them");
					RequestDispatcher rd = request.getRequestDispatcher("CategoryInput.jsp");
					rd.forward(request, response);					
				}
			}
			
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

package Controler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import loaiModal.loaibo;
import sachModal.sachAdmin;
import sachModal.sachbo;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			String ms = request.getParameter("ms");
			System.out.println(ms);
			String id = request.getParameter("id");
			String action=request.getParameter("action");
			request.setAttribute("id",id);
			loaibo lbo = new loaibo();
			sachbo sbo = new sachbo();
			request.setAttribute("dsloai", lbo.getloai());
			
			if (id != null && !id.equals("0")) {
			    sachAdmin temp = sbo.getSingleSach(id);
			    if (temp != null) { // Kiểm tra temp có null không
			        request.setAttribute("data", temp);
			    } else {
			        // Xử lý khi không tìm thấy sách
			        request.setAttribute("error", "Không tìm thấy sách với id: " + id);
			    }
			}
			
			if(action!= null && action.equals("delete") && id!=null) {
				sbo.xoaSach(id);
				response.sendRedirect("AdminController?direct=books");
			}
			 
						
			RequestDispatcher rd = request.getRequestDispatcher("BookInput.jsp");
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

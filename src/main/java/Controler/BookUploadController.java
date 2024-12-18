package Controler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import sachModal.sachbo;

/**
 * Servlet implementation class BookUploadController
 */
@WebServlet("/BookUploadController")
public class BookUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUploadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			sachbo sbo = new sachbo();
			java.sql.Date ngaynhapDate = null;
			DiskFileItemFactory factory = new DiskFileItemFactory();
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			String dirUrl1 = request.getServletContext().getRealPath("") +  File.separator + "image_sach";
			List<FileItem> fileItems;
			fileItems = upload.parseRequest(request);
			
			String masach = null;
			String tensach = null;
			String tacgia = null;
			long gia = 0;
			int soluong = 0;
			String ngaynhap = null;
			String anh = null;
			int sotap = 0;
			String maloai = null;
			String action = null;
			
			if(fileItems != null && !fileItems.isEmpty()) {
				for (FileItem fileItem : fileItems) {
					if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
						// xử lý file
						String nameimg = fileItem.getName();
						if (!nameimg.equals("")) {
							//Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
							String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "image_sach";
							File dir = new File(dirUrl);
							if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
								dir.mkdir();
							}
							String fileImg = dirUrl + File.separator + nameimg;
							File file = new File(fileImg);//tạo file
							anh = "image_sach/"+nameimg;
							try {
								fileItem.write(file);//lưu file
				            	System.out.println("UPLOAD THÀNH CÔNG...!");
//				            	System.out.println("Đường dẫn lưu file là: "+dirUrl);
				            	System.out.println(anh);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
					else//Neu la control
					{
						String sach = fileItem.getFieldName();

						if (sach.equals("ms")) {
						    masach = fileItem.getString("UTF-8");
						}
						if (sach.equals("ts")) {
						    tensach = fileItem.getString("UTF-8");
						}
						if (sach.equals("tacgia")) {
						    tacgia = fileItem.getString("UTF-8");
						}
						if (sach.equals("gia") && sach != null) {
						    String giaStr = fileItem.getString("UTF-8").trim();
						    if (!giaStr.isEmpty()) {
						        gia = Long.parseLong(giaStr);
						    }
						}
						if (sach.equals("sl")) {
						    String soluongStr = fileItem.getString("UTF-8").trim();
						    if (!soluongStr.isEmpty()) {
						        soluong = Integer.parseInt(soluongStr);
						    }
						}
						
						if (sach.equals("ngayNhap")) {
							String ngaynhapStr = fileItem.getString("UTF-8").trim();
							
							
							if (!ngaynhapStr.isEmpty()) {
								ngaynhap = fileItem.getString("UTF-8");
								
								SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					            java.util.Date parsedDate = dateFormat.parse(ngaynhapStr);
					            ngaynhapDate = new java.sql.Date(parsedDate.getTime());
						    }else {
						    	LocalDate currentDate = LocalDate.now();
					            ngaynhapDate = java.sql.Date.valueOf(currentDate);
						    }

						    
						}
						if (sach.equals("stap")) {
						    String sotapStr = fileItem.getString("UTF-8").trim();
						    if (!sotapStr.isEmpty()) {
						        sotap = Integer.parseInt(sotapStr);
						    }
						}
						if (sach.equals("ml")) {
						    maloai = fileItem.getString("UTF-8");
						}
						if (sach.equals("action")) {
							action = fileItem.getString("UTF-8");
						}
						
					}
				}
				
				if(action.equals("add")) {
					 if(!masach.isEmpty() ) {
//						 System.out.println(maloai);
						 sbo.themSach(masach, tensach, soluong, gia, maloai, sotap, anh, ngaynhapDate, tacgia);
						 System.out.println("them sach");
						 response.sendRedirect("AdminController?direct=books");
					 }
				}else if (action.equals("update")){
					System.out.println("update thanh cong");
					sbo.suaSach(masach, tensach, soluong, gia, maloai, sotap, anh, ngaynhapDate, tacgia);
					response.sendRedirect("AdminController?direct=books");
				}
			}else {
				response.sendRedirect("AdminController");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//Lấy về các đối tượng gửi lên
		//duyệt qua các đối tượng gửi lên từ client gồm file và các control
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

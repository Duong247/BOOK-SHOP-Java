package sachModal;

import java.beans.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ketNoiModal.KetNoi;
import loaiModal.loai;

public class sachdao {
	public ArrayList<sach> getsach() throws Exception{
		ArrayList<sach> ds= new ArrayList<sach>();
	    //b1: ket noi
	    KetNoi kn = new KetNoi();
	    kn.ketnoi();
//	    b2: query sql
	    String sql = "select * from sach";
//	    b3: thuc hien cau lenh sql
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    ResultSet rs = cmd.executeQuery();
	 
	    
		//String masach, String tensach, String tacgia,
		//Long soluong, Long gia, String anh, String maloai
		while (rs.next()) {
			String masach= rs.getString("masach");
			String tensach= rs.getString("tensach");
			String tacgia = rs.getString("tacgia");
			Long soluong = rs.getLong("soluong");
			Long gia=  rs.getLong("gia");
			String anh = rs.getString("anh");
			String maloai = rs.getString("maloai");
			ds.add(new sach(masach,tensach,tacgia,soluong,gia,anh,maloai));
		}
		rs.close();kn.cn.close();
		return ds;
	 }
	
	
   public ArrayList<sach> getsachPhanTrang(int currentPage,int pagesize) throws Exception{
	ArrayList<sach> ds= new ArrayList<sach>();
	
    // Tính toán startRow và endRow cho phân trang
    int startRow = (currentPage - 1) * pagesize + 1;
    int endRow = currentPage * pagesize;

    //b1: ket noi
    KetNoi kn = new KetNoi();
    kn.ketnoi();
//    b2: query sql
//    String sql = "select * from sach";
    String sql = "SELECT * FROM ("
    		+ "	SELECT ROW_NUMBER() OVER (ORDER BY masach) AS RowNum, *"
    		+ "FROM sach"
    		+ ") AS t"
    		+ "WHERE RowNum BETWEEN ? AND ?";
//    b3: thuc hien cau lenh sql
    PreparedStatement cmd = kn.cn.prepareStatement(sql);
    cmd.setInt(1, startRow); 
    cmd.setInt(2, endRow);
    ResultSet rs = cmd.executeQuery();
 
    
	//String masach, String tensach, String tacgia,
	//Long soluong, Long gia, String anh, String maloai
	while (rs.next()) {
		String masach= rs.getString("masach");
		String tensach= rs.getString("tensach");
		String tacgia = rs.getString("tacgia");
		Long soluong = rs.getLong("soluong");
		Long gia=  rs.getLong("gia");
		String anh = rs.getString("anh");
		String maloai = rs.getString("maloai");
		ds.add(new sach(masach,tensach,tacgia,soluong,gia,anh,maloai));
	}
	rs.close();kn.cn.close();
	return ds;
   }
   
   
   public int getCount() throws Exception {
//		b1: ket noi csdl
	   KetNoi kn = new KetNoi();
       kn.ketnoi();
//      b2 truy van du lieu
       String query = "select count(*) as totalSach from sach";
       PreparedStatement cmd = kn.cn.prepareStatement(query);
       ResultSet rs = cmd.executeQuery();

       int total = 0;
       if (rs.next()) {
           total = rs.getInt("totalSach"); 
       }
       
       rs.close();
       kn.cn.close();
       
       return total;
   }
   
   public boolean themSach(String masach,String tensach,int soluong,long gia,String maloai,int sotap,String anh,Date NgayNhap,String tacgia) throws Exception {
	   KetNoi kn = new KetNoi();
	   kn.ketnoi();
	   String sql = "INSERT INTO sach (masach,tensach,soluong,gia,maloai,sotap,anh,NgayNhap,tacgia) "
	   		+ "VALUES (?,?,?,?,?,?,?,?,?);";
	   Date today = new Date(System.currentTimeMillis());
	   PreparedStatement cmd = kn.cn.prepareStatement(sql);
	   cmd.setString(1,masach);
	   cmd.setString(2, tensach);
	   cmd.setInt(3, soluong);
	   cmd.setLong(4, gia);
	   cmd.setString(5, maloai);
	   cmd.setInt(6, sotap);
	   cmd.setString(7, anh);
	   cmd.setDate(8, NgayNhap==null?today:NgayNhap);
	   cmd.setString(9, tacgia);
	   int rs = cmd.executeUpdate();
       kn.cn.close();
	   return rs > 0;
   }
   
   
   
   
   public boolean suaSach(String masach,String tensach,int soluong,long gia,String maloai,int sotap,String anh,Date NgayNhap,String tacgia) throws Exception {
	   KetNoi kn = new KetNoi();
	   kn.ketnoi();
	   String sql = "UPDATE sach "
			   		+ "SET tensach=?,soluong=?,gia=?,maloai=?,sotap=?,anh=?,NgayNhap=?,tacgia=? "
			   		+ "WHERE masach=?;";
	   Date today = new Date(System.currentTimeMillis());
	   PreparedStatement cmd = kn.cn.prepareStatement(sql);
	   cmd.setString(1, tensach);
	   cmd.setInt(2, soluong);
	   cmd.setLong(3, gia);
	   cmd.setString(4, maloai);
	   cmd.setInt(5, sotap);
	   cmd.setString(6, anh);
	   cmd.setDate(7, NgayNhap==null?today:NgayNhap);
	   cmd.setString(8, tacgia);
	   cmd.setString(9,masach);
	   int rs = cmd.executeUpdate();
       kn.cn.close();
	   return rs > 0;
   }
   
   
   public sachAdmin getSinglesach(String ms) throws Exception {
	   KetNoi kn = new KetNoi();
	   kn.ketnoi();
	   sachAdmin sachad = null;
	   String sql = "select * from sach where masach=?";
	   PreparedStatement cmd = kn.cn.prepareStatement(sql);
	   cmd.setString(1, ms);
	   ResultSet rs = cmd.executeQuery();
	   if(rs.next()) {
		   	String masach= rs.getString("masach");
			String tensach= rs.getString("tensach");
			Long soluong = rs.getLong("soluong");
			Long gia=  rs.getLong("gia");
			String anh = rs.getString("anh");
			int sotap = rs.getInt("sotap");
			String maloai = rs.getString("maloai");
			Date ngayNhap = rs.getDate("NgayNhap");
			String tacgia = rs.getString("tacgia");
			System.out.println("ma loai data "+ maloai);
			sachad = new sachAdmin(masach,tensach,soluong,gia,maloai,sotap,anh,ngayNhap,tacgia);
	   }
	   rs.close();
       kn.cn.close();
       return sachad;
   }
   
   public boolean xoaSach(String ms) throws Exception {
   	KetNoi kn = new KetNoi();
   	kn.ketnoi();
   	String sql = "DELETE FROM sach WHERE masach = ?";
   	PreparedStatement cmd = kn.cn.prepareStatement(sql);
	   	cmd.setString(1,ms);
		int rs = cmd.executeUpdate();
		kn.cn.close();
		return rs > 0;
   }
   
   
   
}



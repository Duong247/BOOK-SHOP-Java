package donhang;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModal.KetNoi;
import loaiModal.loai;

public class donhangDao {
	public ArrayList<donhang> getdh() throws Exception{
		ArrayList<donhang> dsDonhang = new ArrayList<donhang>();
		KetNoi kn = new KetNoi();
	     kn.ketnoi();

	     String sql = "SELECT dbo.hoadon.MaHoaDon, dbo.KhachHang.hoten, dbo.hoadon.NgayMua, SUM(dbo.ChiTietHoaDon.SoLuongMua * dbo.sach.gia) AS ThanhTien\r\n"
	     		+ "FROM     dbo.ChiTietHoaDon INNER JOIN\r\n"
	     		+ "                  dbo.hoadon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.hoadon.MaHoaDon INNER JOIN\r\n"
	     		+ "                  dbo.KhachHang ON dbo.hoadon.makh = dbo.KhachHang.makh INNER JOIN\r\n"
	     		+ "                  dbo.sach ON dbo.ChiTietHoaDon.MaSach = dbo.sach.masach INNER JOIN\r\n"
	     		+ "                  dbo.loai ON dbo.sach.maloai = dbo.loai.maloai CROSS JOIN\r\n"
	     		+ "                  dbo.DangNhap\r\n"
	     		+ "WHERE  (dbo.hoadon.damua = 0)\r\n"
	     		+ "GROUP BY dbo.hoadon.MaHoaDon, dbo.KhachHang.hoten, dbo.hoadon.NgayMua";

	     PreparedStatement cmd = kn.cn.prepareStatement(sql);
	     ResultSet rs = cmd.executeQuery();
	     while(rs.next()) {
	    	 String mahd =rs.getString("MaHoaDon");
	    	 String hoten= rs.getString("hoten");
	    	 Date ngaymua= rs.getDate("NgayMua");
	    	 Long thanhtien= rs.getLong("ThanhTien");
	    	 dsDonhang.add(new donhang(mahd,hoten,ngaymua,thanhtien));
	     }
	     kn.cn.close();
	     rs.close();
	     return dsDonhang;
	}
	
	public boolean xacnhanHD(String maHD) throws Exception {
		KetNoi kn  = new KetNoi();
		kn.ketnoi();
		String sql="UPDATE ChiTietHoaDon\r\n"
				+ "set damua = 1\r\n"
				+ "where MaHoaDon = ?\r\n"
				+ "UPDATE hoadon\r\n"
				+ "set damua = 1\r\n"
				+ "where MaHoaDon = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maHD);
		cmd.setString(2, maHD);
		int rs = cmd.executeUpdate();
		kn.cn.close();
		return rs>0;
	}
	
}

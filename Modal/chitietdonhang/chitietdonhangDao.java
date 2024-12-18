package chitietdonhang;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import donhang.donhang;
import ketNoiModal.KetNoi;

public class chitietdonhangDao {
	public ArrayList<chitietdonhang> getdh(String mahoadon) throws Exception{
		ArrayList<chitietdonhang> dshang = new ArrayList<chitietdonhang>();
		KetNoi kn = new KetNoi();
	     kn.ketnoi();

	     String sql = "SELECT dbo.ChiTietHoaDon.MaHoaDon, dbo.ChiTietHoaDon.MaChiTietHD, dbo.KhachHang.hoten, dbo.sach.tensach, dbo.sach.gia, dbo.hoadon.NgayMua, dbo.ChiTietHoaDon.SoLuongMua\r\n"
	     		+ "FROM     dbo.ChiTietHoaDon INNER JOIN\r\n"
	     		+ "                  dbo.hoadon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.hoadon.MaHoaDon INNER JOIN\r\n"
	     		+ "                  dbo.KhachHang ON dbo.hoadon.makh = dbo.KhachHang.makh INNER JOIN\r\n"
	     		+ "                  dbo.sach ON dbo.ChiTietHoaDon.MaSach = dbo.sach.masach INNER JOIN\r\n"
	     		+ "                  dbo.loai ON dbo.sach.maloai = dbo.loai.maloai\r\n"
	     		+ "WHERE  (dbo.ChiTietHoaDon.MaHoaDon = ?) AND (dbo.ChiTietHoaDon.damua = 0)";

	     PreparedStatement cmd = kn.cn.prepareStatement(sql);
	     cmd.setString(1, mahoadon);
	     ResultSet rs = cmd.executeQuery();
	     while(rs.next()) {
	    	 String mahd =rs.getString("MaHoaDon");
	    	 String machitiethd = rs.getString("MaChiTietHD");
	    	 String hoten= rs.getString("hoten");
	    	 String tensach= rs.getString("tensach");
	    	 int soluong= rs.getInt("SoLuongMua");
	    	 long gia = rs.getLong("gia");
	    	 Date ngaymua= rs.getDate("NgayMua");
	    	 dshang.add(new chitietdonhang(mahd,machitiethd,hoten,tensach,soluong,gia,ngaymua));
	     }
	     kn.cn.close();
	     rs.close();
	     return dshang;
	}
	
	public boolean suaSL(int soluong,String  mactHD) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "UPDATE ChiTietHoaDon\r\n"
				+ "SET SoLuongMua = ?\r\n"
				+ "WHERE MaChiTietHD = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setInt(1, soluong);
	    cmd.setString(2, mactHD);
	    int rs = cmd.executeUpdate();
	    kn.cn.close();
	    return rs>0;
	}
	
	public boolean xacnhan(String mactHD) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql ="UPDATE ChiTietHoaDon\r\n"
				+ "SET damua = 1 \r\n"
				+ "WHERE MaChiTietHD=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setString(1, mactHD);
	    int rs = cmd.executeUpdate();
	    kn.cn.close();
	    return rs>0;
	}
	
	public boolean xacnhanSL(int soluong,String masach) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql ="UPDATE sach\r\n"
				+ "SET soluong = ?\r\n"
				+ "WHERE masach=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, soluong);
		cmd.setString(2, masach);
	    int rs = cmd.executeUpdate();
	    kn.cn.close();
	    return rs>0;
	}
	
	public boolean xoachitiet(String mactHD) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "DELETE FROM ChiTietHoaDon\r\n"
				+ "WHERE MaChiTietHD = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, mactHD);
		int rs = cmd.executeUpdate();
		kn.cn.close();
		return rs > 0;
	}
	
	
}

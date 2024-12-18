package khachHangModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModal.KetNoi;

public class khachhangdao {
	public ArrayList<khachhang> getkh() throws Exception{
		ArrayList<khachhang> ds= new ArrayList<khachhang>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql="select * from KhachHang";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			long makh = rs.getLong("makh");
			String hoten = rs.getString("hoten");
			String diachi= rs.getString("diachi");
			String sodt= rs.getString("sodt");
			String email = rs.getString("email");
			String tendn = rs.getString("tendn");
			String pass = rs.getString("pass");
			ds.add(new khachhang(makh,hoten,diachi,sodt,email,tendn,pass));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	
	public int Demkh() throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		int count =0;
		String sql = "SELECT COUNT(*) AS total FROM KhachHang";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		if(rs.next()) {
			count =  rs.getInt("total");
		}
		
		rs.close();
	    kn.cn.close();
		return count;
	}
	
}

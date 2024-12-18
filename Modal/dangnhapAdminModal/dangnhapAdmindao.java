package dangnhapAdminModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModal.KetNoi;
import khachHangModal.khachhang;

public class dangnhapAdmindao {
	public String KtDangNhap(String tendn, String pass) throws Exception{
		ArrayList<dangnhapAdmin> ds= new ArrayList<dangnhapAdmin>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql="select * from DangNhap where TenDangNhap =? and MatKhau=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
        cmd.setString(2, pass);
        ResultSet rs = cmd.executeQuery();
        String kq = null;
        if(rs.next() == true) {
        	kq= tendn;
        }
		rs.close();
		kn.cn.close();
		return kq;
	}
}

package lichsuModal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModal.KetNoi;
import loaiModal.loai;

public class lichsuDao {
	public ArrayList<lichsu> getLichsu(long makh) throws Exception{
	    ArrayList<lichsu> ds= new ArrayList<lichsu>();
	    KetNoi kn= new KetNoi();
	    kn.ketnoi();
	    String sql="select * from Vlichsu where makh=?";
	    PreparedStatement cmd= kn.cn.prepareStatement(sql);
	    cmd.setLong(1, makh);
	    ResultSet rs= cmd.executeQuery();
	    while(rs.next()) {
	        String tensach=rs.getString("tensach");
	        long SoLuongMua=rs.getLong("SoLuongMua");
	        long gia=rs.getLong("gia");;
	        long ThanhTien=rs.getLong("ThanhTien");;
	        Date NgayMua=rs.getDate("NgayMua");
	        boolean damua=rs.getBoolean("damua");
	ds.add(new lichsu(tensach, SoLuongMua, gia, ThanhTien, NgayMua, damua, makh));
	    } rs.close();kn.cn.close();
	    return ds;
	}
}

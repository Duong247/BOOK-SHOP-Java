package loaiModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModal.KetNoi;

public class loaidao {
    public ArrayList<loai> getloai() throws Exception{
     ArrayList<loai> ds= new ArrayList<loai>();
     //b1: ket noi
     KetNoi kn = new KetNoi();
     kn.ketnoi();
//     b2: query sql
     String sql = "select * from loai";
//     b3: thuc hien cau lenh sql
     PreparedStatement cmd = kn.cn.prepareStatement(sql);
     ResultSet rs = cmd.executeQuery();
//     duyet rs va luu vao ds
     while(rs.next()) {
    	   String maloai =rs.getString("maloai");
    	   String tenloai= rs.getString("tenloai");
    	   ds.add(new loai(maloai,tenloai));
     }
     rs.close();kn.cn.close();
     return ds;
    }
    
    public int Demsach() throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		int count =0;
		String sql = "SELECT COUNT(*) as totalSach FROM loai";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		if(rs.next()) {
			count =  rs.getInt("totalSach");
		}
		rs.close();
	    kn.cn.close();
		return count;
	}
    
    public boolean themLoai(String maloai,String tenloai) throws Exception {
 	   KetNoi kn = new KetNoi();
 	   kn.ketnoi();
 	   String sql = "INSERT INTO loai VALUES (?,?);";
 	   PreparedStatement cmd = kn.cn.prepareStatement(sql);
 	   cmd.setString(1,maloai);
 	   cmd.setString(2, tenloai);
 	   int rs = cmd.executeUpdate();
 	   kn.cn.close();
 	   return rs > 0;
    }
    
    public boolean suaLoai(String maloai,String tenloai) throws Exception {
  	   KetNoi kn = new KetNoi();
  	   kn.ketnoi();
  	   String sql = "UPDATE loai "
  	   		+ "SET tenloai = ? "
  	   		+ "WHERE maloai = ?";
  	   PreparedStatement cmd = kn.cn.prepareStatement(sql);
  	   cmd.setString(1, tenloai);
  	   cmd.setString(2,maloai);
  	   int rs = cmd.executeUpdate();
  	   kn.cn.close();
  	   return rs > 0;
     }
    
    public loai getSingleloai(String ml) throws Exception {
    	KetNoi kn = new KetNoi();
    	kn.ketnoi();
    	loai oj = null;
    	String sql ="SELECT * FROM loai WHERE maloai = ?";
    	PreparedStatement cmd = kn.cn.prepareStatement(sql);
   	    cmd.setString(1,ml);
   	    ResultSet rs = cmd.executeQuery();
   	    if(rs.next()) {
   	    	String maloai =rs.getString("maloai");
   	    	String tenloai= rs.getString("tenloai");
   	    	oj = new loai(maloai,tenloai);
   	    }
   	    rs.close();
   	    kn.cn.close();
   	    return oj;
    }
    
    public boolean xoaLoai(String ml) throws Exception {
    	KetNoi kn = new KetNoi();
    	kn.ketnoi();
    	String sql = "DELETE FROM loai WHERE maloai = ?";
    	PreparedStatement cmd = kn.cn.prepareStatement(sql);
	   	cmd.setString(1,ml);
		int rs = cmd.executeUpdate();
		kn.cn.close();
		return rs > 0;
    }
    
    
}

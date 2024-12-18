package loaiModal;

import java.util.ArrayList;

public class loaibo {
    loaidao ldao= new loaidao();
    public ArrayList<loai> getloai() throws Exception{
    	return ldao.getloai();
    }
    
    public int demLoai() throws Exception {
    	return ldao.Demsach();
    }
    
    public boolean themLoai(String maloai, String tenloai) throws Exception {
    	return ldao.themLoai(maloai, tenloai);
    }  
    
    public boolean suaLoai(String maloai, String tenloai) throws Exception {
    	return ldao.suaLoai(maloai, tenloai);
    }
    
    public loai getSingleloai(String ml) throws Exception {
    	return ldao.getSingleloai(ml);
    }
    
    public String gettl(String ml) throws Exception {
    	ArrayList<loai> ds = ldao.getloai(); 
    	for (loai item :ds) {
    		if(item.getMaloai().equals(ml)) {
    			return item.getTenloai();
    		}
    	}
    	return "";
    }
    
    public boolean xoaLoai(String ml) throws Exception {
    	return ldao.xoaLoai(ml);
		
	}
    
}

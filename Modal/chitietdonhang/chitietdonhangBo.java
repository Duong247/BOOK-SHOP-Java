package chitietdonhang;

import java.util.ArrayList;

public class chitietdonhangBo {
	chitietdonhangDao ctDao = new chitietdonhangDao();
	public ArrayList<chitietdonhang> getdshang (String mahoadon) throws Exception{
		return ctDao.getdh(mahoadon);
	}	
	
	public boolean suaSL(int sl,String mactHD) throws Exception {
		return ctDao.suaSL(sl, mactHD);
	}
	
	public boolean xacnhan(String mactHD) throws Exception {
		return ctDao.xacnhan(mactHD);
	}
	
	public boolean xoachitiet(String mactHD) throws Exception {
		return ctDao.xoachitiet(mactHD);
	}
}

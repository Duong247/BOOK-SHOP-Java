package donhang;

import java.util.ArrayList;

public class donhangBo {
	donhangDao dhDao = new donhangDao();
	public ArrayList<donhang> getds() throws Exception{
		return dhDao.getdh();
	}
	
	public boolean xacnhanHD(String maHD) throws Exception {
		return dhDao.xacnhanHD(maHD);
	}
}

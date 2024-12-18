package khachHangModal;

import java.util.ArrayList;

public class khachhangbo {
	khachhangdao khdao = new khachhangdao();
	public ArrayList<khachhang> getkh() throws Exception{
		return khdao.getkh();
	}
	
	public int dẹmkh() throws Exception {
		return khdao.Demkh();
	}
}

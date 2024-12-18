package giohangModal;

import java.util.ArrayList;

public class giohangbo {
  public ArrayList<hang> ds= new ArrayList<hang>();
  public ArrayList<hang> dsxacnhan = new ArrayList<hang>();
  public void Them(String masach, String tensach, Long gia, Long soluong) {
	 for(hang h: ds)
		 if(h.getMasach().equals(masach)) {
			 h.setSoluong(h.getSoluong()+soluong);
			 return;
		 }
	  ds.add(new hang(masach, tensach, gia, soluong));
  }
  public void xoa(String masach) {
	  for(hang h: ds)
			 if(h.getMasach().equals(masach)) {
				 ds.remove(h);break;
			 }
  }
  
  public void xacnhan(String masach) {
	  for (hang h:ds)
		  if(h.getMasach().equals(masach)) {
			  dsxacnhan.add(h);
		  }
  }
  
  public long Tong() {
	  long s=0;
	  for(hang h: ds) s=s+h.getThanhtien();
	  return s;
  }
}

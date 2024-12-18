package sachModal;


import java.sql.Date;
import java.util.ArrayList;

public class sachbo {
   sachdao sdao= new sachdao();
   private int PAGE_SIZE = 9;
   
   ArrayList<sach> ds;
   public ArrayList<sach> getsach() throws Exception{
	   ds=sdao.getsach();
	   return ds;
   }
   
   public ArrayList<sach> getsachphantrang(int page) throws Exception{
	   ds=sdao.getsachPhanTrang(page,PAGE_SIZE);
	   return ds;
   }
   
   public ArrayList<sach> Timma(String maloai){
	   ArrayList<sach> tam= new ArrayList<sach>();
	   for(sach s: ds)
		   if(s.getMaloai().toLowerCase().trim().equals(
				   maloai.toLowerCase().trim()))
			   tam.add(s);
	   return tam;
   }
   
   public ArrayList<sach> Tim(String key){
	   ArrayList<sach> tam= new ArrayList<sach>();
	   for(sach s: ds)
		   if(s.getTensach().toLowerCase().trim().contains(
				   key.toLowerCase().trim())||
				   s.getTacgia().toLowerCase().trim().contains(
				   key.toLowerCase().trim()))
			   tam.add(s);
	   return tam;
   }
   
   public int demSach () throws Exception {
	   return sdao.getCount();
   }
   
   public Date getToday() {
	   Date today = new Date(System.currentTimeMillis());
       return today;
   }
   
   public boolean themSach(String masach,String tensach,int soluong,long gia,String maloai,int sotap,String anh,Date NgayNhap,String tacgia) throws Exception {
	   return sdao.themSach(masach, tensach, soluong, gia, maloai, sotap, anh, NgayNhap, tacgia);
   }
   
   public boolean suaSach(String masach,String tensach,int soluong,long gia,String maloai,int sotap,String anh,Date NgayNhap,String tacgia) throws Exception {
	   return sdao.suaSach(masach, tensach, soluong, gia, maloai, sotap, anh, NgayNhap, tacgia);
   }
   
   public sachAdmin getSingleSach(String ms) throws Exception {
	   System.out.println("ma loai bo" + sdao.getSinglesach(ms).getMaloai() );
	   return sdao.getSinglesach(ms);
   }
   
   public boolean xoaSach(String ms) throws Exception {
	   return sdao.xoaSach(ms);
   }
}
   
   
	



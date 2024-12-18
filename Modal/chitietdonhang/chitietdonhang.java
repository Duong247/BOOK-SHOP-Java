package chitietdonhang;

import java.sql.Date;

public class chitietdonhang {
	private String mahd;
	private String machitiethd;
	private String hoten;
	private String tensach;
	private int soluong;
	private long gia;
	private Date ngaymua;
	private long tongtien;
	
	public chitietdonhang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public chitietdonhang(String mahd, String machitiethd, String hoten, String tensach, int soluong, long gia,
			Date ngaymua) {
		super();
		this.mahd = mahd;
		this.machitiethd = machitiethd;
		this.hoten = hoten;
		this.tensach = tensach;
		this.soluong = soluong;
		this.gia = gia;
		this.ngaymua = ngaymua;
		this.tongtien = this.soluong*this.gia;
	}
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getMachitiethd() {
		return machitiethd;
	}
	public void setMachitiethd(String machitiethd) {
		this.machitiethd = machitiethd;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public long getTongtien() {
		return tongtien;
	}


	
}

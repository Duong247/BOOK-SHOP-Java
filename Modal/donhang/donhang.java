package donhang;

import java.sql.Date;

public class donhang {
	private String madh;
	private String hoten;
	private Date NgayMua;
	private Long ThanhTien;
	
	public donhang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public donhang(String madh, String hoten, Date ngayMua, Long thanhTien) {
		super();
		this.madh = madh;
		this.hoten = hoten;
		NgayMua = ngayMua;
		ThanhTien = thanhTien;
	}

	public String getMadh() {
		return madh;
	}

	public void setMadh(String madh) {
		this.madh = madh;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public Date getNgayMua() {
		return NgayMua;
	}

	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}

	public Long getThanhTien() {
		return ThanhTien;
	}

	public void setThanhTien(Long thanhTien) {
		ThanhTien = thanhTien;
	}

	
}



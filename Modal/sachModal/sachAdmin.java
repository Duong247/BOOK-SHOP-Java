package sachModal;

import java.sql.Date;

public class sachAdmin {
	private String masach;
	private String tensach;
	private Long soluong;
	private Long gia;
	private String maloai;
	private int sotap;
	private String anh;
	private Date NgayNhap;
	private String tacgia;
	
	public sachAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public sachAdmin(String masach, String tensach, Long soluong, Long gia, String maloai, int sotap, String anh,
			Date ngayNhap, String tacgia) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.soluong = soluong;
		this.gia = gia;
		this.maloai = maloai;
		this.sotap = sotap;
		this.anh = anh;
		NgayNhap = ngayNhap;
		this.tacgia = tacgia;
	}

	public String getMasach() {
		return masach;
	}

	public void setMasach(String masach) {
		this.masach = masach;
	}

	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
	}

	public Long getSoluong() {
		return soluong;
	}

	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}

	public Long getGia() {
		return gia;
	}

	public void setGia(Long gia) {
		this.gia = gia;
	}

	public String getMaloai() {
		return maloai;
	}

	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}

	public int getSotap() {
		return sotap;
	}

	public void setSotap(int sotap) {
		this.sotap = sotap;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public Date getNgayNhap() {
		return NgayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		NgayNhap = ngayNhap;
	}

	public String getTacgia() {
		return tacgia;
	}

	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	
}


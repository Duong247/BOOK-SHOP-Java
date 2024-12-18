package dangnhapAdminModal;

public class dangnhapAdminBo {
	dangnhapAdmindao dndao= new dangnhapAdmindao();
	public String KtDangNhap(String tendn, String pass) throws Exception{
		return dndao.KtDangNhap(tendn, pass);
	}
}

package constant;

public class Defines {
	// định nghĩa các thông số cho ứng dụng web
	public String urlPublic;
	public String urlAdmin;
	public String superAdmin;
	
	public static final String SUCCESS = "Xử lý thành công!";
	public static final String ERROR = "Có lỗi trong quá trình xử lý";
	public static final String BAD_REQUEST = "Bạn không thể xóa admin!";
	public static final String DIR_UPLOAD = "upload";
	public static final int ROW_COUNT_ADMIN = 10;
	public static final int ROW_COUNT_PUBLIC = 10;

	public String getUrlPublic() {
		return urlPublic;
	}

	public void setUrlPublic(String urlPublic) {
		this.urlPublic = urlPublic;
	}

	public String getUrlAdmin() {
		return urlAdmin;
	}

	public void setUrlAdmin(String urlAdmin) {
		this.urlAdmin = urlAdmin;
	}

	public String getSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(String superAdmin) {
		this.superAdmin = superAdmin;
	}

}

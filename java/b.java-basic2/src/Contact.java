import java.io.Serializable;

/**
 * 한 사람의 연락처 정보를 저장하는 클래스
 * @author shoseo
 *
 */
// 객체를 파일에 저장하려면 클래스가 Serializable 인터페이스를 구현해야 합니다.
public class Contact implements Serializable {
	
	private int no;
	private String name;
	private String phone;
	private String email;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String info() {
		// String.format : System.out.printf에서 출력 기능만 제거 (문자열 만들기)
		String info = String.format("[%d][%s][%s][%s]", no, name, phone, email);
		return info;
	}
}




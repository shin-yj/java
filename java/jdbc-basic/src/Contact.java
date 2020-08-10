import java.io.Serializable;
import java.sql.Date;

/*
	//테이블 만들기
	CREATE TABLE Contact
	(
	 c_no number primary key,
	 c_name varchar2(50 char) not null,
	 c_phone varchar2(20 char) not null,
	 c_email varchar2(50 char) null,
	 c_regdate date default (sysdate)
	);
	
	//자동 증가 번호 생성기 만들기
	CREATE SEQUENCE ContactNo_Seq nocache;

*/


/**
 * 한 사람의 연락처 정보를 저장하는 클래스 
 * @author shoseo
 *
 */
public class Contact {

	private int no;
	private String name;
	private String phone;
	private String email;
	private Date regDate;
	
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public String toString() {
		//String.format : System.out.printf에서 출력 기능만 제거 (문자열 만들기)
		String info = 
			String.format("[%d][%s][%s][%s][%s]", 
						  no, name, phone, email, regDate.toString());
		return info;
	}
}















public class Ex03 {

	public static void main(String[] args) {
		
		// 연락처 관리 프로그램
		// 연락처 정보 : 번호, 이름, 전화번호, 이메일
		// 기능 : 등록, 목록보기, 검색, 삭제, 수정
		
		// 테스트 1
//		Contact contact; // 참조 변수 만들기
//		contact = new Contact(); // 인스턴스 만들기 + 인스턴스의주소를 참조변수에 저장
//		
//		contact.setNo(1);
//		contact.setName("홍길동");
//		contact.setEmail("hkd@example.com");
//		contact.setPhone("010-9833-0924");
//		
//		String info = contact.info();
//		System.out.println(info);

		//
		
		 //아래는 int x = 10;과 같다.
		ContactManager manager = new ContactManager();
		manager.doManage();
	
		

	}

}

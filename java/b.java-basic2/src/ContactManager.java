import java.util.Scanner;

/**
 * 연락처를 관리하는 클래스 <br>
 * 배열을 사용해서 연락처 목록 저장 <br>
 * 등록, 목록보기, 검색, 삭제, 수정 기능 구현
 * 
 * @author shoseo
 *
 */
public class ContactManager {

	// 연락처 목록을 저장하는 배열 (배열 제약 때문에 생성할 때 크기를 결정해야 합니다.) // 배열은 만드는 시점에(new) 크기를 정해야
	// 한다.
	private Contact[] contacts = new Contact[1000];// contact"s"로 배열 의미 만들기 // 1000개의 연락처
	private int nextPosition = 0; // 새로 등록할 연락처의 배열 위치 번호, 제일 먼저 시작 값 0

	// 연락처 관리 기능을 구현한 메서드
	public void doManage() { // Ex03에 구현함.

		outer: while (true) { // 끝날 때까지 반복
			// 1.메뉴 표시 및 사용자 입력
			String selection = selectMenu();

			// 2.사용자 선택에 따라 작업을 수행(등록, 목록보기, ...)
			switch (selection) {
			case "0":
				System.out.println("프로그램을 종료합니다.");
				break outer; // outer로 이름 붙인 반복문 또는 선택문을 break
			case "2": // 연락처 등록을 선택한 경우

				if (nextPosition >= 1000) {

					System.out.println("저장 용량을 초과했습니다.");
					break;
				}

				createNewContact();

				break;
			case "1": // 목록 표시
				showAllContacts();
				break;
			case "3": // 검색
				Contact[] results = findContact();
				if (results == null) {
					System.out.println("검색된 연락처가 없습니다.");
				} else {
					System.out.println("[ 검색된 연락처 ] ");
					for (Contact c : results) {
						System.out.println(c.info());
					}
				}

			case "4": // 삭제
				// 1. 검색
				Contact[] results2 = findContact();
				if (results2 == null) {
					System.out.println("검색된 연락처가 없습니다.");
					break;
				} else {
					System.out.println("[ 검색된 연락처 ] ");
					for (Contact c : results2) {
						System.out.println(c.info());
					}
				}
				// 2. 삭제할 연락처 선택(입력)
				System.out.println("삭제할 연락처 번호 : ");
				int no = scanner.nextInt();
				scanner.nextLine(); // buffer에 남아있는 enter 제거
				
				// 3. 삭제 (삭제 대상 위치 뒤에 있는 요소들의 위치를 하나씩 앞으로 이동)
				for (int i = no + 1; i < nextPosition; i++) {
					Contact c = contacts[i];
					c.setNo(i-1);
					contacts[i-1] =c;
				}	
				nextPosition--;
				
			case "5":
				break;
			default:
				System.out.println("지원하지 않는 작업입니다.");
				break; // 가장 가까운 반복문 또는 선택문 break
			}

		}

	}

	Scanner scanner = new Scanner(System.in);

	private String selectMenu() {
		System.out.println("******************************");
		System.out.println("* 1. 연락처 목록                              *");
		System.out.println("* 2. 연락처 등록                              *");
		System.out.println("* 3. 연락처 검색                              *");
		System.out.println("* 4. 연락처 삭제                              *");
		System.out.println("* 5. 연락처 수정                              *");
		System.out.println("* 0. 종료                                       *");
		System.out.println("******************************");
		System.out.print("[ 원하는 작업 번호를 입력하세요 ] : ");
		String selection = scanner.nextLine();
		return selection;
	}

	private void createNewContact() {
		System.out.println("[ 등록할 연락처 정보 ]");
		System.out.print("이름 입력하세요 : ");
		String name = scanner.nextLine();
		System.out.print("전화번호 입력하세요 : ");
		String phone = scanner.nextLine();
		System.out.print("이메일 입력하세요 : ");
		String email = scanner.nextLine();

		Contact c = new Contact();
		c.setNo(nextPosition);
		c.setName(name);
		c.setEmail(email);
		c.setPhone(phone);

		contacts[nextPosition] = c;
		nextPosition++;
	}

	private void showAllContacts() {
		if (nextPosition == 0) {
			System.out.println("등록된 연락처가 없습니다.");
			return;
		}

		System.out.println("[ 연락처 목록 ]");
		for (int i = 0; i < nextPosition; i++) {
			Contact c = contacts[i];
			String info = c.info();
			System.out.println(info);

		}
	}

	private Contact[] findContact() {
		// 1. 이름 입력
		System.out.print("검색할 이름을 입력하세요 : ");
		String name = scanner.nextLine();

		// 2. 배열에 저장된 연락처를 순회하면서 입력된 이름과 비교
		// 완전일치/부분일치인지 판단, 동명이인에 대한 고려
		String searchedNos = ""; // 문자열
		System.out.println("[검색된 연락처]");
		for (int i = 0; i < nextPosition; i++) {
			Contact c = contacts[i];
			// if (c.getName().equals(name)) { // 완전일치 검색
			if (c.getName().contains(name)) { // 부분일치 검색
				if (searchedNos.length() == 0) {
					searchedNos += c.getNo();

				} else {
					searchedNos += "/" + c.getNo();
				}
			}
		}
		if (searchedNos.length() == 0) {
			return null;
		} else {
			// "1/3/7" -> ["1", "3", "7"]로 만들어줌
			String[] snos = searchedNos.split("/");
			// 번호의 갯수 크기의 배열 만들기
			Contact[] results = new Contact[snos.length];
			for (int i = 0; i < snos.length; i++) {
				// Integer.parseInt("1") -> 1
				int no = Integer.parseInt(snos[i]);
				results[i] = contacts[no];
			}
			return results;
		}
	}
}

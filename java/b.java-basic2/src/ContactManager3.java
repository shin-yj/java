import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 연락처를 관리하는 클래스 <br>
 * 배열을 사용해서 연락처 목록 저장 <br>
 * 등록, 목록보기, 검색, 삭제, 수정 기능 구현
 * 
 * @author shoseo
 *
 */
public class ContactManager3 {

	private int nextNo = 1;

	// 연락처 목록을 저장하는 컬렉션 객체
	private ArrayList<Contact> contacts = new ArrayList<Contact>();

	// 생성자 메서드 (constructor)
	// 인스턴스가 생성될 때 자동으로 호출되는 메서드 (초기화 메서드)
	// 메서드 이름이 클래스이름과 같고 결과형이 없습니다.
	public ContactManager3() { // -> new ContactManager3() 할 때 자동 호출
		try {
			// File : File 또는 Directory 정보를 관리하는 클래스
			File file = new File("contacts.dat");
			if (file.exists()) { // File.exists() : 파일 또는 디렉터리의 존재 여부 확인 -> 존재한다면 이것을 따른다.
				
			
			FileInputStream fis = new FileInputStream("contacts.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			contacts = (ArrayList<Contact>)ois.readObject();
			ois.close();
			fis.close();
			//기존 목록의 마지막 연락처 번호를 이용해서 다음 연락처 번호를 설정
			Contact lastContact = contacts.get(contacts.size() - 1);
			nextNo = lastContact.getNo() + 1;
			
			}
//			showAllContacts(); //선택사항
		} catch(IOException ex) {
			ex.printStackTrace(); // 오류메세지 출력
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	
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

				createNewContact();

				break;
			case "1": // 목록 표시
				showAllContacts();
				break;
			case "3": // 검색
				ArrayList<Contact> results = findContact();
				if (results.size() == 0) {
					System.out.println("검색된 연락처가 없습니다.");
				} else {
					System.out.println("[ 검색된 연락처 ] ");
					for (Contact c : results) {
						System.out.println(c.info());
					}
				}

			case "4": // 삭제
				// 1. 검색
				ArrayList<Contact> results2 = findContact();
				if (results2.size() == 0) {
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

				// 3. 삭제 (리스트를 순회하면서 번호가 같은 연락처 제거)
				for (int i = 0; i < contacts.size(); i++) {
					if (contacts.get(i).getNo() == no) {
						contacts.remove(i);
						break;
					}
				}

			case "5":
				break;

			case "6": // 연락처 저장
				try {
					FileOutputStream fos = new FileOutputStream("contacts.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(contacts);
					oos.close();
					fos.close();
					System.out.println("데이터를 파일에 저장했습니다.");
				} catch (IOException ex) {
					System.out.println("저장 실패");
					System.out.println(ex.getMessage());
					ex.printStackTrace(); // 오류 관련 메세지 전체를 출력
				}
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
		System.out.println("* 6. 연락처 저장                              *");
		System.out.println("* 0. 종료                                        *");
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
		c.setNo(nextNo);
		c.setName(name);
		c.setEmail(email);
		c.setPhone(phone);

		contacts.add(c);

		nextNo++;
	}

	private void showAllContacts() {
		if (contacts.size() == 0) {
			System.out.println("등록된 연락처가 없습니다.");
			return;
		}

		System.out.println("[ 연락처 목록 ]");
		for (Contact c : contacts) {
			String info = c.info();
			System.out.println(info);

		}
	}

	private ArrayList<Contact> findContact() {
		// 1. 이름 입력
		System.out.print("검색할 이름을 입력하세요 : ");
		String name = scanner.nextLine();

		// 2. 배열에 저장된 연락처를 순회하면서 입력된 이름과 비교
		// 완전일치/부분일치인지 판단, 동명이인에 대한 고려
		ArrayList<Contact> results = new ArrayList<>();
		System.out.println("[검색된 연락처]");
		for (Contact c : contacts) {

			// if (c.getName().equals(name)) { // 완전일치 검색
			if (c.getName().contains(name)) { // 부분일치 검색
				results.add(c);
			}
		}
		return results;
	}

}

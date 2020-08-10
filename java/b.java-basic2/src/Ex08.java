import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;


public class Ex08 {

	public static void main(String[] args) throws Exception {
		
//		//1. char[] <-> byte[] 직접 처리 (텍스트 데이터 IO)
//		FileOutputStream fos1 = new FileOutputStream("test1.txt");//쓰기용 파일 만들기
//		String str = "파일에 쓰는 데이터 1\r\n"; //문자열 : char[]
//		byte[] bstr = str.getBytes(); //String.getBytes() : char[] -> byte[] 메서드 // stream 사용 위해 byte array로 바꿔줘야 한다.
//		fos1.write(bstr);
//		fos1.write("파일에 쓰는 데이터 2\r\n".getBytes()); // 출력은 write
//		fos1.write("파일에 쓰는 데이터 3\r\n".getBytes());
//		
//		fos1.close();//파일 닫기
//		
//		System.out.println("파일에 데이터를 썼습니다.");
		
//		FileInputStream fis1 = new FileInputStream("test1.txt");//읽기 스트림		
//		byte[] buffer1 = new byte[256];//한 번에 읽은 데이터를 저장할 변수 // 한꺼번에 256바이트 읽겠다
//		while (true) {
//			int count =						//read 명령으로 실제 읽은 데이터 양 (return 값) 
//				fis1.read(buffer1,			//스트림에서 읽은 데이터를 저장할 byte[]   //그릇
//						  0, 				//읽은 데이터를 buffer1의 어디부터 저장할지 지정 //어느 위치부터 담을 것인지
//						  buffer1.length);	//읽기 원하는 양 //이만큼 담아달라(256)! //그릇에 담을 양 -> 데이터 남지 않을 때 까지
//			
//			if (count == -1) break; //EOF (End of File) // 읽을 때 데이터 값이 없으면 -1을 주는데 그 때 break
//			
//			//byte[] -> char[] 직접 변환 (String 생성자를 사용)
//			String str2 = new String(buffer1, 0, count);//buffer1의 0번째부터 count까지의 데이터를 문자열로 변환
//			System.out.println(str2);
//		}
//		fis1.close();//파일 닫기
//		
		//////////////////////////////////////////////////////////////////////

		//2. char[] <-> byte[] 자동 변환 (Text Data 입출력)
//		FileOutputStream ostream2 = new FileOutputStream("test2.txt");//쓰기 기능
//		OutputStreamWriter writer2 = new OutputStreamWriter(ostream2);//변환 기능 // ostream2를 감싸서 outputstream 만듬: string을 byte array로 바꿈 -> stream으로 전달
//		writer2.write("파일에 기록하는\t\t 데이터 1\r\n"); 
//		writer2.write("파일에 기록하는\t\t 데이터 2\r\n");
//		writer2.write("파일에 기록하는\t\t 데이터 3\r\n");
//		writer2.close();
//		ostream2.close();
//		System.out.println("파일에 데이터를 썼습니다.");
//		
//		FileInputStream istream2 = new FileInputStream("test2.txt"); // 읽기 기능
//		InputStreamReader reader2 = new InputStreamReader(istream2); // 변환 기능
//		BufferedReader breader2 = new BufferedReader(reader2);		 // 행 단위로 꺼내는 기능
//		while (true) {
//			String line = breader2.readLine();//readLine : 한 줄 읽기
//			if (line == null)//null이면 EOF (End Of File)
//				break;
//			System.out.println(line);
//		}
//		breader2.close();
//		reader2.close();
//		istream2.close();
		
//		3. primitive type <-> byte[]		
//		FileOutputStream ostream3 = new FileOutputStream("test3.dat");//파일에 쓰기
//		DataOutputStream dostream3 = new DataOutputStream(ostream3); //binary를 byte array로 primitive type -> byte[]
//		
//		FileOutputStream ostream3_1 = 	new FileOutputStream("test3.txt");//파일에 쓰기
//		OutputStreamWriter writer3 = new OutputStreamWriter(ostream3_1); //char,string을 byte로 text -> byte[]
//		
//		for (int i = 0; i < 10000; i++) { // 10000번 데이터를 파일에 기록
//			dostream3.writeInt(Integer.MAX_VALUE); //binary write
//			writer3.write(Integer.MAX_VALUE + ""); //text write			
//		}
//		dostream3.close();
//		ostream3.close();
//		writer3.close();
//		ostream3_1.close();
//		
//		System.out.println("파일에 데이터를 썼습니다.");
		
		//data outputstream으로 했으니까(원래 binary형) inputstream으로 써야한다(역변환, byte로 바뀜) . 읽는 것 ->inputstream
//		
//		FileInputStream istream3 = new FileInputStream("test3.dat");//파일에서 읽기
//		DataInputStream distream3 = new DataInputStream(istream3);//byte[] -> binary
//		int data = distream3.readInt();
//		int data2 = distream3.readInt();
//		System.out.printf("%d-%d", data, data2);
//		
//		distream3.close(); istream3.close();
		
		//4. Object <-> byte[]
//		Item item = new Item(); 
//		item.setNo(10); // item.no = 10;
//		item.setName("테스트 아이템");
//		//System.out.println(item.toString());
//		
//		
//		FileOutputStream ostream4 = new FileOutputStream("test4.dat"); // byte[] 저장
//		ObjectOutputStream oostream4 = new ObjectOutputStream(ostream4); // Object -> byte[]로 바뀌어줌 		
//		oostream4.writeObject(item);//객체를 byte[]로 변환해서 파일에 binary 형식으로 저장 		
//		oostream4.close(); ostream4.close();
//		
//		System.out.println("파일에 데이터를 썼습니다.");
//		
//		FileInputStream istream4 = new FileInputStream("test4.dat"); //byte[] 읽기
//		ObjectInputStream oistream4 = new ObjectInputStream(istream4); // byte[] -> Object// objectoutput에서 역변환
//		Item item2 = (Item)oistream4.readObject();//파일에서 데이터를 읽고 객체로 복원
//
//		System.out.println(item2);
//				
//		oistream4.close();
//		istream4.close();
//		
		//5.		
//		ArrayList<Item> items = new ArrayList<Item>();
//		for (int i = 0; i < 10; i++) {
//			Item item = new Item();
//			item.setNo(i+1); 
//			item.setName("test " + (i + 1));
//			items.add(item);
//		}
//				
//		FileOutputStream ostream5 = new FileOutputStream("test5.dat");
//		ObjectOutputStream oostream5 = new ObjectOutputStream(ostream5);
//		
//		//아이템을 여러번 저장하는 방식
////		for (Item item : items) {
////			oostream5.writeObject(item);
////		}
//			
//		//아이템을 한번에 저장하는 방식 (ArrayList를 저장) -> ArrayList의 모든 요소도 저장
//		oostream5.writeObject(items);  
//
//		oostream5.close();
//		ostream5.close();
//		
//		System.out.println("파일에 데이터를 썼습니다.");
//		
//		FileInputStream istream5 = new FileInputStream("test5.dat");
//		ObjectInputStream oistream5 = new ObjectInputStream(istream5);
//		ArrayList<Item> items2 = (ArrayList<Item>)oistream5.readObject();
//		
//		for (Item item : items2) {
//			//System.out.println(item);
//			System.out.println(item.toString());
//		}
//		oistream5.close();istream5.close();
		
		//6 - 1.
//		InputStream is = System.in;
//		InputStreamReader isr6 = new InputStreamReader(is); //System.in : 표준 입력 스트림 (키보드) // 캐릭터로 바꾸기
//		BufferedReader br6 = new BufferedReader(isr6);//enter 단위로 읽기 가능 // 한 줄씩 읽기
//		
//		System.out.print("이름 : ");
//		String name = br6.readLine();
//		System.out.println("Your Name is " + name); //System.out : 표준 출력 장치 (모니터)
//		
		//6 - 2. 
//		Scanner scanner = new Scanner(System.in); //표준 입력 스트림 (키보드)
//		System.out.print("이메일 : ");
//		String email = scanner.nextLine();
//		System.out.println("Your Email is " + email);
//		scanner.close();
//			
	}

}









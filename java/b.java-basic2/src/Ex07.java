import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex07 {

	public static void main(String[] args) throws Exception {
		
		// File : File or Directory를 관리하는 클래스
		File file = new File("C:\\Windows");
		
		if (file.isDirectory()) {
			System.out.println("디렉터리 입니다.");
		} if (file.isFile()) {
			System.out.println("파일입니다.");
		}
		
		if (file.isDirectory()) {
			
			//SimpleDateFormat : 날짜 -> 특별한 형식의 문자열로 변경하는 도구
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm"); // a -> am/pm 나타냄
			// list : 디렉터리에 포함된 파일과 디렉터리의 목록을 String형식으로 반환
			// listFiles : 디렉터리에 포함된 파일과 디렉터리의 목록을 File형식으로 반환
			File[] files = file.listFiles();
			
			
			for (File f : files) {
				// tick count를 사용해서 날짜 객체 만들기
				Date d = new Date(f.lastModified());
				String lastModified = sdf.format(d); // 날짜 -> 지정된 형식의 문자열로 바꾼다.
				if (f.isDirectory()) {
				
					System.out.printf("%s %5s %10s %s\n",
									  lastModified,
									  "<DIR>",
									  "",
									  f.getName()); //1칸, 5칸의 입력칸 출력하라, 10칸,1칸
					
				}
		if (f.isFile()) {
			System.out.printf("%s %5s %,10d %s\n", // s를 d로 (문자열으로 출력해야되서)
					  lastModified,
					  "",
					  f.length(),
					  f.getName());
					
				}

			}
			
		}
		
		////////////////////////////////
		
		
		File f2 = new File("test");
		if (f2.exists()) { // File, Directory가 존재 여부 확인
		
			System.out.println("이미 존재하는 디렉터리 입니다.");
		} else {
			f2.mkdir(); // 디렉터리 만들기
			System.out.println("test 디렉터리를 만들었습니다.");
		}

	}
}

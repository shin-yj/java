import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton; //JButton의 ctrl+space 결과
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex01 {
	
	public static void main(String[] args) {
		
		//윈도우 인스턴스 만들기 -> 윈도우 만드는 클래스를 위해 JFrame 사용
		JFrame window = new JFrame();
		//윈도우를 닫으면 프로그램도 종료하는 설정
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null); //윈도우 내부의 객체들의 위치를 절대 좌표로 결정하는 설정 (없으면 전체가 버튼이 됨)
		//윈도우 속성을 변경 -> 속성은 변수로, 기능은 메서드로 --> 속성 변수에 접근하는 setter를 사용해서 변경
		window.setTitle("처음 만든 윈도우! @.@ ");
		window.setSize(600, 500); // 600x500사이즈의 윈도우 만들기
		window.setResizable(false); // 크기조절 못함
	
		// 버튼 만들기
		JButton button = new JButton();
		button.setText("눌러 주세요");
		button.setSize(300,50);
		button.setLocation(150, 200);
		
		ClickHandler handler = new ClickHandler();
		button.addActionListener(handler); // button 클릭되었을 때 호출할 객체를 지정(규격(인터페이스)에 따라만든 객체) // 인터페이스(맨 밑)를 통해 연결해준다
		//버튼을 윈도우에 추가
		window.add(button);
				
		window.setVisible(true); // 윈도우를 화면에 표시
		
		
		
	}


}
class ClickHandler implements ActionListener { // 버튼과 연결

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JOptionPane.showMessageDialog(null, "눌러 주셔서 감사합니다.");
		
	}
	
	
}
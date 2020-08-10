import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton; //JButton의 ctrl+space 결과
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex02 extends JFrame { // ex02가 jframe을 상속받음 , jframe이 되어버림

	
	public Ex02() {
		init();
	}
	private void init() {
			//윈도우를 닫으면 프로그램도 종료하는 설정
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 이제 jframe이니까 window(남의 것)지우기 -> 내가 window가 되어버림
			setLayout(null); //윈도우 내부의 객체들의 위치를 절대 좌표로 결정하는 설정 (없으면 전체가 버튼이 됨)
			//윈도우 속성을 변경 -> 속성은 변수로, 기능은 메서드로 --> 속성 변수에 접근하는 setter를 사용해서 변경
			setTitle("처음 만든 윈도우! @.@ ");
			setSize(600, 500); // 600x500사이즈의 윈도우 만들기
			setResizable(false); // 크기조절 못함
		
			// 버튼 만들기
			JButton button = new JButton();
			button.setText("눌러 주세요");
			button.setSize(300,50);
			button.setLocation(150, 200);
			
			ClickHandler handler = new ClickHandler();
			button.addActionListener(handler); // button 클릭되었을 때 호출할 객체를 지정(규격(인터페이스)에 따라만든 객체) // 인터페이스(맨 밑)를 통해 연결해준다
			//버튼을 윈도우에 추가
			add(button);
	
	}
	class ClickHandler implements ActionListener { // clickhandler를 Ex02 안으로 넣기 -> clickhandler와 윈도우를 같은 곳에 넣는 것 -> 서로 접근이 가능해졌다
// 이제 clickhandler는 JFrame의 모든 영역 다 사용가능
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Container container = getContentPane(); // 배경색 바꾸기
//			container.setBackground(Color.red);
			int r = (int)(Math.random() * 256);// (0~ 256] ]는 미포함 -> 0~255값
			int g = (int)(Math.random() * 256);
			int b = (int)(Math.random() * 256);
			Color c = new Color(r,g,b);
			container.setBackground(c);
			
			
		}
	}
		
	public static void main(String[] args) {
		
		// JFrame window = new JFrame();
		Ex02 window = new Ex02(); // 상속받기만 한 Ex02 변수를 만들어야 되서
		window.setVisible(true); //윈도우를 화면에 표시

	}
	}

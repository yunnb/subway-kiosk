package STUDY;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContentPaneEx extends JFrame {
    public ContentPaneEx() {
        setTitle("ContentPane과 JFrame 예제");  // 프레임 타이틀
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();  // 컨텐트팬 알아내기
        contentPane.setBackground(Color.orange);  // 배경색 지정
        contentPane.setLayout(new FlowLayout());  // 컨탠트팬에 FlowLayout 배치관리자 달기

        contentPane.add(new JButton("OK"));
        contentPane.add(new JButton("Cancel"));
        contentPane.add(new JButton("Ignore"));

        setSize(300, 150);  // 프레임 크기 설정
        setVisible(true);  // 화면에 프레임 출력
    }

    public static void main(String[] args) {
        new ContentPaneEx();
    }
}

import javax.swing.*;
import java.awt.*;

public class NullContainerEx extends JFrame {
    public NullContainerEx() {
        setTitle("배치관리자 없이 절대 배치");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        JLabel la = new JLabel("Yunnb's Dev!");
        la.setLocation(130, 50);
        la.setSize(200, 20);

        this.add(la);

        // 10개의 컴포넌트 생성 후 동일 크기로 설정, 위치 겹치게
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(Integer.toString(i));
            btn.setLocation(i*15, i*15);
            btn.setSize(50, 20);
            this.add(btn);
        }

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NullContainerEx();
    }
}

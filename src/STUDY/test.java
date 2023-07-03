package STUDY;

import javax.swing.*;
import java.awt.*;

public class test extends JFrame{
    public test() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(20, 5));
        int b = 1;
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 10; j++) {
                jp.add(new JButton(b + "번"));
                ++b;
            }
        }

        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;

        JScrollPane jsp = new JScrollPane(jp, v, h);

        contentPane.add(jsp, BorderLayout.CENTER);

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new test();
    }

}

import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx extends JFrame {
    public BorderLayoutEx() {
        setTitle("BorderLayout 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        contentPane.setLayout(new BorderLayout(30, 20));

        contentPane.add(new JButton("Button 1"), BorderLayout.CENTER);
        contentPane.add(new JButton("Button 2"), BorderLayout.NORTH);
        contentPane.add(new JButton("Button 3"), BorderLayout.SOUTH);
        contentPane.add(new JButton("Button 4"), BorderLayout.EAST);
        contentPane.add(new JButton("Button 5"), BorderLayout.WEST);

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutEx();
    }
}

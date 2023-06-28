import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        button.setText("Click");
    }
}

class MyFrameTest extends JFrame {
    private JButton button;
    private JLabel label;

    public MyFrameTest() {
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Independent class");

        JPanel panel = new JPanel();
        button = new JButton("Button");
        label = new JLabel("Yunnb's Dev");

        button.addActionListener(new MyListener());
        panel.add(button);
        panel.add(label);

        this.add(panel);
        this.setVisible(true);
    }
}
public class IndepClassListener {
    public static void main(String[] args) {
        new MyFrameTest();
    }
}

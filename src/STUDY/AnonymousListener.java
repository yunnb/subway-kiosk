import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnonymousListener extends JFrame {
    private JButton btn;

    public AnonymousListener() {
        this.setTitle("AnonymousListener");
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp = new JPanel();
        btn = new JButton("Button");

        // 리스너 구현
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("Button")) btn.setText("Click");
                else btn.setText("Button");
            }
        });

        jp.add(btn);

        this.add(jp);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AnonymousListener();
    }
}

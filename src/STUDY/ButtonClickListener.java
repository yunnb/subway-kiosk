package STUDY;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener extends JFrame implements ActionListener {
    JButton b1, b2;
    JPanel p;

    public ButtonClickListener() {
        setSize(300, 100);
        setTitle("ButtonClickListener");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new JPanel();
        b1 = new JButton("Yellow");
        b2 = new JButton("Pink");

        b1.addActionListener(this);  // 이벤트 메소드 호출
        b2.addActionListener(this);

        p.add(b1);
        p.add(b2);
        add(p);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) p.setBackground(Color.YELLOW);
        else if (e.getSource() == b2) p.setBackground(Color.PINK);
    }

    public static void main(String[] args) {
        new ButtonClickListener();
    }
}

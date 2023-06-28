package STUDY;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerClassListener extends JFrame {
    public InnerClassListener() {
        setTitle("InnerClassListener");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Button");
        btn.addActionListener(new MyActionListener());

        c.add(btn);
        setSize(300, 200);
        setVisible(true);
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            if (b.getText().equals("Button")) b.setText("Click");
            else b.setText("Button");

            // InnerClassListener의 멤버나 JFrame의 멤버 호출 가능
            InnerClassListener.this.setTitle(b.getText());
        }
    }

    public static void main(String[] args) {
        new InnerClassListener();
    }
}

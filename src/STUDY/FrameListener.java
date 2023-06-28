package STUDY;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameListener implements ActionListener{

    private JFrame frame;
    private JTextField text;
    private JLabel label;

    public FrameListener() {
        frame=new JFrame("HelloEx");

        buildGUI();

        frame.setBounds(500,300,200,80);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    private void buildGUI() {
        text=new JTextField();
        JButton button=new JButton("확인");
        button.addActionListener(this); //button에서 ActionEvent가 나나타면 나에게 전달
        //=> 내가 가지고 있는 actionPerformed에게 ActionEvent를 전달해서 처리하기

        label=new JLabel("Hello World");

        frame.add(text, BorderLayout.CENTER);
        frame.add(button, BorderLayout.EAST);
        frame.add(label, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        new FrameListener();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String name=text.getText();
        label.setText("Hello, "+name);

        text.setText("");
    }
}
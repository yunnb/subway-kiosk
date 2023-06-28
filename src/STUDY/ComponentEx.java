import javax.swing.*;
import java.awt.*;

public class ComponentEx extends JFrame {
    public ComponentEx() {
        setTitle("Yunnb's Dev");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        JLabel label = new JLabel("Hello World");
        // this.add(label);

        //JButton btn = new JButton("JButton");
        //JCheckBox btn = new JCheckBox("JCheckBox");
        //JRadioButton btn = new JRadioButton("JRadioButton");
        // this.add(btn);

        //JTextField text = new JTextField(20);
        JFormattedTextField text = new JFormattedTextField(30);
        this.add(text);

        setSize(250, 100);
        setVisible(true);
        setResizable(true);
    }

    public static void main(String[] args) {
        new ComponentEx();
    }
}

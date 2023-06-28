package PROJECT;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class MainFrame extends JFrame{

    // Main Screen
    static JButton startBtn = new JButton(new ImageIcon("images/startButton.png"));
    static JPanel mainScreen = new JPanel() {
        ImageIcon icon = new ImageIcon("images/main3.jpg");
        public void paintComponent(Graphics g) {
            g.drawImage(icon.getImage(), 0, 0, null);
        }
    };

    // Order Screen
    static String[] menuText = {"샌드위치", "샐러드", "랩/기타", "사이드/음료"};
    static JButton[] menuBtn = new JButton[4];
    static JPanel menuScreen = new JPanel() {

    };

    public MainFrame() {
        setFrame();
        setPanel();
        startOrder();
    }

    public void setFrame() {
        setSize(540, 960);
        setTitle("Subway Kiosk");
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setMenuBtn();
    }

    public void setPanel() {
        startBtn.setBounds(0, 805, 540, 120);
        mainScreen.setBounds(0, 0, 540, 960);
        menuScreen.setBounds(0, 0, 540, 960);

        mainScreen.setLayout(null);
        menuScreen.setLayout(null);

        menuScreen.setVisible(false);

        add(mainScreen);
        add(menuScreen);
        mainScreen.add(startBtn);
    }

    public void startOrder() {
        startBtn.addMouseListener(new MouseAdapter() {
            @Override public void mousePressed(MouseEvent e) {
                mainScreen.setVisible(false);
                menuScreen.setVisible(true);
            }
        });
    }

    private void setMenuBtn() {
        Font font = new Font("SUITE", Font.BOLD, 18);
        for (int i = 0; i < 4; i++) {
            menuBtn[i] = new JButton(menuText[i]);
            menuBtn[i].setBounds(3+130*i,100, 130, 100);
            menuBtn[i].setBackground(new Color(0, 0, 0, 0));
            menuBtn[i].setVisible(true);
            menuBtn[i].setFont(font);
            //menuBtn[i].setBorderPainted(false);
            menuBtn[i].setContentAreaFilled(false);
            menuBtn[i].setFocusPainted(false);
            menuScreen.add(menuBtn[i]);
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
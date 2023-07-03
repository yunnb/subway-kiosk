package PROJECT;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class MainFrame extends JFrame {

    // Main Screen
    private JButton startBtn = new JButton(new ImageIcon("images/startButton.png"));
    private JPanel mainScreen = new JPanel() {
        ImageIcon icon = new ImageIcon("images/main3.jpg");

        public void paintComponent(Graphics g) {
            g.drawImage(icon.getImage(), 0, 0, null);
        }
    };

    // Order Screen
    private JPanel menuScreen = new JPanel();
    private JPanel sandwichMenuScreen = new JPanel(new BorderLayout());

    private JPanel cartScreen = new JPanel();

    private Font font1 = new Font("SUITE", Font.BOLD, 18);
    private Font font2 = new Font("SUITE", Font.PLAIN, 16);
    private Color color = new Color(0, 0, 0, 0);

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
        menuScreen.setBounds(0, 20, 540, 100);
        sandwichMenuScreen.setBounds(0, 130, 525, 630);
        cartScreen.setBounds(0, 760, 540, 200);

        mainScreen.setLayout(null);
        menuScreen.setLayout(null);
        cartScreen.setLayout(null);

        menuScreen.setVisible(false);
        sandwichMenuScreen.setVisible(false);
        cartScreen.setVisible(false);

        //menuScreen2.setBackground(Color.black);
        //cartScreen.setBackground(Color.BLUE);

        add(mainScreen);
        add(menuScreen);
        add(sandwichMenuScreen);
        add(cartScreen);
        mainScreen.add(startBtn);
    }

    public void startOrder() {
        startBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mainScreen.setVisible(false);
                menuScreen.setVisible(true);
                cartScreen.setVisible(true);
            }
        });
    }

    private void setMenuBtn() {
        String[] menuText = {"샌드위치", "샐러드", "랩/기타", "사이드/음료"};
        JButton[] menuBtn = new JButton[4];
        for (int i = 0; i < 4; i++) {
            menuBtn[i] = new JButton(menuText[i]);
            menuBtn[i].setBounds(2 + 130 * i, 0, 130, 100);
            menuBtn[i].setBackground(color);
            menuBtn[i].setVisible(true);
            menuBtn[i].setFont(font1);
            //menuBtn[i].setBorderPainted(false);
            menuBtn[i].setContentAreaFilled(false);
            menuBtn[i].setFocusPainted(false);
            menuScreen.add(menuBtn[i]);
        }

        menuBtn[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setSandwichMenuBtn();
                sandwichMenuScreen.setVisible(true);
            }
        });
    }

    private void setSandwichMenuBtn() {
        JPanel panel = new JPanel(new GridLayout(0, 3));
        panel.setBounds(0, 130, 525, 630);

        ArrayList<SandwichType> sandwiches = new ArrayList<>(Arrays.asList(
                SandwichType.Ham, SandwichType.SubwayClub, SandwichType.SpicyItalian,
                SandwichType.SteakCheese, SandwichType.ChickenBaconAvocado, SandwichType.KBBQ,
                SandwichType.PulledPorkBarbecue, SandwichType.RotisserieBarbecueChicken,
                SandwichType.RoastedChicken, SandwichType.Shrimp, SandwichType.ChickenTeriyaki,
                SandwichType.ItalianBMT, SandwichType.BLT, SandwichType.ChickenSlice,
                SandwichType.Tuna, SandwichType.EggMayo, SandwichType.Veggie));

        for (SandwichType j : sandwiches) {
            ImageIcon icon = new ImageIcon(j.getImg());
            Image img = icon.getImage();
            Image resizeImg = img.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

            JButton sandwichMenuBtn = new JButton(new ImageIcon(resizeImg));
            sandwichMenuBtn.setSize(70, 70);
            sandwichMenuBtn.setBackground(color);
            sandwichMenuBtn.setVisible(true);
            sandwichMenuBtn.setContentAreaFilled(false);  // 내용 영역 채우기
            sandwichMenuBtn.setFocusPainted(true);  // 선택 시 테두리
            sandwichMenuBtn.setBorderPainted(false); // 테두리
            sandwichMenuBtn.setText(j.getName());
            sandwichMenuBtn.setHorizontalTextPosition(JButton.CENTER);
            sandwichMenuBtn.setVerticalTextPosition(JButton.BOTTOM);
            sandwichMenuBtn.setFont(font2);

            panel.add(sandwichMenuBtn);
            panel.setVisible(true);
        }

        JScrollPane sandwichScrollPane = new JScrollPane(panel);
        sandwichScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        sandwichMenuScreen.add(sandwichScrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
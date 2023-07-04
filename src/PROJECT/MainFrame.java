package PROJECT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {

    // Main Screen
    private JButton startBtn = new JButton(new ImageIcon("images/startButton.png"));
    private JPanel mainScreen = new JPanel() {
        ImageIcon icon = new ImageIcon("images/main3.jpg");
        public void paintComponent(Graphics g) {
            g.drawImage(icon.getImage(), 0, 0, null);
        }
    };

    // Order Screen
    private String[] menuText = {"샌드위치", "샐러드", "랩/기타", "사이드/음료"};
    private JButton[] menuBtn = new JButton[4];
    private JPanel menuScreen = new JPanel();

    private JPanel sandwichMenuScreen = new JPanel(new BorderLayout());
    private JPanel saladMenuScreen = new JPanel(new BorderLayout());
    private JPanel wrapEtcMenuScreen = new JPanel(new BorderLayout());
    private JPanel sideDrinkMenuScreen = new JPanel(new BorderLayout());

    // Cart Screen
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
        startBtn.setBounds(0, 785, 540, 140);
        mainScreen.setBounds(0, 0, 540, 960);
        menuScreen.setBounds(0, 20, 540, 100);
        cartScreen.setBounds(0, 760, 540, 200);

        mainScreen.setLayout(null);
        menuScreen.setLayout(null);
        cartScreen.setLayout(null);

        menuScreen.setVisible(false);
        cartScreen.setVisible(false);

        sandwichMenuScreen.setVisible(false);
        saladMenuScreen.setVisible(false);
        wrapEtcMenuScreen.setVisible(false);
        sideDrinkMenuScreen.setVisible(false);

        //Category.setBackground(Color.black);
        cartScreen.setBackground(Color.WHITE);

        add(mainScreen);
        add(menuScreen);
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
                setCartScreen();
            }
        });
    }

    private void setMenuBtn() {
        for (int i = 0; i < 4; i++) {
            menuBtn[i] = new JButton(menuText[i]);
            menuBtn[i].setBounds(2 + 130 * i, 0, 130, 100);
            menuBtn[i].setBackground(color);
            menuBtn[i].setVisible(true);
            menuBtn[i].setFont(font1);
            //menuBtn[i].setBorderPainted(false);
            menuBtn[i].setContentAreaFilled(false);
            menuBtn[i].setFocusPainted(false);
            menuBtn[i].addActionListener(this);
            menuScreen.add(menuBtn[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuBtn[0]) {
            setSandwichMenuBtn();
            sandwichMenuScreen.setVisible(true);
            saladMenuScreen.setVisible(false);
            wrapEtcMenuScreen.setVisible(false);
            sideDrinkMenuScreen.setVisible(false);
        }
        else if (e.getSource() == menuBtn[1]) {
            setSaladMenuBtn();
            sandwichMenuScreen.setVisible(false);
            saladMenuScreen.setVisible(true);
            wrapEtcMenuScreen.setVisible(false);
            sideDrinkMenuScreen.setVisible(false);
        }
        else if (e.getSource() == menuBtn[2]) {
            setWrapEtcMenuBtn();
            sandwichMenuScreen.setVisible(false);
            saladMenuScreen.setVisible(false);
            wrapEtcMenuScreen.setVisible(true);
            sideDrinkMenuScreen.setVisible(false);
        }
        else if (e.getSource() == menuBtn[3]) {
            setSideDrinkMenuBtn();
            sandwichMenuScreen.setVisible(false);
            saladMenuScreen.setVisible(false);
            wrapEtcMenuScreen.setVisible(false);
            sideDrinkMenuScreen.setVisible(true);
        }
    }

    private void setSandwichMenuBtn() {
        sandwichMenuScreen.setBounds(0, 130, 525, 630);
        add(sandwichMenuScreen);
        sandwichMenuScreen.setVisible(true);

        JPanel sandwichMenuPanel = new JPanel(new GridLayout(0, 3));
        sandwichMenuPanel.setBounds(0, 130, 525, 630);

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

            sandwichMenuPanel.add(sandwichMenuBtn);
            sandwichMenuPanel.setVisible(true);

            sandwichMenuBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Sandwich sandwich = new Sandwich(j);
                    sandwich.chooseSandwich();
                }
            });
        }
        JScrollPane sandwichScrollPane = new JScrollPane(sandwichMenuPanel);
        sandwichScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        sandwichMenuScreen.add(sandwichScrollPane, BorderLayout.CENTER);
    }

    private void setSaladMenuBtn() {
        saladMenuScreen.setBounds(0, 130, 525, 630);
        add(saladMenuScreen);
        saladMenuScreen.setBackground(Color.PINK);

        JPanel saladMenuPanel = new JPanel(new GridLayout(0, 3));
        saladMenuPanel.setBounds(0, 130, 525, 630);
    }

    private void setWrapEtcMenuBtn() {
        wrapEtcMenuScreen.setBounds(0, 130, 525, 630);
        add(wrapEtcMenuScreen);
        wrapEtcMenuScreen.setBackground(Color.BLACK);

        JPanel wrapEtcMenuPanel = new JPanel(new GridLayout(0, 3));
        wrapEtcMenuPanel.setBounds(0, 130, 525, 630);
    }

    private void setSideDrinkMenuBtn() {
        sideDrinkMenuScreen.setBounds(0, 130, 525, 630);
        add(sideDrinkMenuScreen);
        sideDrinkMenuScreen.setBackground(Color.ORANGE);

        JPanel sideDrinkMenuPanel = new JPanel(new GridLayout(0, 3));
        sideDrinkMenuPanel.setBounds(0, 130, 525, 630);
    }
    private void setCartScreen() {
        JPanel cartList = new JPanel();
        cartList.setBounds(10, 10, 380, 140);
        cartList.setBackground(Color.ORANGE);

        ImageIcon icon = new ImageIcon("images/payButton.png");
        Image img = icon.getImage();
        Image resizeImg = img.getScaledInstance(115, 140, Image.SCALE_SMOOTH);
        JButton payBtn = new JButton(new ImageIcon(resizeImg));
        payBtn.setBounds(400, 10, 115, 140);

        cartScreen.add(cartList);
        cartScreen.add(payBtn);
        payBtn.setVisible(true);
        cartList.setVisible(true);
    }
    public static void main(String[] args) {
        new MainFrame();
    }
}
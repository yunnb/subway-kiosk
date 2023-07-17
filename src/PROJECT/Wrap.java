package PROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

enum WrapType {
    SteakCheeseAvocadoWrap(6000, 478, "스테이크 & 치즈 아보카도 랩", "images/Wraps/1.png"),
    ShrimpEggMayoWrap(5300, 506, "쉬림프 에그마요 랩", "images/Wraps/2.png"),
    ChickenBaconMiniWrap(3400, 391, "치킨 베이컨 미니 랩", "images/Wraps/3.png");

    private int price;
    private int kcal;
    private String name;
    private String img;

    WrapType(int price, int kcal, String name, String img) {
        this.price = price;
        this.kcal = kcal;
        this.name = name;
        this.img = img;
    }

    public int getPrice() { return price; }
    public int getKcal() {
        return kcal;
    }
    public String getName() {
        return name;
    }
    public String getImg() { return img; }
}

public class Wrap {
    private JFrame frame = new JFrame();
    private JPanel setPanel = new JPanel();
    private JPanel cookiePanel = new JPanel();
    private JPanel drinkPanel = new JPanel();
    private JPanel checkPanel = new JPanel();

    private Font font1 = new Font("SUITE", Font.BOLD, 18);
    private Font font2 = new Font("SUITE", Font.PLAIN, 15);
    private Color color = new Color(0, 0, 0, 0);

    private WrapType wrapType;
    private CookieType cookieType;
    private DrinkType drinkType;

    private int price;
    private int kcal;
    private boolean set;

    public Wrap(WrapType wrapType) {
        this.wrapType = wrapType;

        this.price = 0;
        this.kcal = 0;
        this.set = false;
    }

    public void setCookie(CookieType cookieType) { this.cookieType = cookieType; }

    public void setDrink(DrinkType drinkType) { this.drinkType = drinkType; }

    public void setPrice() {
        price += wrapType.getPrice();
        if(set) price += 2600;
    }
    public int getPrice() { return price; }

    public int getKcal() {
        kcal += wrapType.getKcal();
        if(set) kcal += cookieType.getKcal() + drinkType.getKcal();

        return kcal;
    }

    public WrapType getWrapType() { return wrapType; }
    public Wrap getWrap() { return this; }

    private void setPopUpFrame() {
        frame.setTitle(wrapType.getName());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(false);
    }

    public void chooseWrap() {
        setPopUpFrame();
        frame.setVisible(true);
        chooseSet();
    }

    private void chooseSet() {
        JLabel label = new JLabel("세트 여부를 선택해주세요.");

        setPanel.setBounds(0, 0, 400, 400);
        setPanel.setLayout(null);

        label.setBounds(100, 80, 400, 60);
        label.setBackground(color);
        label.setFont(font1);

        frame.add(setPanel);
        setPanel.add(label);

        JButton setBtn[] = new JButton[2];
        setBtn[0] = new JButton(new ImageIcon("images/noSet.png"));
        setBtn[1] = new JButton(new ImageIcon("images/set.png"));
        for (int i = 0; i < 2; i++) {
            setBtn[i].setBounds(180*i + 30, 180, 150, 150);
            setBtn[i].setBackground(color);
            setBtn[i].setVisible(true);
            setBtn[i].setContentAreaFilled(false);
            setBtn[i].setFocusPainted(false);
            setPanel.add(setBtn[i]);
        }
        setBtn[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                set = false;
                setPanel.setVisible(false);
                checkSandwich();
            }
        });
        setBtn[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                set = true;
                setPanel.setVisible(false);
                chooseCookie();
            }
        });
    }

    private void chooseCookie() {
        JLabel label = new JLabel("쿠키를 선택해주세요.");

        cookiePanel.setBounds(0, 0, 400, 600);
        cookiePanel.setLayout(null);

        label.setBounds(125, 80, 400, 60);
        label.setBackground(color);
        label.setFont(font1);

        frame.add(cookiePanel);
        cookiePanel.add(label);

        JPanel cookieBtnPanel = new JPanel(new GridLayout(0, 3));
        cookieBtnPanel.setBounds(0, 130, 380, 350);
        cookiePanel.add(cookieBtnPanel);

        for(CookieType c: CookieType.values()) {
            ImageIcon icon = new ImageIcon(c.getImg());
            Image img = icon.getImage();
            Image resizeImg = img.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

            JButton cookieBtn = new JButton(c.getName(),new ImageIcon(resizeImg));
            cookieBtn.setSize(100, 100);
            cookieBtn.setContentAreaFilled(false);
            cookieBtn.setFocusPainted(true);
            cookieBtn.setBorderPainted(false);
            cookieBtn.setHorizontalTextPosition(JButton.CENTER);
            cookieBtn.setVerticalTextPosition(JButton.BOTTOM);
            cookieBtn.setFont(font2);

            cookieBtnPanel.add(cookieBtn);
            cookieBtnPanel.setVisible(true);
            cookieBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setCookie(c);
                    cookiePanel.setVisible(false);
                    chooseDrink();
                    System.out.println(c.getName());
                }
            });
        }
    }

    private void chooseDrink() {
        JLabel label = new JLabel("음료를 선택해주세요.");

        drinkPanel.setBounds(0, 0, 400, 550);
        drinkPanel.setLayout(null);

        label.setBounds(125, 80, 400, 60);
        label.setBackground(color);
        label.setFont(font1);

        frame.add(drinkPanel);
        drinkPanel.add(label);

        JPanel drinkBtnPanel = new JPanel(new GridLayout(2, 3));
        drinkBtnPanel.setBounds(0, 130, 380, 350);
        drinkPanel.add(drinkBtnPanel);

        for(DrinkType d: DrinkType.values()) {
            ImageIcon icon = new ImageIcon(d.getImg());
            Image img = icon.getImage();
            Image resizeImg = img.getScaledInstance(128, 128, Image.SCALE_SMOOTH);

            JButton drinkBtn = new JButton(d.getName(), new ImageIcon(resizeImg));
            drinkBtn.setSize(100, 100);
            drinkBtn.setContentAreaFilled(false);
            drinkBtn.setFocusPainted(true);
            drinkBtn.setBorderPainted(false);
            drinkBtn.setHorizontalTextPosition(JButton.CENTER);
            drinkBtn.setVerticalTextPosition(JButton.BOTTOM);
            drinkBtn.setFont(font2);

            drinkBtnPanel.add(drinkBtn);
            drinkBtnPanel.setVisible(true);
            drinkBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setDrink(d);
                    drinkPanel.setVisible(false);
                    checkSandwich();
                    System.out.println(d.getName());
                }
            });
        }
    }

    private void checkSandwich() {
        System.out.println("check");
        checkPanel.setLayout(null);
        checkPanel.setBounds(0, 0, 400, 550);
        frame.add(checkPanel);

        JLabel label = new JLabel("주문 내역을 확인해주세요.");
        label.setBounds(100, 40, 400, 60);
        label.setBackground(color);
        label.setFont(font1);
        checkPanel.add(label);

        JLabel setL = new JLabel();
        if(set) setL.setText("세트 |   " + cookieType.getName() + ",  " + drinkType.getName());
        else setL.setText("세트 |   선택 안함");

        setL.setBounds(40, 205, 400, 40);
        setL.setFont(font2);

        setPrice();

        JLabel bar = new JLabel("-------------------------------------");
        JLabel priceL = new JLabel("금액 |   " + getPrice() + "원");
        JLabel kcalL = new JLabel("열량 |   " + getKcal() + "kcal");

        bar.setBounds(40, 325, 400, 40);
        priceL.setBounds(40, 365, 200, 40);
        kcalL.setBounds(220, 365, 200, 40);

        bar.setFont(font2);
        priceL.setFont(font2);
        kcalL.setFont(font2);

        JButton cart = new JButton("담기");
        JButton cancel = new JButton("취소");
        cart.setBounds(85, 450, 90, 40);
        cancel.setBounds(200, 450, 90, 40);
        cart.setFont(font2);
        cancel.setFont(font2);

        checkPanel.add(setL);
        checkPanel.add(bar);
        checkPanel.add(priceL);
        checkPanel.add(kcalL);
        checkPanel.add(cart);
        checkPanel.add(cancel);

        checkPanel.setVisible(true);

        cart.revalidate();
        cancel.revalidate();
        cart.repaint();
        cancel.repaint();

        cart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainFrame.plusCart(getWrap());
                frame.setVisible(false);
            }
        });
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
            }
        });
    }
}

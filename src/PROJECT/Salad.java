package PROJECT;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

enum SaladType {
    Shrimp(8200, 79, "쉬림프", "images/Salads/1.png"),
    SteakCheese(9100, 193, "스테이크 & 치즈", "images/Salads/3.png"),
    ChickenBaconAbocado(9100, 200, "치킨 베이컨 아보카도", "images/Salads/3.png"),
    RoastedChicken(8200, 138, "로스트 치킨", "images/Salads/4.png"),
    RotisserieBarbecueChicken(8400, 165, "로티세리 바비큐 치킨", "images/Salads/5.png"),
    KBBQ(8400, 210, "K-바비큐", "images/Salads/6.png"),
    PulledPorkBarbecue(8300, 165, "풀드 포크 바비큐", "images/Salads/7.png"),
    SubwayClub(8200, 144, "써브웨이 클럽", "images/Salads/8.png"),
    ChickenTeriyaki(8100, 152, "치킨 데리야끼", "images/Salads/9.png"),
    SpicyItalian(8000, 302, "스파이시 이탈리안", "images/Salads/10.png"),
    ItalianBMT(7800, 226, "이탈리안 비엠티", "images/Salads/11.png"),
    BLT(7700, 153, "비엘티", "images/Salads/12.png"),
    ChickenSlice(7600, 103, "치킨 슬라이스", "images/Salads/13.png"),
    Tuna(6900, 153, "참치", "images/Salads/14.png"),
    Ham(6900, 99, "햄", "images/Salads/15.png"),
    EggMayo(6600, 254, "에그마요", "images/Salads/16.png"),
    Veggie(6100, 46, "베지", "images/Salads/17.png");

    private int price;
    private int kcal;
    private String name;
    private String img;

    SaladType(int price, int kcal, String name, String img) {
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

public class Salad {
    private JFrame frame = new JFrame();
    private JPanel cheesePanel = new JPanel();
    private JPanel toppingPanel = new JPanel();
    private JPanel vegetablePanel = new JPanel();
    private JPanel saucePanel = new JPanel();
    private JPanel setPanel = new JPanel();
    private JPanel cookiePanel = new JPanel();
    private JPanel drinkPanel = new JPanel();
    private JPanel checkPanel = new JPanel();

    private Font font1 = new Font("SUITE", Font.BOLD, 18);
    private Font font2 = new Font("SUITE", Font.PLAIN, 15);
    private Color color = new Color(0, 0, 0, 0);

    private SaladType saladType;
    private CheeseType cheeseType;
    private ArrayList<ToppingType> toppings;
    private ArrayList<VegetableType> vegetables;
    private ArrayList<SauceType> sauces;
    private CookieType cookieType;
    private DrinkType drinkType;

    private int[] toppingCnt = {0, 0, 0, 0, 0, 0, 0};
    private int[] vegetableCnt = {0, 0, 0, 0, 0, 0, 0, 0};
    private int[] sauceCnt = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    private int price;
    private int kcal;
    private boolean set;

    public Salad(SaladType saladType) {
        this.saladType = saladType;

        this.toppings = new ArrayList<>();
        this.vegetables = new ArrayList<>();
        this.sauces = new ArrayList<>();

        this.price = 0;
        this.kcal = 0;

        this.set = false;
    }

    public void setCheese(CheeseType cheeseType) {
        this.cheeseType = cheeseType;
    }

    public void addTopping(String topping) {
        toppings.add(ToppingType.valueOf(topping));
    }

    public void addVegetable(String vegetable) {
        vegetables.add(VegetableType.valueOf(vegetable));
    }

    public void addSauce(String sauce) {
        sauces.add(SauceType.valueOf(sauce));
    }

    public void removeTopping(String topping) {
        toppings.remove(ToppingType.valueOf(topping));
    }

    public void removeVegetable(String vegetable) {
        vegetables.remove(VegetableType.valueOf(vegetable));
    }

    public void removeSauce(String sauce) {
        sauces.remove(SauceType.valueOf(sauce));
    }

    public void setCookie(CookieType cookieType) { this.cookieType = cookieType; }

    public void setDrink(DrinkType drinkType) { this.drinkType = drinkType; }

    public void setPrice() {
        price += saladType.getPrice();
        if(set) price += 1700;
        for(ToppingType topping : toppings) price += topping.getPrice();
    }
    public int getPrice() { return price; }

    public int getKcal() {
        kcal += saladType.getKcal();
        if(set) kcal += cookieType.getKcal() + drinkType.getKcal();
        for(ToppingType topping : toppings) kcal += topping.getKcal();

        return kcal;
    }

    public SaladType getSaladType() { return saladType; }
    public Salad getSalad() { return this; }

    private void setPopUpFrame() {
        frame.setTitle(saladType.getName());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(false);
    }

    public void chooseSalad() {
        setPopUpFrame();
        frame.setVisible(true);
        chooseCheese();
    }

    private void chooseCheese() {

        JLabel label = new JLabel("치즈를 선택해주세요.");

        cheesePanel.setBounds(0, 0, 400, 600);
        cheesePanel.setLayout(null);

        label.setBounds(125, 80, 400, 60);
        label.setBackground(color);
        label.setFont(font1);

        frame.add(cheesePanel);
        cheesePanel.add(label);

        JPanel cheeseBtnPanel = new JPanel(new GridLayout(0, 3));
        cheeseBtnPanel.setBounds(0, 130, 380, 230);
        cheesePanel.add(cheeseBtnPanel);

        for(CheeseType c: CheeseType.values()) {
            ImageIcon icon = new ImageIcon(c.getImg());
            Image img = icon.getImage();
            Image resizeImg = img.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

            JButton cheeseBtn = new JButton(c.getName(),new ImageIcon(resizeImg));
            cheeseBtn.setSize(100, 100);
            cheeseBtn.setContentAreaFilled(false);
            cheeseBtn.setFocusPainted(true);
            cheeseBtn.setBorderPainted(false);
            cheeseBtn.setHorizontalTextPosition(JButton.CENTER);
            cheeseBtn.setVerticalTextPosition(JButton.BOTTOM);
            cheeseBtn.setFont(font2);

            cheeseBtnPanel.add(cheeseBtn);
            cheeseBtnPanel.setVisible(true);
            cheeseBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setCheese(c);
                    cheesePanel.setVisible(false);
                    chooseTopping();
                    System.out.println(c.getName());
                }
            });
        }
    }
    private void chooseTopping() {
        JLabel label = new JLabel("추가하실 토핑을 선택해주세요.");

        toppingPanel.setBounds(0, 0, 400, 600);
        toppingPanel.setLayout(null);

        label.setBounds(95, 80, 400, 60);
        label.setBackground(color);
        label.setFont(font1);

        frame.add(toppingPanel);
        toppingPanel.add(label);

        JPanel toppingBtnPanel = new JPanel(new GridLayout(0, 3));
        toppingBtnPanel.setBounds(0, 130, 380, 400);
        toppingPanel.add(toppingBtnPanel);

        for(ToppingType t: ToppingType.values()) {
            ImageIcon icon = new ImageIcon(t.getNoColorImg());
            Image img = icon.getImage();
            Image resizeImg = img.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

            JButton toppingBtn = new JButton(t.getName(), new ImageIcon(resizeImg));
            toppingBtn.setSize(100, 100);
            toppingBtn.setContentAreaFilled(false);
            toppingBtn.setFocusPainted(true);
            toppingBtn.setBorderPainted(false);
            toppingBtn.setHorizontalTextPosition(JButton.CENTER);
            toppingBtn.setVerticalTextPosition(JButton.BOTTOM);
            toppingBtn.setFont(font2);

            toppingBtnPanel.add(toppingBtn);
            toppingBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ImageIcon noColorIcon = new ImageIcon(t.getNoColorImg());
                    Image noColorImg = noColorIcon.getImage();
                    Image resizeNoColorImg = noColorImg.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

                    ImageIcon ColorIcon = new ImageIcon(t.getColorImg());
                    Image ColorImg = ColorIcon.getImage();
                    Image resizeColorImg = ColorImg.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

                    toppingCnt[t.ordinal()]++;
                    if (toppingCnt[t.ordinal()] % 2 == 1) {
                        addTopping(t.name());
                        toppingBtn.setIcon(new ImageIcon(resizeColorImg));
                        System.out.println("add " + t.getName());
                    }
                    else if (toppingCnt[t.ordinal()] % 2 == 0) {
                        removeTopping(t.name());
                        toppingBtn.setIcon(new ImageIcon(resizeNoColorImg));
                        System.out.println("remove " + t.getName());
                    }
                }
            });
        }

        JButton next = new JButton("다음", new ImageIcon("images/Toppings/8.png"));
        next.setSize(100, 100);
        next.setContentAreaFilled(false);
        next.setFocusPainted(true);
        next.setBorderPainted(false);
        next.setHorizontalTextPosition(JButton.CENTER);
        next.setVerticalTextPosition(JButton.BOTTOM);
        next.setFont(font2);
        toppingBtnPanel.add(next);
        toppingBtnPanel.setVisible(true);
        next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toppingPanel.setVisible(false);
                chooseVegetable();
                System.out.println("다음");
            }
        });

    }

    private void chooseVegetable() {
        JLabel label = new JLabel("야채를 선택해주세요.");

        vegetablePanel.setBounds(0, 0, 400, 600);
        vegetablePanel.setLayout(null);

        label.setBounds(125, 80, 400, 60);
        label.setBackground(color);
        label.setFont(font1);

        frame.add(vegetablePanel);
        vegetablePanel.add(label);

        JPanel vegetableBtnPanel = new JPanel(new GridLayout(3, 3));
        vegetableBtnPanel.setBounds(0, 130, 380, 400);
        vegetablePanel.add(vegetableBtnPanel);

        for(VegetableType v: VegetableType.values()) {
            ImageIcon icon = new ImageIcon(v.getNoColorImg());
            Image img = icon.getImage();
            Image resizeImg = img.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

            JButton vegetableBtn = new JButton(new ImageIcon(resizeImg));
            vegetableBtn.setSize(100, 100);
            vegetableBtn.setContentAreaFilled(false);
            vegetableBtn.setFocusPainted(true);
            vegetableBtn.setBorderPainted(false);
            vegetableBtn.setText(v.getName());
            vegetableBtn.setHorizontalTextPosition(JButton.CENTER);
            vegetableBtn.setVerticalTextPosition(JButton.BOTTOM);
            vegetableBtn.setFont(font2);

            vegetableBtnPanel.add(vegetableBtn);
            vegetableBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ImageIcon noColorIcon = new ImageIcon(v.getNoColorImg());
                    Image noColorImg = noColorIcon.getImage();
                    Image resizeNoColorImg = noColorImg.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

                    ImageIcon ColorIcon = new ImageIcon(v.getColorImg());
                    Image ColorImg = ColorIcon.getImage();
                    Image resizeColorImg = ColorImg.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

                    vegetableCnt[v.ordinal()]++;
                    if (vegetableCnt[v.ordinal()] % 2 == 1) {
                        addVegetable(v.name());
                        vegetableBtn.setIcon(new ImageIcon(resizeColorImg));
                        System.out.println("add " + v.getName());
                    }
                    else if (vegetableCnt[v.ordinal()] % 2 == 0) {
                        removeVegetable(v.name());
                        vegetableBtn.setIcon(new ImageIcon(resizeNoColorImg));
                        System.out.println("remove " + v.getName());
                    }
                }
            });
        }

        JButton next = new JButton("다음", new ImageIcon("images/Toppings/8.png"));
        next.setSize(100, 100);
        next.setContentAreaFilled(false);
        next.setFocusPainted(true);
        next.setBorderPainted(false);
        next.setHorizontalTextPosition(JButton.CENTER);
        next.setVerticalTextPosition(JButton.BOTTOM);
        next.setFont(font2);

        next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vegetablePanel.setVisible(false);
                chooseSauce();
                System.out.println("다음");
            }
        });
        vegetableBtnPanel.add(next);
        vegetableBtnPanel.setVisible(true);

    }
    private void chooseSauce() {
        JLabel label = new JLabel("소스를 선택해주세요.");

        saucePanel.setBounds(0, 0, 400, 600);
        saucePanel.setLayout(null);

        label.setBounds(125, 80, 400, 60);
        label.setBackground(color);
        label.setFont(font1);

        frame.add(saucePanel);
        saucePanel.add(label);

        JPanel sauceBtnPanel = new JPanel(new GridLayout(3, 3));
        sauceBtnPanel.setBounds(0, 130, 380, 400);
        saucePanel.add(sauceBtnPanel);

        for(SauceType s: SauceType.values()) {
            ImageIcon icon = new ImageIcon(s.getNoColorImg());
            Image img = icon.getImage();
            Image resizeImg = img.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

            JButton sauceBtn = new JButton(new ImageIcon(resizeImg));
            sauceBtn.setSize(100, 100);
            sauceBtn.setContentAreaFilled(false);
            sauceBtn.setFocusPainted(true);
            sauceBtn.setBorderPainted(false);
            sauceBtn.setText(s.getName());
            sauceBtn.setHorizontalTextPosition(JButton.CENTER);
            sauceBtn.setVerticalTextPosition(JButton.BOTTOM);
            sauceBtn.setFont(font2);

            sauceBtnPanel.add(sauceBtn);
            sauceBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ImageIcon noColorIcon = new ImageIcon(s.getNoColorImg());
                    Image noColorImg = noColorIcon.getImage();
                    Image resizeNoColorImg = noColorImg.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

                    ImageIcon ColorIcon = new ImageIcon(s.getColorImg());
                    Image ColorImg = ColorIcon.getImage();
                    Image resizeColorImg = ColorImg.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

                    sauceCnt[s.ordinal()]++;
                    if (sauceCnt[s.ordinal()] % 2 == 1) {
                        addSauce(s.name());
                        sauceBtn.setIcon(new ImageIcon(resizeColorImg));
                        System.out.println("add " + s.getName());
                    } else if (sauceCnt[s.ordinal()] % 2 == 0) {
                        removeSauce(s.name());
                        sauceBtn.setIcon(new ImageIcon(resizeNoColorImg));
                        System.out.println("remove " + s.getName());
                    }
                }
            });

        }
        JButton next = new JButton("다음", new ImageIcon("images/Toppings/8.png"));

        next.setSize(100, 100);
        next.setContentAreaFilled(false);
        next.setFocusPainted(true);
        next.setBorderPainted(false);
        next.setHorizontalTextPosition(JButton.CENTER);
        next.setVerticalTextPosition(JButton.BOTTOM);
        next.setFont(font2);
        next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saucePanel.setVisible(false);
                chooseSet();
                System.out.println("다음");
            }
        });
        sauceBtnPanel.add(next);
        sauceBtnPanel.setVisible(true);
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

        //JLabel bread = new JLabel();
        JLabel cheese = new JLabel("치즈 |   " + cheeseType.getName());
        JLabel topping = new JLabel();
        JLabel vegetable = new JLabel();
        JLabel sauce = new JLabel();
        JLabel setL = new JLabel();

        //if(!sizeUp) bread.setText("  빵   |   15cm,  " + breadType.getName());
        //else bread.setText("  빵   |   30cm,  " + breadType.getName());

        String str = "토핑 |   ";
        for (ToppingType t : toppings) str += t.getName() + ",  ";
        topping.setText(str);

        str = "야채 |   ";
        for (VegetableType v : vegetables) str += v.getName() + ",  ";
        vegetable.setText(str);

        str = "소스 |   ";
        for (SauceType s : sauces) str += s.getName() + ",  ";
        sauce.setText(str);

        if(set) setL.setText("세트 |   " + cookieType.getName() + ",  " + drinkType.getName());
        else setL.setText("세트 |   선택 안함");

        //bread.setBounds(40, 110, 400, 40);
        cheese.setBounds(40, 145, 400, 40);
        topping.setBounds(40, 180, 400, 40);
        vegetable.setBounds(40, 215, 400, 40);
        sauce.setBounds(40, 250, 400, 40);
        setL.setBounds(40, 285, 400, 40);

        //bread.setFont(font2);
        cheese.setFont(font2);
        topping.setFont(font2);
        vegetable.setFont(font2);
        sauce.setFont(font2);
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

        //checkPanel.add(bread);
        checkPanel.add(cheese);
        checkPanel.add(topping);
        checkPanel.add(vegetable);
        checkPanel.add(sauce);
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
                MainFrame.plusCart(getSalad());
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


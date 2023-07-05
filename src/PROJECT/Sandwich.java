package PROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

enum SandwichType {
    Ham(5200,262,"햄", "images/Sandwiches/1.png"),
    SubwayClub(6500,299,"써브웨이 클럽", "images/Sandwiches/2.png"),
    SpicyItalian(6300,464,"스파이시 이탈리안", "images/Sandwiches/3.png"),
    SteakCheese(7400,355,"스테이크&치즈", "images/Sandwiches/4.png"),
    ChickenBaconAvocado(7400,355,"치킨 베이컨 아보카도", "images/Sandwiches/5.png"),
    KBBQ(6700,372,"K-바비큐", "images/Sandwiches/6.png"),
    PulledPorkBarbecue(6600,327,"풀드 포크 바비큐", "images/Sandwiches/7.png"),
    RotisserieBarbecueChicken(6700,327,"로티세리 바비큐 치킨", "images/Sandwiches/8.png"),
    RoastedChicken(6700,300,"로스트 치킨", "images/Sandwiches/9.png"),
    Shrimp(6500,229,"쉬림프", "images/Sandwiches/10.png"),
    ChickenTeriyaki(6400,314,"치킨 데리야끼", "images/Sandwiches/11.png"),
    ItalianBMT(6100,388,"이탈리안 비엠티", "images/Sandwiches/12.png"),
    BLT(6000,300,"비엘티", "images/Sandwiches/13.png"),
    ChickenSlice(5900,265,"치킨 슬라이스", "images/Sandwiches/14.png"),
    Tuna(5200,316,"참치", "images/Sandwiches/15.png"),
    EggMayo(4900,416,"에그마요", "images/Sandwiches/16.png"),
    Veggie(4400,209,"베지", "images/Sandwiches/17.png");


    private int kcal;
    private int price;
    private String name;
    private String img;

    SandwichType(int price, int kcal, String name, String img) {
        this.kcal = kcal;
        this.price = price;
        this.name = name;
        this.img = img;
    }

    public int getKcal() {
        return  kcal;
    }
    public int getPrice() {
        return price;
    }
    public String getName(){
        return name;
    }
    public String getImg() { return img; }

}

enum BreadType {
    HoneyOat(235, "허니오트", "images/Breads/1.png"),
    Hearty(210, "하티", "images/Breads/2.png"),
    Wheat(192, "위트", "images/Breads/3.png"),
    ParmesanOregano(213, "파마산 오레가노", "images/Breads/4.png"),
    White(202, "화이트", "images/Breads/5.png"),
    Flat(467, "플랫브레드", "images/Breads/6.png");

    private int kcal;
    private String name;
    private String img;

    BreadType(int kcal, String name, String img) {
        this.kcal = kcal;
        this.name = name;
        this.img = img;
    }

    public int getKcal() {
        return kcal;
    }

    public String getName() {
        return name;
    }
    public String getImg() { return img; }
}
enum CheeseType {
    American(35, "아메리칸 치즈", "images/Cheeses/1.png"),
    Shredded(57, "슈레드 치즈", "images/Cheeses/2.png"),
    Mozzarella(44, "모차렐라 치즈", "images/Cheeses/3.png");


    private int kcal;
    private String name;
    private String img;

    CheeseType(int kcal, String name, String img) {
        this.kcal = kcal;
        this.name = name;
        this.img = img;
    }

    public int getKcal() {
        return kcal;
    }
    public String getName() {
        return name;
    }
    public String getImg() { return img; }

}

enum ToppingType {
    Meat(3000,100, "미트 추가", "images/Toppings/1.png", "images/Toppings2/1.png"),
    EggMayo(2000,205, "에그마요", "images/Toppings/2.png", "images/Toppings2/2.png"),
    Omelet(1800,120, "오믈렛", "images/Toppings/3.png", "images/Toppings2/3.png"),
    Avocado(1500,63, "아보카도", "images/Toppings/4.png", "images/Toppings2/4.png"),
    Bacon(1500,89, "베이컨", "images/Toppings/5.png", "images/Toppings2/5.png"),
    Pepperoni(1400,81, "페퍼로니", "images/Toppings/6.png", "images/Toppings2/6.png"),
    Cheese(1400,50, "치즈 추가", "images/Toppings/7.png", "images/Toppings2/7.png");

    private int kcal;
    private int price;
    private String name;
    private String colorImg;
    private String noColorImg;

    ToppingType(int price,int kcal, String name, String colorImg, String noColorImg) {
        this.kcal = kcal;
        this.price = price;
        this.name = name;
        this.colorImg = colorImg;
        this.noColorImg = noColorImg;
    }

    public int getKcal() {
        return  kcal;
    }
    public int getPrice() {
        return price;
    }
    public String getName(){
        return name;
    }
    public String getColorImg() { return colorImg; }
    public String getNoColorImg() { return noColorImg; }
}

enum VegetableType {
    Lettuce(3, "양상추", "images/Vegetables/1.png","images/Vegetables2/1.png" ),
    Tomato(8, "토마토", "images/Vegetables/2.png", "images/Vegetables2/2.png"),
    Cucumber(1, "오이", "images/Vegetables/3.png", "images/Vegetables2/3.png"),
    Peppers(1, "피망", "images/Vegetables/4.png", "images/Vegetables2/4.png"),
    Onions(3, "양파", "images/Vegetables/5.png", "images/Vegetables2/5.png"),
    Pickles(1, "피클", "images/Vegetables/6.png", "images/Vegetables2/6.png"),
    Olives(4, "올리브", "images/Vegetables/7.png", "images/Vegetables2/7.png"),
    Jalapeno(1, "할라피뇨", "images/Vegetables/8.png", "images/Vegetables2/8.png");

    private int kcal;
    private String name;
    private String colorImg;
    private String noColorImg;

    VegetableType(int kcal, String name, String colorImg, String noColorImg) {
        this.kcal = kcal;
        this.name = name;
        this.colorImg = colorImg;
        this.noColorImg = noColorImg;
    }

    public int getKcal() {
        return kcal;
    }
    public String getName() {
        return name;
    }
    public String getColorImg() { return colorImg; }
    public String getNoColorImg() { return noColorImg; }
}

enum SauceType {
    Ranch(116, "렌치", "images/Sauces/1.png", "images/Sauces2/1.png"),
    SweetOnion(40, "스윗 어니언", "images/Sauces/2.png", "images/Sauces2/2.png"),
    Mayonnaise(158, "마요네즈", "images/Sauces/3.png", "images/Sauces2/3.png"),
    SweetChilli(40, "스윗 칠리", "images/Sauces/4.png", "images/Sauces2/4.png"),
    SmokeBBQ(32, "스모크 바베큐", "images/Sauces/5.png", "images/Sauces2/5.png"),
    HotChilli(42, "핫 칠리", "images/Sauces/6.png", "images/Sauces2/6.png"),
    HoneyMustard(38, "허니 머스터드", "images/Sauces/7.png", "images/Sauces2/7.png"),
    SouthwestChipotle(96, "사우스 웨스트 치폴레", "images/Sauces/8.png", "images/Sauces2/8.png"),
    Horseradish(106, "홀스래디쉬", "images/Sauces/9.png", "images/Sauces2/9.png"),
    YellowMustard(15, "머스타드", "images/Sauces/10.png", "images/Sauces2/10.png");

    private int kcal;
    private String name;
    private String colorImg;
    private String noColorImg;

    SauceType(int kcal, String name, String colorImg, String noColorImg) {
        this.kcal = kcal;
        this.name = name;
        this.colorImg = colorImg;
        this.noColorImg = noColorImg;
    }

    public int getKcal() {
        return kcal;
    }

    public String getName() {
        return name;
    }
    public String getColorImg() { return colorImg; }
    public String getNoColorImg() { return noColorImg; }

}

enum CookieType {
    DoubleChocolateChip(212, "더블 초코칩", "images/Cookies/1.png"),
    ChocolateChip(228, "초코칩", "images/Cookies/2.png"),
    OatmealRaisin(200, "오트밀 레이즌", "images/Cookies/3.png"),
    RaspberryCheeseCake(204, "라즈베리 치즈케익", "images/Cookies/4.png"),
    WhiteChocoMacadamia(245, "화이트 초코 마카다미아", "images/Cookies/5.png");

    private int kcal;
    private String name;
    private String img;

    CookieType(int kcal, String name, String img) {
        this.kcal = kcal;
        this.name = name;
        this.img = img;
    }

    public int getKcal() {
        return kcal;
    }

    public String getName() {
        return name;
    }
    public String getImg() { return img; }

}

enum DrinkType {
    CocaCola(94, "코카 콜라", "images/Drinks/1.png"),
    CocaColaZero(0, "코카콜라 제로", "images/Drinks/2.png"),
    Sprite(90, "스프라이트", "images/Drinks/3.png"),
    SpriteZero(0, "스프라이트 제로", "images/Drinks/4.png"),
    FantaPineapple(42, "환타 파인애플", "images/Drinks/5.png"),
    FantaGrape(80, "환타 포도", "images/Drinks/6.png");

    private int kcal;
    private String name;
    private String img;

    DrinkType(int kcal, String name, String img) {
        this.kcal = kcal;
        this.name = name;
        this.img = img;
    }

    public int getKcal() {
        return kcal;
    }

    public String getName() {
        return name;
    }
    public String getImg() { return img; }
}

class Sandwich {
    private JFrame frame = new JFrame();
    private JPanel sizePanel = new JPanel();
    private JPanel breadPanel = new JPanel();
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

    private SandwichType sandwichType;
    private BreadType breadType;
    private CheeseType cheeseType;
    public ArrayList<ToppingType> toppings;
    private ArrayList<VegetableType> vegetables;
    private ArrayList<SauceType> sauces;
    private CookieType cookieType;
    private DrinkType drinkType;

    private int[] toppingCnt = {0, 0, 0, 0, 0, 0, 0};
    private int[] vegetableCnt = {0, 0, 0, 0, 0, 0, 0, 0};
    private int[] sauceCnt = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    private int price;
    private int kcal;

    private boolean sizeUp;
    private boolean set;

    public Sandwich(SandwichType sandwichType) {
        this.sandwichType = sandwichType;

        this.toppings = new ArrayList<>();
        this.vegetables = new ArrayList<>();
        this.sauces = new ArrayList<>();

        this.price = 0;
        this.kcal = 0;

        this.sizeUp = false;
        this.set = false;
    }

    public void setBread(BreadType breadType) {
        this.breadType = breadType;
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

    public int getPrice() {
        price += sandwichType.getPrice();
        if(sizeUp) price += 5500;
        if(set) price += 2500;

        for(ToppingType topping : toppings) {
            price += topping.getPrice();
            if(sizeUp) price += topping.getPrice();
        }
        return price;
    }

    public int getKcal() {
        kcal += sandwichType.getKcal();
        if(sizeUp) kcal += sandwichType.getKcal();
        if(set) kcal += cookieType.getKcal() + drinkType.getKcal();

        for(ToppingType topping : toppings) {
            kcal += topping.getKcal();
            if(sizeUp) kcal += topping.getKcal();
        }

        return kcal;
    }

    private void setPopUpFrame() {
        frame.setTitle(sandwichType.getName());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(false);
    }

    public void chooseSandwich() {
        setPopUpFrame();
        frame.setVisible(true);
        chooseSize();
    }

    private void chooseSize() {
        JLabel label = new JLabel("빵 길이를 선택해주세요.");

        sizePanel.setBounds(0, 0, 400, 400);
        sizePanel.setLayout(null);

        label.setBounds(115, 80, 400, 60);
        label.setBackground(color);
        label.setFont(font1);

        frame.add(sizePanel);
        sizePanel.add(label);

        JButton sizeBtn[] = new JButton[2];
        sizeBtn[0] = new JButton(new ImageIcon("images/15cm.png"));
        sizeBtn[1] = new JButton(new ImageIcon("images/30cm.png"));
        for (int i = 0; i < 2; i++) {
            sizeBtn[i].setBounds(180*i + 30 , 180,150,150);
            sizeBtn[i].setBackground(color);
            sizeBtn[i].setVisible(true);
            sizeBtn[i].setContentAreaFilled(false);
            sizeBtn[i].setFocusPainted(false);
            sizePanel.add(sizeBtn[i]);
            sizeBtn[0].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    sizeUp = false;
                    sizePanel.setVisible(false);
                    chooseBread();
                }
             });

            sizeBtn[1].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    sizeUp = true;
                    sizePanel.setVisible(false);
                    chooseBread();
                }
            });
        }
    }

    private void chooseBread() {
        JLabel label = new JLabel("빵 종류를 선택해주세요.");

        breadPanel.setBounds(0, 0, 400, 550);
        breadPanel.setLayout(null);

        label.setBounds(115, 80, 400, 60);
        label.setBackground(color);
        label.setFont(font1);

        frame.add(breadPanel);
        breadPanel.add(label);

        JPanel breadBtnPanel = new JPanel(new GridLayout(2, 3));
        breadBtnPanel.setBounds(0, 130, 380, 350);
        breadPanel.add(breadBtnPanel);

        for(BreadType b: BreadType.values()) {
            ImageIcon icon = new ImageIcon(b.getImg());
            Image img = icon.getImage();
            Image resizeImg = img.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

            JButton breadBtn = new JButton(b.getName(), new ImageIcon(resizeImg));
            breadBtn.setSize(100, 100);
            breadBtn.setContentAreaFilled(false);
            breadBtn.setFocusPainted(true);
            breadBtn.setBorderPainted(false);
            breadBtn.setHorizontalTextPosition(JButton.CENTER);
            breadBtn.setVerticalTextPosition(JButton.BOTTOM);
            breadBtn.setFont(font2);

            breadBtnPanel.add(breadBtn);
            breadBtnPanel.setVisible(true);
            breadBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setBread(b);
                    breadPanel.setVisible(false);
                    chooseCheese();
                    System.out.println(b.getName());
                }
            });
        }
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
            setBtn[i].setBounds(180*i + 30 , 180,150,150);
            setBtn[i].setBackground(color);
            setBtn[i].setVisible(true);
            setBtn[i].setContentAreaFilled(false);
            setBtn[i].setFocusPainted(false);
            setPanel.add(setBtn[i]);
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

        JLabel bread = new JLabel();
        JLabel cheese = new JLabel("치즈 |   " + cheeseType.getName());
        JLabel topping = new JLabel();
        JLabel vegetable = new JLabel();
        JLabel sauce = new JLabel();
        JLabel setL = new JLabel();

        if(!sizeUp) bread.setText("  빵   |   15cm,  " + breadType.getName());
        else bread.setText("  빵   |   30cm,  " + breadType.getName());

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
        else setL.setText("세트 |   ");

        bread.setBounds(40, 110, 400, 40);
        cheese.setBounds(40, 145, 400, 40);
        topping.setBounds(40, 180, 400, 40);
        vegetable.setBounds(40, 215, 400, 40);
        sauce.setBounds(40, 250, 400, 40);
        setL.setBounds(40, 285, 400, 40);

        bread.setFont(font2);
        cheese.setFont(font2);
        topping.setFont(font2);
        vegetable.setFont(font2);
        sauce.setFont(font2);
        setL.setFont(font2);

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

        checkPanel.add(bread);
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
    }
}

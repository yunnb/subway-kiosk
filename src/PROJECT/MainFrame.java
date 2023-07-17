package PROJECT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.*;

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
    private JPanel wrapMenuScreen = new JPanel(new BorderLayout());
    private JPanel sideDrinkMenuScreen = new JPanel(new BorderLayout());

    // Cart Screen
    private JPanel cartScreen = new JPanel();
    static String[][] data = {{"", "", "", "", "", ""}};
    static String[] column = {"품명", "수량", "가격", "-", "+", "삭제"};
    static DefaultTableModel model = new DefaultTableModel(data, column);
    static JTable cartListTable = new JTable(model);
    static JScrollPane cartListScrollPane = new JScrollPane(cartListTable);
    static DefaultTableModel m = (DefaultTableModel)cartListTable.getModel();

    static int totalPrice = 0;
    static JLabel totalPriceLabel = new JLabel(Integer.toString(totalPrice));

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
        wrapMenuScreen.setVisible(false);
        sideDrinkMenuScreen.setVisible(false);

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
            wrapMenuScreen.setVisible(false);
            sideDrinkMenuScreen.setVisible(false);
        }
        else if (e.getSource() == menuBtn[1]) {
            setSaladMenuBtn();
            sandwichMenuScreen.setVisible(false);
            saladMenuScreen.setVisible(true);
            wrapMenuScreen.setVisible(false);
            sideDrinkMenuScreen.setVisible(false);
        }
        else if (e.getSource() == menuBtn[2]) {
            setWrapMenuBtn();
            sandwichMenuScreen.setVisible(false);
            saladMenuScreen.setVisible(false);
            wrapMenuScreen.setVisible(true);
            sideDrinkMenuScreen.setVisible(false);
        }
        else if (e.getSource() == menuBtn[3]) {
            setSideDrinkMenuBtn();
            sandwichMenuScreen.setVisible(false);
            saladMenuScreen.setVisible(false);
            wrapMenuScreen.setVisible(false);
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

        JPanel saladMenuPanel = new JPanel(new GridLayout(0, 3));
        saladMenuPanel.setBounds(0, 130, 525, 630);

        ArrayList<SaladType> salads = new ArrayList<>(Arrays.asList(SaladType.Shrimp, SaladType.SteakCheese,
                SaladType.ChickenBaconAbocado, SaladType.RoastedChicken, SaladType.RotisserieBarbecueChicken,
                SaladType.KBBQ, SaladType.PulledPorkBarbecue, SaladType.SubwayClub, SaladType.ChickenTeriyaki,
                SaladType.SpicyItalian, SaladType.ItalianBMT, SaladType.BLT, SaladType.ChickenSlice, SaladType.Tuna,
                SaladType.Ham, SaladType.EggMayo, SaladType.Veggie));

        for (SaladType s : salads) {
            ImageIcon icon = new ImageIcon(s.getImg());
            Image img = icon.getImage();
            Image resizeImg = img.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

            JButton saladMenuBtn = new JButton(new ImageIcon(resizeImg));
            saladMenuBtn.setSize(70, 70);
            saladMenuBtn.setBackground(color);
            saladMenuBtn.setVisible(true);
            saladMenuBtn.setContentAreaFilled(false);  // 내용 영역 채우기
            saladMenuBtn.setFocusPainted(true);  // 선택 시 테두리
            saladMenuBtn.setBorderPainted(false); // 테두리
            saladMenuBtn.setText(s.getName());
            saladMenuBtn.setHorizontalTextPosition(JButton.CENTER);
            saladMenuBtn.setVerticalTextPosition(JButton.BOTTOM);
            saladMenuBtn.setFont(font2);

            saladMenuPanel.add(saladMenuBtn);
            saladMenuPanel.setVisible(true);

            saladMenuBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println(s.getName());
                    Salad salad = new Salad(s);
                    salad.chooseSalad();
                }
            });
        }
        JScrollPane saladScrollPane = new JScrollPane(saladMenuPanel);
        saladScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        saladMenuScreen.add(saladScrollPane, BorderLayout.CENTER);
    }

    private void setWrapMenuBtn() {
        wrapMenuScreen.setBounds(0, 130, 525, 150);
        add(wrapMenuScreen);
        //wrapMenuScreen.setBackground(Color.BLACK);

        JPanel wrapMenuPanel = new JPanel(new GridLayout(0, 3));
        wrapMenuPanel.setBounds(0, 0, 525, 100);

        ArrayList<WrapType> Wraps = new ArrayList<>(Arrays.asList(WrapType.SteakCheeseAvocadoWrap,
                WrapType.ShrimpEggMayoWrap, WrapType.ChickenBaconMiniWrap));

        for (WrapType w : Wraps) {
            ImageIcon icon = new ImageIcon(w.getImg());
            Image img = icon.getImage();
            Image resizeImg = img.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

            JButton wrapMenuBtn = new JButton(new ImageIcon(resizeImg));
            wrapMenuBtn.setSize(70, 70);
            wrapMenuBtn.setBackground(color);
            wrapMenuBtn.setVisible(true);
            wrapMenuBtn.setContentAreaFilled(false);  // 내용 영역 채우기
            wrapMenuBtn.setFocusPainted(true);  // 선택 시 테두리
            wrapMenuBtn.setBorderPainted(false); // 테두리
            wrapMenuBtn.setText(w.getName());
            wrapMenuBtn.setHorizontalTextPosition(JButton.CENTER);
            wrapMenuBtn.setVerticalTextPosition(JButton.BOTTOM);
            wrapMenuBtn.setFont(font2);

            wrapMenuPanel.add(wrapMenuBtn);
            wrapMenuPanel.setVisible(true);

            wrapMenuBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println(w.getName());
                    Wrap wrap = new Wrap(w);
                    wrap.chooseWrap();
                }
            });
        }
        wrapMenuScreen.add(wrapMenuPanel);
    }

    private void setSideDrinkMenuBtn() {
        sideDrinkMenuScreen.setBounds(0, 130, 525, 630);
        add(sideDrinkMenuScreen);
        //sideDrinkMenuScreen.setBackground(Color.ORANGE);

        JPanel sideDrinkMenuPanel = new JPanel(new GridLayout(0, 3));
        sideDrinkMenuPanel.setBounds(0, 130, 525, 630);

        ArrayList<CookieType> Cookies = new ArrayList<>(Arrays.asList(
                CookieType.DoubleChocolateChip, CookieType.ChocolateChip, CookieType.OatmealRaisin,
                CookieType.RaspberryCheeseCake, CookieType.WhiteChocoMacadamia));

        for (CookieType c : Cookies) {
            ImageIcon icon = new ImageIcon(c.getImg());
            Image img = icon.getImage();
            Image resizeImg = img.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

            JButton cookieMenuBtn = new JButton(new ImageIcon(resizeImg));
            cookieMenuBtn.setSize(70, 70);
            cookieMenuBtn.setBackground(color);
            cookieMenuBtn.setVisible(true);
            cookieMenuBtn.setContentAreaFilled(false);  // 내용 영역 채우기
            cookieMenuBtn.setFocusPainted(true);  // 선택 시 테두리
            cookieMenuBtn.setBorderPainted(false); // 테두리
            cookieMenuBtn.setText(c.getName());
            cookieMenuBtn.setHorizontalTextPosition(JButton.CENTER);
            cookieMenuBtn.setVerticalTextPosition(JButton.BOTTOM);
            cookieMenuBtn.setFont(font2);

            sideDrinkMenuPanel.add(cookieMenuBtn);
            sideDrinkMenuPanel.setVisible(true);

            cookieMenuBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println(c.getName());
                    plusCart(c);
                }
            });
        }

        ArrayList<DrinkType> drinks = new ArrayList<>(Arrays.asList(
                DrinkType.CocaCola, DrinkType.CocaColaZero, DrinkType.Sprite,
                DrinkType.SpriteZero, DrinkType.FantaPineapple, DrinkType.FantaGrape));

        for (DrinkType d : drinks) {
            ImageIcon icon = new ImageIcon(d.getImg());
            Image img = icon.getImage();
            Image resizeImg = img.getScaledInstance(128, 90, Image.SCALE_SMOOTH);

            JButton drinkMenuBtn = new JButton(new ImageIcon(resizeImg));
            drinkMenuBtn.setSize(70, 70);
            drinkMenuBtn.setBackground(color);
            drinkMenuBtn.setVisible(true);
            drinkMenuBtn.setContentAreaFilled(false);  // 내용 영역 채우기
            drinkMenuBtn.setFocusPainted(true);  // 선택 시 테두리
            drinkMenuBtn.setBorderPainted(false); // 테두리
            drinkMenuBtn.setText(d.getName());
            drinkMenuBtn.setHorizontalTextPosition(JButton.CENTER);
            drinkMenuBtn.setVerticalTextPosition(JButton.BOTTOM);
            drinkMenuBtn.setFont(font2);

            sideDrinkMenuPanel.add(drinkMenuBtn);
            sideDrinkMenuPanel.setVisible(true);

            drinkMenuBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println(d.getName());
                    plusCart(d);
                }
            });
        }
        sideDrinkMenuScreen.add(sideDrinkMenuPanel);
    }

    private void setCartScreen() {
        JPanel cartListPanel = new JPanel(new BorderLayout());
        cartListPanel.setBounds(10, 10, 380, 110);

        ImageIcon icon = new ImageIcon("images/payButton.png");
        Image img = icon.getImage();
        Image resizeImg = img.getScaledInstance(115, 140, Image.SCALE_SMOOTH);
        JButton payBtn = new JButton(new ImageIcon(resizeImg));
        payBtn.setBounds(400, 10, 115, 140);
        payBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("결제");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(400, 600);
                frame.setLocationRelativeTo(null);
                frame.setLayout(null);
                frame.setVisible(true);

                JPanel panel = new JPanel();
                System.out.println("check");
                panel.setLayout(null);
                panel.setBounds(0, 0, 400, 550);
                frame.add(panel);

                JLabel label = new JLabel("결제 ㄱ.");
                label.setBounds(100, 40, 400, 60);
                label.setBackground(color);
                label.setFont(font1);
                panel.add(label);

                JLabel totalPriceLabel = new JLabel(Integer.toString(totalPrice));
                totalPriceLabel.setBounds(150, 100, 400, 60);
                label.setBackground(color);
                label.setFont(font1);
                panel.add(totalPriceLabel);

                JButton cart = new JButton("결제");
                JButton cancel = new JButton("취소");
                cart.setBounds(85, 450, 90, 40);
                cancel.setBounds(200, 450, 90, 40);
                cart.setFont(font2);
                cancel.setFont(font2);

                panel.add(cart);
                panel.add(cancel);

                panel.setVisible(true);

                cart.revalidate();
                cancel.revalidate();
                cart.repaint();
                cancel.repaint();

                cart.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.exit(0);
                    }
                });
                cancel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        frame.setVisible(false);
                    }
                });
            }
        });

        JPanel cartList = new JPanel();
        cartList.setBounds(0, 0, 380, 110);
        cartListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        model.removeRow(0);

        JPanel totalPricePanel = new JPanel(new BorderLayout());
        totalPricePanel.setBounds(10, 120, 380, 20);
        totalPricePanel.add(new JLabel("총 금액"), BorderLayout.WEST);
        totalPricePanel.add(totalPriceLabel, BorderLayout.EAST);

        for (int i = 3; i < 6; i++) {
            TableColumn btnColumn = cartListTable.getColumnModel().getColumn(i);
            btnColumn.setCellRenderer(new ButtonRenderer());
            btnColumn.setCellEditor(new ButtonEditor(i, cartListTable));
        }

        // 테이블 안 텍스트 가운데 정렬
        TableColumnModel columnModel = cartListTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setCellRenderer(new CustomTableCellRenderer());
        }

        cartListTable.getColumnModel().getColumn(0).setPreferredWidth(130);
        cartListTable.getColumnModel().getColumn(1).setPreferredWidth(30);
        cartListTable.getColumnModel().getColumn(2).setPreferredWidth(70);
        cartListTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        cartListTable.getColumnModel().getColumn(4).setPreferredWidth(20);
        cartListTable.getColumnModel().getColumn(5).setPreferredWidth(20);

        cartListPanel.add(cartListScrollPane, BorderLayout.CENTER);
        cartScreen.add(cartListPanel);
        cartScreen.add(payBtn);
        cartScreen.add(totalPricePanel);
        payBtn.setVisible(true);
        cartListPanel.setVisible(true);
    }

    public static void plusCart(Sandwich sandwich) {
        m.addRow(new Object[]{sandwich.getSandwichType().getName(), 1, sandwich.getPrice(), "", "", ""});
        totalPrice += sandwich.getPrice();
        totalPriceLabel.setText(Integer.toString(totalPrice));
    }

    public static void plusCart(Salad salad) {
        m.addRow(new Object[]{salad.getSaladType().getName(), 1, salad.getPrice(), "", "", ""});
        totalPrice += salad.getPrice();
        totalPriceLabel.setText(Integer.toString(totalPrice));
    }

    public static void plusCart(Wrap wrap) {
        m.addRow(new Object[]{wrap.getWrapType().getName(), 1, wrap.getPrice(), "", "", ""});
        totalPrice += wrap.getPrice();
        totalPriceLabel.setText(Integer.toString(totalPrice));
    }
    public void plusCart(CookieType cookie) {
        m.addRow(new Object[]{cookie.getName(), 1, cookie.getPrice(), "", "",""});
        totalPrice += cookie.getPrice();
        totalPriceLabel.setText(Integer.toString(totalPrice));
    }
    public void plusCart(DrinkType drink) {
        m.addRow(new Object[]{drink.getName(), 1, drink.getPrice(), "", "",""});
        totalPrice += drink.getPrice();
        totalPriceLabel.setText(Integer.toString(totalPrice));
    }
    public static void main(String[] args) {
        new MainFrame();
    }

    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            return this;
        }
    }

    static class ButtonEditor extends DefaultCellEditor {
        private JButton btn;
        private int btnIndex;
        private JTable cartListTable; // JTable 변수 추가

        // 생성자에 JTable을 전달받는 매개변수 추가
        public ButtonEditor(int btnIndex, JTable cartListTable) {
            super(new JTextField());
            this.btnIndex = btnIndex;
            this.cartListTable = cartListTable; // 전달받은 JTable 설정
            btn = new JButton();
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = cartListTable.getSelectedRow();
                    if (row != -1) { // 선택된 행이 있는 경우
                        String name = (String)cartListTable.getValueAt(row, 0);
                        int amount = (int)cartListTable.getValueAt(row, 1);
                        int price = (int)cartListTable.getValueAt(row, 2);
                        int originalPrice = price / amount;

                        switch (btnIndex) {
                            case 3:
                                if (amount <= 1) {
                                    totalPrice -= price;
                                    totalPriceLabel.setText(Integer.toString(totalPrice));
                                    m.removeRow(row);
                                }
                                else {
                                    totalPrice -= originalPrice;
                                    totalPriceLabel.setText(Integer.toString(totalPrice));
                                    cartListTable.setValueAt(--amount, row, 1);
                                    cartListTable.setValueAt(price-originalPrice, row, 2);
                                }
                                System.out.println(name + " 수량-1");
                                break;
                            case 4:
                                totalPrice += originalPrice;
                                totalPriceLabel.setText(Integer.toString(totalPrice));
                                cartListTable.setValueAt(++amount, row, 1);
                                cartListTable.setValueAt(price+originalPrice, row, 2);
                                System.out.println(name + " 수량+1");
                                break;
                            case 5:
                                totalPrice -= price;
                                totalPriceLabel.setText(Integer.toString(totalPrice));
                                cartListTable.setValueAt(0, row, 1);
                                cartListTable.setValueAt("", row, 0); // 해당 행의 이름을 빈 문자열로 설정하여 숨기기
                                System.out.println(name + " 삭제");
                                break;
                        }
                    }
                    // 행을 숨기기 위한 작업
                    for (int i = m.getRowCount() - 1; i >= 0; i--) {
                        int amount = (int) m.getValueAt(i, 1);
                        if (amount == 0) m.removeRow(i);
                    }
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            btn.setText(value.toString());
            return btn;
        }
    }

    static class CustomTableCellRenderer extends DefaultTableCellRenderer {
        public CustomTableCellRenderer() {
            setHorizontalAlignment(SwingConstants.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            return this;
        }
    }
}
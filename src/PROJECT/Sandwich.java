package PROJECT;
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
    Oat(235, "허니오트"),
    Hearty(210, "하티"),
    Wheat(192, "위트"),
    Oregano(213, "파마산 오레가노"),
    White(202, "화이트"),
    Flat(467, "플랫브레드");

    private int kcal;
    private String name;

    BreadType(int kcal, String name) {
        this.kcal = kcal;
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public String getName() {
        return name;
    }
}
enum CheeseType {
    American(35, "아메리칸 치즈"),
    Shredded(57, "슈레드 치즈"),
    Mozzarella(44, "모차렐라 치즈");


    private int kcal;
    private String name;

    CheeseType(int kcal, String name) {
        this.kcal = kcal;
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }
    public String getName() {
        return name;
    }

}

enum ToppingType {
    Meat(3000,100, "미트 추가"),
    EggMayo(2000,205, "에그마요"),
    Omelet(1800,120, "오믈렛"),
    Avocado(1500,63, "아보카도"),
    Bacon(1500,89, "베이컨"),
    Pepperoni(1400,81, "페퍼로니"),
    Cheese(1400,50, "치즈 추가");

    private int kcal;
    private int price;
    private String name;

    ToppingType(int price,int kcal, String name) {
        this.kcal = kcal;
        this.price = price;
        this.name = name;
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
}

enum VegetableType {
    Lettuce(3, "양상추"),
    Tomato(8, "토마토"),
    Cucumber(1, "오이"),
    Peppers(1, "피망"),
    Onions(3, "양파"),
    Pickles(1, "피클"),
    Olives(4, "올리브"),
    Jalapeno(1, "할라피뇨");

    private int kcal;
    private String name;

    VegetableType(int kcal, String name) {
        this.kcal = kcal;
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }
    public String getName() {
        return name;
    }
}

enum SauceType {
    Ranch(116, "렌치"),
    SweetOnion(40, "스윗 어니언"),
    Mayonnaise(158, "마요네즈"),
    SweetChilli(40, "스윗 칠리"),
    SmokeBBQ(32, "스모크 바베큐"),
    HotChilli(42, "핫 칠리"),
    HoneyMustard(38, "허니 머스터드"),
    SouthwestChipotle(96, "사우스 웨스트 치폴레"),
    Horseradish(106, "홀스래디쉬"),
    YellowMustard(15, "머스타드");

    private int kcal;
    private String name;

    SauceType(int kcal, String name) {
        this.kcal = kcal;
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public String getName() {
        return name;
    }

}

enum CookieType {
    DoubleChocolateChip(212, "더블 초코칩"),
    ChocolateChip(228, "초코칩"),
    OatmealRaisin(200, "오트밀 레이즌"),
    RaspberryCheeseCake(204, "라즈베리 치즈케익"),
    WhiteChocoMacadamia(245, "화이트 초코 마카다미아");

    private int kcal;
    private String name;

    CookieType(int kcal, String name) {
        this.kcal = kcal;
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public String getName() {
        return name;
    }

}

enum DrinkType {
    CocaCola(94, "코카 콜라"),
    CocaColaZero(0, "코카콜라 제로"),
    Sprite(90, "스프라이트"),
    SpriteZero(0, "스프라이트 제로"),
    FantaPineapple(42, "환타 파인애플"),
    FantaGrape(80, "환타 포도");

    private int kcal;
    private String name;

    DrinkType(int kcal, String name) {
        this.kcal = kcal;
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public String getName() {
        return name;
    }
}

class Sandwich {
    private SandwichType sandwichType;
    private BreadType breadType;
    private CheeseType cheeseType;
    public ArrayList<ToppingType> toppings;
    private ArrayList<VegetableType> vegetables;
    private ArrayList<SauceType> sauces;
    private CookieType cookieType;
    private DrinkType drinkType;

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
}

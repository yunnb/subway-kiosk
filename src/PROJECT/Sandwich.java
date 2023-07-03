package PROJECT;
import java.util.ArrayList;
import java.util.List;

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

enum SandwichType {
    Ham(5200,262,"햄"),
    SubwayClub(6500,299,"써브웨이 클럽"),
    SpicyItalian(6300,464,"스파이시 이탈리안"),
    SteakCheese(7400,355,"스테이크&치즈"),
    ChickenBaconAvocado(7400,355,"치킨 베이컨 아보카도"),
    KBBQ(6700,372,"K-바비큐"),
    PulledPorkBarbecue(6600,327,"풀드 포크 바비큐"),
    RotisserieBarbecueChicken(6700,327,"로티세리 바비큐 치킨"),
    RoastedChicken(6700,300,"로스트 치킨"),
    Shrimp(6500,229,"쉬림프"),
    ChickenTeriyaki(6400,314,"치킨 데리야끼"),
    ItalianBMT(6100,388,"이탈리안 비엠티"),
    BLT(6000,300,"비엘티"),
    ChickenSlice(5900,265,"치킨 슬라이스"),
    Tuna(5200,316,"참치"),
    EggMayo(4900,416,"에그마요"),
    Veggie(4400,209,"베지");


    private int kcal;
    private int price;
    private String name;

    SandwichType(int price, int kcal, String name) {
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

class Vegetable {
    private VegetableType type;

    public Vegetable(VegetableType type) {
        this.type = type;
    }

    public VegetableType getType() {
        return type;
    }
}

class Sauce {
    private SauceType type;

    public Sauce(SauceType type)
    {
        this.type = type;
    }

    public SauceType getType()
    {
        return type;
    }
}

class Topping {
    private ToppingType type;
    private int quantity;

    public Topping(ToppingType type,int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public ToppingType getType() {
        return type;
    }
}



class Sandwich {
    private SandwichType sandwichType;
    private String ImgPath;
    private boolean basic = true; //true 가 15cm false가 30cm
    private boolean set = false; //false가 기본 true가 세트
    private int price;
    private int kcal;
    private BreadType breadType;
    private CheeseType cheeseType;
    private List<Vegetable> vegetables;
    private List<Sauce> sauces;
    private List<Topping> toppings;

    public Sandwich(SandwichType sandwichType, String ImgPath) {
        this.sandwichType = sandwichType;

        this.ImgPath = ImgPath;

        this.price = sandwichType.getPrice();
        this.kcal = sandwichType.getKcal();

        this.toppings = new ArrayList<>();
        this.vegetables = new ArrayList<>();
        this.sauces = new ArrayList<>();
    }

    public void choiceSandwich(SandwichType sandwichType) {
        this.sandwichType = sandwichType;
    }
    public void choiceBread(BreadType breadType) {
        this.breadType = breadType;
    }
    public void choiceCheese(CheeseType cheeseType) {
        this.cheeseType = cheeseType;
    }

    public void addTopping(ToppingType toppingType, int quantity) {
        toppings.add(new Topping(toppingType,quantity));
    }

    public void addVegetable(VegetableType vegetableType) {
        vegetables.add(new Vegetable(vegetableType));
    }

    public void addSauce(SauceType sauceType) {
        sauces.add(new Sauce(sauceType));
    }


    public int TotalPrice() {
        int total = price;

        if(set) total += 1600; //세트면 1600원 추가

        //토핑 가격 계산
        for(Topping topping : toppings) {
            int toppingPrice = topping.getType().getPrice();
            if(!basic) toppingPrice *= 2; //30cm 이면 토핑 가격 2배
            total += toppingPrice;
        }

        return total;
    }

    public int TotalKcal() {
        int total = kcal;

        //토핑 칼로리 게산
        for(Topping topping : toppings) {
            int toppingKcal = topping.getType().getKcal();
            if(!basic) toppingKcal *= 2; //30cm 면 칼로리 2배
            total += toppingKcal;
        }

        //소스 칼로리 계산
        for(Sauce sauce : sauces) {
            int sauceKcal = sauce.getType().getKcal();
            if(!basic) sauceKcal *= 2; //30cm 면 칼로리 2배
            total += sauceKcal;
        }

        //야채 칼로리 계산
        for(Vegetable vegetable : vegetables) {
            int vegetableKcal = vegetable.getType().getKcal();
            if(!basic) vegetableKcal *= 2; //30cm 면 칼로리 2배
            total += vegetableKcal;
        }

        total += breadType.getKcal(); //빵 칼로리 계산
        total += cheeseType.getKcal(); //치즈 칼로리 계산

        return total;
    }

    public SandwichType getSandwichType() {
        return sandwichType;
    }

    public String getImgPath() {
        return ImgPath;
    }

    public void test() {
        System.out.println("이 샌드위치는 " + sandwichType.getName() + "입니다");
    }



}

/*
public class SandwichClass {


    public static void main(String[] args)
    {
        Sandwich sandwich = new Sandwich(SandwichType.Ham);
        sandwich.addSauce(SauceType.Horseradish);
        sandwich.addTopping(ToppingType.Bacon,2);
        sandwich.addTopping(ToppingType.Avocado,1);
        sandwich.addVegetable(VegetableType.Lettuce);
        sandwich.choiceBread(BreadType.Flat);
        sandwich.choiceCheese(CheeseType.Mozzarella);

        System.out.println("Price : " + sandwich.TotalPrice());
        System.out.println("Kcal : " + sandwich.TotalKcal());

    }

}
*/
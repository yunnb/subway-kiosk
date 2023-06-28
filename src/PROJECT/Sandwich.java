package PROJECT;
enum BreadType {
    Oat(235),
    Hearty(210),
    Wheat(192),
    Oregano(213),
    White(202),
    Flat(467);

    private int kcal;

    BreadType(int kcal)
    {
        this.kcal = kcal;
    }

    public int getKcal()
    {
        return kcal;
    }

}
enum CheeseType {
    American(35),
    Shredded(57),
    Mozzarella(44);


    private int kcal;

    CheeseType(int kcal)
    {
        this.kcal = kcal;
    }

    public int getKcal()
    {
        return kcal;
    }

}

enum VegetableType {
    Lettuce(3), //양상추
    Tomato(8),  //토마토
    Cucmber(1), //오이
    Peppers(1), //피망
    Onions(3), //양파
    Pickles(1), //피클
    Olives(4), //올리브
    Jalapeno(1); //할라피뇨

    private int kcal;

    VegetableType(int kcal)
    {
        this.kcal = kcal;
    }

    public int getKcal()
    {
        return kcal;
    }

}

enum SauceType {
    Ranch(116), //렌치
    SweetOnion(40),  //스윗 어니언
    Mayonnaise(158), //마요네즈
    SweetChilli(40), //스윗 칠리
    SmokeBBQ(32), //스모크 바베큐
    HotChilli(42), //핫 칠리
    HoneyMustard(38), //허니 머스터드
    SouthwestChipotle(96), //사우스 웨스트 치폴레
    Horseradish(106), //홀스래디쉬
    YellowMustard(15); //머스타드

    private int kcal;

    SauceType(int kcal)
    {
        this.kcal = kcal;
    }

    public int getKcal()
    {
        return kcal;
    }

}

enum ToppingType
{
    Meat(3000,100),
    EggMayo(2000,205),
    Omelet(1800,120),
    Avocado(1500,63),
    Bacon(1500,89),
    Pepperoni(1400,81),
    Cheese(1400,50);

    private int kcal;
    private int price;

    ToppingType(int price,int kcal)
    {
        this.kcal = kcal;
        this.price = price;
    }

    public int getKcal()
    {
        return  kcal;
    }
    public int getPrice()
    {
        return price;
    }

}

enum SandwichType
{
    Ham(5200,262),
    SubwayClub(6500,299),
    SpicyItalian(6300,464),
    SteakCheese(7400,355),
    ChickenBaconAvocado(7400,355),
    KBBQ(6700,372),
    PulledPorkBarbecue(6600,327),
    RotisserieBarbecueChicken(6700,327),
    RoastedChicken(6700,300),
    Shrimp(6500,229),
    ChickenTeriyaki(6400,314),
    ItalianBMT(6100,388),
    BLT(6000,300),
    ChickenSlice(5900,265),
    Tuna(5200,316),
    EggMayo(4900,416),
    Veggie(4400,209);


    private int kcal;
    private int price;

    SandwichType(int price,int kcal)
    {
        this.kcal = kcal;
        this.price = price;
    }

    public int getKcal()
    {
        return  kcal;
    }
    public int getPrice()
    {
        return price;
    }

}
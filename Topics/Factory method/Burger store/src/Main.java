class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        /* write your code here */
        BurgerStore burgerStore = new BurgerStore();
        Burger chineseBurger =burgerStore.orderBurger("Chinese");
        Burger americanBurger =burgerStore.orderBurger("American");
        Burger russianBurger =burgerStore.orderBurger("Russian");

    }
}

abstract class BurgerFactory {

    abstract Burger createBurger(String type);

    Burger orderBurger(String type) throws InterruptedException {
        Burger burger = createBurger(type);
        if (burger == null) {
            System.out.println("Sorry, we are unable to create this kind of burger\n");
            return null;
        }
        System.out.println("Making a " + burger.getName()+" Burger");
        burger.putBun();
        burger.putCutlet();
        burger.putSauce();
        Thread.sleep(1500L);
        System.out.println(burger.getName() + " Burger ready" + "\n");
        return burger;
    }
}

class BurgerStore extends BurgerFactory {
    @Override
    Burger createBurger(String type) {
        switch (type) {
            case "Chinese":
                return new ChineseBurger("Chinese");
            case "American":
                return new AmericanBurger("American");
            case "Russian":
                return new RussianBurger("Russian");
            default:
                return null;
        }
    }
}

abstract class Burger {
    private String name;

    Burger(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void putBun() {
        System.out.println("Putting bun");
    }

    void putCutlet() {
        System.out.println("Putting patty");
    }

    void putSauce() {
        System.out.println("Putting sauce");
    }

}

class ChineseBurger extends Burger {
    ChineseBurger(String name) {
        super(name);
    }
    /* write your code here */
}

class AmericanBurger extends Burger {
    AmericanBurger(String name) {
        super(name);
    }
    /* write your code here */
}

class RussianBurger extends Burger {
    RussianBurger(String name) {
        super(name);
    }
    /* write your code here */
}
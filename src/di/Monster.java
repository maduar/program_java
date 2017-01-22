package di;

/**
 * Created by maduar on 2017/1/17.
 */
public class Monster {

    private String name;
    private float age;

    public Monster(String name, float age) {
        this.name = name;
        this.age = age;
    }

    public static void main (String[] args) {
        Monster m1 = new Monster("goog", 11);
        System.out.println("name = " + m1.name);
        System.out.println("age = " + m1.age);
    }

}

package List;

/**
 * Created by maduar on 2017/1/20.
 */
public class Test {

    public static void main(String[] args) {

        Sequencelist list = new Sequencelist(20);

        try {

            int size = list.size();
            boolean bool = list.isEmpty();
            System.out.println("list.length = " + size);
            System.out.println("list.isEmpty = " + bool);

            list.insert(0, 100);
            list.insert(0,50);
            list.insert(1, 20);

            size = list.size();
            bool = list.isEmpty();
            System.out.println("list.length = " + size);
            System.out.println("list.isEmpty = " + bool);

            for(int i = 0; i < list.size; i++) {
                System.out.println("第" + i + "个数为" + list.get(i));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

package hongbao;

public class MyTest {
    public static void main(String[] args) {
        int redPackage = 100;
        int num = 3;
        int personNum = 4;
        MyRunnable myRunnable = new MyRunnable(redPackage, num);

        for (int i = 0; i < personNum; i++) {
            new Thread(myRunnable).start();
        }
    }
}

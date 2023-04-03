package hongbao;

/**
 * 抢红包的类
 */
public class MyRunnable implements Runnable {

    private int redPackage; //总额
    private int num; //个数
    private int size;  //大小
    private int lastSize; //最后一个红包

    public MyRunnable(int redPackage, int num) {
        this.redPackage = redPackage;
        this.num = num;
        this.size = redPackage / num;
        this.lastSize = redPackage - (num - 1) * size;
    }

    //抢红包逻辑
    @Override
    public void run() {
        synchronized (MyRunnable.class) {
            int currentSize;
            if (num != 1) {
                currentSize = size;
            } else {
                currentSize = lastSize;
            }
            if (num > 0) {
                //抢到红包了
                num--;
                System.out.println(Thread.currentThread().getName() + "---抢到了---" + currentSize);
            } else {
                //没想到
                System.out.println(Thread.currentThread().getName() + "---没抢到");
            }
        }
    }
}

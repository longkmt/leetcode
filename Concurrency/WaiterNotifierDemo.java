public class WaiterNotifierDemo {

    public static void main(String[] args){
        CommonLock lock = new CommonLock("Common lock");
        Waiter waiter = new Waiter(lock);
        Notifier notifier = new Notifier(lock);
        Thread waiterThread1 = new Thread(waiter,"Waiter thread 1");
        Thread waiterThread2 = new Thread(waiter,"Waiter thread 2");
        Thread notifierThread = new Thread(notifier, "Notifier Thread");

        waiterThread1.start();
        waiterThread2.start();

        notifierThread.start();

        System.out.println("All threads started");
    }
}

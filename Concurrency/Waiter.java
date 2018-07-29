public class Waiter implements Runnable {

    private CommonLock lock;

    public Waiter(CommonLock lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        synchronized (lock){
            try{
                System.out.println(name + " starts waiting at: " + System.currentTimeMillis());
                lock.wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            //get notified
            System.out.println(name + " get notified at: " + System.currentTimeMillis());
        }

    }
}

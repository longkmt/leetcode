public class Notifier implements Runnable {

    private CommonLock lock;

    public Notifier(CommonLock lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started at: " + System.currentTimeMillis());
        try{
            Thread.sleep(1000);
            synchronized (lock){
                System.out.println("Start notifying");
                //lock.notify();
                lock.notifyAll();
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class MyDeadLockThread extends MyThread {

    private Object o1;
    private Object o2;

    public MyDeadLockThread(Object o1, Object o2, String name){
        super(name);
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void processSomething() throws InterruptedException{

        System.out.println(this.getName() + " is acquiring lock on " + o1.toString());

        synchronized (o1){

            System.out.println(this.getName() + " acquired lock on " + o1.toString());
            System.out.println(this.getName() + " doing something that takes 10s to complete!");
            sleep(10000);

            System.out.println(this.getName() + " is acquiring lock on " + o2.toString());
            synchronized (o2){
                System.out.println(this.getName() + " acquired lock on " + o2.toString());
                System.out.println(this.getName() + " doing extra thing that takes another 10s to complete!");
                sleep(10000);
            }
            System.out.println(this.getName() + " released lock on " + o2.toString());
        }

        System.out.println(this.getName() + " released lock on " + o1.toString());
        System.out.println(this.getName() + " finished processing!");
    }

    @Override
    public void run(){
        //do trivial things for the demo
        System.out.println(this.getName() + " START ");
        try{
            processSomething();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println(this.getName() + " END ");
    }

    public static class MyDeadLockThreadDemo{

        public static void main(String[] args) throws InterruptedException{

            CommonLock l1 = new CommonLock("Lock 1");
            CommonLock l2 = new CommonLock("Lock 2");
            CommonLock l3 = new CommonLock("Lock 3");

            Thread t1 = new MyDeadLockThread(l1,l2,"Thread 1");
            Thread t2 = new MyDeadLockThread(l2,l3,"Thread 2");
            Thread t3 = new MyDeadLockThread(l3,l1,"Thread 3");

            t1.start();

            sleep(5000);

            t2.start();

            sleep(5000);

            t3.start();

        }

    }
}

import java.sql.SQLOutput;

public class MyThread extends Thread {

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run(){
        //do trivial things for the demo
        System.out.println(this.getName() + " START ");
        try{
            Thread.sleep(1000); //this is checked exception so we need to catch it (or throws it)
            processSomething();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println(this.getName() + " END ");
    }

    public void processSomething() throws InterruptedException{ //since the caller method run() already handle this checked exception, we can just propagate it to the caller
        //just sleep for more :)
        System.out.println(this.getName() + " sleeping for another 4s");
        sleep(4000);
    }

    public static class ConcurrenceDemo{ //example of static nested class

        public static void main(String[] args){
            System.out.println("Starting classic threads.");
            MyThread thread1 = new MyThread("Classic-Thread 1");
            MyThread thread2 = new MyThread("Classic-Thread 2");
            thread1.start(); // start() method will spawn a new thread and also invoke run() method for that thread
            thread2.start();
            System.out.println("Classic threads started");

            System.out.println("Starting runnable threads");
            Thread thread3 = new Thread(new MyRunnable(),"Runnable-Thread 3");
            Thread thread4 = new Thread(new MyRunnable(),"Runnable-Thread 4");
            thread3.start();
            thread4.start();
            System.out.println("Runnable threads started");

        }
    }
}

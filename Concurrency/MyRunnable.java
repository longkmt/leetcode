public class MyRunnable implements Runnable {
    @Override
    public void run() {
        //do trivial things for the demo, this is just a copy & paste from MyThread
        System.out.println(Thread.currentThread().getName() + " START ");
        try{
            Thread.sleep(1000); //this is checked exception so we need to catch it (or throws it)
            processSomething();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " END ");
    }

    public void processSomething() throws InterruptedException{ //since the caller method run() already handle this checked exception, we can just propagate it to the caller
        //just sleep for more :)
        System.out.println(Thread.currentThread().getName() + " sleeping for another 4s");
        Thread.sleep(4000);
    }
}

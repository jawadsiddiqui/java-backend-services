package com.problems;

public class RunnableImpl implements Runnable {
    Thread t;
    RunnableImpl(){
        t = new Thread(this, "Demo Thread");
        System.out.println("Child thread:"+t);
        t.start();
    }
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try{
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread:"+i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Child Intrupted"+e);
        }
        System.out.println("Exiting child thread");
    }
}

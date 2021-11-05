import java.util.Scanner;
 
public class ThreadsExample {
 
// main method of our program
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
 
 
        MyThread oddNumber = new MyThread(1);
        Thread t1 = new Thread(oddNumber);
        t1.start();
    
 
    }
 
}
 
 
class MyThread implements Runnable {
 
    private int timer;
    private int counter = 0;
//constructor
 
    MyThread(int timer) { //modify here
 
        
        this.timer = timer;
//code for constructor goes here
 
    }
 
    public void run() {
        
//the task of the thread goes in here
 
        for (;;) { //infinte loop
 
            try {
 
                Thread.sleep(this.timer*1000);
 
            } catch (InterruptedException e) {
 
                return;
 
            }
            //do something before it sleeps/stops for the time amount of seconds
            System.out.print(counter + " ");
            counter+=2;
 
        }
    }
 
}
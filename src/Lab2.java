public class Lab2 {
    
    public static void main(String[] args) {
    	
        Runnable joes = new SharingAResource("Eat at Joe's", 5, 3);
        Runnable bills = new SharingAResource("Eat at Bill's", 8, 6);
        Runnable gracie = new SharingAResource("Eat at Gracie's", 10, 9);
        
        Thread j = new Thread(joes);
        Thread b = new Thread(bills);
        Thread g = new Thread(gracie);
        
        j.start();
        b.start();
        g.start();
        
        System.out.println("Billboard started: ");
        

      try {
         j.join();
         b.join();
         g.join();
         
     } catch (InterruptedException e) {
         return;
     }
        System.out.println("Billboard closed");   
    }
}
 
 
class SharingAResource implements Runnable {
    
    private String message;
    private int counter;
    private int pause;
    
    //constructor
    public SharingAResource(String message, int counter, int pause){
        this.message = message;
        this.counter = counter;
        this.pause = pause * 1000; 
    }
    
    public void run() {
        
        for(int i=3; i<counter; i++) {
            try {
                Thread.sleep(this.pause);
            } catch(InterruptedException e) {
                return;
            }
            
            System.out.println(this.message);
        }
        
    }
}
 
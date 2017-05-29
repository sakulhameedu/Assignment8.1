package Session8;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {  //Parent Class

 
    public void run() {
        System.out.println("Timer task started at:"+new Date());
        completeTask();
        System.out.println("Timer task finished at:"+new Date());
    }

    private void completeTask() {
        try {
            //assuming it takes 20 secs to complete the task
            Thread.sleep(200);  //Thread sleeps in 200
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        TimerTask timerTask = new MyTimerTask();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
        System.out.println("TimerTask started"); /TO start timer 
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("TimerTask cancelled");  //Cancel timer
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

------------
Sample Output:
sh-4.3$ javac MyTimerTask.java                                                                                                                                                  
sh-4.3$ java MyTimerTask                                                                                                                                                        
TimerTask started                                                                                                                                                               
Timer task started at:Mon May 29 12:17:42 UTC 2017                                                                                                                              
Timer task finished at:Mon May 29 12:17:42 UTC 2017                                                                                                                             
Timer task started at:Mon May 29 12:17:43 UTC 2017                                                                                                                              
TimerTask cancelled                                                                                                                                                             
Timer task finished at:Mon May 29 12:17:43 UTC 2017   

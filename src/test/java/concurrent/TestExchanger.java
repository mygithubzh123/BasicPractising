package concurrent;

import java.util.concurrent.Exchanger;

public class TestExchanger {
	
		   Exchanger<StringBuffer> exchanger = new Exchanger<>();

		   class FillingLoop implements Runnable {
			   StringBuffer currentBuffer = new StringBuffer("abc");
			   String temp ;
			   public void run() {
		       try {
		    	   temp = currentBuffer.toString();
		    	   System.out.println("i am "+currentBuffer);
		    	   System.out.println(" FillingLoop start exchange");
		           currentBuffer = exchanger.exchange(currentBuffer);
		           System.out.println(" FillingLoop exchange over");
		       } catch (InterruptedException ex) {
		    	   
		       }finally {
		    	   System.out.println("now i become "+ currentBuffer+"from "+temp);
		       }
		     }
		   }

		   class EmptyingLoop implements Runnable {
			   StringBuffer currentBuffer = new StringBuffer("123");
			   String temp;
		     public void run() {
		       try {
		    	   Thread.sleep(10000);
		    	   temp = currentBuffer.toString();
		    	   System.out.println("i am "+currentBuffer);
		    	   System.out.println(" EmptyingLoop start exchange");
		           currentBuffer = exchanger.exchange(currentBuffer);
		           System.out.println(" EmptyingLoop exchange over");
		       } catch (InterruptedException ex) {
		    	   
		       }finally {
		    	   System.out.println("now i become "+ currentBuffer+"from "+temp);
		       }
		     }
		   }

		   void start() {
		     new Thread(new FillingLoop()).start();
		     new Thread(new EmptyingLoop()).start();
		   }
		   
		   public static void main(String[] args) {
			new TestExchanger().start();
		}
}

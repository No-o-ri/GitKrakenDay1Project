import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
public class countThread extends Thread{
	public static AtomicInteger count = new AtomicInteger(0);
	public static int goal = 1000000;
	public static int threadCount = goal/1000;
	public static void main(String[] args) throws InterruptedException{

		Thread [] listThreads = new Thread[threadCount];
		for(int i = 0; i<listThreads.length; i++){
			listThreads[i] = new countThread();
			listThreads[i].start();
		}
		for(Thread t: listThreads){
			t.join();
		}
		System.out.println("hi "+count.get());
	}
	public void run(){
		while(true){
			int n = count.get();
			if(n >goal) break;
			count.incrementAndGet();

		}
	}

}
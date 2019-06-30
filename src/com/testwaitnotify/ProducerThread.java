package com.testwaitnotify;
/*
 * 需要注意的是：在调用wait()方法时，需要把它放到一个同步段里，否则将会出现异常：
 * “java.lagn.IllegalMonitorStateException:current thread not owner.
 */
class ProducerThread extends Thread {
	long sum = 0;
	
	ProducerThread() {
		start();
	}
	
	public void run() {
		synchronized(this) {
			for(int i = 0; i < 1000; i++)
				sum += i;
			System.out.println("生产者产生完毕数据：sum=" + sum); //生产者线程产生数据完成后发出通知
			notify();	//发出通知信息
		}
	}
	
	/*
	 * 成员方法的返回值类型为Java语言的任何数据类型。
	 * 如果一个成员方法没有返回值，则其返回值得类型被说明为void。
	 * 如果有返回值，则return语句要带参数，且return语句中返回的数据类型必须与方法说明中的方法返回值类型一致。
	 */
	/*
	 * 需要注意的是：在调用wait()方法时，需要把它放到一个同步段里，否则将会出现异常：
	 * “java.lagn.IllegalMonitorStateException:current thread not owner.
	 */
	synchronized public long getSum() {
		try {
			wait(); //等待过程中不断测试，等待信号
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		return sum;
	}
}

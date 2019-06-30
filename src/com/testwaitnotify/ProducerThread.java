package com.testwaitnotify;
/*
 * ��Ҫע����ǣ��ڵ���wait()����ʱ����Ҫ�����ŵ�һ��ͬ��������򽫻�����쳣��
 * ��java.lagn.IllegalMonitorStateException:current thread not owner.
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
			System.out.println("�����߲���������ݣ�sum=" + sum); //�������̲߳���������ɺ󷢳�֪ͨ
			notify();	//����֪ͨ��Ϣ
		}
	}
	
	/*
	 * ��Ա�����ķ���ֵ����ΪJava���Ե��κ��������͡�
	 * ���һ����Ա����û�з���ֵ�����䷵��ֵ�����ͱ�˵��Ϊvoid��
	 * ����з���ֵ����return���Ҫ����������return����з��ص��������ͱ����뷽��˵���еķ�������ֵ����һ�¡�
	 */
	/*
	 * ��Ҫע����ǣ��ڵ���wait()����ʱ����Ҫ�����ŵ�һ��ͬ��������򽫻�����쳣��
	 * ��java.lagn.IllegalMonitorStateException:current thread not owner.
	 */
	synchronized public long getSum() {
		try {
			wait(); //�ȴ������в��ϲ��ԣ��ȴ��ź�
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		return sum;
	}
}

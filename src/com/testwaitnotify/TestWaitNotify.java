package com.testwaitnotify;

public class TestWaitNotify {

	public static void main(String[] args) {
		ProducerThread pt = new ProducerThread();
		System.out.println("�������Ϊ��sum=" + pt.getSum());

	}

}

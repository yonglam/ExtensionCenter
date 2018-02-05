package org.yonglam.extcenter;

public class Demo implements IDemoExt {
	public static void main(String[] args) {

		Demo d = new Demo();

		Demo2 d2 = new Demo2();

		Demo3 d3 = new Demo3();
		d3.send();

	}

	public Demo() {
		ExtensionCenter.shareInstance().register(IDemoExt.class, this);
	}

	public void finalize() {
		ExtensionCenter.shareInstance().unregister(IDemoExt.class, this);
	}

	public void fooo(int x) {
		System.out.println("Demo fooo: " + x);
	}

	public void fooo2(String s) {
		System.out.println("Demo fooo2: " + s);

	}

}
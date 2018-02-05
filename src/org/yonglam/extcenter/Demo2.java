package org.yonglam.extcenter;

public class Demo2 implements IDemoExt {
	public Demo2() {
		ExtensionCenter.shareInstance().register(IDemoExt.class, this);
	}
	
	public void fooo(int x) {
		System.out.println("Demo2 fooo: " + x);
	}
	
	public void fooo2(String s) {
		System.out.println("Demo2 fooo2: " + s);
		
	}
	public void finalize() {
		ExtensionCenter.shareInstance().unregister(IDemoExt.class, this);
	}
}
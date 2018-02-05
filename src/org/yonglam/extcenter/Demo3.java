package org.yonglam.extcenter;

public class Demo3 {
	public void send() {
		ExtensionCenter ec = ExtensionCenter.shareInstance();
		System.out.println("===== call fooo =====");
		ec.call(IDemoExt.class).fooo(100);
		
		System.out.println("===== call fooo2 =====");
		ec.call(IDemoExt.class).fooo2("hello");
	}
}

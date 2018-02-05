package org.yonglam.extcenter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

abstract interface IExt {

}

public class ExtensionCenter {
	private static ExtensionCenter gInstance;
	private ExtensionCenter() {
		
	}
	public static ExtensionCenter shareInstance() {
		if (null == gInstance) {
			gInstance = new ExtensionCenter(); 
		}
		return gInstance;
	}
	
	class Handler <T> implements InvocationHandler {
		private final IExt original;
		private final Class<T> cls;

		public Handler(IExt original, Class<T> cls) {
			this.original = original;
			this.cls = cls;
		}

		public Object invoke(Object proxy, Method method, Object[] args)
				throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			System.out.println("BEFORE");
			System.out.println(String.format("CALL METHORD: %s", method.toString()));
			List l = mMap.get(this.cls);
			for (Object o : l) {
				Object r = method.invoke(o, args);
			}
			System.out.println("AFTER");
			return null;
		}
	}

	private HashMap<Class, List> mMap = new HashMap<Class, List>();

	public <T extends IExt> void register(Class<T> c, Object o) {
		if (!mMap.containsKey(c)) {
			mMap.put(c, new LinkedList());
		}
		List l = mMap.get(c);
		if (l.contains(o)) {
			return;
		}
		l.add(o);
	}

	public <T extends IExt> void unregister(Class<T> c, Object o) {
		if (!mMap.containsKey(c)) {
			return;
		}
		List l = mMap.get(c);
		l.remove(o);
	}

	public <T extends IExt> T call(Class<T> c) {
		IExt e = new IExt() {
		};

		Handler handler = new Handler<T>(e, c);
		T f = (T) Proxy.newProxyInstance(c.getClassLoader(), new Class[] { c }, handler);
		return f;

	}

}

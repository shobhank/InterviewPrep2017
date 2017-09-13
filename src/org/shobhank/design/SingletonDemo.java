package org.shobhank.design;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonDemo {

	public static void main(String[] args) {
//		for(int i=0;i<=10;i++){
//			new Thread(new SingletonCreator()).start();
//		}
		Constructor<Singleton> constructor = (Constructor<Singleton>) Singleton.class.getDeclaredConstructors()[0];
		constructor.setAccessible(true);
		Singleton singleton;
		try {
			singleton = constructor.newInstance(new Object[0]);
			System.out.println(singleton);
			singleton = constructor.newInstance(new Object[0]);
			System.out.println(singleton);
			singleton = constructor.newInstance(new Object[0]);
			System.out.println(singleton);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}

class SingletonCreator implements Runnable{

	@Override
	public void run() {
		try {
			System.out.println(Singleton.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

class Singleton{
	private static volatile Singleton s;
	private Singleton() throws Exception {
		if(Singleton.s!=null)
			throw new Exception();
		else
			s = this;
	}
	
	public static Singleton getInstance() throws Exception {
	    if(s==null){
		synchronized(Singleton.class){
			if (s==null)
				s = new Singleton();
		}
	    }
	    return s;	
	}
}
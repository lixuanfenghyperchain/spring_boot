package com.hyperchain.javase.reflact;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class ReflectDemo02 {
	//获取对象的实例，并操作对象
	public static void demo01() throws InstantiationException, IllegalAccessException {
			Class<?> perClazz =  null ; 
			try {
				perClazz =  Class.forName("com.hyperchain.javase.reflact.Person") ;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Person per = (Person)perClazz.newInstance() ;
			per.setName("zs");
			per.setAge(23);
			System.out.println(  per.getName()+","+per.getAge());
	}
	
	//操作属性
	public static void demo02() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		Class<?> perClazz =  null ; 
		try {
			perClazz =  Class.forName("com.hyperchain.javase.reflact.Person") ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Person per = (Person)perClazz.newInstance() ;
		Field idField = perClazz.getDeclaredField(  "id");
		//访问的是private修饰的id，但是private是私有
		//修改属性的访问权限  使用反射时，如果 因为访问修饰符限制造成异常，可以通过  Field/Method/Constructor.setAccessible(true)
		idField.setAccessible(true);
		idField.set(per, 1);   //per.setId(1);
		System.out.println( per.getId() );
		
		System.out.println("=====");
		Method method = perClazz.getDeclaredMethod("privateMethod", null) ;
		method.setAccessible(true);
		method.invoke(per,null )  ;//方法的调用：invoke()
		//per.say(xxx);
		
		Method method2 = perClazz.getDeclaredMethod("privateMethod2", String.class) ;
		method2.setAccessible(true);
		method2.invoke(per, "zs") ;
		
	}

	//操作构造方法
	public static void demo03() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		Class<?> perClazz =  null ; 
		try {
			perClazz =  Class.forName("com.hyperchain.javase.reflact.Person") ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
//		Constructor<?>[] constructors = perClazz.getConstructors() ;//公共
//		for(Constructor constructor:constructors) {
//			System.out.println(constructor);
//		}
		
//		Constructor<?>[] constructors = perClazz.getDeclaredConstructors() ;//本类
//		for(Constructor constructor:constructors) {
//			System.out.println(constructor);
//		}
		
		//获取指定的构造方法  
		//在反射中，根据类型 获取方法时：基本类型（int、char...）和包装类(Integer,Character)是不同的类型
		Constructor<?> constructor = perClazz.getConstructor(Integer.class) ;
		System.out.println(constructor);
		
		Constructor<?> constructor2 = perClazz.getDeclaredConstructor(String.class) ;
		System.out.println(constructor2);
		//Person per = new Person() ;
		
		
		//根据获取的private构造方法，获取对象实例
		constructor2.setAccessible(true);
		Person per3 = (Person)constructor2.newInstance("zs") ;
		System.out.println("per3"+per3);
		
		Person instance2 = (Person)constructor.newInstance(23) ;//因为constructor是 有参构造方法(Integer)，因此需要传入一个Integer值
		System.out.println(instance2);
		
		Constructor<?> constructor3 = perClazz.getConstructor() ;
		Person instance = (Person)constructor3.newInstance( ) ;//因为constructor3是 无参构造方法，因此不需要传值
		
		System.out.println(instance);
	}
	
	//动态加载 类名 和方法
	public static void demo04() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		prop.load(   new FileReader("class.txt") );
		
		String classname = prop.getProperty("classname") ;
		String methodname = prop.getProperty("methodname") ;
		
		Class<?> perClazz =  null ; 
		try {
			perClazz =  Class.forName(classname) ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Method method = perClazz.getMethod(methodname) ;
		method.invoke( perClazz.newInstance()  ) ;
		
	}
	
	//反射可以 越过泛型检查 
	//虽然可以通过反射 访问private等访问修饰符不允许访问的属性/方法，也可以忽略掉泛型的约束；但实际开发 不建议这样使用，因此可能造成程序的混乱。
	public static void demo05() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		ArrayList<Integer> list = new ArrayList<>() ;
		list.add(123) ;
		list.add(3) ;
		list.add(2) ;
//		list.add("zs") ; 
		
		Class<?> listClazz = list.getClass() ;
		Method method = listClazz.getMethod("add", Object.class) ;
		method.invoke(list , "zs...") ;
		System.out.println(list);
	}
	
	public static void demo06() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Person per = new Person();
		PropertyUtil.setProperty(per, "name", "zs");
		PropertyUtil.setProperty(per, "age", 23);
		Student stu  = new Student() ;
		PropertyUtil.setProperty(stu, "score", 98);
		
		System.out.println(per.getName()+","+per.getAge());
		System.out.println(stu.getScore());
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException {
//		demo01() ;
//		demo02() ;
//		demo03() ;
//		demo04() ;
//		demo05() ;
		demo06() ;
	}
}
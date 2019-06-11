package com.hyperchain.javase.reflact;

public class Person  implements MyInterface,MyInterface2{
	private int id;
	private String name ;
	private int age ; 
	
	public String desc ;
	
	private Person(String name) {
		this.name = name;
	}
	
	public Person() {
	}
	public Person(Integer id) {
		this.id = id;
	}
	
	public Person(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	private void privateMethod() {
		System.out.println(" private method...");
	}
	
	private void privateMethod2(String name) {
		System.out.println(" private method2..."+name);
	}


	public void setAge(int age) {
		this.age = age;
	}
	public static void staticMethod() {
		System.out.println("static  method ...");
	}
	
	@Override
	public void interfaceMethod() {
		System.out.println("interface  Method....");
	}
	@Override
	public void interface2Method() {
		System.out.println("interface2  Method....");
		
	}

}

package com.thamil.grocery.datamodel;

import java.util.LinkedList;

public class Register<E> extends LinkedList<E> implements Comparable<Register<E>>{
	private static final long serialVersionUID = 1L;
	private String name;
	
	public Register(String name){
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(Register<E> register) {
		return this.name.compareTo(register.getName());
	}
	
}

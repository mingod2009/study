package com.nie.proxy;

public class Main {

	public static void main(String[] args) {
		IUserDao u = new UserDao();
		IUserDao p = new UserDaoProxy(u);
		
		p.save();
	}
}

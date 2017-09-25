package com.nie.proxy;

public class UserDaoProxy implements IUserDao {

	private IUserDao userDao;
	public UserDaoProxy(IUserDao target){
		userDao = target;
	}
	@Override
	public void save() {
		userDao.save();
		System.out.println("proxy");
	}

}

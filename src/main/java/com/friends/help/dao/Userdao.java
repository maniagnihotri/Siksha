package com.friends.help.dao;

import java.util.List;

import com.friends.help.forms.User;

public interface Userdao {
	public void saveUser(User user) ;
	public List<User> listUser() ;
	public User getUser(String username);
}

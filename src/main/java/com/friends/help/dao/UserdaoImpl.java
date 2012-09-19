package com.friends.help.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import org.hibernate.SessionFactory;

import com.friends.help.forms.User;
import com.friends.help.util.CustomHibernateDaoSupport;

public class UserdaoImpl extends CustomHibernateDaoSupport implements Userdao{

	/*private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory)
	{
	//this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	
	this.sessionFactory = sessionFactory;
	}*/
	 
	@Override
	public void saveUser(User user) {
		System.out.println("Hi in the userdaoimpl");
		getHibernateTemplate().save(user);
		
	}
	/*@Override
	public List<User> listUser() {
		sessionFactory.getCurrentSession().createQuery("from users userId");
		return null;
	}*/

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		
		 List user = new ArrayList();
		 //User u = new  User();
		 //u.setFirstname(username);
		 user = getHibernateTemplate().find("from User where username=?",username);
		//getHibernateTemplate().findByNamedQuery("from user where username=?",u.getFirstname());
		//System.out.println(u.getEmail());
		 return (User)user.get(0);
	}
	
}

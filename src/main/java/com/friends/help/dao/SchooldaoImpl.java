package com.friends.help.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.friends.help.forms.School;
import com.friends.help.forms.SchoolCategory;
import com.friends.help.forms.VillageType;
import com.friends.help.util.CustomHibernateDaoSupport;

public class SchooldaoImpl extends CustomHibernateDaoSupport implements Schooldao {

	@Override
	public void addSchool(School C) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			//if (this.getBlock(B.getBlock_name(),D).isEmpty()) {
				transaction = session.beginTransaction();
				session.save(C);
				transaction.commit();
			//}
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void updateSchool(School C) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			//if (this.getBlock(B.getBlock_name(),D).isEmpty()) {
				transaction = session.beginTransaction();
				session.update(C);
				transaction.commit();
			//}
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void deletSchool(School C) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			//if (this.getBlock(B.getBlock_name(),D).isEmpty()) {
				transaction = session.beginTransaction();
				session.delete(C);
				transaction.commit();
			//}
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public Set<School> getSchoolList(int villageid) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		Set<School> school; 
		school=null;
		try {
			
				transaction = session.beginTransaction();
				//session.save(B);
				Criteria criteria = session.createCriteria(School.class);
				criteria.add(Restrictions.eq("village_id",villageid));
				//criteria.add(Restrictions.eq("type_id", villagetypeid));
				school =new HashSet<School>(criteria.list());
				transaction.commit();
			 return school;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return school;
		} finally {
			session.close();
		}
	}

	@Override
	public School getSchoolObject(String name, int villageid) {
		// TODO Auto-generated method stub
		School school = new School();
		school = null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(School.class);
				criteria.add(Restrictions.eq("village_id",villageid));
				criteria.add(Restrictions.eq("name", name));
				//criteria.add(Restrictions.eq("cluster_name", clustname));
				school=(School)criteria.uniqueResult();
				transaction.commit();
				return school;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return school;
		} finally {
			session.close();
		}
	}

	@Override
	public School getSchoolObjectbyID(int schoolid) {
		// TODO Auto-generated method stub
		School school = new School();
		school = null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(School.class);
				criteria.add(Restrictions.eq("id",schoolid));
				//criteria.add(Restrictions.eq("cluster_name", clustname));
				school=(School)criteria.uniqueResult();
				transaction.commit();
				return school;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return school;
		} finally {
			session.close();
		}
	}

	@Override
	public SchoolCategory getSchoolCategoryById(int categoryid) {
		// TODO Auto-generated method stub
		SchoolCategory schoolcategory = new SchoolCategory();
		schoolcategory = null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(SchoolCategory.class);
				criteria.add(Restrictions.eq("id",categoryid));
				//criteria.add(Restrictions.eq("cluster_name", clustname));
				schoolcategory=(SchoolCategory)criteria.uniqueResult();
				transaction.commit();
				return schoolcategory;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return schoolcategory;
		} finally {
			session.close();
		}
	}
	
	
}

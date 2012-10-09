package com.friends.help.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.friends.help.forms.Village;
import com.friends.help.util.CustomHibernateDaoSupport;

public class VillagedaoImpl extends CustomHibernateDaoSupport implements Villagedao {

	@Override
	public void addVillage(Village C) {
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
	public void updateVillage(Village C) {
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
	public void deletVillage(Village C) {
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
	public Village getVillageObject(String villagename, int Villagetypenamesid) {
		// TODO Auto-generated method stub
		Village village = new Village();
		village = null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(Village.class);
				criteria.add(Restrictions.eq("villagetypenames_id",Villagetypenamesid));
				criteria.add(Restrictions.eq("name", villagename));
				//criteria.add(Restrictions.eq("cluster_name", clustname));
				village=(Village)criteria.uniqueResult();
				transaction.commit();
				return village;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return village;
		} finally {
			session.close();
		}
	}

	@Override
	public Set<Village> getVillageList(int villagetypenamesid) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		Set<Village> village; 
		village=null;
		try {
			
				transaction = session.beginTransaction();
				//session.save(B);
				Criteria criteria = session.createCriteria(Village.class);
				criteria.add(Restrictions.eq("villagetypenames_id",villagetypenamesid));
				//criteria.add(Restrictions.eq("type_id", villagetypeid));
				village =new HashSet<Village>(criteria.list());
				transaction.commit();
			 return village;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return village;
		} finally {
			session.close();
		}
	}

	@Override
	public Village getVillageObjectbyID(int villageid) {
		// TODO Auto-generated method stub
		Village village = new Village();
		village = null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(Village.class);
				criteria.add(Restrictions.eq("id",villageid));
				//criteria.add(Restrictions.eq("cluster_name", clustname));
				village=(Village)criteria.uniqueResult();
				transaction.commit();
				return village;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return village;
		} finally {
			session.close();
		}
	}

}

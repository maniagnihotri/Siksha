package com.friends.help.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.friends.help.forms.Clusters;
import com.friends.help.forms.VillageType;
import com.friends.help.forms.VillageTypeNames;
import com.friends.help.util.CustomHibernateDaoSupport;

public class VillageTypeNamesdaoImpl extends CustomHibernateDaoSupport implements VillageTypeNamesdao {

	@Override
	public void addVillageTypeNames(VillageTypeNames C) {
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
	public void updateVillageTypeNames(VillageTypeNames C) {
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
	public void deletVillageTypeNames(VillageTypeNames C) {
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
	public Set<VillageTypeNames> getVillageTypeNamesList(int clusterid,int villagetypeid) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		Set<VillageTypeNames> villagetypenames; 
		villagetypenames=null;
		try {
			
				transaction = session.beginTransaction();
				//session.save(B);
				Criteria criteria = session.createCriteria(VillageTypeNames.class);
				criteria.add(Restrictions.eq("cluster_id", clusterid));
				criteria.add(Restrictions.eq("type_id", villagetypeid));
				villagetypenames =new HashSet<VillageTypeNames>(criteria.list());
				transaction.commit();
			 return villagetypenames;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return villagetypenames;
		} finally {
			session.close();
		}
	}

	@Override
	public VillageTypeNames getVillageTypeNamesObjectbyID(int villagetypenamesid) {
		// TODO Auto-generated method stub
		VillageTypeNames villageTypeNames = new VillageTypeNames();
		villageTypeNames = null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(VillageTypeNames.class);
				criteria.add(Restrictions.eq("id",villagetypenamesid));
				//criteria.add(Restrictions.eq("cluster_name", clustname));
				villageTypeNames=(VillageTypeNames)criteria.uniqueResult();
				transaction.commit();
				return villageTypeNames;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return villageTypeNames;
		} finally {
			session.close();
		}
	}

	@Override
	public VillageTypeNames getVillageTypeNamesObject(String name, int clusterid) {
		// TODO Auto-generated method stub
		VillageTypeNames villageTypeNames = new VillageTypeNames();
		villageTypeNames = null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(VillageTypeNames.class);
				criteria.add(Restrictions.eq("cluster_id",clusterid));
				criteria.add(Restrictions.eq("name", name));
				//criteria.add(Restrictions.eq("cluster_name", clustname));
				villageTypeNames=(VillageTypeNames)criteria.uniqueResult();
				transaction.commit();
				return villageTypeNames;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return villageTypeNames;
		} finally {
			session.close();
		}
	}

	@Override
	public Set<VillageType> getVillageType() {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		Set<VillageType> villagetype; 
		villagetype=null;
		try {
			
				transaction = session.beginTransaction();
				//session.save(B);
				Query queryresult = session.createQuery("from VillageType");
				//districtlist=queryresult.list();
				villagetype =new HashSet<VillageType>(queryresult.list());
				transaction.commit();
			 return villagetype;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return villagetype;
		} finally {
			session.close();
		}
	}

	@Override
	public VillageType getVillageTypeById(int id) {
		// TODO Auto-generated method stub
		VillageType villageType = new VillageType();
		villageType = null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(VillageType.class);
				criteria.add(Restrictions.eq("id",id));
				//criteria.add(Restrictions.eq("cluster_name", clustname));
				villageType=(VillageType)criteria.uniqueResult();
				transaction.commit();
				return villageType;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return villageType;
		} finally {
			session.close();
		}
	}
}


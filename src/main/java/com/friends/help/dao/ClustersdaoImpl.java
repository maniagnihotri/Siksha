package com.friends.help.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.friends.help.forms.Clusters;
import com.friends.help.util.CustomHibernateDaoSupport;

public class ClustersdaoImpl extends CustomHibernateDaoSupport implements Clustersdao {

	@Override
	public void addCluster(Clusters C) {
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
	public void updateCluster(Clusters C) {
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
	public void deletClusterobject(Clusters C) {
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
	public Clusters getClustersObject(String clustname,int blockid) {
		// TODO Auto-generated method stub
		Clusters clusters = new Clusters();
		clusters = null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(Clusters.class);
				criteria.add(Restrictions.eq("block_id",blockid));
				criteria.add(Restrictions.eq("cluster_name", clustname));
				clusters=(Clusters)criteria.uniqueResult();
				transaction.commit();
				return clusters;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return clusters;
		} finally {
			session.close();
		}
	}

	@Override
	public Set<Clusters> getClustersList(int blockid) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		Set<Clusters> clusters; 
		clusters=null;
		try {
			
				transaction = session.beginTransaction();
				//session.save(B);
				Criteria criteria = session.createCriteria(Clusters.class);
				criteria.add(Restrictions.eq("block_id", blockid));
				clusters =new HashSet<Clusters>(criteria.list());
				transaction.commit();
			 return clusters;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return clusters;
		} finally {
			session.close();
		}
		
	}

	@Override
	public Clusters getClustersObjectbyID(int clusterid) {
		// TODO Auto-generated method stub
		Clusters clusters = new Clusters();
		clusters = null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(Clusters.class);
				criteria.add(Restrictions.eq("cluster_id",clusterid));
				//criteria.add(Restrictions.eq("cluster_name", clustname));
				clusters=(Clusters)criteria.uniqueResult();
				transaction.commit();
				return clusters;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return clusters;
		} finally {
			session.close();
		}
	}

}

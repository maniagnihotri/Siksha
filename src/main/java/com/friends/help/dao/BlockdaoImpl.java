package com.friends.help.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.friends.help.forms.Block;
import com.friends.help.util.CustomHibernateDaoSupport;

public class BlockdaoImpl extends CustomHibernateDaoSupport implements Blockdao {

	@Override
	public void addBlock(Block B) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			//if (this.getBlock(B.getBlock_name(),D).isEmpty()) {
				transaction = session.beginTransaction();
				session.save(B);
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
	public void updateBlock(Block B) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				session.update(B);
				transaction.commit();
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}

	@Override
	public void deletBlockobject(Block B) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				session.delete(B);
				transaction.commit();
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}
	
	@Override
	public Set<Block> getBlocks(int districtid) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		Set<Block> block;
		block=null;
		
		
		try {
			
				transaction = session.beginTransaction();
				//session.save(B);
				Criteria criteria = session.createCriteria(Block.class);
				criteria.add(Restrictions.eq("district_id", districtid));
				block = new HashSet<Block>(criteria.list());
				transaction.commit();
			 return block;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return block;
		} finally {
			session.close();
		}
		
	}

	/*@Override
	public boolean deleteBlocks(String districtname) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			
				transaction = session.beginTransaction();
				//session.save(B);
				Criteria criteria = session.createCriteria(Block.class);
				criteria.add(Restrictions.eq("districtname", districtname));
				getHibernateTemplate().deleteAll(criteria.list());
				transaction.commit();
			 return true;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		//return false;
	}*/

	@Override
	public Block getBlockobject(int district, String blockname) {
		// TODO Auto-generated method stub
		Block block = new Block();
		block = null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				//districtlist = getHibernateTemplate().find("from District where District_Name=?", DistrictName);
				Criteria criteria = session.createCriteria(Block.class);
				criteria.add(Restrictions.eq("district_id", district));
				criteria.add(Restrictions.eq("block_name",blockname));
				block=(Block)criteria.uniqueResult();
				transaction.commit();
				return block;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return block;
		} finally {
			session.close();
		}
	}



	@Override
	public List<String> getBlocknames(int district) {
		// TODO Auto-generated method stub
		List<String> blocklist = new ArrayList<String>();
		blocklist= null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				//districtlist = getHibernateTemplate().find("from District where District_Name=?", DistrictName);
				Criteria criteria = session.createCriteria(Block.class);
				criteria.add(Restrictions.eq("district_id", district));
				criteria.setProjection(Projections.property("block_name"));
				blocklist=criteria.list();
				transaction.commit();
				return blocklist;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return blocklist;
		} finally {
			session.close();
		}
	}

	@Override
	public Block getBlockobjectbyID(int blockid) {
		// TODO Auto-generated method stub
		Block block = new Block();
		block = null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				//districtlist = getHibernateTemplate().find("from District where District_Name=?", DistrictName);
				Criteria criteria = session.createCriteria(Block.class);
				criteria.add(Restrictions.eq("block_id", blockid));
				block=(Block)criteria.uniqueResult();
				transaction.commit();
				return block;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return block;
		} finally {
			session.close();
		}
	}

}

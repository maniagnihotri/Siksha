package com.friends.help.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.friends.help.forms.CasteType;
import com.friends.help.forms.ChildDetails;
import com.friends.help.forms.Disability;
import com.friends.help.forms.School;
import com.friends.help.util.CustomHibernateDaoSupport;

public class ChildDetailsdaoImpl extends CustomHibernateDaoSupport implements ChildDetailsdao {

	@Override
	public void saveChild(ChildDetails cd) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			//if (this.getBlock(B.getBlock_name(),D).isEmpty()) {
				transaction = session.beginTransaction();
				session.save(cd);
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
	public void updateChild(ChildDetails cd) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			//if (this.getBlock(B.getBlock_name(),D).isEmpty()) {
				transaction = session.beginTransaction();
				session.update(cd);
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
	public void deleteChild(ChildDetails cd) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			//if (this.getBlock(B.getBlock_name(),D).isEmpty()) {
				transaction = session.beginTransaction();
				session.delete(cd);
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
	public CasteType getCastteype(int castid) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		CasteType castetype = new CasteType();
		castetype = null;
		try {
			//if (this.getBlock(B.getBlock_name(),D).isEmpty()) {
				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(CasteType.class);
				criteria.add(Restrictions.eq("ID",castid));
				castetype = (CasteType)criteria.uniqueResult();
				transaction.commit();
				return castetype;
			//}
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return castetype;
		} finally {
			session.close();
		}
		
	}

	@Override
	public Disability getDisability(int disabilityid) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		Disability disability = new Disability();
		disability = null;
		try {
			//if (this.getBlock(B.getBlock_name(),D).isEmpty()) {
				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(Disability.class);
				criteria.add(Restrictions.eq("ID",disabilityid));
				disability = (Disability)criteria.uniqueResult();
				transaction.commit();
				return disability;
			//}
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return disability;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Disability> getDisabilityList() {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		List<Disability> disabilityList = new ArrayList<Disability>();
		disabilityList = null;
		try {
			//if (this.getBlock(B.getBlock_name(),D).isEmpty()) {
				transaction = session.beginTransaction();
				Query queryresult = session.createQuery("from Disability");
				disabilityList=queryresult.list();
				transaction.commit();
				return disabilityList;
			//}
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return disabilityList;
		} finally {
			session.close();
		}
	}	

}

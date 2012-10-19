package com.friends.help.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.friends.help.forms.ChildClass;
import com.friends.help.forms.EducationalDetails;
import com.friends.help.forms.Irregularity;
import com.friends.help.util.CustomHibernateDaoSupport;

public class EducationDetailsDaoImpl extends CustomHibernateDaoSupport implements EducationDetailsDao {

	@Override
	public void saveEducation(EducationalDetails cd) {
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
	public void updateEducation(EducationalDetails cd) {
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
	public void deleteEducation(EducationalDetails cd) {
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
	public Irregularity getRegularityObject(int irregularityid) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		Irregularity irregularity = new Irregularity();
		irregularity = null;
		try {
			//if (this.getBlock(B.getBlock_name(),D).isEmpty()) {
				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(Irregularity.class);
				criteria.add(Restrictions.eq("id",irregularityid));
				irregularity = (Irregularity)criteria.uniqueResult();
				transaction.commit();
				return irregularity;
			//}
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return irregularity;
		} finally {
			session.close();
		}
	}

	@Override
	public ChildClass getClassObject(int classid) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		ChildClass childclass = new ChildClass();
		childclass = null;
		try {
			//if (this.getBlock(B.getBlock_name(),D).isEmpty()) {
				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(ChildClass.class);
				criteria.add(Restrictions.eq("id",classid));
				childclass = (ChildClass)criteria.uniqueResult();
				transaction.commit();
				return childclass;
			//}
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return childclass;
		} finally {
			session.close();
		}
	}

	@Override
	public int getNumberOfRows() {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
	//	List<Disability> disabilityList = new ArrayList<Disability>();
		//disabilityList = null;
		try {
			//if (this.getBlock(B.getBlock_name(),D).isEmpty()) {
				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(EducationalDetails.class);
				criteria.setProjection(Projections.rowCount());
				Long i = (Long) criteria.uniqueResult();
				transaction.commit();
				return i.intValue();
			//}
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return 0;
		} finally {
			session.close();
		}
	}

}

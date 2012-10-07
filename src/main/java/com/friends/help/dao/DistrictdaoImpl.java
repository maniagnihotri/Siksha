package com.friends.help.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.friends.help.forms.District;
import com.friends.help.util.CustomHibernateDaoSupport;

public class DistrictdaoImpl extends CustomHibernateDaoSupport implements
		Districtdao {

	@Override
	public void addDistrict(District D) {
		// TODO Auto-generated method stub
		System.out.println("Inside addDistrict Method");
		// getHibernateTemplate().save(D);
		// getHibernateTemplate().clear();

		Session session = getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			//if (this.getDistrict(D.getDistrict_name())==null) {
				transaction = session.beginTransaction();
				// City city = new City();
				// city.setName(cityName);
				// cityId = (Long) session.save(city);
				session.save(D);
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
	public void updateDistrict(District D) {
		// TODO Auto-generated method stub
		//getHibernateTemplate().update(D);
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				session.update(D);
				transaction.commit();
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}

	@Override
	public District getDistrict(String DistrictName) {
		
		//List districtlist = new ArrayList();
		//districtlist= null;
		District district = new District();
		district = null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				//districtlist = getHibernateTemplate().find("from District where District_Name=?", DistrictName);
				Criteria criteria = session.createCriteria(District.class);
				criteria.add(Restrictions.eq("district_name", DistrictName));
				district=(District)criteria.uniqueResult();
				transaction.commit();
				return district;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return district;
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<String> getDistrictnames() {
		// TODO Auto-generated method stub
		List<String> districtlist = new ArrayList<String>();
		districtlist= null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				//districtlist = getHibernateTemplate().find("from District where District_Name=?", DistrictName);
				Criteria criteria = session.createCriteria(District.class);
				criteria.setProjection(Projections.property("district_name"));
				districtlist=criteria.list();
				transaction.commit();
				return districtlist;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return districtlist;
		} finally {
			session.close();
		}
	}

	@Override
	public List<District> getAllDistricts() {
		// TODO Auto-generated method stub
		List<District> districtlist = new ArrayList<District>();
		districtlist= null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				//districtlist = getHibernateTemplate().find("from District where District_Name=?", DistrictName);
				//Criteria criteria = session.createCriteria(District.class);
				Query queryresult = session.createQuery("from District");
				districtlist=queryresult.list();
				transaction.commit();
				return districtlist;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return districtlist;
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteDistrict(District D) {
		// TODO Auto-generated method stub
			Session session = getSessionFactory().openSession();
			Transaction transaction = null;
			try {

					transaction = session.beginTransaction();
					session.delete(D);
					transaction.commit();
					
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
				
			} finally {
				session.close();
			}
		
	}

	@Override
	public District getDistrictbyID(int districtid) {
		// TODO Auto-generated method stub
		District district = new District();  
		district= null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {

				transaction = session.beginTransaction();
				//districtlist = getHibernateTemplate().find("from District where District_Name=?", DistrictName);
				Criteria criteria = session.createCriteria(District.class);
				criteria.add(Restrictions.eq("ID", districtid));
				//criteria.setProjection(Projections.property("ID"));
				district=(District)criteria.uniqueResult();
				transaction.commit();
				return district;
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return district;
		} finally {
			session.close();
		}
	}
	
	
	
}

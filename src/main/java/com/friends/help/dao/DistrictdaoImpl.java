package com.friends.help.dao;

import com.friends.help.forms.District;
import com.friends.help.util.CustomHibernateDaoSupport;

public class DistrictdaoImpl extends CustomHibernateDaoSupport implements Districtdao {

	@Override
	public void addDistrict(District D) {
		// TODO Auto-generated method stub
		System.out.println("Inside addDistrict Method");
		getHibernateTemplate().save(D);
	}

	@Override
	public void updateDistrict(District D) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(D);
	}

}

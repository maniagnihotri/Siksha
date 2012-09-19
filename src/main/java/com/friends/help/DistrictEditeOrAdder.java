package com.friends.help;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.friends.help.dao.Districtdao;
import com.friends.help.forms.District;

@Controller
public class DistrictEditeOrAdder {

	@Autowired
	public Districtdao districtdao;
	
	@RequestMapping(value="/distadder.html",method=RequestMethod.POST)
	public ModelAndView adddistrict(@ModelAttribute("district") District district, BindingResult result, ModelMap model ,Locale locale)
	{
		
	 districtdao.addDistrict(district);
	return new ModelAndView("home_redirect",model);
	}

	public Districtdao getDistrictdao() {
		return districtdao;
	}

	public void setDistrictdao(Districtdao districtdao) {
		this.districtdao = districtdao;
	}
}
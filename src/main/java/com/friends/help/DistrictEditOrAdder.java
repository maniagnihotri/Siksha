package com.friends.help;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
public class DistrictEditOrAdder {

	@Autowired
	public Districtdao districtdao;
	
	@RequestMapping(value="/distadder.html",method=RequestMethod.POST)
	public ModelAndView adddistrict(@ModelAttribute("district") District district, BindingResult result, HttpServletRequest req, ModelMap model ,Locale locale)
	{
		System.out.println("District: "+district.getDistrict_name()+" Name: "+req.getParameter("name"));
		
	 districtdao.addDistrict(district);
	return new ModelAndView("home",model);
	}

	public Districtdao getDistrictdao() {
		return districtdao;
	}

	public void setDistrictdao(Districtdao districtdao) {
		this.districtdao = districtdao;
	}
}
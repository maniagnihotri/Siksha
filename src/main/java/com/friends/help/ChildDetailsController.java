package com.friends.help;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.friends.help.dao.Blockdao;
import com.friends.help.dao.ChildDetailsdao;
import com.friends.help.dao.Clustersdao;
import com.friends.help.dao.Districtdao;
import com.friends.help.dao.Schooldao;
import com.friends.help.dao.VillageTypeNamesdao;
import com.friends.help.dao.Villagedao;
import com.friends.help.forms.ChildDetails;
import com.friends.help.forms.Disability;
import com.friends.jsp.validate.Childvalidator;

@Controller
public class ChildDetailsController {
	
	@Autowired
	public Villagedao villagedao;
	
	@Autowired
	Childvalidator childvalidator;
	
	@Autowired
	public Blockdao blockdao;
	
	@Autowired
	public Clustersdao clustersdao;

	@Autowired
	public Districtdao districtdao;
	
	@Autowired
	public VillageTypeNamesdao villagetypenamesdao;
	
	@Autowired
	public Schooldao schooldao;
	
	@Autowired
	public ChildDetailsdao childdetailsdao;
	
	@RequestMapping(value = "/Childdetailsadder.html", method = RequestMethod.GET)
	public ModelAndView initForm(ModelMap model) {

		ChildDetails childdetails = new ChildDetails();
		model.addAttribute("ChildDetails", childdetails);
		return new ModelAndView("addChild", "command", childdetails);
	}
	
	@RequestMapping(value = "/Childdetailsadder.html", method = RequestMethod.POST)
	public ModelAndView processSubmit(@ModelAttribute("ChildDetails") ChildDetails childdetails,
			BindingResult result, SessionStatus status, ModelMap model) {
		
		//schoolvalidator.setSchool(schooldao.getSchoolObject(school.getName(),school.getVillage_id()));
		//schoolvalidator.setRequesttype(0);
		childvalidator.validate(childdetails, result);

		if (result.hasErrors()) {
			return new ModelAndView("addChild");
		} else {
			childdetails.setVillage(villagedao.getVillageObjectbyID(childdetails.getVillageid()));
			childdetails.setCaste_type(childdetailsdao.getCastteype(childdetails.getCasteid()));
			childdetails.setDisability(childdetailsdao.getDisability(childdetails.getDisabilityid()));
			
			Date date = null;
			
			try {
				
				SimpleDateFormat  sdf = new SimpleDateFormat("dd-MMM-yyyy");
				//SimpleDateFormat mysqlformat = new SimpleDateFormat("yyyy-mm-dd");
				 date= sdf.parse(childdetails.getDate());
				 System.out.println(date.toString());
				 //dow MMM yy
				/* System.out.println(date.toString());
				 
				 Calendar c =
				 c.
				 
				 
				 Date d = new Date(date., month, date)*/
				//mysql.mysqlformat.format(date);
			   // mysql = mysqlformat.parse(mysqlformat.format(date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			childdetails.setDate_of_birth(date);
			
			//childdetails.setVillage(village);
			//school.setT_or_v_id(villagedao.getVillageObjectbyID(school.getVillage_id()));
			childdetailsdao.saveChild(childdetails);
			status.setComplete();
			
			
			ChildDetails childdetails2 = new ChildDetails();
			childdetails2.setVillage(childdetails.getVillage());
			childdetails2.setGender('M');
			childdetails2.setIsdisable(1);
			model.addAttribute("ChildDetails", childdetails2);
			return new ModelAndView("addChild", "command", childdetails2);
		}
		
	}

	@ModelAttribute("DisabilityList")
	public List<Disability> populateDisability() {

		List<Disability> DisabilityList = new ArrayList<Disability>();

		DisabilityList = childdetailsdao.getDisabilityList();
		return DisabilityList;
	}
}

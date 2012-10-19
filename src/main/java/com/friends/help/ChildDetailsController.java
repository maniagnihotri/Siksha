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
import org.springframework.web.bind.annotation.RequestParam;
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
import com.friends.help.forms.EducationalDetails;
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
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			childdetails.setDate_of_birth(date);
			//if(childdetails.getId()=="")
			//{	
			long tid;
			tid = childdetails.getVillage().getVillageTypeNames().getClusters().getBlock().getDistrict().getID();
			tid = tid * 100 + childdetails.getVillage().getVillageTypeNames().getClusters().getBlock().getBlock_id();
			tid = tid * 100 + childdetails.getVillage().getVillageTypeNames().getClusters().getCluster_id();
			tid = tid * 100 + childdetails.getVillage().getId();
			tid = tid*100000 + childdetailsdao.getNumberOfRows() ; 
			String s = ""+tid;
			
			childdetails.setId(s);
			ChildDetails check = null;
				check = childdetailsdao.getChildById(s);
			//if(check==null)
				childdetailsdao.saveChild(childdetails);
			//}
			status.setComplete();
			
			return new ModelAndView("forward:/childEducation.html?childId="+childdetails.getId());
		}
		
	}

	@ModelAttribute("DisabilityList")
	public List<Disability> populateDisability() {

		List<Disability> DisabilityList = new ArrayList<Disability>();

		DisabilityList = childdetailsdao.getDisabilityList();
		return DisabilityList;
	}
	
	@RequestMapping(value = "/childEducation.html", method = {RequestMethod.POST ,RequestMethod.GET} )
	public ModelAndView educationinput(@RequestParam("childId")String childId,ModelMap model ){
		EducationalDetails ed = new EducationalDetails();
		//ChildDetails childdetails2 = new ChildDetails();
		ed.setHelp_child_id(childId);
		ChildDetails childDetails = childdetailsdao.getChildById(childId);
		model.addAttribute("SchoolList",schooldao.getSchoolList(childDetails.getVillage().getId(),0));
		model.addAttribute("Child", childDetails);
		model.addAttribute("EducationalDetails",ed);
		return new ModelAndView("addEducation", "command", ed);
	}
	
}

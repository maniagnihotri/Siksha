package com.friends.help;

import java.util.ArrayList;
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
import com.friends.help.dao.EducationDetailsDao;
import com.friends.help.dao.Schooldao;
import com.friends.help.dao.VillageTypeNamesdao;
import com.friends.help.dao.Villagedao;
import com.friends.help.forms.ChildDetails;
import com.friends.help.forms.Disability;
import com.friends.help.forms.EducationalDetails;
import com.friends.jsp.validate.EducationalDetailsValidator;

@Controller
public class EducationDetailsController {
	
	@Autowired
	public Villagedao villagedao;
	
	@Autowired
	EducationalDetailsValidator educationaldetailsvalidator;
	
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
	
	@Autowired
	public EducationDetailsDao educationdetailsdao;

	@RequestMapping(value = "/Edudetailsadder.html", method = RequestMethod.GET)
	public ModelAndView initForm(ModelMap model) {

		EducationalDetails educationaldetails = new EducationalDetails();
		model.addAttribute("EducationalDetails", educationaldetails);
		return new ModelAndView("addEducation", "command", educationaldetails);
	}
	
	@RequestMapping(value = "/Edudetailsadder.html", method = RequestMethod.POST)
	public ModelAndView processSubmit(@ModelAttribute("EducationalDetails") EducationalDetails educationaldetails,
			BindingResult result, SessionStatus status, ModelMap model) {
		
		if(educationaldetails.getRegularityType()=="Regular")
		{
			educationaldetails.setHelp_irregularity_id(1);
			educationaldetails.setHelp_left_school_at(16);
		}
		
		educationaldetailsvalidator.validate(educationaldetails, result);

		if (result.hasErrors()) {
			return new ModelAndView("addChild");
		} else {
			/*childdetails.setVillage(villagedao.getVillageObjectbyID(childdetails.getVillageid()));
			childdetails.setCaste_type(childdetailsdao.getCastteype(childdetails.getCasteid()));
			childdetails.setDisability(childdetailsdao.getDisability(childdetails.getDisabilityid()));
			*/
			educationaldetails.setIrregularity(educationdetailsdao.getRegularityObject(educationaldetails.getHelp_irregularity_id()));
			//educational
			educationaldetails.setClass_id(educationdetailsdao.getClassObject(educationaldetails.getHelp_class_id()));
			educationaldetails.setLeft_school_at(educationdetailsdao.getClassObject(educationaldetails.getHelp_left_school_at()));
			educationaldetails.setAge_class_id(educationdetailsdao.getClassObject(educationaldetails.getHelp_age_class_id()));
			ChildDetails childdetails_tosave = childdetailsdao.getChildById(educationaldetails.getHelp_child_id());
			educationaldetails.setChild_id(childdetails_tosave);
			educationaldetails.setSchool_id(schooldao.getSchoolObjectbyID(educationaldetails.getHelp_school_id()));
			

			long tid;
			tid = childdetails_tosave.getVillage().getVillageTypeNames().getClusters().getBlock().getDistrict().getID();
			tid = tid * 100 + childdetails_tosave.getVillage().getVillageTypeNames().getClusters().getBlock().getBlock_id();
			tid = tid * 100 + childdetails_tosave.getVillage().getVillageTypeNames().getClusters().getCluster_id();
			tid = tid * 100 + childdetails_tosave.getVillage().getId();
			tid = tid*100000 + educationdetailsdao.getNumberOfRows() ; 
			String s = ""+tid;
			educationaldetails.setId(s);
			
			educationdetailsdao.saveEducation(educationaldetails);
			status.setComplete();
			
			
			ChildDetails childdetails = new ChildDetails();
			childdetails.setVillage(villagedao.getVillageObjectbyID(educationaldetails.getChild_id().getVillage().getId()));
			childdetails.setGender('M');
			childdetails.setIsdisable(1);
			model.addAttribute("ChildDetails", childdetails);
			model.addAttribute("Village", villagedao.getVillageObjectbyID(educationaldetails.getChild_id().getVillage().getId()));
			return new ModelAndView("addChild", "command", childdetails);
		}
		
	}
	
	@ModelAttribute("DisabilityList")
	public List<Disability> populateDisability() {

		List<Disability> DisabilityList = new ArrayList<Disability>();

		DisabilityList = childdetailsdao.getDisabilityList();
		DisabilityList.remove(1);
		return DisabilityList;
	}
}

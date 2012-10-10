package com.friends.help;

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
import com.friends.help.dao.Clustersdao;
import com.friends.help.dao.Districtdao;
import com.friends.help.dao.Schooldao;
import com.friends.help.dao.VillageTypeNamesdao;
import com.friends.help.dao.Villagedao;
import com.friends.help.forms.ChildDetails;
import com.friends.help.forms.School;
import com.friends.jsp.validate.Schoolvalidator;

@Controller
public class ChildDetailsController {
	
	@Autowired
	public Villagedao villagedao;
	
	@Autowired
	Schoolvalidator schoolvalidator;
	
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
	
	@RequestMapping(value = "/Childdetailsadder.html", method = RequestMethod.GET)
	public ModelAndView initForm(ModelMap model) {

		ChildDetails childdetails = new ChildDetails();
		model.addAttribute("ChildDetails", childdetails);
		return new ModelAndView("addChild", "command", childdetails);
	}
	
	@RequestMapping(value = "/Childdetailsadder.html", method = RequestMethod.POST)
	public ModelAndView processSubmit(@ModelAttribute("ChildDetails") ChildDetails childdetails,
			BindingResult result, SessionStatus status, ModelMap model) {
		
		schoolvalidator.setSchool(schooldao.getSchoolObject(school.getName(),school.getVillage_id()));
		schoolvalidator.setRequesttype(0);
		schoolvalidator.validate(school, result);

		if (result.hasErrors()) {
			return new ModelAndView("addSchool");
		} else {
			school.setSchool_category(schooldao.getSchoolCategoryById(school.getCategory_id()));
			school.setT_or_v_id(villagedao.getVillageObjectbyID(school.getVillage_id()));
			schooldao.addSchool(school);
			status.setComplete();
			model.put("BlockNameList",blockdao.getBlocks(school.getDistrict_id())) ;
			model.put("ClustersNameList",clustersdao.getClustersList(school.getBlock_id())) ;
			//model.put("Schooltypelist", Schooltypenamesdao.getSchoolType());
			model.put("VillagetypenamesList", villagetypenamesdao.getVillageTypeNamesList(school.getCluster_id(),school.getType_id()));
			//model.put("SchoolList", Schooldao.getSchoolList(school.getVillage_id()));
			model.put("VillageList", villagedao.getVillageList(school.getVillagetypenames_id()));
			model.put("SchoolList", schooldao.getSchoolList(school.getVillage_id()));
			school.setName(null);
			model.addAttribute("School", school);
	
			return new ModelAndView("addSchool", "command", school);
		}
	}

}

package com.friends.help;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.friends.help.forms.District;
import com.friends.help.forms.School;
import com.friends.jsp.validate.Schoolvalidator;

@Controller
public class SchoolController {


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

	
	@RequestMapping(value = "/Schooladder.html", method = RequestMethod.GET)
	public ModelAndView initForm(ModelMap model) {

		School school = new School();
		model.addAttribute("School", school);
		return new ModelAndView("addSchool", "command", school);
	}
	
	@RequestMapping(value = "/Schooladder.html", method = RequestMethod.POST)
	public ModelAndView processSubmit(@ModelAttribute("School") School school,
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
			model.put("SchoolList", schooldao.getSchoolList(school.getVillage_id(),school.getCategory_id()));
			school.setName(null);
			model.addAttribute("School", school);
	
			return new ModelAndView("addSchool", "command", school);
		}
	}
	
	@ModelAttribute("DistrictNameList")
	public List<District> populateDistrictList() {

		List<District> DistrictNameList = new ArrayList<District>();

		DistrictNameList = districtdao.getAllDistricts();
		return DistrictNameList;
	}
	
	
	
	@RequestMapping(value = "/BlocknamesinSchool.html", method = RequestMethod.POST)
	public ModelAndView getBlockname(@ModelAttribute("School") School School,
			ModelMap model) {

		//System.out.println("In Post method of Blocknames");
		model.addAttribute("School", School);
		model.put("BlockNameList",blockdao.getBlocks(School.getDistrict_id())) ;
		return new ModelAndView("addSchool", "command", School);
		//return new ModelAndView(new RedirectView("Schooladder.html"));
	}
	
	@RequestMapping(value = "/ClustersnamesinSchool.html", method = RequestMethod.POST)
	public ModelAndView getClusternames(@ModelAttribute("School") School School,
			ModelMap model) {

		//System.out.println("In Post method of Blocknames");
		//School.setDistrict_id(district_id)
		model.addAttribute("School", School);
		model.put("BlockNameList",blockdao.getBlocks(School.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(School.getBlock_id())) ;
		return new ModelAndView("addSchool", "command", School);
		//return new ModelAndView(new RedirectView("Schooladder.html"));
	}
	
	@RequestMapping(value = "/VillagetypenamesinSchool.html", method = RequestMethod.POST)
	public ModelAndView getVlillagetype(@ModelAttribute("School") School school,
			BindingResult result, SessionStatus status,ModelMap model) {

		//schoolvalidator.setSchool(Schooldao.getSchoolObject(School.getName(),school.getSchooltypenames_id()));
		schoolvalidator.setRequesttype(1);
		schoolvalidator.validate(school, result);

		if (result.hasErrors()) {
			return new ModelAndView("addSchool");
		} else {
		model.addAttribute("School", school);
		model.put("BlockNameList",blockdao.getBlocks(school.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(school.getBlock_id())) ;
		//model.put("Schooltypelist", Schooldao.getSchoolType());
		model.put("VillagetypenamesList", villagetypenamesdao.getVillageTypeNamesList(school.getCluster_id(),school.getType_id()));
		//model.put("SchoolList", Schooldao.getSchoolList(School.getSchooltypenames_id()));
		return new ModelAndView("addSchool", "command", school);
		}//return new ModelAndView(new RedirectView("Schooladder.html"));
	}
	
	@RequestMapping(value = "/VillageinSchool.html", method = RequestMethod.POST)
	public ModelAndView getVillages(@ModelAttribute("School") School school,
			ModelMap model) {

		//System.out.println("In Post method of Blocknames");
		//School.setDistrict_id(district_id)
		model.addAttribute("School", school);
		model.put("BlockNameList",blockdao.getBlocks(school.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(school.getBlock_id())) ;
		model.put("VillagetypenamesList", villagetypenamesdao.getVillageTypeNamesList(school.getCluster_id(),school.getType_id()));
		model.put("VillageList", villagedao.getVillageList(school.getVillagetypenames_id()));
		return new ModelAndView("addSchool", "command", school);
		//return new ModelAndView(new RedirectView("Schooladder.html"));
	}
	
	@RequestMapping(value = "/Schoolnames.html", method = RequestMethod.POST)
	public ModelAndView getVlillagetypenames(@ModelAttribute("School") School school,
			BindingResult result, SessionStatus status,ModelMap model) {

		schoolvalidator.setSchool(schooldao.getSchoolObject(school.getName(),school.getVillage_id()));
		schoolvalidator.setRequesttype(2);
		schoolvalidator.validate(school, result);

		if (result.hasErrors()) {
			return new ModelAndView("addSchool");
		} else {
		model.addAttribute("School", school);
		model.put("BlockNameList",blockdao.getBlocks(school.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(school.getBlock_id())) ;
		//model.put("Schooltypelist", Schooldao.getSchoolType());
		model.put("VillagetypenamesList", villagetypenamesdao.getVillageTypeNamesList(school.getCluster_id(),school.getType_id()));
		model.put("VillageList", villagedao.getVillageList(school.getVillagetypenames_id()));
		model.put("SchoolList", schooldao.getSchoolList(school.getVillage_id(),school.getCategory_id()));
		return new ModelAndView("addSchool", "command", school);
		}//return new ModelAndView(new RedirectView("Schooladder.html"));
	}
	
		
	@RequestMapping(value = "/updateSchool{school_id}.html", method = RequestMethod.GET)
	public ModelAndView getUpdateDistrictPage(@PathVariable int school_id,ModelMap model) {
		School school = schooldao.getSchoolObjectbyID(school_id);
		school.setDistrict_id(school.getT_or_v_id().getVillageTypeNames().getClusters().getBlock().getDistrict().getID());
		school.setBlock_id(school.getT_or_v_id().getVillageTypeNames().getClusters().getBlock().getBlock_id());
		school.setCluster_id(school.getT_or_v_id().getVillageTypeNames().getClusters().getCluster_id());
		school.setType_id(school.getT_or_v_id().getVillageTypeNames().getType().getId());
		school.setVillagetypenames_id(school.getT_or_v_id().getVillageTypeNames().getId());
		school.setVillage_id(school.getT_or_v_id().getId());
		school.setCategory_id(school.getSchool_category().getSchool_category_id());
		model.addAttribute("School", school);
		model.put("BlockNameList",blockdao.getBlocks(school.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(school.getBlock_id())) ;
		//model.put("Schooltypelist", Schooldao.getSchoolType());
		model.put("VillagetypenamesList", villagetypenamesdao.getVillageTypeNamesList(school.getCluster_id(),school.getType_id()));
		model.put("VillageList", villagedao.getVillageList(school.getVillagetypenames_id()));
		model.put("SchoolList", schooldao.getSchoolList(school.getVillage_id(),school.getCategory_id()));
		//School.setCluster_name(null);
		//model.addAttribute("School", School);

		return new ModelAndView("addSchool", "command", school);

	}
	
	@RequestMapping(value = "/updateSchool.html", method = RequestMethod.POST)
	public ModelAndView updateSchool(@ModelAttribute("School") School school,
			BindingResult result, SessionStatus status,ModelMap model) {

		schoolvalidator.setSchool(schooldao.getSchoolObject(school.getName(),school.getVillage_id()));
		schoolvalidator.setRequesttype(0);
		schoolvalidator.validate(school, result);

		if (result.hasErrors()) {
			return new ModelAndView("addSchool");
		} else {
			school.setSchool_category(schooldao.getSchoolCategoryById(school.getCategory_id()));
			school.setT_or_v_id(villagedao.getVillageObjectbyID(school.getVillage_id()));
			//school.setSchoolTypeNames(Schooltypenamesdao.getSchoolTypeNamesObjectbyID(School.getSchooltypenames_id()));
			schooldao.updateSchool(school);
			status.setComplete();
			model.put("BlockNameList",blockdao.getBlocks(school.getDistrict_id())) ;
			model.put("ClustersNameList",clustersdao.getClustersList(school.getBlock_id())) ;
			//model.put("Schooltypelist", Schooltypenamesdao.getSchoolType());
			model.put("VillagetypenamesList", villagetypenamesdao.getVillageTypeNamesList(school.getCluster_id(),school.getType_id()));
			//model.put("SchoolList", Schooldao.getSchoolList(school.getVillage_id()));
			model.put("VillageList", villagedao.getVillageList(school.getVillagetypenames_id()));
			model.put("SchoolList", schooldao.getSchoolList(school.getVillage_id(),school.getCategory_id()));
			school.setName(null);
			model.addAttribute("School", school);
	
			return new ModelAndView("addSchool", "command", school);
		}
		

	}
	
	@RequestMapping(value = "/deleteSchool{school_id}.html", method = RequestMethod.GET)
	public ModelAndView deleteDistrict(@PathVariable int school_id, ModelMap model) {

		School school = schooldao.getSchoolObjectbyID(school_id);
		school.setDistrict_id(school.getT_or_v_id().getVillageTypeNames().getClusters().getBlock().getDistrict().getID());
		school.setBlock_id(school.getT_or_v_id().getVillageTypeNames().getClusters().getBlock().getBlock_id());
		school.setCluster_id(school.getT_or_v_id().getVillageTypeNames().getClusters().getCluster_id());
		school.setType_id(school.getT_or_v_id().getVillageTypeNames().getType().getId());
		school.setVillagetypenames_id(school.getT_or_v_id().getVillageTypeNames().getId());
		school.setVillage_id(school.getT_or_v_id().getId());
		school.setCategory_id(school.getSchool_category().getSchool_category_id());
		schooldao.deletSchool(school);
		model.addAttribute("School", school);
		model.put("BlockNameList",blockdao.getBlocks(school.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(school.getBlock_id())) ;
		//model.put("Schooltypelist", Schooldao.getSchoolType());
		model.put("VillagetypenamesList", villagetypenamesdao.getVillageTypeNamesList(school.getCluster_id(),school.getType_id()));
		model.put("VillageList", villagedao.getVillageList(school.getVillagetypenames_id()));
		model.put("SchoolList", schooldao.getSchoolList(school.getVillage_id(),school.getCategory_id()));
		//School.setCluster_name(null);
		//model.addAttribute("School", School);

		return new ModelAndView("addSchool", "command", school);

	}
}

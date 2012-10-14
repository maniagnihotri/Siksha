package com.friends.help;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.friends.help.dao.VillageTypeNamesdao;
import com.friends.help.dao.Villagedao;
import com.friends.help.forms.ChildDetails;
import com.friends.help.forms.Disability;
import com.friends.help.forms.District;
import com.friends.help.util.PlaceHelper;
import com.friends.jsp.validate.SelectPlaceValidator;

@Controller
public class SelectPlaceController {

	@Autowired
	public Villagedao villagedao;
	
	@Autowired
	SelectPlaceValidator selectplacevalidator;
	
	@Autowired
	public Blockdao blockdao;
	
	@Autowired
	public Clustersdao clustersdao;

	@Autowired
	public Districtdao districtdao;
	
	@Autowired
	public ChildDetailsdao childdetailsdao;
	
	@Autowired
	public VillageTypeNamesdao villagetypenamesdao;
	
	@RequestMapping(value = "/SelectPlace.html", method = RequestMethod.GET)
	public ModelAndView initForm(ModelMap model, Principal principal, HttpSession session) {
		String user = principal.getName();
		user = user.substring(0,1).toUpperCase()+user.substring(1).toLowerCase();
		session.setAttribute("user", user);
		PlaceHelper placehelper = new PlaceHelper();
		model.addAttribute("PlaceHelper", placehelper);
		return new ModelAndView("selectPlace", "command", placehelper);
	}
	
	@RequestMapping(value = "/SelectPlace.html", method = RequestMethod.POST)
	public ModelAndView processSubmit(@ModelAttribute("PlaceHelper") PlaceHelper placehelper,
			BindingResult result, SessionStatus status, ModelMap model) {
		selectplacevalidator.setRequesttype(0);
		selectplacevalidator.validate(placehelper, result);

		if (result.hasErrors()) {
			return new ModelAndView("selectPlace");
		} else {
			
			ChildDetails childdetails = new ChildDetails();
			childdetails.setVillage(villagedao.getVillageObjectbyID(placehelper.getVillage_id()));
			childdetails.setGender('M');
			childdetails.setIsdisable(1);
			model.addAttribute("ChildDetails", childdetails);
			model.addAttribute("VillageName", villagedao.getVillageObjectbyID(placehelper.getVillage_id()).getName());
			return new ModelAndView("addChild", "command", childdetails);
			//return new ModelAndView("selectPlace", "command", placehelper);
		}
	}
	
	@ModelAttribute("DistrictNameList")
	public List<District> populateDistrictList() {

		List<District> DistrictNameList = new ArrayList<District>();

		DistrictNameList = districtdao.getAllDistricts();
		return DistrictNameList;
	}
	
	
	
	@RequestMapping(value = "/BlocknamesinSelectPlace.html", method = RequestMethod.POST)
	public ModelAndView getBlockname(@ModelAttribute("PlaceHelper") PlaceHelper placehelper,
			ModelMap model) {

		//System.out.println("In Post method of Blocknames");
		model.addAttribute("PlaceHelper", placehelper);
		model.put("BlockNameList",blockdao.getBlocks(placehelper.getDistrict_id())) ;
		return new ModelAndView("selectPlace", "command", placehelper);
		//return new ModelAndView(new RedirectView("Schooladder.html"));
	}
	
	@RequestMapping(value = "/ClustersnamesinSelectPlace.html", method = RequestMethod.POST)
	public ModelAndView getClusternames(@ModelAttribute("PlaceHelper") PlaceHelper placehelper,
			ModelMap model) {

		//System.out.println("In Post method of Blocknames");
		//School.setDistrict_id(district_id)
		model.addAttribute("PlaceHelper", placehelper);
		model.put("BlockNameList",blockdao.getBlocks(placehelper.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(placehelper.getBlock_id())) ;
		return new ModelAndView("selectPlace", "command", placehelper);
		//return new ModelAndView(new RedirectView("Schooladder.html"));
	}
	
	@RequestMapping(value = "/VillagetypenamesinSelectPlace.html", method = RequestMethod.POST)
	public ModelAndView getVlillagetype(@ModelAttribute("PlaceHelper") PlaceHelper placehelper,
			BindingResult result, SessionStatus status,ModelMap model) {

		//schoolvalidator.setSchool(Schooldao.getSchoolObject(School.getName(),school.getSchooltypenames_id()));
		selectplacevalidator.setRequesttype(1);
		selectplacevalidator.validate(placehelper, result);

		if (result.hasErrors()) {
			return new ModelAndView("selectPlace");
		} else {
		model.addAttribute("PlaceHelper", placehelper);
		model.put("BlockNameList",blockdao.getBlocks(placehelper.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(placehelper.getBlock_id())) ;
		//model.put("Schooltypelist", Schooldao.getSchoolType());
		model.put("VillagetypenamesList", villagetypenamesdao.getVillageTypeNamesList(placehelper.getCluster_id(),placehelper.getType_id()));
		//model.put("SchoolList", Schooldao.getSchoolList(School.getSchooltypenames_id()));
		return new ModelAndView("selectPlace", "command", placehelper);
		}//return new ModelAndView(new RedirectView("Schooladder.html"));
	}
	
	@RequestMapping(value = "/VillageinSelectplace.html", method = RequestMethod.POST)
	public ModelAndView getVillages(@ModelAttribute("PlaceHelper") PlaceHelper placehelper,
			ModelMap model) {

		//System.out.println("In Post method of Blocknames");
		//School.setDistrict_id(district_id)
		model.addAttribute("PlaceHelper", placehelper);
		model.put("BlockNameList",blockdao.getBlocks(placehelper.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(placehelper.getBlock_id())) ;
		model.put("VillagetypenamesList", villagetypenamesdao.getVillageTypeNamesList(placehelper.getCluster_id(),placehelper.getType_id()));
		model.put("VillageList", villagedao.getVillageList(placehelper.getVillagetypenames_id()));
		return new ModelAndView("selectPlace", "command", placehelper);
		//return new ModelAndView(new RedirectView("Schooladder.html"));
	}
	
	@ModelAttribute("DisabilityList")
	public List<Disability> populateDisability() {

		List<Disability> DisabilityList = new ArrayList<Disability>();

		DisabilityList = childdetailsdao.getDisabilityList();
		DisabilityList.remove(0);
		return DisabilityList;
	}

}

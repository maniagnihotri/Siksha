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
import com.friends.help.dao.VillageTypeNamesdao;
import com.friends.help.dao.Villagedao;
import com.friends.help.forms.District;
import com.friends.help.forms.Village;
import com.friends.jsp.validate.Villagevalidator;

@Controller
public class VillageController {

	@Autowired
	public Villagedao villagedao;
	
	@Autowired
	Villagevalidator villagevalidator;
	
	@Autowired
	public Blockdao blockdao;
	
	@Autowired
	public Clustersdao clustersdao;

	@Autowired
	public Districtdao districtdao;
	
	@Autowired
	public VillageTypeNamesdao villagetypenamesdao;

	
	@RequestMapping(value = "/Villageadder.html", method = RequestMethod.GET)
	public ModelAndView initForm(ModelMap model) {

		Village village = new Village();
		model.addAttribute("Village", village);
		return new ModelAndView("addVillage", "command", village);
	}
	
	@RequestMapping(value = "/Villageadder.html", method = RequestMethod.POST)
	public ModelAndView processSubmit(@ModelAttribute("Village") Village village,
			BindingResult result, SessionStatus status, ModelMap model) {
		
		villagevalidator.setVillage(villagedao.getVillageObject(village.getName(),village.getVillagetypenames_id()));
		villagevalidator.setRequesttype(0);
		villagevalidator.validate(village, result);

		if (result.hasErrors()) {
			return new ModelAndView("addVillage");
		} else {
			//village.setType(Villagedao.getVillageTypeById(Village.getType_id()));
			village.setVillageTypeNames(villagetypenamesdao.getVillageTypeNamesObjectbyID(village.getVillagetypenames_id()));
			villagedao.addVillage(village);
			status.setComplete();
			model.put("BlockNameList",blockdao.getBlocks(village.getDistrict_id())) ;
			model.put("ClustersNameList",clustersdao.getClustersList(village.getBlock_id())) ;
			//model.put("Villagetypelist", villagetypenamesdao.getVillageType());
			model.put("VillagetypenamesList", villagetypenamesdao.getVillageTypeNamesList(village.getCluster_id(),village.getType_id()));
			model.put("VillageList", villagedao.getVillageList(village.getVillagetypenames_id()));
			village.setName(null);
			model.addAttribute("Village", village);
	
			return new ModelAndView("addVillage", "command", village);
		}
	}
	
	@ModelAttribute("DistrictNameList")
	public List<District> populateDistrictList() {

		List<District> DistrictNameList = new ArrayList<District>();

		DistrictNameList = districtdao.getAllDistricts();
		return DistrictNameList;
	}
	
	
	
	@RequestMapping(value = "/Blocknamesinvillage.html", method = RequestMethod.POST)
	public ModelAndView getBlockname(@ModelAttribute("Village") Village village,
			ModelMap model) {

		//System.out.println("In Post method of Blocknames");
		model.addAttribute("Village", village);
		model.put("BlockNameList",blockdao.getBlocks(village.getDistrict_id())) ;
		return new ModelAndView("addVillage", "command", village);
		//return new ModelAndView(new RedirectView("Villageadder.html"));
	}
	
	@RequestMapping(value = "/Clustersnamesinvillage.html", method = RequestMethod.POST)
	public ModelAndView getClusternames(@ModelAttribute("Village") Village village,
			ModelMap model) {

		//System.out.println("In Post method of Blocknames");
		//Village.setDistrict_id(district_id)
		model.addAttribute("Village", village);
		model.put("BlockNameList",blockdao.getBlocks(village.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(village.getBlock_id())) ;
		return new ModelAndView("addVillage", "command", village);
		//return new ModelAndView(new RedirectView("Villageadder.html"));
	}
	
	@RequestMapping(value = "/VillagetypenamesinVillage.html", method = RequestMethod.POST)
	public ModelAndView getVlillagetype(@ModelAttribute("Village") Village village,
			BindingResult result, SessionStatus status,ModelMap model) {

		villagevalidator.setVillage(villagedao.getVillageObject(village.getName(),village.getVillagetypenames_id()));
		villagevalidator.setRequesttype(1);
		villagevalidator.validate(village, result);

		if (result.hasErrors()) {
			return new ModelAndView("addVillage");
		} else {
		model.addAttribute("Village", village);
		model.put("BlockNameList",blockdao.getBlocks(village.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(village.getBlock_id())) ;
		//model.put("Villagetypelist", Villagedao.getVillageType());
		model.put("VillagetypenamesList", villagetypenamesdao.getVillageTypeNamesList(village.getCluster_id(),village.getType_id()));
		//model.put("VillageList", villagedao.getVillageList(village.getVillagetypenames_id()));
		return new ModelAndView("addVillage", "command", village);
		}//return new ModelAndView(new RedirectView("Villageadder.html"));
	}
	
	@RequestMapping(value = "/Villagenames.html", method = RequestMethod.POST)
	public ModelAndView getVlillagetypenames(@ModelAttribute("Village") Village village,
			BindingResult result, SessionStatus status,ModelMap model) {

		villagevalidator.setVillage(villagedao.getVillageObject(village.getName(),village.getVillagetypenames_id()));
		villagevalidator.setRequesttype(1);
		villagevalidator.validate(village, result);

		if (result.hasErrors()) {
			return new ModelAndView("addVillage");
		} else {
		model.addAttribute("Village", village);
		model.put("BlockNameList",blockdao.getBlocks(village.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(village.getBlock_id())) ;
		//model.put("Villagetypelist", Villagedao.getVillageType());
		model.put("VillagetypenamesList", villagetypenamesdao.getVillageTypeNamesList(village.getCluster_id(),village.getType_id()));
		model.put("VillageList", villagedao.getVillageList(village.getVillagetypenames_id()));
		return new ModelAndView("addVillage", "command", village);
		}//return new ModelAndView(new RedirectView("Villageadder.html"));
	}
	
		
	@RequestMapping(value = "/updateVillage{village_id}.html", method = RequestMethod.GET)
	public ModelAndView getUpdateDistrictPage(@PathVariable int village_id,ModelMap model) {
		Village village = villagedao.getVillageObjectbyID(village_id);
		village.setDistrict_id(village.getVillageTypeNames().getClusters().getBlock().getDistrict().getID());
		village.setBlock_id(village.getVillageTypeNames().getClusters().getBlock().getBlock_id());
		village.setCluster_id(village.getVillageTypeNames().getClusters().getCluster_id());
		village.setType_id(village.getVillageTypeNames().getType().getId());
		village.setVillagetypenames_id(village.getVillageTypeNames().getId());
		model.addAttribute("Village", village);
		model.put("BlockNameList",blockdao.getBlocks(village.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(village.getBlock_id())) ;
		//model.put("Villagetypelist", Villagedao.getVillageType());
		model.put("VillagetypenamesList", villagetypenamesdao.getVillageTypeNamesList(village.getCluster_id(),village.getType_id()));
		model.put("VillageList", villagedao.getVillageList(village.getVillagetypenames_id()));
		//Village.setCluster_name(null);
		//model.addAttribute("Village", village);

		return new ModelAndView("addVillage", "command", village);

	}
	
	@RequestMapping(value = "/updateVillage.html", method = RequestMethod.POST)
	public ModelAndView updateBlock(@ModelAttribute("Village") Village village,
			BindingResult result, SessionStatus status,ModelMap model) {
		villagevalidator.setVillage(villagedao.getVillageObject(village.getName(),village.getVillagetypenames_id()));
		villagevalidator.setRequesttype(0);
		villagevalidator.validate(village, result);

		if (result.hasErrors()) {
			return new ModelAndView("addVillage");
		} else {
			//village.setType(Villagedao.getVillageTypeById(Village.getType_id()));
			village.setVillageTypeNames(villagetypenamesdao.getVillageTypeNamesObjectbyID(village.getVillagetypenames_id()));
			villagedao.updateVillage(village);
			status.setComplete();
			model.put("BlockNameList",blockdao.getBlocks(village.getDistrict_id())) ;
			model.put("ClustersNameList",clustersdao.getClustersList(village.getBlock_id())) ;
			//model.put("Villagetypelist", villagetypenamesdao.getVillageType());
			model.put("VillagetypenamesList", villagetypenamesdao.getVillageTypeNamesList(village.getCluster_id(),village.getType_id()));
			model.put("VillageList", villagedao.getVillageList(village.getVillagetypenames_id()));
			village.setName(null);
			model.addAttribute("Village", village);
	
			return new ModelAndView("addVillage", "command", village);
		}
		

	}
	
	@RequestMapping(value = "/deleteVillage{village_id}.html", method = RequestMethod.GET)
	public ModelAndView deleteDistrict(@PathVariable int village_id, ModelMap model) {

		Village village = villagedao.getVillageObjectbyID(village_id);
		village.setDistrict_id(village.getVillageTypeNames().getClusters().getBlock().getDistrict().getID());
		village.setBlock_id(village.getVillageTypeNames().getClusters().getBlock().getBlock_id());
		village.setCluster_id(village.getVillageTypeNames().getClusters().getCluster_id());
		village.setType_id(village.getVillageTypeNames().getType().getId());
		village.setVillagetypenames_id(village.getVillageTypeNames().getId());
		villagedao.deletVillage(village);
		model.put("BlockNameList",blockdao.getBlocks(village.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(village.getBlock_id())) ;
		//model.put("Villagetypelist", Villagedao.getVillageType());
		model.put("VillagetypenamesList", villagetypenamesdao.getVillageTypeNamesList(village.getCluster_id(),village.getType_id()));
		model.put("VillageList", villagedao.getVillageList(village.getVillagetypenames_id()));
		village.setName(null);
		model.addAttribute("Village", village);

		return new ModelAndView("addVillage", "command", village);

	}
}

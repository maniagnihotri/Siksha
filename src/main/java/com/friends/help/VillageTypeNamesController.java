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
import com.friends.help.forms.District;
import com.friends.help.forms.VillageTypeNames;
import com.friends.jsp.validate.VillageTypeNamesvalidator;

@Controller
public class VillageTypeNamesController {

	@Autowired
	public VillageTypeNamesdao villagetypenamesdao;
	
	@Autowired
	VillageTypeNamesvalidator villageTypeNamesvalidator;
	
	@Autowired
	public Blockdao blockdao;
	
	@Autowired
	public Clustersdao clustersdao;

	@Autowired
	public Districtdao districtdao;
	
	@Autowired
	public VillageTypeNamesdao VillageTypeNamesdao;
	
	@RequestMapping(value = "/VillageTypeNamesadder.html", method = RequestMethod.GET)
	public ModelAndView initForm(ModelMap model) {

		VillageTypeNames VillageTypeNames = new VillageTypeNames();
		model.addAttribute("VillageTypeNames", VillageTypeNames);
		return new ModelAndView("addVillageTypeNames", "command", VillageTypeNames);
	}
	
	@RequestMapping(value = "/VillageTypeNamesadder.html", method = RequestMethod.POST)
	public ModelAndView processSubmit(@ModelAttribute("VillageTypeNames") VillageTypeNames villageTypeNames,
			BindingResult result, SessionStatus status, ModelMap model) {
		
		villageTypeNamesvalidator.setVillagetypenames(VillageTypeNamesdao.getVillageTypeNamesObject(villageTypeNames.getName(),villageTypeNames.getCluster_id()));
		villageTypeNamesvalidator.setRequesttype(0);
		villageTypeNamesvalidator.validate(villageTypeNames, result);

		if (result.hasErrors()) {
			return new ModelAndView("addVillageTypeNames");
		} else {
			villageTypeNames.setType(VillageTypeNamesdao.getVillageTypeById(villageTypeNames.getType_id()));
			villageTypeNames.setClusters(clustersdao.getClustersObjectbyID(villageTypeNames.getCluster_id()));
			VillageTypeNamesdao.addVillageTypeNames(villageTypeNames);
			status.setComplete();
			model.put("BlockNameList",blockdao.getBlocks(villageTypeNames.getDistrict_id())) ;
			model.put("ClustersNameList",clustersdao.getClustersList(villageTypeNames.getBlock_id())) ;
			model.put("Villagetypelist", VillageTypeNamesdao.getVillageType());
			model.put("VillageTypeNamesList", VillageTypeNamesdao.getVillageTypeNamesList(villageTypeNames.getCluster_id(),villageTypeNames.getType_id()));
			villageTypeNames.setName(null);
			model.addAttribute("VillageTypeNames", villageTypeNames);
	
			return new ModelAndView("addVillageTypeNames", "command", villageTypeNames);
		}
	}
	
	@ModelAttribute("DistrictNameList")
	public List<District> populateDistrictList() {

		List<District> DistrictNameList = new ArrayList<District>();

		DistrictNameList = districtdao.getAllDistricts();
		return DistrictNameList;
	}
	
	
	
	@RequestMapping(value = "/Blocknamesinvillagetype.html", method = RequestMethod.POST)
	public ModelAndView getBlockname(@ModelAttribute("VillageTypeNames") VillageTypeNames villageTypeNames,
			ModelMap model) {

		//System.out.println("In Post method of Blocknames");
		model.addAttribute("VillageTypeNames", villageTypeNames);
		model.put("BlockNameList",blockdao.getBlocks(villageTypeNames.getDistrict_id())) ;
		return new ModelAndView("addVillageTypeNames", "command", villageTypeNames);
		//return new ModelAndView(new RedirectView("VillageTypeNamesadder.html"));
	}
	
	@RequestMapping(value = "/Clustersnamesinvillagetype.html", method = RequestMethod.POST)
	public ModelAndView getClusternames(@ModelAttribute("VillageTypeNames") VillageTypeNames villageTypeNames,
			ModelMap model) {

		//System.out.println("In Post method of Blocknames");
		//villageTypeNames.setDistrict_id(district_id)
		model.addAttribute("VillageTypeNames", villageTypeNames);
		model.put("BlockNameList",blockdao.getBlocks(villageTypeNames.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(villageTypeNames.getBlock_id())) ;
		return new ModelAndView("addVillageTypeNames", "command", villageTypeNames);
		//return new ModelAndView(new RedirectView("VillageTypeNamesadder.html"));
	}
	
	@RequestMapping(value = "/Villagetypenames.html", method = RequestMethod.POST)
	public ModelAndView getVlillagetype(@ModelAttribute("VillageTypeNames") VillageTypeNames villageTypeNames,
			BindingResult result, SessionStatus status,ModelMap model) {

		villageTypeNamesvalidator.setVillagetypenames(VillageTypeNamesdao.getVillageTypeNamesObject(villageTypeNames.getName(),villageTypeNames.getCluster_id()));
		villageTypeNamesvalidator.setRequesttype(1);
		villageTypeNamesvalidator.validate(villageTypeNames, result);

		if (result.hasErrors()) {
			return new ModelAndView("addVillageTypeNames");
		} else {
		model.addAttribute("VillageTypeNames", villageTypeNames);
		model.put("BlockNameList",blockdao.getBlocks(villageTypeNames.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(villageTypeNames.getBlock_id())) ;
		model.put("Villagetypelist", VillageTypeNamesdao.getVillageType());
		model.put("VillageTypeNamesList", VillageTypeNamesdao.getVillageTypeNamesList(villageTypeNames.getCluster_id(),villageTypeNames.getType_id()));
		return new ModelAndView("addVillageTypeNames", "command", villageTypeNames);
		}//return new ModelAndView(new RedirectView("VillageTypeNamesadder.html"));
	}
	
	/*@RequestMapping(value = "/Villagenames.html", method = RequestMethod.POST)
	public ModelAndView getVillagenames(@ModelAttribute("VillageTypeNames") VillageTypeNames villageTypeNames,
			ModelMap model) {

		//System.out.println("In Post method of Blocknames");
		//model.addAttribute("VillageTypeNames", VillageTypeNames);
		model.put("BlockNameList",blockdao.getBlocks(villageTypeNames.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(villageTypeNames.getBlock_id())) ;
		model.put("Villagetypelist", VillageTypeNamesdao.getVillageType());
		model.put("VillageTypeNamesList", VillageTypeNamesdao.getVillageTypeNamesList(villageTypeNames.getCluster_id(),villageTypeNames.getType_id()));
		//VillageTypeNames.setCluster_name(null);
		model.addAttribute("VillageTypeNames", villageTypeNames);

		return new ModelAndView("addVillageTypeNames", "command", villageTypeNames);
	}*/
	
	@RequestMapping(value = "/updateVillageTypeNames{villagenames_id}.html", method = RequestMethod.GET)
	public ModelAndView getUpdateDistrictPage(@PathVariable int villagenames_id,ModelMap model) {
		VillageTypeNames villageTypeNames = VillageTypeNamesdao.getVillageTypeNamesObjectbyID(villagenames_id);
		villageTypeNames.setDistrict_id(villageTypeNames.getClusters().getBlock().getDistrict().getID());
		villageTypeNames.setBlock_id(villageTypeNames.getClusters().getBlock().getBlock_id());
		villageTypeNames.setCluster_id(villageTypeNames.getClusters().getCluster_id());
		model.addAttribute("VillageTypeNames", villageTypeNames);
		model.put("BlockNameList",blockdao.getBlocks(villageTypeNames.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(villageTypeNames.getBlock_id())) ;
		model.put("Villagetypelist", VillageTypeNamesdao.getVillageType());
		model.put("VillageTypeNamesList", VillageTypeNamesdao.getVillageTypeNamesList(villageTypeNames.getCluster_id(),villageTypeNames.getType_id()));
		//VillageTypeNames.setCluster_name(null);
		model.addAttribute("VillageTypeNames", villageTypeNames);

		return new ModelAndView("addVillageTypeNames", "command", villageTypeNames);

	}
	
	@RequestMapping(value = "/updateVillageTypeNames.html", method = RequestMethod.POST)
	public ModelAndView updateBlock(@ModelAttribute("VillageTypeNames") VillageTypeNames villageTypeNames,
			BindingResult result, SessionStatus status,ModelMap model) {
		villageTypeNamesvalidator.setVillagetypenames(VillageTypeNamesdao.getVillageTypeNamesObject(villageTypeNames.getName(),villageTypeNames.getCluster_id()));
		villageTypeNamesvalidator.setRequesttype(0);
		villageTypeNamesvalidator.validate(villageTypeNames, result);

		if (result.hasErrors()) {
			return new ModelAndView("addVillageTypeNames");
		} else {
			villageTypeNames.setType(VillageTypeNamesdao.getVillageTypeById(villageTypeNames.getType_id()));
			villageTypeNames.setClusters(clustersdao.getClustersObjectbyID(villageTypeNames.getCluster_id()));
			VillageTypeNamesdao.updateVillageTypeNames(villageTypeNames);
			status.setComplete();
			model.put("BlockNameList",blockdao.getBlocks(villageTypeNames.getDistrict_id())) ;
			model.put("ClustersNameList",clustersdao.getClustersList(villageTypeNames.getBlock_id())) ;
			model.put("Villagetypelist", VillageTypeNamesdao.getVillageType());
			model.put("VillageTypeNamesList", VillageTypeNamesdao.getVillageTypeNamesList(villageTypeNames.getCluster_id(),villageTypeNames.getType_id()));
			villageTypeNames.setName(null);
			model.addAttribute("VillageTypeNames", villageTypeNames);
	
			return new ModelAndView("addVillageTypeNames", "command", villageTypeNames);
		}
		

	}
	
	@RequestMapping(value = "/deleteVillageTypeNames{villagetypenamesid}.html", method = RequestMethod.GET)
	public ModelAndView deleteDistrict(@PathVariable int villagetypenamesid, ModelMap model) {

		VillageTypeNames villageTypeNames = new VillageTypeNames();
		//VillageTypeNames(blockdao.getBlockobjectbyID(VillageTypeNames.getBlock_id()));
		villageTypeNames = VillageTypeNamesdao.getVillageTypeNamesObjectbyID(villagetypenamesid);
		villageTypeNames.setDistrict_id(villageTypeNames.getClusters().getBlock().getDistrict().getID());
		villageTypeNames.setBlock_id(villageTypeNames.getClusters().getBlock().getBlock_id());
		villageTypeNames.setCluster_id(villageTypeNames.getClusters().getCluster_id());
		VillageTypeNamesdao.deletVillageTypeNames(villageTypeNames);
		model.put("BlockNameList",blockdao.getBlocks(villageTypeNames.getDistrict_id())) ;
		model.put("ClustersNameList",clustersdao.getClustersList(villageTypeNames.getBlock_id())) ;
		model.put("Villagetypelist", VillageTypeNamesdao.getVillageType());
		model.put("VillageTypeNamesList", VillageTypeNamesdao.getVillageTypeNamesList(villageTypeNames.getCluster_id(),villageTypeNames.getType_id()));
		villageTypeNames.setName(null);
		model.addAttribute("VillageTypeNames", villageTypeNames);
		
		
		return new ModelAndView("addVillageTypeNames", "command", villageTypeNames);

	}
}

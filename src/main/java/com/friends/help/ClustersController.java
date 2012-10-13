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
import com.friends.help.forms.Clusters;
import com.friends.help.forms.District;
import com.friends.jsp.validate.Clustersvalidator;

@Controller
public class ClustersController {

	@Autowired
	Clustersvalidator clustersvalidator;
	@Autowired
	public Blockdao blockdao;

	@Autowired
	public Districtdao districtdao;
	
	@Autowired
	public Clustersdao clustersdao;
	
	@RequestMapping(value = "/Clustersadder.html", method = RequestMethod.GET)
	public ModelAndView initForm(ModelMap model) {

		Clusters clusters = new Clusters();
		model.addAttribute("clusters", clusters);
		return new ModelAndView("addClusters", "command", clusters);
	}
	
	@RequestMapping(value = "/Clustersadder.html", method = RequestMethod.POST)
	public ModelAndView processSubmit(@ModelAttribute("clusters") Clusters clusters,
			BindingResult result, SessionStatus status, ModelMap model) {
		
		clustersvalidator.setClusttersInValidator(clustersdao.getClustersObject(clusters.getCluster_name(),clusters.getBlock_id()));
		clustersvalidator.validate(clusters, result);

		if (result.hasErrors()) {
			return new ModelAndView("addClusters");
		} else {
			clusters.setBlock(blockdao.getBlockobjectbyID(clusters.getBlock_id()));
			clustersdao.addCluster(clusters);
			status.setComplete();
			model.put("BlockNameList",blockdao.getBlocks(clusters.getDistrict_id()));
			model.put("ClustersList", clustersdao.getClustersList(clusters.getBlock_id()));
			clusters.setCluster_name(null);
			model.addAttribute("clusters", clusters);
	
			return new ModelAndView("addClusters", "command", clusters);
		}
	}
	
	@ModelAttribute("DistrictNameList")
	public List<District> populateDistrictList() {

		List<District> DistrictNameList = new ArrayList<District>();

		DistrictNameList = districtdao.getAllDistricts();
		return DistrictNameList;
	}
	
	
	
	@RequestMapping(value = "/Blocknamesincluster.html", method = RequestMethod.POST)
	public ModelAndView getBlockname(@ModelAttribute("clusters") Clusters clusters,
			ModelMap model) {

		//System.out.println("In Post method of Blocknames");
		model.addAttribute("clusters", clusters);
		model.put("BlockNameList",blockdao.getBlocks(clusters.getDistrict_id())) ;
		return new ModelAndView("addClusters", "command", clusters);
		//return new ModelAndView(new RedirectView("Clustersadder.html"));
	}
	
	@RequestMapping(value = "/Clusternames.html", method = RequestMethod.POST)
	public ModelAndView getClusternames(@ModelAttribute("clusters") Clusters clusters,
			ModelMap model) {

		//System.out.println("In Post method of Blocknames");
		//model.addAttribute("clusters", clusters);
		model.put("BlockNameList",blockdao.getBlocks(clusters.getDistrict_id()));
		model.put("ClustersList", clustersdao.getClustersList(clusters.getBlock_id()));
		//clusters.setCluster_name(null);
		model.addAttribute("clusters", clusters);

		return new ModelAndView("addClusters", "command", clusters);
	}
	
	@RequestMapping(value = "/updateClusters{cluster_id}.html", method = RequestMethod.GET)
	public ModelAndView getUpdateDistrictPage(@PathVariable int cluster_id,ModelMap model) {
		Clusters clusters = clustersdao.getClustersObjectbyID(cluster_id);
		clusters.setDistrict_id(clusters.getBlock().getDistrict().getID());
		clusters.setBlock_id(clusters.getBlock().getBlock_id());
		model.addAttribute("clusters", clusters);
		model.put("BlockNameList",blockdao.getBlocks(clusters.getDistrict_id()));
		model.put("ClustersList", clustersdao.getClustersList(clusters.getBlock_id()));
		//clusters.setCluster_name(null);
		model.addAttribute("clusters", clusters);

		return new ModelAndView("addClusters", "command", clusters);

	}
	
	@RequestMapping(value = "/updateClusters.html", method = RequestMethod.POST)
	public ModelAndView updateBlock(@ModelAttribute("clusters") Clusters clusters,
			BindingResult result, SessionStatus status,ModelMap model) {
		clustersvalidator.setClusttersInValidator(clustersdao.getClustersObject(clusters.getCluster_name(),clusters.getBlock_id()));
		clustersvalidator.validate(clusters, result);

		if (result.hasErrors()) {
			return new ModelAndView("addClusters");
		} else {
			clusters.setBlock(blockdao.getBlockobjectbyID(clusters.getBlock_id()));
			clustersdao.updateCluster(clusters);
			status.setComplete();
			model.put("BlockNameList",blockdao.getBlocks(clusters.getDistrict_id()));
			model.put("ClustersList", clustersdao.getClustersList(clusters.getBlock_id()));
			clusters.setCluster_name(null);
			model.addAttribute("clusters", clusters);
	
			return new ModelAndView("addClusters", "command", clusters);
		}
		

	}
	
	@RequestMapping(value = "/deleteClusters{cluster_id}.html", method = RequestMethod.GET)
	public ModelAndView deleteDistrict(@PathVariable int cluster_id, ModelMap model) {

		Clusters clusters = new Clusters();
		//clusters(blockdao.getBlockobjectbyID(clusters.getBlock_id()));
		clusters = clustersdao.getClustersObjectbyID(cluster_id);
		clusters.setDistrict_id(clusters.getBlock().getDistrict().getID());
		clustersdao.deletClusterobject(clusters);
		model.put("BlockNameList",blockdao.getBlocks(clusters.getDistrict_id()));
		model.put("ClustersList", clustersdao.getClustersList(clusters.getBlock_id()));
		clusters.setCluster_name(null);
		
		model.addAttribute("clusters", clusters);

		
		
		return new ModelAndView("addClusters", "command", clusters);

	}

}

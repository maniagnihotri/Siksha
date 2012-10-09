package com.friends.help;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.friends.help.dao.Districtdao;
import com.friends.help.forms.Block;
import com.friends.help.forms.District;
import com.friends.jsp.validate.Blockvalidator;

@Controller
public class BlockController {

	@Autowired
	Blockvalidator blockvalidator;
	@Autowired
	public Blockdao blockdao;

	@Autowired
	public Districtdao districtdao;

	@RequestMapping(value = "/Blockadder.html", method = RequestMethod.GET)
	public ModelAndView initForm(ModelMap model) {
		Block block = new Block();
		model.addAttribute("block", block);
		return new ModelAndView("addBlock", "command", block);
	}

	@RequestMapping(value = "/Blocknames.html", method = RequestMethod.POST)
	public ModelAndView getBlockname(@ModelAttribute("block") Block block,
			HttpServletRequest httprequest, ModelMap model) {

		model.addAttribute("block", block);	
		//District dist = new District();
		//dist = districtdao.getDistrictbyID(block.getDistrict_id());
		//if(dist!=null){
			model.put("BlockList", blockdao.getBlocks(block.getDistrict_id()));	
		//}
		
		return new ModelAndView("addBlock", "command", block);

	}

	@ModelAttribute("DistrictNameList")
	public List<District> populateDistrictList() {

		List<District> DistrictNameList = new ArrayList<District>();

		DistrictNameList = districtdao.getAllDistricts();
		return DistrictNameList;
	}

	/*
	 * @ModelAttribute("DistrictNameList") public List<String>
	 * populateDistrictList() {
	 * 
	 * // Data referencing for web framework checkboxes List<String>
	 * DistrictNameList = new ArrayList<String>(); // DistrictEditOrAdder deoa =
	 * new DistrictEditOrAdder(); DistrictNameList =
	 * districtdao.getDistrictnames(); return DistrictNameList; }
	 */

	@RequestMapping(value = "/Blockadder.html", method = RequestMethod.POST)
	public ModelAndView processSubmit(@ModelAttribute("block") Block block,
			BindingResult result, SessionStatus status, ModelMap model) {
		blockvalidator.setBlockInValidator(blockdao.getBlockobject(
				block.getDistrict_id(), block.getBlock_name()));
		blockvalidator.validate(block, result);

		if (result.hasErrors()) {
			return new ModelAndView("addBlock");
		} else {
			block.setDistrict(districtdao.getDistrictbyID(block.getDistrict_id()));
			blockdao.addBlock(block);
			status.setComplete();
			model.put("BlockList", blockdao.getBlocks(block.getDistrict_id()));
			block.setBlock_name(null);
			model.addAttribute("block", block);
			return new ModelAndView("addBlock", "command", block);
		}
	}

	
	  @RequestMapping(value = "/updateBlock{block_id}.html", method
	  = RequestMethod.GET) 
	  public ModelAndView getUpdateDistrictPage(@PathVariable int block_id,
			  ModelMap model) {
	  
	  // District d = districtdao.getDistrict(name); 
	  Block block = blockdao.getBlockobjectbyID(block_id); 
	  model.addAttribute("block", block); 
	  model.put("BlockList", blockdao.getBlocks(block.getDistrict_id())); 
	  return new ModelAndView("addBlock", "command", block);
	  
	  }
	 

	
	  @RequestMapping(value = "/updateBlock.html", method = RequestMethod.POST)
	  public ModelAndView updateBlock(@ModelAttribute("block") Block block,
	  BindingResult result, SessionStatus status,ModelMap model) { //
	 
	 //districtvalidator.setDistInValidator(this.getdistrict(district.getDistrict_name()));
		  blockvalidator.setBlockInValidator(blockdao.getBlockobject(
					block.getDistrict_id(), block.getBlock_name()));
			blockvalidator.validate(block, result);
	  // districtvalidator.setActionString("UPDATE"); 
	  if (result.hasErrors()) {
	  return new ModelAndView("addBlock", "command", block); 
	  } 
	  else {
	  status.setComplete();
	  block.setDistrict(districtdao.getDistrictbyID(block.getDistrict_id()));
	  blockdao.updateBlock(block); 
	  model.put("BlockList", blockdao.getBlocks(block.getDistrict_id()));
		block.setBlock_name(null);
		model.addAttribute("block", block);
		return new ModelAndView("addBlock", "command", block);
	  }
	  
	  }
	 

	
	  @RequestMapping(value = "/deleteBlock{block_id}.html", method
	  = RequestMethod.GET) public ModelAndView deleteDistrict(@PathVariable
	  int block_id, ModelMap model) {
	  
	  
	  Block block = blockdao.getBlockobjectbyID(block_id); 
	  blockdao.deletBlockobject(block); 
	  model.put("BlockList", blockdao.getBlocks(block.getDistrict_id())); 
	  block.setBlock_name(null);
	  model.addAttribute("block", block); 
	  return new ModelAndView("addBlock","command", block);
	  
	  }
	 
}

package com.friends.help;

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
import org.springframework.web.servlet.view.RedirectView;

import com.friends.help.dao.Blockdao;
import com.friends.help.dao.Districtdao;
import com.friends.help.forms.District;
import com.friends.jsp.validate.Districtvalidator;

@Controller
public class DistrictEditOrAdder {

	@Autowired
	public Districtdao districtdao;
	
	@Autowired
	public Blockdao blockdao;
	
	@Autowired
	Districtvalidator districtvalidator;

	public Districtdao getDistrictdao() {
		return districtdao;
	}

	public void setDistrictdao(Districtdao districtdao) {
		this.districtdao = districtdao;
	}

	public List<String> getDistrictname() {
		return districtdao.getDistrictnames();
		// return null;
	}
	
	public District getdistrict(String districtname)
	{
		return districtdao.getDistrict(districtname);
		
	}

	@ModelAttribute("alldistricts")
	public List<District> getAllDistricts() {
		return districtdao.getAllDistricts();
		// return null;
	}

	@RequestMapping(value="/distView.html",method = RequestMethod.GET)
	public ModelAndView distView(ModelMap model) {
		District dist = new District();
		model.addAttribute("district", dist);
		return new ModelAndView("addDistrict", "command", dist);
	}

	@RequestMapping(value="/distView.html",method = RequestMethod.POST)
	public ModelAndView adddistrict(
			@ModelAttribute("district") District district,
			BindingResult result, SessionStatus status) {
		// System.out.println("District: "+district.getDistrict_name()+" Name: "+req.getParameter("name"));
			districtvalidator.setDistInValidator(this.getdistrict(district.getDistrict_name()));
			//districtvalidator.setActionString("ADD");
			districtvalidator.validate(district, result);
			if (result.hasErrors()) {
				return new ModelAndView("addDistrict");
			} else {
				//blockdao.addBlock(block);
				status.setComplete();
				//block.setBlock_name(null);
				
				districtdao.addDistrict(district);
				return new ModelAndView(new RedirectView("distView.html"));
			}
			
		
	}
	
	@RequestMapping(value="/updateDistrict{name}.html", method = RequestMethod.GET)
	public ModelAndView getUpdateDistrictPage(@PathVariable String name, ModelMap model) {
 
		District d = districtdao.getDistrict(name);
		model.addAttribute("district", d);
		return new ModelAndView("addDistrict","command",d);
 
	}
	@RequestMapping(value="/updateDistrict.html", method = RequestMethod.POST)
	public ModelAndView updateDistrict(@ModelAttribute("district") District district,
			BindingResult result, SessionStatus status) {
		districtvalidator.setDistInValidator(this.getdistrict(district.getDistrict_name()));
		districtvalidator.validate(district, result);
		//districtvalidator.setActionString("UPDATE");
		if (result.hasErrors()) {
			return new ModelAndView("addDistrict","command",district);
		} else {
			//blockdao.addBlock(block);
			status.setComplete();
			//block.setBlock_name(null);
			districtdao.updateDistrict(district);
			//District dist = new District();
			//model.addAttribute("district", dist);
			return new ModelAndView(new RedirectView("distView.html"));
		}
		//return new ModelAndView("addDistrict","command",new District());
 
	}

	@RequestMapping(value="/deleteDistrict{name}.html", method = RequestMethod.GET)
	public ModelAndView deleteDistrict(@PathVariable String name, ModelMap model) {
 
		District d = districtdao.getDistrict(name);
		//model.addAttribute("district", d);
		//if(blockdao.deleteBlocks(name))
		//{
		districtdao.deleteDistrict(d);
		//}
		return new ModelAndView(new RedirectView("distView.html"));
 
	}

}
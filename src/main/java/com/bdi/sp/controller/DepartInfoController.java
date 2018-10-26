package com.bdi.sp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdi.sp.service.DepartInfoService;
import com.bdi.sp.vo.Depart;

@Controller
public class DepartInfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartInfoController.class);
	
	@Autowired
	private DepartInfoService ds;
	
	@RequestMapping(value="/departs" ,method=RequestMethod.GET)
	public @ResponseBody List<Depart> getDepartList(@ModelAttribute Depart d){
		return ds.getDepartList(d);
	}
	
	@RequestMapping(value="/departs/{dino}" ,method=RequestMethod.GET)
	public @ResponseBody Depart getDepart(@PathVariable Integer dino) {
		return ds.getDepart(dino);
	} 
	@RequestMapping(value="/departs" ,method=RequestMethod.POST)
	public @ResponseBody int insertDepart(@RequestBody Depart d) {
		logger.debug("depart=>{}",d);
		return ds.saveInsertDepart(d);
	}
	@RequestMapping(value="/departs/{dino}" ,method=RequestMethod.DELETE)
	public @ResponseBody int deleteDepart(@RequestBody Depart d,@PathVariable Integer dino) {
		logger.debug("depart=>{}",d);
		return ds.deleteDepart(dino);
	}
	@RequestMapping(value="/departs/{dino}" ,method=RequestMethod.PUT)
	public @ResponseBody int updateDepart(@RequestBody Depart d,@PathVariable Integer dino) {
		logger.debug("depart=>{}",d);
		return ds.updateDepart(d);
	}
	

}

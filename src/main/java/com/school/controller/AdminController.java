package com.school.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.dao.AdminDao;
import com.school.dto.FeesClassesDto;

@Controller
public class AdminController {
	
	@Autowired
	public AdminDao adminDao;
	
	@RequestMapping("/classes")
	public String classes(Model model) {
		List<FeesClassesDto> classes = adminDao.listClasses();
		model.addAttribute("classes",classes);
		return "addClasses";
	}

	@RequestMapping("/addClasses")
	public String addClasses(@RequestParam("className") String className,@RequestParam("feesAmount") int feesAmount, @RequestParam("submittedBy") String submittedBy) {
	List<FeesClassesDto> classesList = 	adminDao.listClasses();
	if(!classesList.contains(className)) {
		adminDao.addClassesAndFees(className,feesAmount,submittedBy);
	}
		return "redirect:/classes";
	}
	
	
	@RequestMapping("/session")
	public String session(Model model) {
		List<String> session = adminDao.listSession();
		model.addAttribute("session", session);
		return "addSession";
	}
	
	@RequestMapping("/addsession")
	public String addSession(@RequestParam("sessionStart") Date sessionStart, @RequestParam("sessionEnd") Date sessionEnd) {
	List<String> sessionList = 	adminDao.listSession();
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy"); 
	System.out.println("start date "+df.format(sessionStart));
	
	if(!sessionList.contains(sessionStart+"-"+sessionEnd)) {
		adminDao.addSession(df.format(sessionStart), df.format(sessionEnd));	
	}
		return "redirect:/session";
	}
	

	@RequestMapping("/category")
	public String category(Model model) {
		List<String> category = adminDao.listCategory();
		model.addAttribute("category", category);
		return "addCategory";
	}
	
	@RequestMapping("/addcategory")
	public String addCategory(@RequestParam("category") String category) {
	List<String> categoryList = adminDao.listCategory();
	if(!categoryList.contains(category)) {
		adminDao.addCategory(category);	
	}
		return "redirect:/category";
	}
	

	@RequestMapping("/feestype")
	public String feestype(Model model) {
		List<String> feestype = adminDao.listfeestype();
		model.addAttribute("feestype", feestype);
		return "addFeesType";
	}
	
	@RequestMapping("/addfeestype")
	public String addfeestype(@RequestParam("feestype") String feestype) {
	List<String> feestypeList = adminDao.listfeestype();
	if(!feestypeList.contains(feestype)) {
		adminDao.addFeestype(feestype);	
	}
		return "redirect:/feestype";
	}
	
	@RequestMapping("/deletefeestype")
	public String delteFeesType(@RequestParam("feestype") String feestype) {
		adminDao.deleteFeesType(feestype);
		return "redirect:/feestype";
	}
	
	@RequestMapping("/deleteclasses")
	public String delteClasses(@RequestParam("classes") String classes) {
		adminDao.deleteClasses(classes);
		return "redirect:/classes";
	}
	
	
	@RequestMapping("/deletesession")
	public String delteSession(@RequestParam("session") String session) {
		System.out.println(session);
		String[]  sessionTime   = session.split("-");
		String startSession = sessionTime[0];
		String endSession = sessionTime[1];
		System.out.println("start sessin "+startSession+ " "+ "End Session"+endSession);
		adminDao.deleteSession(startSession, endSession);
		return "redirect:/session";
	}
	@RequestMapping("/deletecategory")
	public String delteCategory(@RequestParam("category") String category) {
		adminDao.deleteCategory(category);
		return "redirect:/category";
	}

}
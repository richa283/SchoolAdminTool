package com.school.controller;

import java.sql.Date;

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

}

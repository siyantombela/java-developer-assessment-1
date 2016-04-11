package com.assessment.ui;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GenresController {
	
	@RequestMapping(value="/genres",method= RequestMethod.GET)
	public String genres(Model model) {
		
		String pageTitle = "Genres";
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute("year",String.valueOf(year));
		
		return "main";
		
	}

}

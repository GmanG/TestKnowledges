package ua.home.testknowledge.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.home.testknowledge.entity.Question;
import ua.home.testknowledge.service.QuestionService;

/**
 * Handles requests for the application home page.
 */
//@Controller
//@RequestMapping("/home")
public class HomeController {
//	
//	@Autowired
//	private QuestionService questionService;	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
////	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		List<Question> qu = questionService.getQuestions();
////		model.addAttribute("qu", qu );
//		Question q = qu.get(0);
//		Gson gson  = new Gson();
//		String json = gson.toJson(q);
//		System.out.println(json);
//		
//		return "home";
//	}
	
}

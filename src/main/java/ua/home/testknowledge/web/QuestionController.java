package ua.home.testknowledge.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.home.testknowledge.entity.Question;
import ua.home.testknowledge.service.AnswerService;
import ua.home.testknowledge.service.QuestionService;



@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerService answerService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/addResult", method = RequestMethod.POST)
	public @ResponseBody
	String getTestResult(@RequestParam int id) {
		Map<String, String> answers = new TreeMap<String, String>();
		if (answerService.getAnswerById(id).getIsCorrect()) {
			answers.put("green", answerService.getAnswerById(id).getAnswer());
		}else{
			answers.put("red", answerService.getAnswerById(id).getAnswer());
		}
		ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = "";
		try {
			json = mapper.writeValueAsString(answers);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value = "/buildQuestion", method = RequestMethod.POST)
	public @ResponseBody
	String buildQuestion(@RequestParam int count) {
		ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		List<Question> listQuestions = questionService.getQuestions();
		String json = "";
		try {
			if(count != 5)
				json = mapper.writeValueAsString(listQuestions.get(count));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;

		
	}
}

package ua.home.testknowledge.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

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

import com.google.gson.Gson;

import ua.home.testknowledge.entity.Answer;
import ua.home.testknowledge.entity.Question;
import ua.home.testknowledge.service.AnswerService;
import ua.home.testknowledge.service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerService answerService;
	private StringBuffer res = new StringBuffer();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

//	@RequestMapping(value = "/addResult", method = RequestMethod.POST)
//	public @ResponseBody
//	String getTestResult(@RequestParam int id) {
////		TreeSet<String> answerResults = new TreeSet<String>();
//		res.setLength(0);
//		int ids = id;
//		System.out.println(ids+"-------------------------------------");
//		if (answerService.getAnswerById(id).getIsCorrect()) {
////			answerResults.add(res.append(
////					" <font color='green'> correct: "
////							+ answerService.getAnswerById(id).getAnswer()
////							+ "</font>").toString());
//			res.append(
//					" <font color='green'> correct: "
//							+ answerService.getAnswerById(id).getAnswer()
//							+ "</font>");
//		} else {
////			answerResults.add(res.append(
////					" <font color='red'> incorrect: "
////							+ answerService.getAnswerById(id).getAnswer()
////							+ "</font>").toString());
//			res.append(
//					" <font color='red'> incorrect: "
//							+ answerService.getAnswerById(id).getAnswer()
//							+ "</font>");
//		}
//		
////		return answerResults.toString().replaceAll("\\[|\\]", "");
//		return res.toString(); 
//	}
//
//	@RequestMapping(value = "/buildQuestion", method = RequestMethod.POST)
//	public @ResponseBody
//	String buildQuestion(@RequestParam int count) {
//		List<Question> listQuestions = questionService.getQuestions();
//		StringBuffer questionString = new StringBuffer();
//		if (count != 5) {
//			Question question = listQuestions.get(count);
//			int i = 1;
//			questionString.append("<h3>" + question.getQuestion() + "</h3>");
//			for (Answer answer : question.getAnswers()) {
//				questionString.append((i++)
//						+ ") <label>"
//						+ "<input type='checkbox' class='chkbox' name='chk' value='"
//						+ answer.getId() + "'>" + answer.getAnswer()
//						+ "</input></label><br>");
//			}
//		} else {
//			count = 0;
//		}
//		return questionString.toString();
//	}
	@RequestMapping(value = "/addResult", method = RequestMethod.POST)
	public @ResponseBody
	String getTestResult(@RequestParam int id) {
		boolean isCorrect = false;
		String s = "";
		Map<String, String> list = new TreeMap<String, String>();
		if (answerService.getAnswerById(id).getIsCorrect()) {
			isCorrect = true;
			s = answerService.getAnswerById(id).getAnswer();
			list.put("green",s);
		}else{
			s = answerService.getAnswerById(id).getAnswer();
			list.put("red",s);
		}
		Gson gson  = new Gson();
		String json = gson.toJson(list);
		return json;
	}
	@RequestMapping(value = "/buildQuestion", method = RequestMethod.GET)
	public @ResponseBody
	/*List<Question>*/ String buildQuestion(@RequestParam int count) {
		ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		List<Question> qu = questionService.getQuestions();
		System.out.println(count);
//		return qu;
		String json = "";
		try {
			if(count != 5)
				json = mapper.writeValueAsString(qu.get(count));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.print(json);
		return json;

		
	}
}

package ua.home.testknowledge.web;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
// @RequestMapping("/home")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerService answerService;
	Model model;
	private StringBuffer res = new StringBuffer();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("serverTime", "info");
		List<Question> ans = questionService.getQuestions();
		// Question an = ans.get(0);

		String s = ans.toString();

		System.out.println(s);
		// model.addAttribute("an", an);
		// Gson gson = new Gson();
		// String json = gson.toJson(s);
		// model.addAttribute("an", ans);
		// System.out.println(json);
		return "home";
	}

	// @RequestMapping(value = "/tarnsger", method = RequestMethod.GET)
	// public @ResponseBody void home2(@RequestParam String quy) {
	// res.append("On question<b id='question'> "+quy+"</b> result was:");
	// }
	@RequestMapping(value = "/ajaxtest1", method = RequestMethod.GET)
	public @ResponseBody
	String home2(@RequestParam int id, String quy) {
		TreeSet<String> ter = new TreeSet<String>();

		int ids = answerService.getAnswerById(id).getId();
//		res.append("<br>On question<b id='question'> "+quy+"</b> result was:");
		if (answerService.getAnswerById(id).getIsCorrect() == 1) {
			ter.add(res.append(
					" <font color='green'> correct: "
							+ answerService.getAnswerById(id).getAnswer()
							+ "</font>").toString());
		} else
			ter.add(res.append(
					" <font color='red'> incorrect: "
							+ answerService.getAnswerById(id).getAnswer()
							+ "</font>").toString());
//		 ter.add(res.append("<br>").toString());

		// res.append("On question<b id='question'> "+quy+"</b> result was:");

		res.setLength(0);

		return ter.toString().replaceAll("\\[|\\]", "");
	}

	@RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
	public @ResponseBody
	String home1(@RequestParam int count) {
		List<Question> qq = questionService.getQuestions();

		StringBuffer result = new StringBuffer();
		// String button ="<input type='button' class='next' value='Next'>";
		if (count != 5) {
			Question qu = qq.get(count);
			int i = 1;
			result.append("<h3>" + qu.getQuestion() + "</h3>");
			for (Answer answer : qu.getAnswers()) {
				result.append((i++)
						+ ") "
						+ "<input type='checkbox' class='chkbox' name='chk' value='"
						+ answer.getId() + "'>" + answer.getAnswer()
						+ "</input><br>");
			}
			// result.append(button);
			// result.append(res);

		} else {
			// result.append(res);
			count = 0;
			// res.setLength(0);
			// res.append("<hr>");
		}
		return result.toString();
	}
}

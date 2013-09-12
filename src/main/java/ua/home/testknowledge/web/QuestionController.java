package ua.home.testknowledge.web;

import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping(value = "/addResult", method = RequestMethod.POST)
	public @ResponseBody
	String getTestResult(@RequestParam int id) {
		TreeSet<String> answerResults = new TreeSet<String>();
		if (answerService.getAnswerById(id).getIsCorrect() == 1) {
			answerResults.add(res.append(
					" <font color='green'> correct: "
							+ answerService.getAnswerById(id).getAnswer()
							+ "</font>").toString());
		} else {
			answerResults.add(res.append(
					" <font color='red'> incorrect: "
							+ answerService.getAnswerById(id).getAnswer()
							+ "</font>").toString());
		}
		res.setLength(0);
		return answerResults.toString().replaceAll("\\[|\\]", "");
	}

	@RequestMapping(value = "/buildQuestion", method = RequestMethod.POST)
	public @ResponseBody
	String buildQuestion(@RequestParam int count) {
		List<Question> listQuestions = questionService.getQuestions();
		StringBuffer questionString = new StringBuffer();
		if (count != 5) {
			Question question = listQuestions.get(count);
			int i = 1;
			questionString.append("<h3>" + question.getQuestion() + "</h3>");
			for (Answer answer : question.getAnswers()) {
				questionString.append((i++)
						+ ") <label>"
						+ "<input type='checkbox' class='chkbox' name='chk' value='"
						+ answer.getId() + "'>" + answer.getAnswer()
						+ "</input></label><br>");
			}
		} else {
			count = 0;
		}
		return questionString.toString();
	}
}

package ua.home.testknowledge.dao;

import java.util.List;

import ua.home.testknowledge.entity.Answer;
import ua.home.testknowledge.entity.Question;

public interface QuestionDAO {

	public List<Question> getQuestions();
	
}

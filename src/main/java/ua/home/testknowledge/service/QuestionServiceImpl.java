package ua.home.testknowledge.service;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.home.testknowledge.dao.QuestionDAO;
import ua.home.testknowledge.entity.Answer;
import ua.home.testknowledge.entity.Question;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionDAO questionDAO;
	
	@Transactional
	public List<Question> getQuestions() {
		return questionDAO.getQuestions();
	}

}

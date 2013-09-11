package ua.home.testknowledge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.home.testknowledge.entity.Answer;
import ua.home.testknowledge.entity.Question;


public interface QuestionService {

	public List<Question> getQuestions();
	
}

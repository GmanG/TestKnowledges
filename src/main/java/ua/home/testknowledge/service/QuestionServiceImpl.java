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
		// TODO Auto-generated method stub
		return questionDAO.getQuestions();
	}

	
	private int generateQuesions(){
		Random random  = new Random();
		Set<Integer> list = new TreeSet<Integer>();
		int size  = questionDAO.getQuestions().size();
//		for (int i = 0; i <= 3; i++) {
//			list.add(random.nextInt(size));
//		}
		
		return  random.nextInt(size);
	}
	public Question getQuestion(int i){
//		Set<Integer> a = generateQuesions();
		
		return questionDAO.getQuestions().get(generateQuesions());
	} 

}

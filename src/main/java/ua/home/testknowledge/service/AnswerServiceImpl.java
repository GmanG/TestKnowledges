package ua.home.testknowledge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.home.testknowledge.dao.AnswerDAO;
import ua.home.testknowledge.entity.Answer;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerDAO answerDAO;
	@Override
	public Answer getAnswerById(int id)  {
		return answerDAO.getAnswerById(id);
	}

}

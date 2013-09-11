package ua.home.testknowledge.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.home.testknowledge.entity.Answer;
import ua.home.testknowledge.entity.Question;

@Repository
public class QuestionDAOImpl implements QuestionDAO {

	@Autowired
	private SessionFactory sessionFactory; 
	@Override
	public List<Question> getQuestions() {
		return sessionFactory.getCurrentSession().createQuery("select distinct q from Question q order by rand()").setMaxResults(5).list();
	}

	
}
 
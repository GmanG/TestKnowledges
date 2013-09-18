package ua.home.testknowledge.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.home.testknowledge.entity.Answer;

@Repository
public class AnswerDAOImpl implements AnswerDAO {
	@Autowired
	SessionFactory sessinFactory;

	@Override
	public Answer getAnswerById(int id)  {
		return  (Answer)sessinFactory.getCurrentSession().createQuery("from Answer a where a.id=:id").setParameter("id", id).uniqueResult();
	}

}
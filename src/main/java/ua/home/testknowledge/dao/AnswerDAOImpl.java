package ua.home.testknowledge.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.home.testknowledge.entity.Answer;

@Repository
public class AnswerDAOImpl implements AnswerDAO {
	@Autowired
	SessionFactory sessinFactory;

	@Override
	public Answer getAnswerById(int id)  {
		Session session = sessinFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Answer.class);
		criteria.add(Restrictions.eq("id", id));
		return (Answer) criteria.uniqueResult(); 
	}

}

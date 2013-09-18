package ua.home.testknowledge.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.home.testknowledge.entity.Question;



@Repository
public class QuestionDAOImpl implements QuestionDAO {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public List<Question> getQuestions() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Question.class);
		criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
		criteria.setMaxResults(5);
		return criteria.list();
//		return sessionFactory.getCurrentSession().createQuery("select distinct q from Question q order by rand()").setMaxResults(5).list();
	}

	
}
 
package ua.home.testknowledge.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Answer implements Serializable{


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue
	private int id;

	private String answer;

	private boolean isCorrect;

//	@ManyToOne(optional = false)
//	@JoinColumn(name="QuestionID")
//	@JsonBackReference("question-answer")
//	@JsonBackReference
	@JsonIgnore
//	@Transient
	@ManyToOne
	@JoinColumn(name="QuestionID")
	private Question question;

	public Answer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean getIsCorrect() {
		return this.isCorrect;
	}

	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

/*	public Question getQuestions() {
		return question;
	}

	public void setQuestions(Question question) {
		this.question = question;
	}*/
//
//	@Override
//	public String toString() {
//		return "Answer [id=" + id + ", answer=" + answer + ", isCorrect="
//				+ isCorrect + ", question=" + question + "]";
//	}

	@Override
	public String toString() {
		return "Answer {id:" + id + ", answer:" + answer + ", isCorrect:"
				+ isCorrect +  "}";
	}

}
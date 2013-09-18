package ua.home.testknowledge.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonManagedReference;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "Question")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Question implements Serializable{


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue
	private int id;

	private String question;


	@JsonManagedReference("question-answers")
//	@JsonManagedReference
//	@OneToMany(mappedBy="question")
	@OneToMany(mappedBy="question" , cascade = CascadeType.PERSIST)
//	@Transient
	private List<Answer> answers;

	public Question() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
//
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answers="
				+ answers + "]";
	}

}
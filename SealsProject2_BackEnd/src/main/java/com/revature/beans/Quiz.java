package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table

public class Quiz {

	//private Set<QuizResult> quizResult = new HashSet<QuizResult>();

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quizSequence")
	@SequenceGenerator(name = "quizSequence", allocationSize = 1, sequenceName = "SQ_QUIZ_PK")
	@Column(name = "QUIZ_ID")
	private int quizId;

	@Column
	@NaturalId
	private String quizName;

	@Column
	private int lockStatus;

	
	 @Lob
	 @Column(name = "question", columnDefinition = "CLOB")
	 //questions is a String of question ids to be parsed on the Angular side
	 private String questions;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User creator;

	public Quiz() {
		super();
	}

	public Quiz(String questions, User creator) {
		super();
		this.questions = questions;
		this.creator = creator;
	}

	public Quiz(String quizName, int lockStatus, String questions, User creator) {
		super();
		this.quizName = quizName;
		this.lockStatus = lockStatus;
		this.questions = questions;
		this.creator = creator;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public int getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(int lockStatus) {
		this.lockStatus = lockStatus;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + lockStatus;
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
		result = prime * result + quizId;
		result = prime * result + ((quizName == null) ? 0 : quizName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quiz other = (Quiz) obj;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (lockStatus != other.lockStatus)
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		if (quizId != other.quizId)
			return false;
		if (quizName == null) {
			if (other.quizName != null)
				return false;
		} else if (!quizName.equals(other.quizName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", quizName=" + quizName + ", lockStatus=" + lockStatus + ", questions="
				+ questions + ", creator=" + creator + "]";
	}
	
}	


package com.revature.beans;

import javax.persistence.*;

@Entity
@Table
public class QuizResult 
{
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User taker;
	
	public QuizResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	@ManyToOne
	@JoinColumn(name = "QUIZ_ID")
	private Quiz quiz;

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="quizResultSequence")
	@SequenceGenerator(name="quizResultSequence", allocationSize=1, sequenceName="SQ_QUIZRESULT_PK")
	private long id;
	
	//0 for fail, 1 for pass
	@Column
	private int result;

	/*
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")  
    public User getTaker() {
        return taker;
    }
    */
    public void setTaker(User taker) {
        this.taker = taker;
    }
 /*
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUIZ_ID")
    public Quiz getQuiz() {
        return quiz;
    }
	*/
    public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
    
    @Override
	public String toString() {
		return "QuizResult [taker=" + taker + ", quiz=" + quiz + ", id=" + id + ", result=" + result + "]";
	}
	public QuizResult(User taker, Quiz quiz, int id, int result) {
    	super();
    	this.taker = taker;
    	this.quiz = quiz;
    	this.id = id;
    	this.result = result;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + id);
		result = prime * result + ((quiz == null) ? 0 : quiz.hashCode());
		result = prime * result + this.result;
		result = prime * result + ((taker == null) ? 0 : taker.hashCode());
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
		QuizResult other = (QuizResult) obj;
		if (id != other.id)
			return false;
		if (quiz == null) {
			if (other.quiz != null)
				return false;
		} else if (!quiz.equals(other.quiz))
			return false;
		if (result != other.result)
			return false;
		if (taker == null) {
			if (other.taker != null)
				return false;
		} else if (!taker.equals(other.taker))
			return false;
		return true;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public User getTaker() {
		return taker;
	}
	public Quiz getQuiz() {
		return quiz;
	}
    
	
    
}
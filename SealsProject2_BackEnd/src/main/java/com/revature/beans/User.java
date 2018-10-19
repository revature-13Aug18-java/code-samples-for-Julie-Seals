package com.revature.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@Component
@Entity
@Table(name = "USER_TABLE")

public class User {

	//private Set<QuizResult> quizResult = new HashSet<QuizResult>();

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
	@SequenceGenerator(name = "userSequence", allocationSize = 1, sequenceName = "SQ_USER_PK")
	@Column(name = "USER_ID")
	private int userId;

	@Column
	private String username;
	
	@Column
	private String displayName;

	@Column
	private String pwd;

	@Column
	// To hold the number of quizzes a user has taken
	private int quizzesTaken;

	@Column
	// To hold the number of quizzes a user has passed
	private int quizzesPassed;

	/*
	@OneToMany(mappedBy = "taker")
	public Set<QuizResult> getQuizResult() {
		return quizResult;
	}
*/
	public User() {
		super();
	}

	public User(int userId, String displayName, String username, String pwd, int quizzesTaken, int quizzesPassed) {
		super();
		this.userId = userId;
		this.username = username;
		this.pwd = pwd;
		this.quizzesTaken = quizzesTaken;
		this.quizzesPassed = quizzesPassed;
		this.displayName = displayName;
	}
	
	public User(String displayName, String username, String pwd, int quizzesTaken, int quizzesPassed) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.quizzesTaken = quizzesTaken;
		this.quizzesPassed = quizzesPassed;
		this.displayName = displayName;
	}

	/*
	public void addQuizResult(QuizResult qr) {
		this.quizResult.add(qr);
	}
	*/
	
	public User(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String displayName) {
		this.username = username;
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getQuizzesTaken() {
		return quizzesTaken;
	}

	public void setQuizzesTaken(int quizzesTaken) {
		this.quizzesTaken = quizzesTaken;
	}

	public int getQuizzesPassed() {
		return quizzesPassed;
	}

	public void setQuizzesPassed(int quizzesPassed) {
		this.quizzesPassed = quizzesPassed;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + quizzesPassed;
		result = prime * result + quizzesTaken;
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (quizzesPassed != other.quizzesPassed)
			return false;
		if (quizzesTaken != other.quizzesTaken)
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", displayName=" + displayName + ", pwd=" + pwd
				+ ", quizzesTaken=" + quizzesTaken + ", quizzesPassed=" + quizzesPassed + "]";
	}
	
}
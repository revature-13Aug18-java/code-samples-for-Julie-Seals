package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table

public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="questSequence")
	@SequenceGenerator(name="questSequence", allocationSize=1, sequenceName="SQ_QUEST_PK")
	@Column(name="QUEST_ID")
	private int id;
	
	@Column
	private int questCat;
	
	@Column(name="QUEST_CONTENT")
	private String questContent;
	
	@Column(name="ANS_SET")
	private String ansSet;

	@Column(name="QUEST_ANS")
	private String questAns;
	

	public Question() {
		super();
	}


	public Question(int id, int questCat, String questContent, String ansSet, String questAns) {
		super();
		this.id = id;
		this.questCat = questCat;
		this.questContent = questContent;
		this.ansSet = ansSet;
		this.questAns = questAns;
	}


	public Question(int questCat, String questContent, String ansSet, String questAns) {
		super();
		this.questCat = questCat;
		this.questContent = questContent;
		this.ansSet = ansSet;
		this.questAns = questAns;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getQuestCat() {
		return questCat;
	}


	public void setQuestCat(int questCat) {
		this.questCat = questCat;
	}


	public String getQuestContent() {
		return questContent;
	}


	public void setQuestContent(String questContent) {
		this.questContent = questContent;
	}


	public String getAnsSet() {
		return ansSet;
	}


	public void setAnsSet(String ansSet) {
		this.ansSet = ansSet;
	}


	public String getQuestAns() {
		return questAns;
	}


	public void setQuestAns(String questAns) {
		this.questAns = questAns;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ansSet == null) ? 0 : ansSet.hashCode());
		result = prime * result + id;
		result = prime * result + ((questAns == null) ? 0 : questAns.hashCode());
		result = prime * result + questCat;
		result = prime * result + ((questContent == null) ? 0 : questContent.hashCode());
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
		Question other = (Question) obj;
		if (ansSet == null) {
			if (other.ansSet != null)
				return false;
		} else if (!ansSet.equals(other.ansSet))
			return false;
		if (id != other.id)
			return false;
		if (questAns == null) {
			if (other.questAns != null)
				return false;
		} else if (!questAns.equals(other.questAns))
			return false;
		if (questCat != other.questCat)
			return false;
		if (questContent == null) {
			if (other.questContent != null)
				return false;
		} else if (!questContent.equals(other.questContent))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Question [id=" + id + ", questCat=" + questCat + ", questContent=" + questContent + ", ansSet=" + ansSet
				+ ", questAns=" + questAns + "]";
	}
	
}

	
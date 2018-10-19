package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Question;
import com.revature.dao.QuestionDao;
import com.revature.dao.QuestionDaoImpl;

@Service
public class QuestionService {
	private QuestionDao qdi = new QuestionDaoImpl();
	
	public List<Question> findAllQuests() {
		return qdi.getQuestionList();
	}

	public Question findQuestById(int id) {
		return qdi.getQuestionById(id);
	}
	
	public List<Question> findQuestByCatId(int cat) {
		return qdi.getQuestionByCat(cat);
	}
	
	public Question addQuest(Question newQuest) {
		int questId = qdi.createQuestion(newQuest);
		return qdi.getQuestionById(questId);
	}
	
	public Question updateQuest(Question quest) {
		qdi.updateQuestion(quest);
		return quest;
	}

	public void deleteQuest(Question quest) {
		qdi.deleteQuestion(quest);
	}
	
	public void deleteQuestById(int id) {
		qdi.deleteQuestionById(id);
	}

}

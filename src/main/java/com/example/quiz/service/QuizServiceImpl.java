package com.example.quiz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	QuizRepository repository;

	@Override
	public Iterable<Quiz> selectAll() {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findAll();
	}

	@Override
	public Optional<Quiz> selectOneById(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findById(id);
	}

	@Override
	public Optional<Quiz> selectOneRandomQuiz() {
		// TODO 自動生成されたメソッド・スタブ
		Integer randId = repository.getRamdomId();
		
		if(randId == null) {
			return Optional.empty();
		}
		return repository.findById(randId);
	}

	@Override
	public Boolean checkQuiz(Integer id, Boolean myAnswer) {
		// TODO 自動生成されたメソッド・スタブ
		Boolean check = false;
		
		Optional<Quiz> optQuiz = repository.findById(id);
		
		if(optQuiz.isPresent()) {
			Quiz quiz = optQuiz.get();
			
			if(quiz.getAnswer().equals(myAnswer)) {
				check = true;
			}
		}
		return check;
	}

	@Override
	public void insertQuiz(Quiz quiz) {
		// TODO 自動生成されたメソッド・スタブ
		repository.save(quiz);

	}

	@Override
	public void updateQuiz(Quiz quiz) {
		// TODO 自動生成されたメソッド・スタブ
		repository.save(quiz);

	}

	@Override
	public void deleteQuizById(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		repository.deleteById(id);

	}

}

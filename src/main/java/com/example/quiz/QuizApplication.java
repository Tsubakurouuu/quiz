package com.example.quiz;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args).getBean(QuizApplication.class).execute();
	}
	
	@Autowired
	QuizRepository repository;
	
	private void execute() {
//		setup();
//		showList();
//		showOne();
//		updateQuiz();
		deleteQuiz();
	}
	
	private void setup() {
		Quiz quiz1 = new Quiz(null, "『Spring』はフレームワークですか？", true, "登録太郎");
		
		quiz1 = repository.save(quiz1);
		
		System.out.println("登録したデータは、" + quiz1 + "です。");
		
		Quiz quiz2 = new Quiz(null, "『Spring MVC』はバッチ処理を提供しますか？", false, "登録太郎");
		
		quiz2 = repository.save(quiz2);
		
		System.out.println("登録したデータは、" + quiz2 + "です。");
		
	}
	
	private void showList() {
		System.out.println("---全件取得開始---");
		
		Iterable<Quiz> quizzes = repository.findAll();
		for(Quiz quiz : quizzes) {
			System.out.println(quiz);
		}
		System.out.println("---全件取得完了---");
	}
	
	private void showOne() {
		System.out.println("---1件取得開始---");
		
		Optional<Quiz> quizOpt = repository.findById(1);
		if(quizOpt.isPresent()) {
			System.out.println(quizOpt.get());
		} else {
			System.out.println("該当する問題が存在しません・・・");
		}
		System.out.println("---1件取得完了---");
	}
	
	private void updateQuiz() {
		System.out.println("---更新処理開始---");
		
		Quiz quiz1 = new Quiz(1, "『スプリング』はフレームワークですか？", true, "変更タロウ");
		
		quiz1 = repository.save(quiz1);
		
		System.out.println("更新したデータは、" + quiz1 + "です。");
		System.out.println("---更新処理終了---");
	}
	
	private void deleteQuiz() {
		System.out.println("---削除処理開始---");
		repository.deleteById(2);
		System.out.println("---削除処理終了---");
	}
	
	

}

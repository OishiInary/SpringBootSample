package com.example.demo.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.model.Fortune;
import com.example.repository.FortuneRepository;

@Service
public class FortuneService {
	
	private final FortuneRepository fortuneRepository;
	
	//コンストラクタでリポジトリを注入
	public FortuneService(FortuneRepository fortuneRepository) {
		this.fortuneRepository = fortuneRepository;
	}
	
	public void saveFortuneResult(String result) {
		Fortune fortuneResult = new Fortune();
		fortuneResult.setResult(result);
	    // LocalDateTimeをTimestampに変換
	    Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
	    fortuneResult.setCreatedAt(timestamp); // setCreatedAtメソッドにTimestampを渡す

	    fortuneRepository.save(fortuneResult);
	}

}

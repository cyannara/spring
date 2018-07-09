package com.company.app.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import com.company.app.board.BoardService;


//@Component
public class Scheduler {
	
	@Autowired
	BoardService boardService;
	
	@Scheduled(cron = "0 0/1 11 * * *")
	public void cronTest1(){
		System.out.println("오전 11에 1분간격으로 실행됩니다 ");
	}	

	
	@Scheduled(cron = "0 0/1 11 * * *")
	public void cronTest2(){
		
	}	
}

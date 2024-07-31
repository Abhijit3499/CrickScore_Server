package com.crkscore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crkscore.Repository.CurrentStateRepository;
import com.crkscore.Repository.ScoreRepository;
import com.crkscore.model.CurrentState;
import com.crkscore.model.Score;


@RestController
@RequestMapping("/api")
public class ScoreController {
	static int i=0;

    @Autowired
    private ScoreRepository scoreRepository;
    

    @Autowired
    private CurrentStateRepository currentStateRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @CrossOrigin(origins = "https://crick-score-fe.vercel.app/")
    @GetMapping("/current-state")
    public CurrentState getCurrentState() {
        return currentStateRepository.findById(1L).orElse(new CurrentState());
    }
    @GetMapping("/runs")
    public Score getRuns() {
        return scoreRepository.findById(1L).orElse(new Score());
    }
    
    @CrossOrigin(origins = "https://crick-score-fe.vercel.app/")
    @PostMapping("/update-score")
    public void updateScore(@RequestBody Score score) {
    	
        CurrentState currentState = currentStateRepository.findById(1L).orElse(new CurrentState());
    	score.setRuns(currentState.getCurrentRuns()+score.getRunsScored());
        //scoreRepository.save(score);
        

        if (score.getRunsScored()==9) {
            currentState.setCurrentWickets(currentState.getCurrentWickets() + 1);
            currentState.setCurrentBallRun(score.getRunsScored());
        } else {
        	currentState.setCurrentBallRun(score.getRunsScored());
            currentState.setCurrentRuns(currentState.getCurrentRuns() + score.getRunsScored());
        }
        

        if (i == 6) {
            currentState.setCurrentOver(currentState.getCurrentOver() + 1);
            i=1;
            currentState.setCurrentBall(i);
            score.setBallNumber(i);
            
        } else {
            currentState.setCurrentBall(++i);
            score.setBallNumber(i);
        }
        scoreRepository.save(score);
        currentStateRepository.save(currentState);


        messagingTemplate.convertAndSend("/topic/scoreUpdate", currentState);
    }
   
}
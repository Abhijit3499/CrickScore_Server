package com.crkscore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crkscore.Repository.ScoreRepository;
import com.crkscore.model.Score;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public void updateScore(int runs) {
        // Fetch the current score from the database
        Score score = scoreRepository.findById(1L).orElse(new Score(1L,0,0));
        // Update the score
        score.setRunsScored(runs);
      
        score.setRuns(score.getRuns() + runs);
        // Save the updated score back to the database
        scoreRepository.save(score);
    }
}

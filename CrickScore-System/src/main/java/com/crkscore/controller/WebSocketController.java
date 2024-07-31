package com.crkscore.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.crkscore.model.CurrentState;
import com.crkscore.model.Score;

@CrossOrigin(origins = "https://your-vercel-domain.vercel.app")
@Controller
public class WebSocketController {

    @MessageMapping("/scoreUpdate")
    @SendTo("/topic/scoreUpdate")
    public CurrentState sendScoreUpdate(CurrentState currentState) {
        return currentState;
    }
    @MessageMapping("/runs")
    @SendTo("/topic/runs")
    public Score sendRuns(Score score) {
        return score;
    }
    
}

package com.crkscore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CurrentState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int currentRuns;
    private int currentWickets;
    private int currentOver;
    private int currentBall;
    private int currentBallRun;
    
    
	public int getCurrentBallRun() {
		return currentBallRun;
	}
	public void setCurrentBallRun(int currentBallRun) {
		this.currentBallRun = currentBallRun;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCurrentRuns() {
		return currentRuns;
	}
	public void setCurrentRuns(int currentRuns) {
		this.currentRuns = currentRuns;
	}
	public int getCurrentWickets() {
		return currentWickets;
	}
	public void setCurrentWickets(int currentWickets) {
		this.currentWickets = currentWickets;
	}
	public int getCurrentOver() {
		return currentOver;
	}
	public void setCurrentOver(int currentOver) {
		this.currentOver = currentOver;
	}
	public int getCurrentBall() {
		return currentBall;
	}
	public void setCurrentBall(int currentBall) {
		this.currentBall = currentBall;
	}

    
}
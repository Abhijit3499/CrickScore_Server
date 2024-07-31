package com.crkscore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int overNumber;
    private int ballNumber;
    private int runsScored;
    private boolean isOut;
    private int runs;
    private int wickets;

    public Score() {
    }

    public Score(Long id, int runs, int wickets) {
        this.id = id;
        this.runs = runs;
        this.wickets = wickets;
    }
    
	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getOverNumber() {
		return overNumber;
	}
	public void setOverNumber(int overNumber) {
		this.overNumber = overNumber;
	}
	public int getBallNumber() {
		return ballNumber;
	}
	public void setBallNumber(int ballNumber) {
		this.ballNumber = ballNumber;
	}
	public int getRunsScored() {
		return runsScored;
	}
	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}
	public boolean isOut() {
		return isOut;
	}
	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}

    
}
package com.example.webcalculator.model;


import javax.persistence.*;

@Entity
@Table(name= "numbers")
public class Numbers {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private long oneNumber;

    private long twoNumber;

    private long answer;

    public long getAnswer() {
        return answer;
    }

    public void setAnswer(long answer) {
        this.answer = answer;
    }

    public Numbers() {
    }

    public Numbers(long oneNumber, long twoNumber) {
        this.oneNumber = oneNumber;
        this.twoNumber = twoNumber;
    }

    public long getOneNumber() {
        return oneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOneNumber(long oneNumber) {
        this.oneNumber = oneNumber;
    }

    public long getTwoNumber() {
        return twoNumber;
    }

    public void setTwoNumber(long twoNumber) {
        this.twoNumber = twoNumber;
    }

    @Override
    public String toString() {
        return "" + answer;
    }
}

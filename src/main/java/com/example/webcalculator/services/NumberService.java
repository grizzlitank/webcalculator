package com.example.webcalculator.services;

import com.example.webcalculator.model.Numbers;
import com.example.webcalculator.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class NumberService {
    private static int counter;

    @Autowired
    private NumberRepository numberRepository;

    public void setOneNumber(long number){
        Numbers numbers = numberRepository.findOne(1);
        numbers.setOneNumber(number);
        numberRepository.save(numbers);
    }

    public void setTwoNumber(long number){
        Numbers numbers = numberRepository.findOne(1);
        numbers.setTwoNumber(number);
        numberRepository.save(numbers);
    }

    public void additionNumbers(){
        Numbers numbers = numberRepository.findOne(1);
        numbers.setAnswer(numbers.getOneNumber() + numbers.getTwoNumber());
        numberRepository.save(numbers);
    }

    public void multiplicationNumbers(){
        Numbers numbers = numberRepository.findOne(1);
        numbers.setAnswer(numbers.getOneNumber() * numbers.getTwoNumber());
        numberRepository.save(numbers);
    }

    public void differencNumbers(){
        Numbers numbers = numberRepository.findOne(1);
        numbers.setAnswer(numbers.getOneNumber() - numbers.getTwoNumber());
        numberRepository.save(numbers);
    }

    public void ratioNumbers(){
        Numbers numbers = numberRepository.findOne(1);
        numbers.setAnswer(numbers.getOneNumber() / numbers.getTwoNumber());
        numberRepository.save(numbers);
    }

    public Numbers getAnswer(){
        return numberRepository.findOne(1);
    }

    public void concat(int id) {

        Numbers numbers = numberRepository.findOne(1);

        if(id < 10) {//id кнопок "1, 2 - 0"
            String message = "" + numbers.getAnswer();
            if (numbers.getAnswer() != 0) {
                message += id;
            } else {
                message = "" + id;
            }

            numbers.setAnswer(Integer.parseInt(message));
            numberRepository.save(numbers);
        }
        if(id == 10){//id кнопки "+"
            numbers.setOneNumber(numbers.getOneNumber() + numbers.getAnswer());
            numbers.setAnswer(0);
            counter = 1;//значение счетчика для обозначения операции нахождения суммы
        }
        if(id == 11){//id кнопки "="
            numbers.setTwoNumber(numbers.getAnswer());
            switch (counter){
                case 1: this.additionNumbers();
                        break;
                case 2: this.multiplicationNumbers();
                        break;
                case 3: this.differencNumbers();
                        break;
                case 4: if(numbers.getTwoNumber() != 0) this.ratioNumbers();
                        break;
            }
            numbers.setOneNumber(0);
            numbers.setTwoNumber(0);
        }
        if(id == 12){//id кнопки "C"
            numbers.setAnswer(0);
        }
        if(id == 13){//id кнопки "*"
            if(numbers.getOneNumber() == 0) {
                numbers.setOneNumber(numbers.getAnswer());
            } else {
                numbers.setOneNumber(numbers.getOneNumber() * numbers.getAnswer());
            }
            numbers.setAnswer(0);
            counter = 2;//значение счетчика для обозначения операции нахождения произведения
        }
        if(id == 14){//id кнопки "-"
            if(numbers.getOneNumber() == 0) {
                numbers.setOneNumber(numbers.getAnswer());
            } else {
                numbers.setOneNumber(numbers.getOneNumber() - numbers.getAnswer());
            }
            numbers.setAnswer(0);
            counter = 3;//значение счетчика для обозначения операции нахождения разности
        }
        if(id == 15){//id кнопки "/"
            if(numbers.getOneNumber() == 0) {
                numbers.setOneNumber(numbers.getAnswer());
            } else {
                numbers.setOneNumber(numbers.getOneNumber() / numbers.getAnswer());
            }
            numbers.setAnswer(0);
            counter = 4;//значение счетчика для обозначения операции деления
        }
    }
}

package com.example.simplefinalfinalflashcard;

public class Question {
    private int answer;

    private boolean correctAnswer;

    public Question(int answer, boolean correctAnswer)
    {
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }

    public int getAnswer()
    {
        return answer;
    }

    public void setAnswer(int answer)
    {
        this.answer = answer;
    }

    public boolean isAnswerTrue()
    {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }
}

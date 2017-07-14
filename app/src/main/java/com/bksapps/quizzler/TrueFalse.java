package com.bksapps.quizzler;

/**
 * Created by spyde on 7/14/2017.
 */

public class TrueFalse {
    private int mQuestionID;
    private boolean mAnswer;

    public TrueFalse(int questionResourceId, boolean trueOrFalse){
        this.mQuestionID=questionResourceId;
        this.mAnswer=trueOrFalse;
    }

    public int getQuestionID() {
        return mQuestionID;
    }

    public void setQuestionID(int questionID) {
        mQuestionID = questionID;
    }

    public boolean getAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}

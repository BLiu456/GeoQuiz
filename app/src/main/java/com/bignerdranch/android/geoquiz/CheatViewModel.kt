package com.bignerdranch.android.geoquiz

import androidx.lifecycle.ViewModel

/*Bonus challenge of closing loopholes for cheaters
* All we really need to know is if the cheater pressed the show answer button
* When they do this class (because it is a viewModel the data will persist) will save a boolean value to indicate they cheated and
* saves what the cheated answer was so the CheatActivity can continue to display it*/
class CheatViewModel : ViewModel(){
    private var cheated = false
    private var answerText: Int = 1 //1 for a placeholder value

    fun setCheat(didCheat : Boolean){
        cheated = didCheat
    }

    fun getCheat(): Boolean{
        return cheated
    }

    fun getText(): Int {
        return answerText
    }

    fun checkAnswer(ansKey: Boolean){
        answerText = when {
            ansKey -> R.string.true_button
            else -> R.string.false_button
        }
    }
}
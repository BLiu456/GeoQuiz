package com.bignerdranch.android.geoquiz

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import java.lang.reflect.Array.get
import java.lang.reflect.Array.set

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
const val IS_CHEATER_KEY = "IS_CHEATER_KEY"

class QuizViewModel (private val savedStateHandle: SavedStateHandle) : ViewModel() {
    //Personalized quiz by simply adding more geography based questions
    private val questionBank = listOf(
        Question(R.string.question_australia, true, cheated = false),
        Question(R.string.question_oceans, true, cheated = false),
        Question(R.string.question_mideast, false, cheated = false),
        Question(R.string.question_southAmerica, true, cheated = false),
        Question(R.string.question_africa, false, cheated = false),
        Question(R.string.question_grandCanyon, false, cheated = false),
        Question(R.string.question_americas, true, cheated = false),
        Question(R.string.question_asia, true, cheated = false),
        Question(R.string.question_greenland, true, cheated = false),
        Question(R.string.question_ringLocale, false, cheated = false),
        Question(R.string.question_europe, false, cheated = false),
        Question(R.string.question_usa, false, cheated = false),
        Question(R.string.question_southHemi, false, cheated = false),
        Question(R.string.question_mariana, true, cheated = false),
        Question(R.string.question_japan, true, cheated = false)
    )
// isCheater variable no longer needed
//    var isCheater: Boolean
//        get() = savedStateHandle.get(IS_CHEATER_KEY) ?: false
//        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)

    private var currentIndex : Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionAnswer: Boolean get() = questionBank[currentIndex].answer
    val currentQuestionText: Int get() = questionBank[currentIndex].textResId
    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    //Added a previous button functionality for the challenge
    fun moveToPrev() {
        currentIndex = (currentIndex - 1) % questionBank.size
        //If index is a negative (i.e. they want to go back from the first question) wrap it around to the last question
        if (currentIndex < 0) {
            currentIndex = questionBank.size - 1
        }
    }
    //currentCheated will be passed a boolean variable from MainActivity to see if the user cheated on the current question
    fun currentCheated(didCheat: Boolean) {
        questionBank[currentIndex].cheated = didCheat
    }
    //Returns the boolean for if the user cheated on the current question
    fun getCheater(): Boolean{
        return  questionBank[currentIndex].cheated
    }
}
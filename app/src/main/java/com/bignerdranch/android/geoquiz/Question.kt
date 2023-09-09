package com.bignerdranch.android.geoquiz

import androidx.annotation.StringRes

/*As part of the challenge of tracking cheating by question,
* I decided to include an additional boolean variable cheated to the question data class
* This variable is what will now be updated when the user cheats rather than the original
* isCheater variable from the QuizViewModel.kt file*/
data class Question(@StringRes val textResId: Int, val answer: Boolean, var cheated: Boolean)
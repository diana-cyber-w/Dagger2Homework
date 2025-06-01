package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.navigator.Navigator
import javax.inject.Inject

class ProducerViewModel @Inject constructor(
    private val navigator: Navigator,
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context
) : ViewModel() {

    fun generateColor() {
        if (context !is Activity) throw RuntimeException("Activity context is required")
        Toast.makeText(context, "Color sent", Toast.LENGTH_SHORT).show()
        colorGenerator.generateColor()
        moveToReceiverFragment()
    }

    private fun moveToReceiverFragment() {
        navigator.openReceiverFragment()
    }
}

class ProducerViewModelFactory @Inject constructor(
    private val navigator: Navigator,
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ProducerViewModel(navigator, colorGenerator, context) as T
}
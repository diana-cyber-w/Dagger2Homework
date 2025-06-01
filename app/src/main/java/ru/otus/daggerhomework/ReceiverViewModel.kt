package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject

class ReceiverViewModel @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ApplicationContext private val context: Context
) : ViewModel() {

    fun observeColors(populateColor: (Int) -> Unit) {
        if (context !is Application) throw RuntimeException("Application context is required")
        viewModelScope.launch {
            colorGenerator.color.collect { color ->
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                populateColor(color)
            }
        }
    }
}

class ReceiverViewModelFactory @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ApplicationContext private val context: Context
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ReceiverViewModel(colorGenerator, context) as T
}
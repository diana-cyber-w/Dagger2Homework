package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ProducerViewModel
import ru.otus.daggerhomework.ProducerViewModelFactory
import ru.otus.daggerhomework.navigator.Navigator

@Module
class ProducerModule {

    @FragmentScope
    @Provides
    fun provideProducerViewModelFactory(
        @ActivityContext  context: Context,
        colorGenerator: ColorGenerator,
        navigator: Navigator
    ): ViewModelProvider.Factory {
        return ProducerViewModelFactory(navigator, colorGenerator, context)
    }
}
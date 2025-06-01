package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ReceiverViewModelFactory

@Module
class ReceiverModule {

    @FragmentScope
    @Provides
    fun provideReceiverViewModelFactory(
        @ApplicationContext context: Context,
        colorGenerator: ColorGenerator
    ): ViewModelProvider.Factory {
        return ReceiverViewModelFactory(colorGenerator, context)
    }
}
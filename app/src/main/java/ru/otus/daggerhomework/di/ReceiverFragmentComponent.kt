package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModelProvider
import dagger.Subcomponent
import ru.otus.daggerhomework.ReceiverFragment

@FragmentScope
@Subcomponent(modules = [ReceiverModule::class])
interface ReceiverFragmentComponent {

    @Subcomponent.Factory
    interface Factory {
        fun build(): ReceiverFragmentComponent
    }

    fun viewModelFactory(): ViewModelProvider.Factory

    fun inject(receiverFragment: ReceiverFragment)
}
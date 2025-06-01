package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModelProvider
import dagger.Subcomponent
import ru.otus.daggerhomework.ProducerFragment

@FragmentScope
@Subcomponent(modules = [ProducerModule::class])
interface ProducerFragmentComponent {

    @Subcomponent.Factory
    interface Factory {
        fun build(): ProducerFragmentComponent
    }

    fun viewModelFactory(): ViewModelProvider.Factory

    fun inject(producerFragment: ProducerFragment)
}
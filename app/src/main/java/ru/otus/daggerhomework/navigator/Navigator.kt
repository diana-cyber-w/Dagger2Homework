package ru.otus.daggerhomework.navigator

import ru.otus.daggerhomework.ProducerFragment
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.ReceiverFragment
import javax.inject.Inject

class Navigator @Inject constructor(
    private val fragmentManagerProvider: FragmentManagerProvider
) {
    fun openProducerFragment() {
        fragmentManagerProvider.provideFragmentManager().beginTransaction()
            .replace(R.id.fragment_container_view, ProducerFragment())
            .addToBackStack(null)
            .commit()
    }

    fun openReceiverFragment() {
        fragmentManagerProvider.provideFragmentManager().beginTransaction()
            .replace(R.id.fragment_container_view, ReceiverFragment())
            .addToBackStack(null)
            .commit()
    }
}
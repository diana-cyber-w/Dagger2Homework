package ru.otus.daggerhomework.navigator

import androidx.fragment.app.FragmentManager

interface FragmentManagerProvider {
    fun provideFragmentManager(): FragmentManager
}
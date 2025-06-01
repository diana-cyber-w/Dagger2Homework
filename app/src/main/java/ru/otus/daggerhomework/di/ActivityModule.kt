package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.navigator.FragmentManagerProvider

@Module
class ActivityModule(private val activity: MainActivity) {

    @Provides
    fun provideActivity(): MainActivity = activity

    @ActivityScope
    @Provides
    fun provideFragmentManagerProvider(activity: MainActivity): FragmentManagerProvider = activity

    @ActivityScope
    @Provides
    fun provideColorGenerator(): ColorGenerator = ColorGeneratorImpl()
}
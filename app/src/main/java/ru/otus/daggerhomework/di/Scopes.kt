package ru.otus.daggerhomework.di

import jakarta.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope
package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import ru.otus.daggerhomework.MainActivity

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun build(
            @BindsInstance
            @ActivityContext
            context: Context,
            activityModule: ActivityModule
        ): ActivityComponent
    }

    fun producerFragmentComponent(): ProducerFragmentComponent.Factory

    fun receiverFragmentComponent(): ReceiverFragmentComponent.Factory

    fun inject(activity: MainActivity)
}
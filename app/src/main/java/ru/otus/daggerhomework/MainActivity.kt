package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import ru.otus.daggerhomework.di.ActivityComponent
import ru.otus.daggerhomework.di.ActivityModule
import ru.otus.daggerhomework.di.ProducerFragmentComponent
import ru.otus.daggerhomework.di.ReceiverFragmentComponent
import ru.otus.daggerhomework.navigator.FragmentManagerProvider
import ru.otus.daggerhomework.navigator.Navigator

class MainActivity : AppCompatActivity(), FragmentManagerProvider {
    val navigator: Navigator = Navigator(this)
    lateinit var activityComponent: ActivityComponent
    lateinit var producerFragmentComponent: ProducerFragmentComponent
    lateinit var receiverFragmentComponent: ReceiverFragmentComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = (application as App).applicationComponent
            .activityComponent()
            .build(this, ActivityModule(this))
        producerFragmentComponent = activityComponent
            .producerFragmentComponent()
            .build()
        receiverFragmentComponent = activityComponent
            .receiverFragmentComponent()
            .build()
        activityComponent.inject(this)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.openProducerFragment()
        }
    }

    override fun provideFragmentManager(): FragmentManager = supportFragmentManager
}
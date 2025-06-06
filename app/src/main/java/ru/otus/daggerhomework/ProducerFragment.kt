package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.ProducerFragmentComponent

class ProducerFragment : Fragment() {
    private lateinit var producerFragmentComponent: ProducerFragmentComponent
    private lateinit var viewModel: ProducerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        producerFragmentComponent = (activity as MainActivity).producerFragmentComponent

        producerFragmentComponent.inject(this)
        viewModel = ViewModelProvider(
            this,
            producerFragmentComponent.viewModelFactory()
        )[ProducerViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_producer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
    }
}
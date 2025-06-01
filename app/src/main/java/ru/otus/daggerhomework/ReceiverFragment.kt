package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.ReceiverFragmentComponent

class ReceiverFragment : Fragment() {
    private lateinit var receiverFragmentComponent: ReceiverFragmentComponent
    private lateinit var viewModel: ReceiverViewModel
    private lateinit var frame: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        receiverFragmentComponent = (activity as MainActivity).receiverFragmentComponent

        receiverFragmentComponent.inject(this)
        viewModel = ViewModelProvider(
            this,
            receiverFragmentComponent.viewModelFactory()
        )[ReceiverViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.receiverFrame)
        viewModel.observeColors { color ->
            populateColor(color)
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}
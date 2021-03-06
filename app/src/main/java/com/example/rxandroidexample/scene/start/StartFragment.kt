package com.example.rxandroidexample.scene.start

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.rxandroidexample.databinding.FragmentStartBinding
import com.example.rxandroidexample.util.SingleLiveEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : Fragment() {

    companion object {
        fun newInstance() = StartFragment()
    }

    private lateinit var binding: FragmentStartBinding
    private val viewModel: StartViewModel by viewModels {
        StartViewModel.Factory(navEen, startActivityEvent)
    }

    private val navEen: SingleLiveEvent<NavDirections> = SingleLiveEvent()
    private val startActivityEvent : SingleLiveEvent<Class<out Activity>> = SingleLiveEvent()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initialize()
    }

    private fun initialize() {
        navEen.observe(this.viewLifecycleOwner) {
            findNavController().navigate(it)
        }

        startActivityEvent.observe(this.viewLifecycleOwner) {
            requireActivity().startActivity(Intent(context, it))
        }
    }


}
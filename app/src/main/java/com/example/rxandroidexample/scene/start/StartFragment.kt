package com.example.rxandroidexample.scene.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rxandroidexample.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    companion object {
        fun newInstance() = StartFragment()
    }

    private lateinit var binding: FragmentStartBinding
    private lateinit var viewModel: StartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.moveSecondFragmentButton.setOnClickListener {
            findNavController().navigate(StartFragmentDirections.actionMainFragmentToSecondFragment())
        }

        binding.moveTodoFragmentButton.setOnClickListener {
            findNavController().navigate(StartFragmentDirections.actionMainFragmentToTodoListFragment())
        }

        return binding.root
    }

}
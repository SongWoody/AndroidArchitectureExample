package com.example.rxandroidexample.scene.main.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rxandroidexample.R
import com.example.rxandroidexample.scene.main.MainActivity
import javax.inject.Inject
import javax.inject.Named


class MainFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var sharedPreferences: SharedPreferences
    @Inject
    lateinit var activityName: String
    @Inject
    @JvmField
    var randomNumber: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as? MainActivity)?.let {
            it.component
                .mainFragmentComponentBuilder
                .setModule(MainFragmentModule())
                .setFragment(this)
                .build()
                .inject(this)
        }

        Log.i("MainFragment",activityName)
        Log.i("MainFragment","Random Number: $randomNumber")
        Log.i("MainFragment","Random Number: $randomNumber")
        Log.i("MainFragment","Random Number: $randomNumber")
    }
}
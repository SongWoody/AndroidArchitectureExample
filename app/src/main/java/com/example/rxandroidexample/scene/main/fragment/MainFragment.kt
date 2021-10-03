package com.example.rxandroidexample.scene.main.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rxandroidexample.R
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Named


class MainFragment : DaggerFragment() {
    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    @Named("app")
    @Inject
    lateinit var appName: String
    @Named("activity")
    @Inject
    lateinit var activityName: String
    @Named("fragment")
    @Inject
    lateinit var fragmentName: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
        Log.i("MainFragment", appName)
        Log.i("MainFragment", activityName)
        Log.i("MainFragment", fragmentName)
    }
}
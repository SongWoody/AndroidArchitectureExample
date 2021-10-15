package com.example.rxandroidexample.view

import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView

class CustomRecyclerViewAdapter: RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomVH {

    }

    override fun onBindViewHolder(holder: CustomVH, position: Int) {

    }

    override fun getItemCount(): Int {

    }

    class CustomVH(view: View): RecyclerView.ViewHolder(view) {

    }
}
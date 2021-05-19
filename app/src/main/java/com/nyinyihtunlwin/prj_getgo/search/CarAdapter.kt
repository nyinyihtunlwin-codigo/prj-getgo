package com.nyinyihtunlwin.prj_getgo.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nyinyihtunlwin.prj_getgo.base.BaseRecyclerAdapter
import com.nyinyihtunlwin.prj_getgo.base.BaseViewHolder
import com.nyinyihtunlwin.prj_getgo.databinding.ViewItemCarBinding

class CarAdapter(context: Context, var carDelegate: CarDelegate) :
    BaseRecyclerAdapter<CarViewHolder, Car>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Car> {
        val binding =
            ViewItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding, carDelegate)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Car>, position: Int) {

    }
}
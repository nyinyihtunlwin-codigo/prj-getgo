package com.nyinyihtunlwin.prj_getgo.search

import android.view.View
import com.nyinyihtunlwin.prj_getgo.base.BaseViewHolder
import com.nyinyihtunlwin.prj_getgo.databinding.ViewItemCarBinding

class CarViewHolder(
    val binding: ViewItemCarBinding,
    var carDelegate: CarDelegate
) : BaseViewHolder<Car>(binding.root) {

    override fun setData(data: Car) {
        mData = data
    }

    override fun onClick(v: View?) {
        carDelegate.onTapCar(mData!!)
    }
}
package com.example.recyclerview.nested_rv

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.RawInnerDiatPlanBinding


@SuppressLint("NotifyDataSetChanged")
class InnerDiatPlanAdapter(var context: Context, var clickListener: View.OnClickListener) :
    RecyclerView.Adapter<InnerDiatPlanAdapter.Holder>() {

    var objList: ArrayList<DietPlanModel.DietPlanItem> = ArrayList()

    inner class Holder(val binding: RawInnerDiatPlanBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            RawInnerDiatPlanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return objList.size
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = objList[position]
        holder.binding.apply {
            tvTitle.text = item.diatTitle
            imgDiatPlan.setImageResource(item.defaultImage)

            btnLog.tag = position
            btnLog.setOnClickListener(clickListener)

            btnAlternative.tag = position
            btnAlternative.setOnClickListener(clickListener)

            if (position == objList.size - 1) {
                viewDietPlan.visibility = View.GONE
            } else {
                viewDietPlan.visibility = View.VISIBLE
            }
        }

    }

    fun addData(mObj: ArrayList<DietPlanModel.DietPlanItem>) {
        objList = ArrayList()
        objList.addAll(mObj)
        this.notifyDataSetChanged()
    }

}
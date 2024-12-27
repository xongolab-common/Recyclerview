package com.example.recyclerview.nested_rv

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.RawOuterDiatPlanBinding


@SuppressLint("NotifyDataSetChanged")
class OuterDiatPlanAdapter(var context: Context, var clickListener: View.OnClickListener) :
    RecyclerView.Adapter<OuterDiatPlanAdapter.Holder>() {

    var objList: ArrayList<DietPlanModel> = ArrayList()

    inner class Holder(val binding: RawOuterDiatPlanBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            RawOuterDiatPlanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return objList.size
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = objList[position]
        holder.binding.apply {

            tvPlanName.text = item.planName

            val innerAdapter = InnerDiatPlanAdapter(context, clickListener)
            rvInnerDiatPlan.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rvInnerDiatPlan.adapter = innerAdapter

            innerAdapter.addData(item.dietPlanItem)

            rvInnerDiatPlan.tag = position
            rvInnerDiatPlan.setOnClickListener(clickListener)

        }

    }


    fun addData(mObj: ArrayList<DietPlanModel>) {
        objList = ArrayList()
        objList.addAll(mObj)
        this.notifyDataSetChanged()
    }

}
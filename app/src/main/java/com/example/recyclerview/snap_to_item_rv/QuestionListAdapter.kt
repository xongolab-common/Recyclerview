package com.example.recyclerview.snap_to_item_rv

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.UserModel
import com.example.recyclerview.databinding.RawQuestionBinding

@SuppressLint("NotifyDataSetChanged")
class QuestionListAdapter(var context: Context, var clickListener: View.OnClickListener) : RecyclerView.Adapter<QuestionListAdapter.Holder>() {

    var objList: ArrayList<UserModel> = ArrayList()
    private lateinit var option3ListAdapter: Option3ListAdapter

    inner class Holder(val binding: RawQuestionBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RawQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return objList.size
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = objList[position]
        holder.binding.apply {
            //tvQuestion.text = "${item.question}"
            option3ListAdapter = Option3ListAdapter(context, clickListener)
            rvQuestionOption.layoutManager = LinearLayoutManager(context)
            rvQuestionOption.adapter = option3ListAdapter
            option3ListAdapter.addData(item.options)

       /*     clOption.tag = position
            clOption.setOnClickListener(clickListener)*/
        }
    }

    fun addData(mObj: ArrayList<UserModel>) {
        objList = ArrayList()
        objList.addAll(mObj)
        this.notifyDataSetChanged()
    }
}
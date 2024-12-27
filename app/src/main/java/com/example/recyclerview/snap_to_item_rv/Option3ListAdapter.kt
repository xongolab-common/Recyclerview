package com.example.recyclerview.snap_to_item_rv

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.UserModel
import com.example.recyclerview.databinding.RawQuestionOption3Binding


@SuppressLint("NotifyDataSetChanged")
class Option3ListAdapter(var context: Context, var clickListener: View.OnClickListener) : RecyclerView.Adapter<Option3ListAdapter.Holder>() {

    var objList: ArrayList<UserModel.OptionsModel> = ArrayList()

    inner class Holder(val binding: RawQuestionOption3Binding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RawQuestionOption3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return objList.size
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = objList[position]
        holder.binding.apply {
            tvOption.text = "${item.label}"

            ivRadio.setImageResource(if (item.isSelect) R.drawable.ic_fill_radio else R.drawable.ic_unfill_radio)
            clOption.setBackgroundResource(if (item.isSelect) R.drawable.dr_selected_border_10 else R.drawable.dr_gray_border_10)

            clOption.tag = position
            clOption.setOnClickListener { view ->
                // Deselect all options
                objList.forEach { it.isSelect = false }
                // Select the current option
                item.isSelect = true
                notifyDataSetChanged()

                // Notify parent view (Question4Activity) of selection
                clickListener.onClick(view)
            }
        }
    }

    fun addData(mObj: ArrayList<UserModel.OptionsModel>) {
        objList = ArrayList()
        objList.addAll(mObj)
        this.notifyDataSetChanged()
    }
}
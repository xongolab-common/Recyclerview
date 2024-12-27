package com.example.recyclerview.nested_rv

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ActivityNestedRecyclerviewBinding


class NestedRecyclerviewActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityNestedRecyclerviewBinding
    private lateinit var outerDiatPlanAdapter: OuterDiatPlanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNestedRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnAlternative -> {
            }
        }
    }

    private fun initView() {

        outerDiatPlanAdapter = OuterDiatPlanAdapter(this, this)

        binding.rvOuterDietPlan.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvOuterDietPlan.adapter = outerDiatPlanAdapter
        diatPlanList()
    }


    private fun diatPlanList() {
        outerDiatPlanAdapter.objList = ArrayList()

        var model = DietPlanModel().apply {
            planName = "When You Wake up"
            title = "Log Slot"
            dietPlanItem = arrayListOf(
                DietPlanModel.DietPlanItem(
                    R.drawable.img_diat,
                    "Overnight Socked Methi Water/Overnight Soaked Fenugreek Seeds Water",
                    "1 Glass - 245ml / 0 Kcal"
                ),
                DietPlanModel.DietPlanItem(
                    R.drawable.img_diat,
                    "Overnight Socked Methi Water/Overnight Soaked Fenugreek Seeds Water",
                    "1 Glass - 245ml / 0 Kcal"
                ),
                DietPlanModel.DietPlanItem(
                    R.drawable.img_diat,
                    "Overnight Socked Methi Water/Overnight Soaked Fenugreek Seeds Water",
                    "1 Glass - 245ml / 0 Kcal"
                ),
            )
        }
        outerDiatPlanAdapter.objList.add(model)

        model = DietPlanModel().apply {
            planName = "Before Breakfast"
            title = "Logged"
            dietPlanItem = arrayListOf(
                DietPlanModel.DietPlanItem(
                    R.drawable.img_diat,
                    "Overnight Socked Methi Water/Overnight Soaked Fenugreek Seeds Water",
                    "1 Glass - 245ml / 0 Kcal"
                ),
                DietPlanModel.DietPlanItem(
                    R.drawable.img_diat,
                    "Overnight Socked Methi Water/Overnight Soaked Fenugreek Seeds Water",
                    "1 Glass - 245ml / 0 Kcal"
                ),
                DietPlanModel.DietPlanItem(
                    R.drawable.img_diat,
                    "Overnight Socked Methi Water/Overnight Soaked Fenugreek Seeds Water",
                    "1 Glass - 245ml / 0 Kcal"
                ),
                DietPlanModel.DietPlanItem(
                    R.drawable.img_diat,
                    "Overnight Socked Methi Water/Overnight Soaked Fenugreek Seeds Water",
                    "1 Glass - 245ml / 0 Kcal"
                ),
            )
        }
        outerDiatPlanAdapter.objList.add(model)

        model = DietPlanModel().apply {
            planName = "Dinner"
            title = "Logged"
            dietPlanItem = arrayListOf(
                DietPlanModel.DietPlanItem(
                    R.drawable.img_diat,
                    "Overnight Socked Methi Water/Overnight Soaked Fenugreek Seeds Water",
                    "1 Glass - 245ml / 0 Kcal"
                ),
                DietPlanModel.DietPlanItem(
                    R.drawable.img_diat,
                    "Overnight Socked Methi Water/Overnight Soaked Fenugreek Seeds Water",
                    "1 Glass - 245ml / 0 Kcal"
                ),
            )
        }
        outerDiatPlanAdapter.objList.add(model)

        outerDiatPlanAdapter.addData(outerDiatPlanAdapter.objList)
    }
}


data class DietPlanModel(
    var planName: String = "",
    var title: String = "",
    var dietPlanItem: ArrayList<DietPlanItem> = ArrayList()
) {

    data class DietPlanItem(
        val defaultImage: Int = 0,
        var diatTitle: String = "",
        var dietDesc: String = "",
    )
}
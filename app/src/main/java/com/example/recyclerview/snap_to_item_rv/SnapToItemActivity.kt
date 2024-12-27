package com.example.recyclerview.snap_to_item_rv

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.recyclerview.R
import com.example.recyclerview.UserModel
import com.example.recyclerview.databinding.ActivitySnapToItemBinding

class SnapToItemActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySnapToItemBinding
    private lateinit var questionListAdapter: QuestionListAdapter

    private var currentIndex: Int = 0
    private var lastPos: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySnapToItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView(){

        binding.btnContinue.setOnClickListener(this)

        questionListAdapter = QuestionListAdapter(this, this)
        binding.rvQuestion.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.rvQuestion.adapter = questionListAdapter

        // Snap to one item at a time
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.rvQuestion)

        setDummyData()

    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnContinue -> {
                Toast.makeText(this, "Option submitted", Toast.LENGTH_SHORT).show()
            }

            R.id.clOption -> {
                lastPos = Integer.parseInt(view.tag.toString())

                // Mark the selected option for the current question
                val currentQuestion = questionListAdapter.objList[currentIndex]
                currentQuestion.options.forEach { it.isSelect = false }
                currentQuestion.options[lastPos].isSelect = true
                questionListAdapter.notifyItemChanged(currentIndex)

                // If all questions have a selected option, enable "Continue" button
                val allQuestionsAnswered = questionListAdapter.objList.all { question ->
                    question.options.any { it.isSelect }
                }

                if (allQuestionsAnswered) {
                    binding.btnContinue.isEnabled = true
                    binding.btnContinue.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.colorPrimary)
                    binding.btnContinue.text = "Next"
                }

                // Scroll to the next question if it's not the last one
                if (currentIndex < questionListAdapter.objList.size - 1) {
                    currentIndex++
                    binding.rvQuestion.smoothScrollToPosition(currentIndex)
                    binding.btnContinue.text = "Next"
                }

            }
        }

    }

    private fun setDummyData() {
        val dummyData = ArrayList<UserModel>()

        for (i in 1..5) {
            val options = ArrayList<UserModel.OptionsModel>()
            for (j in 1..4) {
                options.add(UserModel.OptionsModel("Option $j", false))
            }

            dummyData.add(UserModel("Question $i", options))
        }

        questionListAdapter.addData(dummyData)
    }

}
package com.example.recyclerview.viewpager_rv

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityViewPagerBinding

    enum class TabType {
        ALL, ONGOING, DELIVERED
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    override fun onClick(view: View) {
       when(view.id){
           R.id.llAll -> selectTab(TabType.ALL)
           R.id.llOngoing -> selectTab(TabType.ONGOING)
           R.id.llDelivered -> selectTab(TabType.DELIVERED)
       }
    }

    private fun initView(){

        binding.llAll.setOnClickListener(this)
        binding.llOngoing.setOnClickListener(this)
        binding.llDelivered.setOnClickListener(this)

        selectTab(TabType.ALL)
    }

    private fun selectTab(tab: TabType) {
        resetTabs()

        when (tab) {
            TabType.ALL -> {
               // Call Api according to status
                binding.viewAll.visibility = View.VISIBLE
                binding.tvAll.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
            }

            TabType.ONGOING -> {
                // Call Api according to status
                binding.viewOngoing.visibility = View.VISIBLE
                binding.tvOngoing.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
            }

            TabType.DELIVERED -> {
                // Call Api according to status
                binding.viewDelivered.visibility = View.VISIBLE
                binding.tvDelivered.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
            }
        }
    }

    private fun resetTabs() {
        // Reset all views
        binding.viewAll.visibility = View.INVISIBLE
        binding.viewOngoing.visibility = View.INVISIBLE
        binding.viewDelivered.visibility = View.INVISIBLE

        // Reset text colors
        binding.tvAll.setTextColor(ContextCompat.getColor(this, R.color.colorSecondary))
        binding.tvOngoing.setTextColor(ContextCompat.getColor(this, R.color.colorSecondary))
        binding.tvDelivered.setTextColor(ContextCompat.getColor(this, R.color.colorSecondary))

    }
}
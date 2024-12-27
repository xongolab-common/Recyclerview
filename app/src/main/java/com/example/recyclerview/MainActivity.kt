package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.nested_rv.NestedRecyclerviewActivity
import com.example.recyclerview.snap_to_item_rv.SnapToItemActivity
import com.example.recyclerview.viewpager_rv.ViewPagerActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSnapToItem.setOnClickListener {
            startActivity(Intent(this, SnapToItemActivity::class.java))
        }

        binding.tvNestedRecyclerview.setOnClickListener {
            startActivity(Intent(this, NestedRecyclerviewActivity::class.java))
        }

        binding.tvViewpagerRecyclerview.setOnClickListener {
            startActivity(Intent(this, ViewPagerActivity::class.java))
        }
    }
}
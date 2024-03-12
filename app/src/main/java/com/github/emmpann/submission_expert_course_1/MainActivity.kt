package com.github.emmpann.submission_expert_course_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.emmpann.submission_expert_course_1.databinding.ActivityMainBinding
import com.github.emmpann.submission_expert_course_1.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, HomeFragment())
                .commit()
        }
    }
}
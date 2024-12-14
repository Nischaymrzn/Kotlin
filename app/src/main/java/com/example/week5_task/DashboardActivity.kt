package com.example.week5_task

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week5_task.adapter.LanguageAdapter
import com.example.week5_task.databinding.ActivityDashboardBinding
import com.example.week5_task.databinding.ActivityLoginBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDashboardBinding
    private var imageList=ArrayList<Int>()
    private var titleList=ArrayList<String>()
    private var descList=ArrayList<String>()

    private lateinit var adapter: LanguageAdapter
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imageList.add(R.drawable.kotlin)
        imageList.add(R.drawable.python)
        imageList.add(R.drawable.javascript)
        imageList.add(R.drawable.java)
        imageList.add(R.drawable.go)
        imageList.add(R.drawable.c)

        titleList.add("Kotlin")
        titleList.add("Python")
        titleList.add("Java Script")
        titleList.add("Java")
        titleList.add("Go")
        titleList.add("C++")

        descList.add("Modern language for Android development")
        descList.add("Popular for AI, Data Science")
        descList.add("The backbone of interactive web pages")
        descList.add("Widely used for enterprise applications")
        descList.add("Fast and efficient for scalable applications")
        descList.add("High-performance language for games")



        val fullName = intent.getStringExtra("fullName") ?: ""
        val emailData = intent.getStringExtra("email") ?: ""
        val passwordData = intent.getStringExtra("password") ?: ""
        val countryData = intent.getStringExtra("country") ?: ""
        val cityData = intent.getStringExtra("city") ?: ""
        val genderData = intent.getStringExtra("gender") ?: ""

        binding.nameText.text="Welcome back, $fullName"
        binding.email.text="Email : $emailData"
        binding.gender.text="Gender : $genderData"
        binding.country.text="Country : $countryData"
        binding.city.text="City : $cityData"

        adapter=LanguageAdapter(
            this@DashboardActivity,
            imageList,
            titleList,
            descList
        )

        binding.languageRecycler.adapter=adapter
        binding.languageRecycler.layoutManager= LinearLayoutManager(this@DashboardActivity,LinearLayoutManager.VERTICAL,false)





    }
}
package com.example.homework1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.homework1.MainActivity.Companion.EMAIL_ARG
import com.example.homework1.MainActivity.Companion.MESSAGE_ARG
import com.example.homework1.databinding.ActivityMainBinding
import com.example.homework1.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvEmail.text = intent.extras?.getString(EMAIL_ARG)
        binding.tvMessage.text = intent.extras?.getString(MESSAGE_ARG)

        binding.btnClear.setOnClickListener {
            binding.tvEmail.text = ""
            binding.tvMessage.text = ""
        }
    }
}
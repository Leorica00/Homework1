package com.example.homework1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.homework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendMessage.setOnClickListener {
            if (binding.etEmail.text?.isBlank() == true || binding.etMessage.text?.isBlank() == true) {
                Toast.makeText(this, "Fill all inputs!", Toast.LENGTH_SHORT).show()
            } else if(binding.etEmail.text?.contains("@") == false){
                Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ResultActivity::class.java).putExtras(
                    Bundle().apply {
                        putString(EMAIL_ARG, binding.etEmail.text.toString())
                        putString(MESSAGE_ARG, binding.etMessage.text.toString())
                    }
                )
                startActivity(intent)
            }
        }
    }

    companion object {
        const val EMAIL_ARG = "email_arg"
        const val MESSAGE_ARG = "message_arg"
    }
}
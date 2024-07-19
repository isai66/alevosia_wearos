package com.example.propuestaalev

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrdersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        val user: User? = intent.getParcelableExtra("user")

        if (user != null) {
            val tvUsername: TextView = findViewById(R.id.tvUsername)
            tvUsername.text = "Welcome, ${user.username}"
        }
    }
}

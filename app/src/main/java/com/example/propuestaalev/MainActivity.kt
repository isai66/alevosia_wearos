package com.example.propuestaalev

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var statusText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Asegúrate de que el nombre del layout sea correcto

        progressBar = findViewById(R.id.progressBar)
        statusText = findViewById(R.id.statusText)

        fetchStatuses()
    }

    private fun fetchStatuses() {
        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        apiService.getStatuses().enqueue(object : Callback<List<StatusResponse>> {
            override fun onResponse(call: Call<List<StatusResponse>>, response: Response<List<StatusResponse>>) {
                if (response.isSuccessful) {
                    val statuses = response.body()
                    if (statuses != null) {
                        updateUI(statuses)
                    }
                } else {
                    statusText.text = "Response not successful: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<List<StatusResponse>>, t: Throwable) {
                statusText.text = "Error: ${t.message}"
            }
        })
    }

    private fun updateUI(statuses: List<StatusResponse>) {
        var currentStatusIndex = 0

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object : Runnable {
            override fun run() {
                if (currentStatusIndex < statuses.size) {
                    statusText.text = "Estado: ${statuses[currentStatusIndex].Estado}"
                    progressBar.progress = (100 / statuses.size) * (currentStatusIndex + 1)
                    currentStatusIndex++
                    handler.postDelayed(this, 3000) // Actualiza cada 3 segundos
                }
            }
        }, 3000)
    }
}

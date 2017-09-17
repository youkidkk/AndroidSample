package youkidkk.android.sample.okhttp3sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById(R.id.textView) as TextView
        val button = findViewById(R.id.button) as Button

        button.setOnClickListener {
            textView.text = "Getting..."

            val request = Request.Builder()
                    .url("http://qiita.com/")
                    .get()
                    .build()

            val client = OkHttpClient()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call?, e: IOException?) {
                    textView.text = "Failure."
                }

                override fun onResponse(call: Call?, response: Response?) {
                    val resBody = response?.body()?.string()?: ""
                    runOnUiThread {
                        textView.text = resBody
                    }
                }
            })
        }
    }

}

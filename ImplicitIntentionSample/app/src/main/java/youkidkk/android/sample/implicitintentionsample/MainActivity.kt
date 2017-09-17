package youkidkk.android.sample.implicitintentionsample

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById(R.id.button) as Button
        button.setOnClickListener {
            val intent = Intent(MY_ACTION)
            startActivity(intent)
        }
    }

    companion object {

        internal val MY_ACTION = "youkidkk.android.sample.implicitintentionsample.MY_ACTION"
    }
}

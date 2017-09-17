package youkidkk.android.sample.explicitintentionsample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class SubActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val editText = findViewById(R.id.subEditText) as EditText

        val intent = intent
        editText.setText(intent.getStringExtra(MainActivity.KEY))

        val button = findViewById(R.id.subButton) as Button
        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra(SUB_KEY, editText.text.toString())

            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }

    companion object {

        val SUB_KEY = "SUB_KEY"
    }
}

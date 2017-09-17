package youkidkk.android.sample.explicitintentionsample

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById(R.id.button) as Button
        button.setOnClickListener {
            val editText = findViewById(R.id.editText) as EditText

            val intent = Intent(this@MainActivity, SubActivity::class.java)
            intent.putExtra(KEY, editText.text.toString())

            startActivityForResult(intent, SUB_ACTIVITY_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val result = data.getStringExtra(SubActivity.SUB_KEY)

            Toast.makeText(this@MainActivity, result, Toast.LENGTH_SHORT).show()

            val editText = findViewById(R.id.editText) as EditText
            editText.setText(result)
        }
    }

    companion object {

        val KEY = "EDIT_TEXT_KEY"
        val SUB_ACTIVITY_REQUEST = 1
    }
}

package youkidkk.android.sample.preferencesample

import android.app.NotificationManager
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var pref: SharedPreferences

    private lateinit var editText: EditText
    private lateinit var saveButton: Button
    private lateinit var prefText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.editText = findViewById(R.id.editText) as EditText
        this.saveButton = findViewById(R.id.saveButton) as Button
        this.prefText = findViewById(R.id.prefText) as TextView

        // SharedPreferences を設定
        pref = PreferenceManager.getDefaultSharedPreferences(this)

        // Preference からキーに対応する値を取得
        val text = pref.getString(PREF_KEY, "none")
        this.prefText.text = text

        this.saveButton.setOnClickListener {
            val text = this.editText.text

            // Preference からエディターを取得
            val editor = pref.edit()
            // 値を設定
            editor.putString(PREF_KEY, text.toString())
            // コミット
            editor.commit()

            Toast.makeText(this, "Saved. ${text}", Toast.LENGTH_SHORT).show()
            this.prefText.text = text
        }
    }

    companion object {
        val PREF_KEY = "text"
    }
}

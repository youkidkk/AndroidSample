package youkidkk.android.sample.sqlitesample

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var dataListTextView: TextView
    private lateinit var idEditText: EditText
    private lateinit var valueEditText: EditText
    private lateinit var button: Button

    private lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.dataListTextView = findViewById(R.id.dataListTextView) as TextView
        this.idEditText = findViewById(R.id.idEditText) as EditText
        this.valueEditText = findViewById(R.id.valueEditText) as EditText
        this.button = findViewById(R.id.button) as Button

        this.db = DatabaseHelper(applicationContext).writableDatabase
        this.printDataList(this.getDataList())

        this.button.setOnClickListener {
            val id = this.idEditText.text.toString()
            val value = this.valueEditText.text.toString()
            val data = Data(id, value)
            this.updateData(data)
            this.printDataList(this.getDataList())
        }
    }

    fun getDataList() : MutableList<Data> {
        val result = mutableListOf<Data>()
        val cursor = this.db.query(DatabaseHelper.TABLE_NAME, arrayOf("id", "value"), null, null, null, null, null)
        cursor.moveToFirst()
        for (i in 0..(cursor.count - 1)) {
            result.add(Data(cursor.getString(0), cursor.getString(1)))
            cursor.moveToNext()
        }
        cursor.close()
        return result
    }

    fun printDataList(dataList: MutableList<Data>) {
        this.dataListTextView.text =
                dataList.map { "${it.id}, ${it.value}" }
                        .toList()
                        .joinToString("\n")
    }

    fun updateData(data: Data) {
        val contentValues = ContentValues()
        contentValues.put("value", data.value)
        if (data.id.isEmpty()) {
            if (!data.value.isEmpty()) {
                this.db.insert(DatabaseHelper.TABLE_NAME, null, contentValues)
            }
        } else {
            if (data.value.isEmpty()) {
                this.db.delete(DatabaseHelper.TABLE_NAME, "id=?", arrayOf(data.id))
            } else {
                this.db.update(DatabaseHelper.TABLE_NAME, contentValues, "id=?", arrayOf(data.id))
            }
        }
        this.printDataList(this.getDataList())
    }

}

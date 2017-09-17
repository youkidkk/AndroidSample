package youkidkk.android.sample.listviewsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    // リストビュー
    private lateinit var listView: ListView

    // Addボタン
    private lateinit var addButton: Button

    // リストビュー用ArrayAdapter
    private lateinit var arrayAdapter: ArrayAdapter<String>

    // リストビューのアイテムのカウンタ
    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // リストビューの設定
        this.listView = findViewById(R.id.listView) as ListView
        this.arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ArrayList<String>())
        this.listView.apply {
            adapter = arrayAdapter
            setOnItemClickListener { _, _, position, _ -> this@MainActivity.onListItemClick(position) }
        }

        // Addボタンの設定
        this.addButton = findViewById(R.id.addButton) as Button
        this.addButton.setOnClickListener { this.onAddButtonClick() }
    }

    /**
     * リストビューのアイテムクリック時の動作。
     *
     * @param position アイテムの位置
     */
    fun onListItemClick(position: Int) {
        val item = this.listView.getItemAtPosition(position) as String
        this.arrayAdapter.remove(item);

        Toast.makeText(applicationContext, "Remove!!!", Toast.LENGTH_SHORT).show()
    }

    /**
     * Addボタンクリック時の動作。
     */
    fun onAddButtonClick() {
        this.arrayAdapter += ("test" + count)
        this.count++

        Toast.makeText(applicationContext, "Add!!!", Toast.LENGTH_SHORT).show()
    }

    /**
     * ArrayAdapter の += 演算子オーバーロード。
     */
    operator fun <T> ArrayAdapter<T>.plusAssign(item: T) = add(item)

}

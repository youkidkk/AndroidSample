package youkidkk.android.sample.asynctasksample

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.textView = findViewById(R.id.textView) as TextView

        val postButton = findViewById(R.id.postButton) as Button
        // View#post のサンプル
        postButton.setOnClickListener {
            textView.text = "Post Start."
            Thread {
                for (i in 0..10) {
                    // View#postの呼び出し
                    // 引数は Runnable
                    textView.post {
                        textView.text = textView.text.toString() + "."
                    }
                    Thread.sleep(500)
                }
                textView.post {
                    textView.text = "Post Finished!!!"
                }
            }.start()
        }

        val runOnUiThreadButton = findViewById(R.id.runOnUiThreadButton) as Button
        // runOnUiThread のサンプル
        runOnUiThreadButton.setOnClickListener {
            textView.text = "RunOnUiThread Start."
            Thread {
                for (i in 0..10) {
                    // Activity#runOnUiThreadの呼び出し
                    // 引数は Runnable
                    this@MainActivity.runOnUiThread {
                        textView.text = textView.text.toString() + "."
                    }
                    Thread.sleep(500)
                }
                this@MainActivity.runOnUiThread {
                    textView.text = "RunOnUiThread Finished!!!"
                }
            }.start()
        }

        val asyncTaskButton = findViewById(R.id.asyncTaskButton) as Button
        // AsyncTask のサンプル
        asyncTaskButton.setOnClickListener {
            MyAsyncTask().execute()
        }

    }

    /*
     * AsyncTask の継承クラス
     * ジェネリクスの型指定はそれぞれ
     * ・doInBackground
     * ・onProgressUpdate
     * ・onPostExecute
     * の引数の型となる
     */
    inner class MyAsyncTask : AsyncTask<Void, Int, String>() {
        // 開始時に実行される処理
        override fun onPreExecute() {
            textView.text = "AsyncTask Start."
        }

        // 非同期処理の本体
        override fun doInBackground(vararg params: Void?): String {
            for (i in 0..100) {
                // 非同期処理中にメインスレッド側で onProgressUpdate の処理が実行される
                // このメソッドの引数の設定値が onProgressUpdate の引数として渡される
                publishProgress(i)

                Thread.sleep(30)
            }
            // 戻り値は onPostExecute の引数となる
            return "AsyncTask Finished!!!"
        }

        // 非同期処理中、メインスレッド側で実行される処理
        // doInBackground での publishProgress 実行時に呼ばれる
        // publishProgress の引数の設定値がこのメソッドの引数として渡される
        override fun onProgressUpdate(vararg values: Int?) {
            textView.text = "Progress : ${values[0]}%"
        }

        // 非同期処理終了時の処理
        // doInBackground の戻り値がこのメソッドの引数となる
        override fun onPostExecute(result: String?) {
            textView.text = result
        }
    }

}

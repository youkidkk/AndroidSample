package youkidkk.android.sample.lifecyclesample

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : Activity() {

    private fun log(tag: String, msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        Log.d(tag, msg)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.log(TAG, "onCreate")
        setContentView(R.layout.activity_main)
    }

    override fun onRestart() {
        super.onRestart()
        this.log(TAG, "onRestart")
    }

    override fun onStart() {
        super.onStart()
        this.log(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        this.log(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        this.log(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        this.log(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        this.log(TAG, "onDestroy")
    }

    companion object {

        internal val TAG = MainActivity::class.java.simpleName
    }

}

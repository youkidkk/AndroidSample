package youkidkk.android.sample.implicitintentionsample

import android.app.Activity
import android.os.Bundle

class SubActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
    }
}

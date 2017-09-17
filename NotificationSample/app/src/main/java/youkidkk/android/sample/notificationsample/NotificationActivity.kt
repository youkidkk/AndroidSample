package youkidkk.android.sample.notificationsample

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Vibrator

class NotificationActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(1000)
    }
}

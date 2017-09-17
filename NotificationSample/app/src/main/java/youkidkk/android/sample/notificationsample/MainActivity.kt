package youkidkk.android.sample.notificationsample

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val builder = Notification.Builder(this)
                .setTicker("Ticker!!!")
                .setDefaults(Notification.DEFAULT_VIBRATE or Notification.DEFAULT_SOUND)
                .setAutoCancel(true)
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .setContentTitle("Notification Title!")
                .setContentText("Notification Text!")
                .setContentIntent(
                        PendingIntent.getActivity(
                                this,
                                0,
                                Intent(this, NotificationActivity::class.java),
                                PendingIntent.FLAG_UPDATE_CURRENT
                        )
                )

        val button = findViewById(R.id.button) as Button
        button.setOnClickListener {
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(MY_NOTIFICATION_ID, builder.build())
        }

    }

    companion object {

        private val MY_NOTIFICATION_ID = 1
    }
}

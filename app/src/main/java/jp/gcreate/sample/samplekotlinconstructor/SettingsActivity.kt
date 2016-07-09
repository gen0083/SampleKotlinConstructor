package jp.gcreate.sample.samplekotlinconstructor

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, SettingsFragment())
                    .commit()
        }
    }
}

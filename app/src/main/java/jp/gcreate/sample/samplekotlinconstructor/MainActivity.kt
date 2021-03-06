package jp.gcreate.sample.samplekotlinconstructor

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.from_preferences) as TextView
    }

    override fun onStart() {
        super.onStart()
        // read from shared preferences
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editTextPreference = sharedPreferences.getString("text_preference", "test")
        val editIntPreference = sharedPreferences.getInt("int_preference", 0)
        val editIntOverloadsPreference = sharedPreferences.getInt("int_overloads_preference", 0)
        textView.text = "$editTextPreference\n" +
                "$editIntPreference\n" +
                "$editIntOverloadsPreference"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.open_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}

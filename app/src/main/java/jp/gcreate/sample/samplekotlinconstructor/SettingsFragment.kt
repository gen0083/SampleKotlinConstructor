package jp.gcreate.sample.samplekotlinconstructor

import android.os.Bundle
import android.preference.PreferenceFragment

/**
 * Copyright 2016 G-CREATE
 *
 */
class SettingsFragment: PreferenceFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preferences)
    }
}
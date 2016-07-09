package jp.gcreate.sample.samplekotlinconstructor.preference

import android.content.Context
import android.content.res.TypedArray
import android.preference.EditTextPreference
import android.util.AttributeSet

/**
 * Copyright 2016 G-CREATE
 *
 */
class EditIntOverloadsPreference : EditTextPreference {
    private var defaultValue: Int = 0

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0):
    super(context, attrs, defStyleAttr) {}

    override fun onGetDefaultValue(a: TypedArray?, index: Int): Any {
        defaultValue = a?.getInt(index, 0) ?: 0
        return defaultValue
    }

    override fun onSetInitialValue(restoreValue: Boolean, defaultValue: Any?) {
        if (restoreValue) {
        }else {
            persistInt(defaultValue as Int)
        }
    }

    override fun persistString(value: String?): Boolean {
        summary = value
        return persistInt(value?.toInt() ?: 0)
    }

    override fun getPersistedString(defaultReturnValue: String?): String {
        return getPersistedInt(defaultReturnValue?.toInt() ?: defaultValue).toString()
    }
}
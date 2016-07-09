package jp.gcreate.sample.samplekotlinconstructor.preference

import android.content.Context
import android.content.res.TypedArray
import android.preference.EditTextPreference
import android.util.AttributeSet

/**
 * Copyright 2016 G-CREATE
 *
 */
class EditIntPreference: EditTextPreference {
    private var defaultValue: Int = 0

    constructor(context: Context):
    super(context) {}
    constructor(context: Context, attrs: AttributeSet):
    super(context, attrs) {}
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int):
    super(context, attrs, defStyleAttr)

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
package com.example.logandpas

import android.util.Log

open class Tester(
    @TesterAttribute(info = "Some attribute")
    private var param: String
) {

    protected val protParam = 42

    @TesterMethod(description="Some public method")
    public fun doPublic() {
        Log.e ("TAG", "protected: $param")
    }

    protected fun doProtected() {
        Log.e("TAG", "protected: $param ($protParam)")
    }

    @TesterMethod(description="Some private method")
    private fun doPrivate() {
        Log.e ("TAG", "private: $param")
    }
}
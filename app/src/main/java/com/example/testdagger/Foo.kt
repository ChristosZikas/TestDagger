package com.example.testdagger

import android.util.Log
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

@BusRegister
class Foo(private val fooString: String) {

    object FooCmd

    @Subscribe
    fun onFooCmdLog(l: FooCmd) = Log.d("FooCmd", "First method fired successfully ${classSome()}")

    @Subscribe
    fun onFooCmdPostBarCmd(l: FooCmd) = EventBus.getDefault().post(Bar.BarCmd)

    @Subscribe
    fun onFooCmdUpdateText(l: FooCmd) = EventBus.getDefault().post(UpdateTextCmd("\nFirst method fired! ${classSome()}"))

    private fun classSome() = fooString


}
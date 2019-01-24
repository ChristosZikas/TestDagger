package com.example.testdagger

import android.util.Log
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

@BusRegister
class Foo(private val fooString: String) {

    object FooCmd

    @Subscribe
    fun on1(l: FooCmd) = Log.d("FooCmd", "First method fired successfully")

    @Subscribe
    fun on2(l: FooCmd) = EventBus.getDefault().post(Bar.BarCmd)

    @Subscribe
    fun on3(l: FooCmd) = EventBus.getDefault().post(UpdateText("\nFirst method fired!"))

    fun classSome() = fooString


}
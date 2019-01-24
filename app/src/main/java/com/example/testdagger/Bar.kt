package com.example.testdagger

import android.util.Log
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

@BusRegister
class Bar(val eventBus: EventBus = EventBus.getDefault()) {
    object BarCmd

    @Subscribe
    fun on(o: BarCmd) = Log.d("BarCmd", "Second method fired successfully")

    @Subscribe
    fun on2(o: BarCmd) = EventBus.getDefault().post(UpdateText("\nSecond method fired!"))
}
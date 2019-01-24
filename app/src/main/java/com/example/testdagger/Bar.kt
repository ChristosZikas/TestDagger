package com.example.testdagger

import android.util.Log
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

@BusRegister
class Bar(val eventBus: EventBus = EventBus.getDefault()) {
    object BarCmd

    @Subscribe
    fun onBarCmdLog(o: BarCmd) = Log.d("BarCmd", "Second method fired successfully")

    @Subscribe
    fun onBarCmdUpdateText(o: BarCmd) = EventBus.getDefault().post(UpdateTextCmd("\nSecond method fired!"))
}
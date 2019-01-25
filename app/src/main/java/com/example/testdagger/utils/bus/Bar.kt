package com.example.testdagger.utils.bus

import android.util.Log
import com.example.testdagger.Contract
import com.example.testdagger.ui.UpdateTextCmd
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

object BarCmd

@BusRegister
class Bar @Inject constructor(): Contract.Bar {

    @Subscribe
    override fun onBarCmdLog(o: BarCmd) {
        Log.d("BarCmd", "Second method fired successfully")
    }

    @Subscribe
    override fun onBarCmdUpdateText(o: BarCmd) = EventBus.getDefault().post(UpdateTextCmd("\nSecond method fired!"))

}
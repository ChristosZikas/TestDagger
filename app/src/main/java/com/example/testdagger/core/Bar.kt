package com.example.testdagger.core

import com.example.testdagger.core.contract.Contract
import com.example.testdagger.ui.UpdateTextCmd
import com.example.testdagger.utils.bus.BusRegister
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

object BarCmd

@BusRegister
class Bar @Inject constructor(val bus: EventBus): Contract.Bar {

    @Subscribe
    override fun onBarCmdUpdateText(o: BarCmd) = bus.post(UpdateTextCmd("\nSecond method fired!"))

}
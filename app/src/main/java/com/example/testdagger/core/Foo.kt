package com.example.testdagger.core

import com.example.testdagger.core.contract.Contract
import com.example.testdagger.ui.UpdateTextCmd
import com.example.testdagger.utils.bus.BusRegister
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

object FooCmd

data class FooStickyEvent(val fooString: String)

@BusRegister
open class Foo @Inject constructor(private val fooString: String, val bus: EventBus) : Contract.Foo {

    @Subscribe
    override fun onFooCmdPostBarCmd(l: FooCmd) = bus.post(BarCmd)

    @Subscribe
    override fun onFooCmdUpdateText(l: FooCmd) =
      bus.post(
            UpdateTextCmd(retrieveText())
        )

    override fun retrieveText() = "\nFirst method fired! ${classSome()} " +
            "\nsticky: ${getStickyString()}"

    private fun getStickyString(): String {
        val fooStickyString = bus.getStickyEvent(FooStickyEvent::class.java)
        return fooStickyString?.fooString ?: "null event"
    }

    private fun classSome() = this.fooString

}
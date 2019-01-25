package com.example.testdagger

import android.util.Log
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

object FooCmd

data class FooStickyEvent(val fooString: String)

@BusRegister
class Foo @Inject constructor(private val fooString: String) : Contract.Foo {

    val bus = EventBus.getDefault()

    @Subscribe
    override fun onFooCmdLog(l: FooCmd) {
        Log.d("FooCmd", "First method fired successfully ${classSome()}")
    }

    @Subscribe
    override fun onFooCmdPostBarCmd(l: FooCmd) = bus.post(BarCmd)

    @Subscribe
    override fun onFooCmdUpdateText(l: FooCmd) =
        EventBus.getDefault().post(UpdateTextCmd("\nFirst method fired! ${classSome()} " +
                "\nsticky: ${getStickyString()}"))

    private fun getStickyString(): String {
        val fooStickyString = bus.getStickyEvent(FooStickyEvent::class.java)
        return fooStickyString?.fooString ?: "null event"
    }

    private fun classSome() = this.fooString

}
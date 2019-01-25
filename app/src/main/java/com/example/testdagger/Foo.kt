package com.example.testdagger

import android.util.Log
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

object FooCmd

@BusRegister
class Foo @Inject constructor(private val fooString: String) : Contract.Foo {

    @Subscribe
    override fun onFooCmdLog(l: FooCmd) {
        Log.d("FooCmd", "First method fired successfully ${classSome()}")
    }

    @Subscribe
    override fun onFooCmdPostBarCmd(l: FooCmd) = EventBus.getDefault().post(BarCmd)

    @Subscribe
    override fun onFooCmdUpdateText(l: FooCmd) =
        EventBus.getDefault().post(UpdateTextCmd("\nFirst method fired! ${classSome()}"))

    private fun classSome() = this.fooString

}
package com.example.testdagger.core

import com.example.testdagger.core.contract.Contract
import com.example.testdagger.ui.UpdateTextCmd
import org.greenrobot.eventbus.EventBus
import org.junit.Test
import org.junit.Before
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class FooTest {

    lateinit var bus: EventBus
    lateinit var foo: Contract.Foo

    @Before
    fun setup() {
        bus = Mockito.mock(EventBus::class.java)
        foo = Foo("str", bus)
    }

    @Test
    fun `on a FooCmd the onFooCmdPostBarCmd fires a BarCmd`() {
        foo.onFooCmdPostBarCmd(FooCmd)

        Mockito.verify(bus).post(BarCmd)
    }

    @Test
    fun `on a onFooCmdUpdateText `() {
        `when`(bus.getStickyEvent(FooStickyEvent::class.java)).thenReturn(FooStickyEvent("expected"))
        val text = foo.retrieveText()

        foo.onFooCmdUpdateText(FooCmd)

        Mockito.verify(bus).post((UpdateTextCmd(text)))
    }
}
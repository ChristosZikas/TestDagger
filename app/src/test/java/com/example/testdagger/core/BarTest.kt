package com.example.testdagger.core

import com.example.testdagger.core.contract.Contract
import com.example.testdagger.ui.UpdateTextCmd
import org.greenrobot.eventbus.EventBus
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify

class BarTest {


    lateinit var bus: EventBus
    lateinit var bar: Contract.Bar

    @Before
    fun setup() {
        bus = Mockito.mock(EventBus::class.java)
        bar = Bar(bus)
    }

    @Test
    fun `on a onBarCmdUpdateText fires updateText`() {
        val expected = "\nSecond method fired!"

        bar.onBarCmdUpdateText(BarCmd)

        verify(bus).post(UpdateTextCmd(expected))
    }

}
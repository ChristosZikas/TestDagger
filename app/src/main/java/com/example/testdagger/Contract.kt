package com.example.testdagger

import com.example.testdagger.utils.bus.BarCmd

interface Contract {

    interface Foo {
        fun onFooCmdLog(l: FooCmd)
        fun onFooCmdPostBarCmd(l: FooCmd)
        fun onFooCmdUpdateText(l: FooCmd)
    }

    interface Bar {
        fun onBarCmdLog(o: BarCmd)
        fun onBarCmdUpdateText(o: BarCmd)
    }

}
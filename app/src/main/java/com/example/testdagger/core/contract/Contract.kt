package com.example.testdagger.core.contract

import com.example.testdagger.core.BarCmd
import com.example.testdagger.core.FooCmd

interface Contract {

    interface Foo {
        fun retrieveText(): String
        fun onFooCmdPostBarCmd(l: FooCmd)
        fun onFooCmdUpdateText(l: FooCmd)
    }

    interface Bar {
        fun onBarCmdUpdateText(o: BarCmd)
    }

}
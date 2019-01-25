package com.example.testdagger.utils.dagger

import com.example.testdagger.core.Foo
import com.example.testdagger.core.Bar
import com.example.testdagger.core.contract.Contract
import com.example.testdagger.utils.bus.RegisterClasses
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class Module {

    data class Injected(val arrayList: ArrayList<Any>)

    @Provides
    fun getInjected(
        foo: Contract.Foo,
        bar: Contract.Bar
    ) = Injected(arrayListOf(
        foo,
        bar
        ))

    @Provides
    @Singleton
    fun providesFooClass(): Foo =
        Foo("\nInjected Foo constructor\n")

    @Provides
    @Singleton
    fun providesFoo(foo: Foo): Contract.Foo = foo

    @Provides
    @Singleton
    fun providesBar(): Contract.Bar = Bar()

    @Provides
    fun providesBusRegistration(injected: Injected): RegisterClasses =
        RegisterClasses(injected.arrayList)

}
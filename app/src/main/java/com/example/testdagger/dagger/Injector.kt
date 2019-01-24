package com.example.testdagger.dagger

import com.example.testdagger.Foo
import com.example.testdagger.Bar
import com.example.testdagger.utils.RegisterClasses
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class Injector {

    @Provides
    @Singleton
    fun providesSomeClass(): Foo {
        return Foo("23")
    }

    @Provides
    @Singleton
    fun providesSomeOtherClass(): Bar = Bar()

    @Provides
    @Singleton
    fun providesBusRegistration(
        someClass: Foo,
        bar: Bar
    ): RegisterClasses = RegisterClasses(
        arrayListOf(
            someClass, bar
        )
    )


}
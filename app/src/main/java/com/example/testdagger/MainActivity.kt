package com.example.testdagger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.testdagger.dagger.AppInit
import com.example.testdagger.utils.RegisterClasses
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

data class UpdateText(val addedText: String)

class MainActivity : AppCompatActivity() {

    @BindView(R.id.text_view)
    lateinit var mainTextView: TextView

    @Inject
    lateinit var registerClasses: RegisterClasses

    private val bus = EventBus.getDefault()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        bus.register(this)
        (application as AppInit).component.inject(this)
    }

    override fun onResume() {
        super.onResume()
        registerClasses.register()
        bus.post(Foo.FooCmd)
    }

    override fun onPause() {
        super.onPause()
        registerClasses.unregister()
    }

    @Subscribe
    fun on(update: UpdateText) {
        val currentText = mainTextView.text.toString()
        val newText = currentText + update.addedText
        mainTextView.text = newText
    }
}
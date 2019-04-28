package com.example.viewmodel.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.viewmodel.R
import com.example.viewmodel.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.numeroLiveData.observe(this, Observer { newNumero ->
            newNumero?.let(this::updateUi)
        })

        tapButton.setOnClickListener {
            viewModel.onButtonPressed()
        }
    }

    private fun updateUi(tapsText: Int) {
        counterTextView.text = tapsText.toString()
    }
}

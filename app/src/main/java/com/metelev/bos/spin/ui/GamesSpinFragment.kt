package com.metelev.bos.spin.ui

import android.content.res.Configuration
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Toast
import com.metelev.bos.spin.R
import com.metelev.bos.spin.domain.AppState
import com.metelev.bos.spin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_games_spin.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class GamesSpinFragment : BaseFragment(R.layout.fragment_games_spin) {

    private val viewModelSpin: GamesSpinViewModel by viewModel()
    private val firstRandom = Random()

    override fun onResume() {
        super.onResume()
        initView()
    }

    private fun initView() {
        viewModelSpin.getLiveData().observe(viewLifecycleOwner) { renderData(it) }
        start_games_button.setOnClickListener {
            spinBottle()
        }
    }

    private fun spinBottle() {
        val random: Int = firstRandom.nextInt(720)
        var result = random
        if (random > 360) result = random - 360
        viewModelSpin.getFormula((spin_image_view.width / 2).toFloat(), (spin_image_view.height / 2).toFloat(), random)
        viewModelSpin.getResult(result)
    }

    private fun renderData(data: AppState) {
        when (data) {
            is AppState.Success -> score_text_view.text = data.data.toString()
            is AppState.Spin -> spin_image_view.startAnimation(data.spin)
            is AppState.Loading -> score_text_view.text = getString(R.string.spin)
            is AppState.Error -> Toast.makeText(context, data.error.message, Toast.LENGTH_SHORT).show()
        }
    }
}
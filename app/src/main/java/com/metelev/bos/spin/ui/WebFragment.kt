package com.metelev.bos.spin.ui

import com.metelev.bos.spin.R
import com.metelev.bos.spin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_web.*

class WebFragment : BaseFragment(R.layout.fragment_web) {

    override fun onResume() {
        super.onResume()

        initView()
    }

    private fun initView() {
        web_view.loadUrl(getString(R.string.web))
        star_games.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.activity_main, GamesSpinFragment())
                ?.addToBackStack("")
                ?.commit()
        }
    }
}
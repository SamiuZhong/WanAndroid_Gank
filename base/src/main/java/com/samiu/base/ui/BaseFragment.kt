package com.samiu.base.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * @author Samiu 2020/3/2
 * @github https://github.com/SamiuZhong
 * @blog samiu.top
 */
abstract class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId),
    CoroutineScope by MainScope() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        initData()
        startObserve()
        viewLifecycleOwner.lifecycleScope.launch {
            startFlow()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun initView()
    abstract fun initData()
    open fun startObserve() = Unit
    open suspend fun startFlow() = Unit


    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}
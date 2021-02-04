package com.example.topdowndialog.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Message
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.example.topdowndialog.R

abstract class BaseTopDownDialog(context: Context): Dialog(context) {

    init {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
    }

    override fun setContentView(view: View) {
        super.setContentView(view)
        initWindow()
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        initWindow()
    }

    override fun setCancelMessage(msg: Message?) {
        super.setCancelMessage(msg)
        initWindow()
    }

    private fun initWindow() {
        window?.let{ window ->
            // Background TRANSPARENT
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            window.attributes = window.attributes.apply {
                width = WindowManager.LayoutParams.MATCH_PARENT
                dimAmount = 0f
                gravity = Gravity.TOP

                // setting animation top down
                windowAnimations = R.style.TopDownDialogAnimationStyle
            }
        }
    }

    /**
     * outside 터치 시 동작
     * true: close dialog
     * false: forward touch events to the outside
     */
    override fun setCanceledOnTouchOutside(cancel: Boolean) {
        super.setCanceledOnTouchOutside(cancel)
        if (cancel) {
            window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL)
        } else {
            window?.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL)
        }
    }
}
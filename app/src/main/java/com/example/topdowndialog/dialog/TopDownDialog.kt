package com.example.topdowndialog.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import com.example.topdowndialog.databinding.DialogTopDownBinding

class TopDownDialog(context: Context,
                    @DrawableRes private val imgRes: Int,
                    private val title: String,
                    private val subTitle: String) : BaseTopDownDialog(context) {

    lateinit var mBinding: DialogTopDownBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCancelable(true)
        setCanceledOnTouchOutside(false)

        mBinding = DialogTopDownBinding.inflate(LayoutInflater.from(context))
        setContentView(mBinding.root)

        mBinding.closeButton.setOnClickListener {
            this.dismiss()
        }
        mBinding.imageView.setImageResource(imgRes)
        mBinding.title.text = title
        mBinding.subTitle.text = subTitle
    }

}
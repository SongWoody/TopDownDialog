package com.example.topdowndialog

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.topdowndialog.databinding.ActivityMainBinding
import com.example.topdowndialog.dialog.TopDownDialog

class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.showButton.setOnClickListener {
            TopDownDialog(
                this,
                R.mipmap.ic_launcher,
                this.resources.getString(R.string.dialog_title),
                this.resources.getString(R.string.dialog_sub_title)
            ).show()
        }
    }
}
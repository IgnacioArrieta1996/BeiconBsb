package com.beiconbsb.ui

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import com.beiconbsb.R

open class BaseActivity : AppCompatActivity() {

    private lateinit var progressDialog: Dialog

    fun showProgressDialog() {
        progressDialog = Dialog(this)

        /*Set the screen content from a layout resource.
        The resource will be inflated, adding all top-level views to the screen.*/
        progressDialog.setContentView(R.layout.dialog_progress)

        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)

        //Start the dialog and display it on screen.
        progressDialog.show()
    }


    fun hideProgressDialog() {
        progressDialog.dismiss()
    }
}
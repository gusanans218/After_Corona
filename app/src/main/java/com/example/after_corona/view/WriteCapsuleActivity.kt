package com.example.after_corona.view

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.after_corona.R
import com.example.after_corona.databinding.ActivityDeviceLinkageBinding
import com.example.after_corona.databinding.ActivityLoginBinding
import com.example.after_corona.databinding.ActivityWriteCapsuleBinding

class WriteCapsuleActivity : AppCompatActivity(),View.OnClickListener {
    private val binding by lazy { ActivityWriteCapsuleBinding.inflate(layoutInflater) }
    private lateinit var mDialogView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDialogView = LayoutInflater.from(this).inflate(R.layout.write_dialog, null)
        setContentView(binding.root)
        binding.activity = this

        binding.writeOkBtn.setOnClickListener(this)





        }

    override fun onClick(v: View?) {
        when (v?.id) {

            binding.writeOkBtn.id -> {
                if ((mDialogView.parent as ViewGroup?) != null) {
                    (mDialogView.parent as ViewGroup?)!!.removeView(mDialogView)
                }
                // 다이얼로그를 생성하기 위해 Builder 클래스 생성자를 이용해 줍니다.
                val builder = AlertDialog.Builder(this)
                    .setView(mDialogView)
                    .setCancelable(true)
                    .create()

                mDialogView.findViewById<Button>(R.id.dialog_ok_btn).setOnClickListener {
                    val intent = Intent(this, CapsuleSuccessActivity::class.java)
                    startActivity(intent)

                    builder.dismiss()
                }


                builder.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                builder.window?.requestFeature(Window.FEATURE_NO_TITLE)
                builder.setCanceledOnTouchOutside(true)
                builder.window?.setGravity(Gravity.CENTER)
                builder.show()
            }
        }
    }
}













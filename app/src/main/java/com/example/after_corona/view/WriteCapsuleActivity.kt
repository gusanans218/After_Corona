package com.example.after_corona.view

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.after_corona.R
import com.example.after_corona.databinding.ActivityDeviceLinkageBinding
import com.example.after_corona.databinding.ActivityLoginBinding
import com.example.after_corona.databinding.ActivityWriteCapsuleBinding
import com.example.after_corona.view.viewmodel.TodoViewModel

class WriteCapsuleActivity : AppCompatActivity(),View.OnClickListener {
    private val binding by lazy { ActivityWriteCapsuleBinding.inflate(layoutInflater) }
    private lateinit var mDialogView: View
    val viewModel:TodoViewModel by lazy {
        ViewModelProvider(this).get(TodoViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDialogView = LayoutInflater.from(this).inflate(R.layout.write_dialog, null)

        setContentView(binding.root)
        binding.activity = this

        binding.writeOkBtn.setOnClickListener(this)

        binding.writeToolbarBack.setOnClickListener {
            finish()
        }

        binding.writeCapsuleContent.addTextChangedListener(object  : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.writeCount.text = "${binding.writeCapsuleContent.text.toString().count()}/80자"

            }

        })

        viewModel.onSuccessEvent.observe(this, Observer {
            if (binding.writeCapsuleName1.text.toString().trim()
                    .isNotEmpty() && binding.writeCapsuleContent.text.toString().trim()
                    .isNotEmpty()&& binding.writeCapsuleContent.text.toString().trim()
                    .count() >= 1 && binding.writeCapsuleContent.text.toString().trim().count() <= 80 ) {
                val intent = Intent(this, CapsuleSuccessActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                Toast.makeText(this, "제목이나 내용이 비어있습니다~", Toast.LENGTH_SHORT).show()            }

        })

        viewModel.onFailureEvent.observe(this, Observer{
            Toast.makeText(this,"통신 에러가 발생하였습니다",Toast.LENGTH_SHORT).show()
        })



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
                viewModel.postTodo(
                    description = binding.writeCapsuleContent.text.toString().trim(),
                    title = binding.writeCapsuleName1.text.toString().trim()

                )



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













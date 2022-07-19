package com.example.tbc_homework_11.Activities

import android.content.Intent
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.tbc_homework_11.Game
import com.example.tbc_homework_11.HasImage
import com.example.tbc_homework_11.R
import com.example.tbc_homework_11.databinding.ActivityEditBinding
import com.squareup.picasso.Picasso

fun isEmpty( Etext : EditText ): Boolean{
    if(Etext.text.toString().trim().isEmpty()) {
        Etext.error = "Please fill this field"
        return true
    }
    else return false
}

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            buttonExtract.setOnClickListener{
                Picasso.get()
                    .load(urlET.text.toString())
                    .error(R.drawable.error)
                    .into(extractedImV);

            }


            buttonConfirm.setOnClickListener {
                //if it is empty
                if(isEmpty(titleET) || isEmpty(descriptionET)) {}
                else {
                    lateinit var game: Game
                    if (urlET.text.toString().trim() == "")
                        game = Game(
                            titleET.text.toString(),
                            descriptionET.text.toString(),
                            null,
                            HasImage.FALSE
                        )
                    else game = Game(
                        titleET.text.toString(),
                        descriptionET.text.toString(),
                        urlET.text.toString(),
                        HasImage.TRUE
                    )
                    val editIntent = Intent().apply {
                        putExtra("game", game)
                    }
                    setResult(RESULT_OK, editIntent)
                    finish()
                }
            }
        }
    }
}
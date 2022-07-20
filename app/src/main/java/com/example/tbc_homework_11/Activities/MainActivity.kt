package com.example.tbc_homework_11

import android.content.Intent
import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tbc_homework_11.Activities.EditActivity
import com.example.tbc_homework_11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private val recAdapter = GameAdapter(gamesList){
      it, pos ->  editGame(it, pos)
    }
    private var editLuncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.gameRecyclerview.apply {
            adapter = recAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
        editLuncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                recAdapter.addGame(it.data?.getSerializableExtra("game") as Game, gamesList.size)
            }
        }

        val addButton = mainBinding.buttonAdd
        addButton.background.alpha = 200
        addButton.setOnClickListener {
            editLuncher?.launch(Intent(this, EditActivity::class.java))
        }

        }
    private fun editGame(game: Game, position: Int) {
        val intent = Intent(this, EditActivity::class.java)
        intent.putExtra("gameToEditPos", position)
        startActivity(intent)
    }
    override fun onResume() {
        super.onResume()
        recAdapter.notifyDataSetChanged()

    }
}
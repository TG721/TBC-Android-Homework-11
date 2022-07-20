package com.example.tbc_homework_11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tbc_homework_11.Activities.EditActivity
import com.example.tbc_homework_11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private val recAdapter = GameAdapter(gamesList) { it, pos ->
        editGame(it, pos)
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

        //for getting game object as a result from Edit Activity for adding to the list
        editLuncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                recAdapter.addGame(it.data?.getSerializableExtra("game") as Game, gamesList.size)
            }
        }

        val addButton = mainBinding.buttonAdd
        //making button a little transparent
        addButton.background.alpha = 200
        //handling add Button click
        addButton.setOnClickListener {
            editLuncher?.launch(Intent(this, EditActivity::class.java))
        }

        //handling refresh Button click
        mainBinding.refreshButton.setOnClickListener{
            //we need to refresh meaning to reload everything
            recAdapter.notifyDataSetChanged()
        }

    }

    //for lunching EditActivity but for list item editing purposes
    private fun editGame(game: Game, position: Int) {
        val intent = Intent(this, EditActivity::class.java)
        intent.putExtra("gameToEditPos", position)
        startActivity(intent)
    }

    //to notify adapter after we leave EditActivity that we edited single list item
    override fun onResume() {
        super.onResume()
        recAdapter.notifyItemChanged(intent.getIntExtra("position", gamesList.size))

    }
}
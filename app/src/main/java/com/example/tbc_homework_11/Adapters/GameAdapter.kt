package com.example.tbc_homework_11

import android.view.LayoutInflater
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_homework_11.GameAdapter.Const.HASIMAGE
import com.example.tbc_homework_11.GameAdapter.Const.NOIMAGE
import com.example.tbc_homework_11.databinding.ActivityMainBinding.inflate
import com.example.tbc_homework_11.databinding.GameWithImageBinding
import com.example.tbc_homework_11.databinding.GameWithoutImageBinding
import com.squareup.picasso.Picasso
import java.text.ParseException

class GameAdapter(private var games: ArrayList<Game>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object Const{
        const val HASIMAGE = 0
        const val NOIMAGE = 1
    }

    inner class GameWithImageViewHolder(private val gameWithImage: GameWithImageBinding) :
        RecyclerView.ViewHolder(gameWithImage.root) {
        fun bind(game: Game) {
            Picasso.get()
                .load(game.imageURL)
                .into(gameWithImage.gameImage)
            gameWithImage.gameWithImageTitle.text = game.title
            gameWithImage.gameWithImageDesc.text = game.desc
        }
    }

    inner class GameWithoutImageViewHolder(private val gameWithoutImage: GameWithoutImageBinding) :
        RecyclerView.ViewHolder(gameWithoutImage.root) {
        fun bind(game: Game) {
            gameWithoutImage.gameTitle.text = game.title
            gameWithoutImage.gameDesc.text = game.desc
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (games[position].hasImage == HasImage.TRUE) HASIMAGE else NOIMAGE
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == HASIMAGE){
            val view = GameWithImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return GameWithImageViewHolder(view)
        }
        else   {
            val view = GameWithoutImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return GameWithoutImageViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position)== HASIMAGE)
            return (holder as GameWithImageViewHolder).bind(games[position])
        else
            return (holder as GameWithoutImageViewHolder).bind(games[position])
    }

    override fun getItemCount(): Int {
        return games.size
    }

    fun addGame(game: Game, position: Int){
        gamesList.add(game)
        notifyItemInserted(position)
    }

}
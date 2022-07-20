package com.example.tbc_homework_11

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_homework_11.databinding.GameWithImageBinding
import com.example.tbc_homework_11.databinding.GameWithoutImageBinding
import com.squareup.picasso.Picasso


class GameAdapter(private var games: ArrayList<Game>, private var onItemEditClicked: ((game: Game, position: Int) -> Unit)) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object Const{
        const val HASIMAGE = 0
        const val NOIMAGE = 1
    }

    inner class GameWithImageViewHolder(private val gameWithImage: GameWithImageBinding) :
        RecyclerView.ViewHolder(gameWithImage.root) {
        fun bind(game: Game, position: Int) {
            Picasso.get()
                .load(game.imageURL)
                .into(gameWithImage.gameImage)
            gameWithImage.gameWithImageTitle.text = game.title
            gameWithImage.gameWithImageDesc.text = game.desc

            gameWithImage.deleteButton.setOnClickListener{deleteItem(position)}
            gameWithImage.editButton.setOnClickListener{onItemEditClicked(game, position)}
        }
    }

    inner class GameWithoutImageViewHolder(private val gameWithoutImage: GameWithoutImageBinding) :
        RecyclerView.ViewHolder(gameWithoutImage.root) {
        fun bind(game: Game, position: Int) {
            gameWithoutImage.gameTitle.text = game.title
            gameWithoutImage.gameDesc.text = game.desc

            gameWithoutImage.deleteButton.setOnClickListener{deleteItem(position)}
            gameWithoutImage.editButton.setOnClickListener{onItemEditClicked(game, position)}
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
            return (holder as GameWithImageViewHolder).bind(games[position], position)
        else
            return (holder as GameWithoutImageViewHolder).bind(games[position], position)
    }

    override fun getItemCount(): Int {
        return games.size
    }

    fun addGame(game: Game, position: Int){
        gamesList.add(game)
        notifyItemInserted(position)
    }

    fun deleteItem(position: Int){
        gamesList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount)
    }

}
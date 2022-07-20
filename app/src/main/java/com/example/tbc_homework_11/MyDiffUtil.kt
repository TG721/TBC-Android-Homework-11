package com.example.tbc_homework_11

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil(
    private val oldList: List<Game>,
    private val newList: List<Game>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
    return oldListSize
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
 return oldList[oldItemPosition].title == newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return when {
           oldList[oldItemPosition].title != newList[newItemPosition].title -> {
               false
           }
           oldList[oldItemPosition].desc != newList[newItemPosition].desc -> {
               false
           }
           oldList[oldItemPosition].imageURL != newList[newItemPosition].imageURL -> {
               false
           }
           oldList[oldItemPosition].hasImage != newList[newItemPosition].hasImage -> {
               false
           }
           else -> true

       }
    }
}
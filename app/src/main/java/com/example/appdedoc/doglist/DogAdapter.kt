package com.example.appdedoc.doglist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.appdedoc.api.response.Dog
import com.example.appdedoc.databinding.DogsListItemBinding

class DogAdapter : ListAdapter<Dog, DogAdapter.DogViewHolder>(DiffCallback) {

    companion object DiffCallback: DiffUtil.ItemCallback<Dog>(){
        override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem.id == newItem.id
        }
    }

    private var onItemClickListener: ((Dog)-> Unit)? = null
    fun setOnItemClickListener(onItemClickListener: (Dog) -> Unit){
        this.onItemClickListener = onItemClickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = DogsListItemBinding.inflate(LayoutInflater.from(parent.context))
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(dogListholder: DogViewHolder, position: Int) {
        val dog = getItem(position)
        dogListholder.bing(dog)
    }


    inner class DogViewHolder(val binding: DogsListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bing(dog: Dog){
            //mostrar l imagen
            binding.dogImage.load(dog.imageUrl)
            binding.dogName.text = dog.name_es
            binding.dogListItemLayout.setOnClickListener{
                onItemClickListener?.invoke(dog)
            }
        }
    }
}



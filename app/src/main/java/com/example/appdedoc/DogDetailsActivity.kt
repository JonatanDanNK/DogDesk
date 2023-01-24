package com.example.appdedoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import coil.load
import com.example.appdedoc.api.response.Dog
import com.example.appdedoc.databinding.ActivityDogDetailsBinding

class DogDetailsActivity : AppCompatActivity() {

    private lateinit var _mBinding:  ActivityDogDetailsBinding

    //Para recuperar el item del perro utilizamos un companion object
    companion object {
        const val DOG_KEY = "dog"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mBinding = ActivityDogDetailsBinding.inflate(layoutInflater)
        setContentView(_mBinding.root)

        // optenemos el perro

        val dog = intent?.extras?.getParcelable<Dog>(DOG_KEY)
        if(dog == null){
            //En caso de que el dog sea nulo, mostramos un toast, matamos la activity y regresamos a la otra activity
            Toast.makeText(this, R.string.error_show_dog, Toast.LENGTH_LONG).show()
            finish()
            return
        }

        _mBinding.dogIndex.text = getString(R.string.dog_index_format, dog.index)
        _mBinding.lifeExpectancy.text = getString(R.string.dog_life_expectancy_format, dog.life_expectancy)
        _mBinding.dog = dog
        _mBinding.dogImage.load(dog.imageUrl)
        _mBinding.closeButton.setOnClickListener {
            finish()
        }
    }
}
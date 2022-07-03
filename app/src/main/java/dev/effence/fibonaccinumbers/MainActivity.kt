package dev.effence.fibonaccinumbers

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.effence.fibonaccinumbers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayNumbers()
    }
    fun displayNumbers(){
        var number_list=numb(100)
        var number_adapter=NumberRecyclerViewAdapter(number_list)
        binding.rvNumbers.layoutManager=LinearLayoutManager(this)
        binding.rvNumbers.adapter=number_adapter
    }
    fun numb(args:Int):List<Int>{
        var list=ArrayList<Int>()
        var number1=0
        var number2=1
        for (i in 1..args){
            var sum=number1+number2
            number1=number2
            number2=sum
            list+=sum
        }
        return list
    }
}
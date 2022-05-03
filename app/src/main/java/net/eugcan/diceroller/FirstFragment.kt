package net.eugcan.diceroller

import android.os.Bundle
import android.os.Debug
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import net.eugcan.diceroller.databinding.FragmentFirstBinding
import kotlin.random.Random

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.textViewRoll.setText(R.string.string_lets_roll)
        binding.buttonRoll.setOnClickListener {
            roll()
        }

    }

    private fun roll(){

        val random_int = getRandomInt()
        println("Random Int: " + random_int)
        val random_int_string = getStringFromRes(random_int)
        binding.textViewRoll.setText(random_int_string)
        //image
        binding.diceImage.setImageResource(getImageFromInt(random_int))
    }

    private fun getRandomInt(): Int {
        return Random.nextInt(1,7)
    }

    private fun getStringFromRes(random_int : Int) : Int {
        var result: Int = random_int

        when (result) {
            1 -> result = R.string.one_text
            2 -> result = R.string.two_text
            3 -> result = R.string.three_text
            4 -> result = R.string.four_text
            5 -> result = R.string.five_text
            6 -> result = R.string.six_text
            else -> {
                result = R.string.six_text
            }
        }
        return result
    }

    private fun getImageFromInt(image_num: Int) : Int {
        var result: Int = image_num

        when (result) {
            1 -> result = R.drawable.dice_1
            2 -> result = R.drawable.dice_2
            3 -> result = R.drawable.dice_3
            4 -> result = R.drawable.dice_4
            5 -> result = R.drawable.dice_5
            6 -> result = R.drawable.dice_6
            else -> {
                result = R.drawable.dice_1
            }
        }
        return result
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package net.eugcan.diceroller

import android.os.Bundle
import android.os.Debug
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import net.eugcan.diceroller.databinding.FragmentFirstBinding
import kotlin.random.Random

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    lateinit var roll_text: TextView
    lateinit var roll_button: Button

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

        /*binding.textViewNumber.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
           }
         */

    }

    private fun roll(){

        val random_int = getRandomInt()
        println("Random Int: " + random_int)
        val random_int_string = getStringFromRes(random_int)
        binding.textViewRoll.setText(random_int_string)
        /*
        val rndm_int = getRandomInt()
        println("Random Int: " + rndm_int)
        binding.textViewRoll.setText(rndm_int)

         */
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


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
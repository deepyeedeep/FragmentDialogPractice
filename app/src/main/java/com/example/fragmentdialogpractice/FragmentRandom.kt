package com.example.fragmentdialogpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentRandom.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentRandom : Fragment() {
    // TODO: Rename and change types of parameters
    private var num: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_random, container, false)
        val txvRandNum = view.findViewById<TextView>(R.id.frg_txv_randnum)
        val valRand = Random.nextInt(0, num)
        txvRandNum.text = valRand.toString()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        num = requireArguments().getInt("param1")
    }
/*
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentRandom.
         */
        // TODO: Rename and change types and number of parameters
        /*

*/
        @JvmStatic
        fun newInstance(param1: String) =
            FragmentRandom().apply {
                arguments = Bundle().apply {
                }
            }
    }*/
}
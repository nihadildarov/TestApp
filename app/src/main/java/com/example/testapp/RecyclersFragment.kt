package com.example.testapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.databinding.FragmentRecyclersBinding

class RecyclersFragment : Fragment() {
    private lateinit var binding: FragmentRecyclersBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclersBinding.inflate(inflater, container, false)
        createRecyclers()

        return binding.root

    }





    private fun createRecyclers() {
        val itemList = listOf(
            "Messi",
            "Ronaldo",
            "Kaka",
            "Nihad",
            "Beckham",
            "C.Ronaldo",
            "Casillas"
        )

        val adapterText = Adapter(
            itemList
        )

        val txtList = listOf(
            "Master",
            "Chief",
            "Expert"
        )

        var prevIdRcy = 1

        for (i in 1..3) {
            val constraintLayout = binding.constraintProducts
            val constraintSet = ConstraintSet()


            val textHeader = TextView(requireContext())
            textHeader.text = txtList[i-1]

            textHeader.id = View.generateViewId()
            textHeader.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
            val params = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,ConstraintLayout.LayoutParams.WRAP_CONTENT)
            textHeader.layoutParams = params


            val recycler = RecyclerView(requireContext())
            recycler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)


            recycler.id = View.generateViewId()
            val paramsRcy = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.WRAP_CONTENT)
            recycler.layoutParams = paramsRcy

            constraintLayout.addView(textHeader)
            constraintLayout.addView(recycler)

            constraintSet.clone(constraintLayout)

            //TextView constraints
            if (i == 1){
            constraintSet.connect(textHeader.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID , ConstraintSet.TOP)
            } else {
                constraintSet.connect(textHeader.id, ConstraintSet.TOP,prevIdRcy , ConstraintSet.BOTTOM)
            }

            constraintSet.connect(
                textHeader.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START
            )
            constraintSet.connect(
                textHeader.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END
            )

            //Recycler constraints
            constraintSet.connect(
                recycler.id,ConstraintSet.TOP,textHeader.id,ConstraintSet.BOTTOM
            )
            constraintSet.connect(
                recycler.id,ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START
            )
            constraintSet.connect(
                recycler.id,ConstraintSet.END,ConstraintSet.PARENT_ID,ConstraintSet.END
            )

            //Store previous recyclerId
            prevIdRcy = recycler.id
            //SetRecyclerAdapter
            recycler.adapter = adapterText

            constraintSet.applyTo(constraintLayout)
        }


    }


}
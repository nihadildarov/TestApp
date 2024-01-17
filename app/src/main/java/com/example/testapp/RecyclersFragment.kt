package com.example.testapp

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.findFragment
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
        val txtList = listOf(
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "Messi",
            "Ronaldo",
            "Kaka",
            "Carlos",
            "Robben",
            "Iniesta",
            "Xavi",
            "Casillas"

        )

        val adapterText = Adapter(
            txtList
        )



        for (i in 1..30) {
            val constraintLayout = binding.constraintProducts
            val constraintSet = ConstraintSet()


            val textHeader = TextView(requireContext())
            textHeader.text = "Header + $i"

            textHeader.id = txtList.size - 1
            textHeader.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
            val params = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,ConstraintLayout.LayoutParams.WRAP_CONTENT)
            textHeader.layoutParams = params


            val recycler = RecyclerView(requireContext())
            recycler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)


            recycler.id = txtList.size + 1
            val paramsRcy = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.WRAP_CONTENT)
            recycler.layoutParams = paramsRcy

            constraintLayout.addView(textHeader)
            constraintLayout.addView(recycler)

            constraintSet.clone(constraintLayout)

            constraintSet.connect(
                textHeader.id, ConstraintSet.TOP,
                if (i == 1) ConstraintSet.PARENT_ID else recycler.id, ConstraintSet.BOTTOM
            )
            constraintSet.connect(
                textHeader.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START
            )
            constraintSet.connect(
                textHeader.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END
            )

            constraintSet.connect(
                recycler.id,ConstraintSet.TOP,textHeader.id,ConstraintSet.BOTTOM
            )
            constraintSet.connect(
                recycler.id,ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START
            )
            constraintSet.connect(
                recycler.id,ConstraintSet.END,ConstraintSet.PARENT_ID,ConstraintSet.END
            )

            recycler.adapter = adapterText

            constraintSet.applyTo(constraintLayout)
        }


    }


}
package com.udacity.shoestore.shoeadd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeaddFragmentBinding

class ShoeAddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding: ShoeaddFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoeadd_fragment, container, false
        )



        binding.cancelButton.setOnClickListener {
            findNavController().navigate(
                ShoeAddFragmentDirections.actionShoeAddFragmentToShoeListFragment(
                    "", 0, "", ""
                )
            )
        }

        // TODO: Disable save button if a field is empty
        binding.saveShoeButton.setOnClickListener {
            findNavController().navigate(
                ShoeAddFragmentDirections.actionShoeAddFragmentToShoeListFragment(
                    binding.shoeNameEditText.text.toString(),
                    binding.shoeSizeEditText.text.toString().toInt(),
                    binding.shoeCompanyEditText.text.toString(),
                    binding.shoeDescriptionEditText.text.toString()
                )
            )
        }

        return binding.root
    }
}
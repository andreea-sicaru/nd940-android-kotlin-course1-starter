package com.udacity.shoestore.shoeadd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeaddFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.shoelist.ShoeListViewModel

class ShoeAddFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding: ShoeaddFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoeadd_fragment, container, false
        )

        binding.shoe = Shoe("", 0.0, "", "")
        binding.viewModel = viewModel

        viewModel.eventGoToShoeList.observe(viewLifecycleOwner) { goToShoeList ->
            if (goToShoeList) {
                findNavController().navigate(ShoeAddFragmentDirections.actionShoeAddFragmentToShoeListFragment())

                viewModel.onGoToShoeListComplete()
            }
        }

        return binding.root
    }
}
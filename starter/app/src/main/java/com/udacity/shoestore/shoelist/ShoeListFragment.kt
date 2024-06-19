package com.udacity.shoestore.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoelistFragmentBinding
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ShoelistFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoelist_fragment, container, false
        )

        viewModel = ViewModelProvider(this)[ShoeListViewModel::class.java]

//        viewModel.shoeList.observe(viewLifecycleOwner, { shoeList ->
//            binding.shoeLayout.removeAllViews()
////            shoeList.
////            shoeList.forEach { shoe ->
////                Timber.i("${shoe.name} ${shoe.size} ${shoe.company} ${shoe.description}")
////            }
//        }

        var args = ShoeListFragmentArgs.fromBundle(requireArguments())
        Timber.i("${args.shoeName} ${args.shoeSize} ${args.shoeCompany} ${args.shoeDescription}")


        binding.addShoeButton.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeAddFragment())
        }

        return binding.root
    }
}
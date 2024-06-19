package com.udacity.shoestore.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoelistFragmentBinding
import timber.log.Timber

class ShoeListFragment : Fragment() {

//    private val viewModel = activityViewModels<ShoeListViewModel>().value
    private val viewModel: ShoeListViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding: ShoelistFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoelist_fragment, container, false
        )

//        viewModel = ViewModelProvider(this)[ShoeListViewModel::class.java]

        var args = ShoeListFragmentArgs.fromBundle(requireArguments())
        addShoeFromArgs(args)

        viewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->
            shoeList.forEach { shoe ->
                Timber.i("Shoe: ${shoe.name}")
                val shoeCard = inflater.inflate(R.layout.shoe_card, container, false) as CardView
                shoeCard.findViewById<TextView>(R.id.shoecard_name).text = shoe.name
                shoeCard.findViewById<TextView>(R.id.shoecard_size).text = shoe.size.toString()
                shoeCard.findViewById<TextView>(R.id.shoecard_company).text = shoe.company
                shoeCard.findViewById<TextView>(R.id.shoecard_description).text = shoe.description
                binding.shoeLayout.addView(shoeCard)
            }
        }


        binding.addShoeButton.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeAddFragment())
        }

        return binding.root
    }

    private fun addShoeFromArgs(args: ShoeListFragmentArgs) {
        if (args.shoeName != "" && args.shoeSize != 0 && args.shoeCompany != "" && args.shoeDescription != "") {
            viewModel.addShoe(args.shoeName, args.shoeSize, args.shoeCompany, args.shoeDescription)
        }
    }
}
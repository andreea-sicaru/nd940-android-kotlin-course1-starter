package com.udacity.shoestore.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoelistFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding: ShoelistFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoelist_fragment, container, false
        )

        var args = ShoeListFragmentArgs.fromBundle(requireArguments())
        addShoeFromArgs(args)

        viewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->
            shoeList.forEach { shoe ->
                val shoeCard = createShoeCard(inflater, container, shoe)
                binding.shoeLayout.addView(shoeCard)
            }
        }

        binding.addShoeButton.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeAddFragment())
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addShoeFromArgs(args: ShoeListFragmentArgs) {
        if (args.shoeName != "" && args.shoeSize != 0 && args.shoeCompany != "" && args.shoeDescription != "") {
            viewModel.addShoe(args.shoeName, args.shoeSize, args.shoeCompany, args.shoeDescription)
        }
    }

    private fun createShoeCard(
        inflater: LayoutInflater,
        container: ViewGroup?,
        shoe: Shoe
    ): CardView {
        val shoeCard = inflater.inflate(R.layout.shoe_card, container, false) as CardView
        shoeCard.findViewById<TextView>(R.id.shoecard_name).text = shoe.name
        shoeCard.findViewById<TextView>(R.id.shoecard_size).text = shoe.size.toString()
        shoeCard.findViewById<TextView>(R.id.shoecard_company).text = shoe.company
        shoeCard.findViewById<TextView>(R.id.shoecard_description).text = shoe.description
        return shoeCard
    }
}
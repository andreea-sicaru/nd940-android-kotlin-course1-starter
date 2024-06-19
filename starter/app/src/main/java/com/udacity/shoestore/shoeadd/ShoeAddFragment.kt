package com.udacity.shoestore.shoeadd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeaddFragmentBinding

class ShoeAddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ShoeaddFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoeadd_fragment, container, false
        )

        return binding.root
    }
}
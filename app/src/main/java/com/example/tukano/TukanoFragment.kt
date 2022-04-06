package com.example.tukano

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.tukano.databinding.TukanoUI

class TukanoFragment : Fragment() {
    private lateinit var binding: TukanoUI
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = TukanoUI.inflate(inflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity = (requireActivity() as AppCompatActivity)
        var actionBar = activity.supportActionBar
        actionBar?.hide()
    }
}
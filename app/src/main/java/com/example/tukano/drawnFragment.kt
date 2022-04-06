package com.example.tukano

import android.R
import android.content.DialogInterface
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tukano.databinding.DrawnUI
import com.github.gcacace.signaturepad.views.SignaturePad
import com.google.android.material.snackbar.Snackbar
import com.madrapps.pikolo.ColorPicker
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener


private lateinit var binding: DrawnUI
class drawnFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DrawnUI.inflate(inflater)

        binding.signaturePad.setOnSignedListener(object : SignaturePad.OnSignedListener {
            override fun onStartSigning() {
                //Event triggered when the pad is touched

            }

            override fun onSigned() {
                //Event triggered when the pad is signed

            }

            override fun onClear() {
                Toast.makeText(
                    context,
                    "Desenho apagado com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()
            }


        })

        binding.btnDelete.setOnClickListener {
            binding.signaturePad.clear()
        }


        binding.btnChangeColor.setOnClickListener {
            binding.colChangeColor.visibility = View.VISIBLE
            binding.btnChangeConfirm.visibility = View.VISIBLE
            binding.colChangeColor.setColorSelectionListener(object : SimpleColorSelectionListener() {
                override fun onColorSelected(color: Int) {
                    // Do whatever you want with the color
                    binding.signaturePad.setPenColor(color)
                }
            })
        }

        binding.btnChangeConfirm.setOnClickListener {
            it.visibility = View.GONE
            binding.colChangeColor.visibility = View.GONE
        }
        return binding.root
    }




}
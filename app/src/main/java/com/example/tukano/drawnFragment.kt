package com.example.tukano

import android.content.DialogInterface
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.example.tukano.databinding.ColorDialogUI
import com.example.tukano.databinding.DrawnUI
import com.example.tukano.databinding.SettingsDialogUI
import com.github.gcacace.signaturepad.views.SignaturePad
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener


private lateinit var binding: DrawnUI
class drawnFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DrawnUI.inflate(inflater)
        val bindingColor = ColorDialogUI.inflate(inflater)

        val builder = android.app.AlertDialog.Builder(requireContext())

        builder
            .setTitle("Selecione a cor desejada")
            .setPositiveButton("Confirmar", DialogInterface.OnClickListener { dialog, which ->

            })
            .setView(bindingColor.root)
        val dialog = builder.create()

        val bindingConfig = SettingsDialogUI.inflate(inflater)

        val builderConfig = android.app.AlertDialog.Builder(requireContext())
        builderConfig
            .setTitle("Configurações do Pincel")
            .setPositiveButton("Confirmar", DialogInterface.OnClickListener { dialog, which ->

            })
            .setView(bindingConfig.root)
        val dialogConfig = builderConfig.create()

        binding.signaturePad.setOnSignedListener(object : SignaturePad.OnSignedListener {
            override fun onStartSigning() {
                //Event triggered when the pad is touched

            }

            override fun onSigned() {
                //Event triggered when the pad is signed

            }

            override fun onClear() {

            }


        })

        binding.btnDelete.setOnClickListener {
            binding.signaturePad.clear()
        }


        binding.btnChangeColor.setOnClickListener {

            dialog.show()

            bindingColor.colChangeColor.setColorSelectionListener(object : SimpleColorSelectionListener() {
                override fun onColorSelected(color: Int) {
                    // Do whatever you want with the color

                    binding.signaturePad.setPenColor(color)
                    //bindingColor.btnChangeConfirm.colorNormal = color
                    //bindingColor.btnChangeConfirm.colorPressed = color
                }
            })
            }




        binding.btnSettings.setOnClickListener {
            dialogConfig.show()
        }



        bindingConfig.sekPencil.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.signaturePad.setMinWidth(progress-2f)
                bindingConfig.txtSize.text = "Tamanho: $progress"
                binding.signaturePad.setMaxWidth(progress+2f)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        bindingConfig.sekVelocity.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var press = progress/100
                binding.signaturePad.setVelocityFilterWeight(press.toFloat())
                bindingConfig.txtVelocity.text = "Velocidade: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })





        return binding.root
    }




}
package com.example.hw1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.hw1.databinding.FragmentDialerBinding

/**
 * A simple [Fragment] subclass.
 * Use the [DialerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DialerFragment : Fragment() {

    private lateinit var phoneNumberText: TextView

    private lateinit var callButton: Button
    private lateinit var eraseButton: Button
    private lateinit var speedDialButton1: Button
    private lateinit var speedDialButton2: Button
    private lateinit var speedDialButton3: Button

    private val contactViewModel: ContactViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentDialerBinding>(inflater, R.layout.fragment_dialer,
            container, false)


        phoneNumberText = binding.phoneNumberText

        callButton = binding.buttonCall
        eraseButton = binding.buttonErase

        speedDialButton1 = binding.buttonSpeedDial1
        speedDialButton2 = binding.buttonSpeedDial2
        speedDialButton3 = binding.buttonSpeedDial3

        val keypadButtons: Array<Button> = arrayOf(
            binding.button0,
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4,
            binding.button5,
            binding.button6,
            binding.button7,
            binding.button8,
            binding.button9,
            binding.buttonPlus,
            binding.buttonHash,
        )

        contactViewModel.currentName1.observe(viewLifecycleOwner, Observer {
            speedDialButton1.text = it
        })

        contactViewModel.currentName2.observe(viewLifecycleOwner, Observer {
            speedDialButton2.text = it
        })

        contactViewModel.currentName3.observe(viewLifecycleOwner, Observer {
            speedDialButton3.text = it
        })

        speedDialButton1.setOnClickListener {
            call(contactViewModel.number1)
        }

        speedDialButton2.setOnClickListener {
            call(contactViewModel.number2)
        }

        speedDialButton3.setOnClickListener {
            call(contactViewModel.number3)
        }

        speedDialButton1.setOnLongClickListener { view: View ->
            view.findNavController().navigate(R.id.action_dialerFragment_to_speedDialFragment)
            contactViewModel.contact = 1
            true
        }

        speedDialButton2.setOnLongClickListener { view: View ->
            view.findNavController().navigate(R.id.action_dialerFragment_to_speedDialFragment)
            contactViewModel.contact = 2
            true
        }

        speedDialButton3.setOnLongClickListener { view: View ->
            view.findNavController().navigate(R.id.action_dialerFragment_to_speedDialFragment)
            contactViewModel.contact = 3
            true
        }

        for (button in keypadButtons){
            button.setOnClickListener {
                if (phoneNumberText.text.toString() == "Dial a number") {
                    phoneNumberText.text = ""
                }
                val newText: String = phoneNumberText.text.toString().plus(button.text.toString())
                phoneNumberText.text = newText
            }
        }

        eraseButton.setOnClickListener {
            if (phoneNumberText.text.toString() != "Dial a number") {
                phoneNumberText.text = phoneNumberText.text.toString().dropLast(1)
            }
            if (phoneNumberText.text.toString().isEmpty()) {
                phoneNumberText.text = "Dial a number"
            }
        }

        callButton.setOnClickListener {
            call(phoneNumberText.text.toString())
        }

        return binding.root
    }

    private fun call(phoneNumber: String) {
        if (phoneNumber.isNotEmpty()){
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNumber")
            startActivity(callIntent)
        }
    }
}
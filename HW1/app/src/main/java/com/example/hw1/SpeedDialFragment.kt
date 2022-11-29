package com.example.hw1

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.hw1.databinding.FragmentSpeedDialBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SpeedDialFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpeedDialFragment : Fragment() {

    private val contactViewModel: ContactViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSpeedDialBinding>(inflater, R.layout.fragment_speed_dial,
            container, false)



        when (contactViewModel.contact){
            1 -> {

                contactViewModel.currentName1.observe(viewLifecycleOwner, Observer {
                    if (it.isNotEmpty()) {
                        binding.speedDialName.hint = it
                    }else{
                        binding.speedDialName.hint = "Contact Name"
                    }
                })

                contactViewModel.currentNumber1.observe(viewLifecycleOwner, Observer {
                    if (it.isNotEmpty()) {
                        binding.speedDialNumber.hint = it
                    }else{
                        binding.speedDialNumber.hint = "Phone number"
                    }
                })

                binding.confirmButton.setOnClickListener { view: View ->
                    // Update the contact name if changed
                    if (binding.speedDialName.text.toString().isNotEmpty()) {
                        contactViewModel.name1 = binding.speedDialName.text.toString()
                        contactViewModel.currentName1.value = contactViewModel.name1
                    }
                    // Update the contact number if changed
                    if (binding.speedDialNumber.text.toString().isNotEmpty()) {
                        contactViewModel.number1 = binding.speedDialNumber.text.toString()
                        contactViewModel.currentNumber1.value = contactViewModel.number1
                    }
                    // Go to dialer screen
                    view.findNavController().navigate(R.id.action_speedDialFragment_to_dialerFragment)
                }

            }
            2 -> {

                contactViewModel.currentName2.observe(viewLifecycleOwner, Observer {
                    if (it.isNotEmpty()) {
                        binding.speedDialName.hint = it
                    }else{
                        binding.speedDialName.hint = "Contact Name"
                    }
                })

                contactViewModel.currentNumber2.observe(viewLifecycleOwner, Observer {
                    if (it.isNotEmpty()) {
                        binding.speedDialNumber.hint = it
                    }else{
                        binding.speedDialNumber.hint = "Phone number"
                    }
                })

                binding.confirmButton.setOnClickListener { view: View ->
                    // Update the contact name if changed
                    if (binding.speedDialName.text.toString().isNotEmpty()) {
                        contactViewModel.name2 = binding.speedDialName.text.toString()
                        contactViewModel.currentName2.value = contactViewModel.name2
                    }
                    // Update the contact number if changed
                    if (binding.speedDialNumber.text.toString().isNotEmpty()) {
                        contactViewModel.number2 = binding.speedDialNumber.text.toString()
                        contactViewModel.currentNumber2.value = contactViewModel.number2
                    }
                    // Go to dialer screen
                    view.findNavController().navigate(R.id.action_speedDialFragment_to_dialerFragment)
                }

            }

            3 -> {

                contactViewModel.currentName3.observe(viewLifecycleOwner, Observer {
                    if (it.isNotEmpty()) {
                        binding.speedDialName.hint = it
                    }else{
                        binding.speedDialName.hint = "Contact Name"
                    }
                })

                contactViewModel.currentNumber3.observe(viewLifecycleOwner, Observer {
                    if (it.isNotEmpty()) {
                        binding.speedDialNumber.hint = it
                    }else{
                        binding.speedDialNumber.hint = "Phone number"
                    }
                })

                binding.confirmButton.setOnClickListener { view: View ->
                    // Update the contact name if changed
                    if (binding.speedDialName.text.toString().isNotEmpty()) {
                        contactViewModel.name3 = binding.speedDialName.text.toString()
                        contactViewModel.currentName3.value = contactViewModel.name3
                    }
                    // Update the contact number if changed
                    if (binding.speedDialNumber.text.toString().isNotEmpty()) {
                        contactViewModel.number3 = binding.speedDialNumber.text.toString()
                        contactViewModel.currentNumber3.value = contactViewModel.number3
                    }
                    // Go to dialer screen
                    view.findNavController().navigate(R.id.action_speedDialFragment_to_dialerFragment)
                }

            }
            else -> {}
        }
        return binding.root
    }

}
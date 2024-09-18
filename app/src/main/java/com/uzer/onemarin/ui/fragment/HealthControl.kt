package com.uzer.onemarin.ui.fragment

import HealthControlViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uzer.onemarin.databinding.FragmentHealthControlBinding
import com.uzer.onemarin.network.NetworkClient
import com.uzer.onemarin.viewmodel.HealthControlViewModel

class HealthControl : Fragment() {

    private lateinit var binding: FragmentHealthControlBinding
    private lateinit var healthControlViewModel: HealthControlViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHealthControlBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val repository = NetworkClient.apiService
        val factory = HealthControlViewModelFactory(repository)
        healthControlViewModel = ViewModelProvider(this, factory).get(HealthControlViewModel::class.java)


        healthControlViewModel.apiStatus.observe(viewLifecycleOwner, Observer { isHealthy ->
            if (isHealthy) {
                binding.txtConnection.text = "Connected"
            } else {
                binding.txtConnection.text = "Not Connected"
            }
        })
    }

    override fun onResume() {
        super.onResume()
        healthControlViewModel.checkApiHealth()
    }
}
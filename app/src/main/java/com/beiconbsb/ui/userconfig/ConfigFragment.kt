package com.beiconbsb.ui.userconfig

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.beiconbsb.R
import com.beiconbsb.core.Status
import com.beiconbsb.databinding.FragmentDrwConfigBinding
import com.beiconbsb.ui.login.LoginActivity
import com.beiconbsb.ui.logout.LogOutViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfigFragment : Fragment(R.layout.fragment_drw_config) {

    private lateinit var binding: FragmentDrwConfigBinding
    private val logOutViewModel: LogOutViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDrwConfigBinding.bind(view)

        binding.userConfigLogout.setOnClickListener {
            logOutViewModel.logOut().observe(viewLifecycleOwner) { result ->
                when (result) {
                    is Status.Loading -> {
                    }
                    is Status.Success -> {
                        startActivity(Intent(requireContext(), LoginActivity::class.java))
                        activity?.finish()
                    }
                    is Status.Failure -> {
                    }
                }
            }
        }

    }
}
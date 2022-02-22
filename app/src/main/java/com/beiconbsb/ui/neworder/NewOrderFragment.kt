package com.beiconbsb.ui.neworder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.beiconbsb.R
import com.beiconbsb.core.Status
import com.beiconbsb.data.model.BurgerFirestore
import com.beiconbsb.databinding.FragmentNeworderBinding
import com.beiconbsb.ui.login.LoginActivity
import com.beiconbsb.ui.neworder.adapter.BurgersApadter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewOrderFragment : Fragment(R.layout.fragment_neworder) {

    private lateinit var binding: FragmentNeworderBinding
    private lateinit var burgerAdapter: BurgersApadter

    private val viewModel: NewOrderViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNeworderBinding.bind(view)
        getBurgersList()
        getVeggieBurgerList()


    }


    private fun getBurgersList() {
        viewModel.getAvaliableBurgerList().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Status.Loading -> {
                    //TODO Mostrar progress dialog
                    Log.d("BURGERLIST", "LOADING...")
                }
                is Status.Success -> {
                    Log.d("BURGERLIST", result.data.toString())
                    setDataAndShowRecycler(result.data, binding.orderRvgridSize)

                }
                is Status.Failure -> {
                    Log.d("BURGERLIST", "FALLÓ: ${result.exception.message}")
                }
            }
        }
    }

    private fun getVeggieBurgerList() {
        viewModel.getVeggieBurgerList().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Status.Loading -> {
                    //TODO Mostrar progress dialog
                    Log.d("VBURGERLIST", "LOADING...")
                }
                is Status.Success -> {
                    Log.d("VBURGERLIST", result.data.toString())
                    setDataAndShowRecycler(result.data, binding.orderRecyclerVeggies)

                }
                is Status.Failure -> {
                    Log.d("VBURGERLIST", "FALLÓ: ${result.exception.message}")
                }
            }
        }
    }

    private fun setDataAndShowRecycler(
        burgerList: List<BurgerFirestore>,
        recyclerView: RecyclerView
    ) {
        burgerAdapter = BurgersApadter(burgerList)
        recyclerView.adapter = burgerAdapter
    }

}
package com.beiconbsb.ui.neworder.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beiconbsb.data.model.BurgerFirestore
import com.beiconbsb.databinding.ItemSizeBurgerBinding
import com.bumptech.glide.Glide

class BurgersApadter(val burgerList: List<BurgerFirestore>) :
    RecyclerView.Adapter<BurgersApadter.BurguersHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BurguersHolder {
        return BurguersHolder(
            ItemSizeBurgerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BurguersHolder, position: Int) {
        holder.render(burgerList[position])
    }

    override fun getItemCount() = burgerList.size


    class BurguersHolder(val binding: ItemSizeBurgerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun render(burger: BurgerFirestore) {
            binding.orderTxtPrice.text = "$ ${burger.price.toString()}"
            Glide.with(binding.elementImageBurger).load(burger.imgUrl).centerCrop().fitCenter().into(binding.elementImageBurger)
        }

    }
}
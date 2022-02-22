package com.beiconbsb.data.neworder

import com.beiconbsb.data.model.BurgerFirestore
import com.beiconbsb.utils.AppConstants
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.tasks.await

class NewOrderDataSource {

    suspend fun getBurgerList(): List<BurgerFirestore> {

        var burgerList = mutableListOf<BurgerFirestore>()
        val querySnapshot = FirebaseFirestore.getInstance().collection(AppConstants.BURGER_COLLECTION).orderBy("price", Query.Direction.ASCENDING).get().await()

        for (burger in querySnapshot.documents) {

            burger.toObject(BurgerFirestore::class.java)?.let { burgerList.add(it) }

        }
        return burgerList
    }


    suspend fun getVeggieBurgerList(): List<BurgerFirestore> {

        var burgerList = mutableListOf<BurgerFirestore>()
        val querySnapshot = FirebaseFirestore.getInstance().collection(AppConstants.VEGGIE_BURGER_COLLECTION).get().await()

        for (burger in querySnapshot.documents) {

            burger.toObject(BurgerFirestore::class.java)?.let { burgerList.add(it) }

        }
        return burgerList

    }

}

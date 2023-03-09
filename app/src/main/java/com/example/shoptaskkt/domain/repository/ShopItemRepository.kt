package com.example.shoptaskkt.domain.repository

import com.example.shoptaskkt.domain.models.ShopItemModel

interface ShopItemRepository {

    fun getShopItem(): ShopItemModel
}
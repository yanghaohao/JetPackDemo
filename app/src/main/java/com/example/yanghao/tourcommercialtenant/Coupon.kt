package com.example.yanghao.tourcommercialtenant

import java.io.Serializable

/**
 * @author younghow
 * @date 2021/8/6
 */
class Coupon : Serializable {
    /**
     * Status : 1
     * Message : null
     * NewID : null
     * Entity : {"Id":5,"ShopId":23,"UserId":"53","Name":"火锅优惠券","Content":"土豆t一份n藕片t一份","termOfValidity":"3日内有效","time":"9月31日之前","userule":"","Status":"0","Limit":null,"UniqueCode":"b2dbd728-b8ee-4483-bca3-4f0ee1d10b98","denomination":"100","money":0.01}
     * TotalPages : 0
     * TotalRowsCount : 0
     */
    var status = 0
    var message: Any? = null
    var newId: Any? = null
    var entity: EntityBean? = null
    var totalPages = 0
    var totalRowsCount = 0

    class EntityBean : Serializable {
        /**
         * Id : 5
         * ShopId : 23
         * UserId : 53
         * Name : 火锅优惠券
         * Content : 土豆t一份n藕片t一份
         * termOfValidity : 3日内有效
         * time : 9月31日之前
         * userule :
         * Status : 0
         * Limit : null
         * UniqueCode : b2dbd728-b8ee-4483-bca3-4f0ee1d10b98
         * denomination : 100
         * money : 0.01
         */
        var id = 0
        var shopId = 0
        var userId: String? = null
        var name: String? = null
        var content: String? = null
        var termOfValidity: String? = null
        var time: String? = null
        var useful: String? = null
        var status: String? = null
        var limit: Any? = null
        var uniqueCode: String? = null
        var denomination: String? = null
        var money = 0.0
    }
}
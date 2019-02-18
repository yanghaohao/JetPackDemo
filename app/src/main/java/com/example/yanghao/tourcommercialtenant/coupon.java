package com.example.yanghao.tourcommercialtenant;

import java.io.Serializable;

public class coupon implements Serializable {

    /**
     * Status : 1
     * Message : null
     * NewID : null
     * Entity : {"Id":5,"ShopId":23,"UserId":"53","Name":"火锅优惠券","Content":"土豆t一份n藕片t一份","termOfValidity":"3日内有效","time":"9月31日之前","userule":"","Status":"0","Limit":null,"UniqueCode":"b2dbd728-b8ee-4483-bca3-4f0ee1d10b98","denomination":"100","money":0.01}
     * TotalPages : 0
     * TotalRowsCount : 0
     */

    private int Status;
    private Object Message;
    private Object NewID;
    private EntityBean Entity;
    private int TotalPages;
    private int TotalRowsCount;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public Object getMessage() {
        return Message;
    }

    public void setMessage(Object Message) {
        this.Message = Message;
    }

    public Object getNewID() {
        return NewID;
    }

    public void setNewID(Object NewID) {
        this.NewID = NewID;
    }

    public EntityBean getEntity() {
        return Entity;
    }

    public void setEntity(EntityBean Entity) {
        this.Entity = Entity;
    }

    public int getTotalPages() {
        return TotalPages;
    }

    public void setTotalPages(int TotalPages) {
        this.TotalPages = TotalPages;
    }

    public int getTotalRowsCount() {
        return TotalRowsCount;
    }

    public void setTotalRowsCount(int TotalRowsCount) {
        this.TotalRowsCount = TotalRowsCount;
    }

    public static class EntityBean implements Serializable{
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

        private int Id;
        private int ShopId;
        private String UserId;
        private String Name;
        private String Content;
        private String termOfValidity;
        private String time;
        private String userule;
        private String Status;
        private Object Limit;
        private String UniqueCode;
        private String denomination;
        private double money;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getShopId() {
            return ShopId;
        }

        public void setShopId(int ShopId) {
            this.ShopId = ShopId;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String UserId) {
            this.UserId = UserId;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public String getTermOfValidity() {
            return termOfValidity;
        }

        public void setTermOfValidity(String termOfValidity) {
            this.termOfValidity = termOfValidity;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getUserule() {
            return userule;
        }

        public void setUserule(String userule) {
            this.userule = userule;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public Object getLimit() {
            return Limit;
        }

        public void setLimit(Object Limit) {
            this.Limit = Limit;
        }

        public String getUniqueCode() {
            return UniqueCode;
        }

        public void setUniqueCode(String UniqueCode) {
            this.UniqueCode = UniqueCode;
        }

        public String getDenomination() {
            return denomination;
        }

        public void setDenomination(String denomination) {
            this.denomination = denomination;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }
    }
}

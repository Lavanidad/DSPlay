package com.deepspring.dsplay.bean;

import java.io.Serializable;

/**
 * Created by Anonym on 2017/3/6.
 */

public class AppInfo implements Serializable {

        /**
         * addTime : 0
         * hasSameDevApp : false
         * videoId : 0
         * source :
         * versionName : 7.8.6
         * hdIcon : {"main":"AppStore/02d455182b6b0dccb2f490e29d6257f69ac43fab3"}
         * ratingScore : 4.5
         * briefShow : 吃喝玩乐，应有尽有，优惠多多
         * developerId : 0
         * fitness : 0
         * id : 98
         * level1CategoryId : 9
         * releaseKeyHash : c4706130e3aa946812dd424d06b24858
         * relateAppHasMore : false
         * rId : 0
         * suitableType : 0
         * briefUseIntro : false
         * ads : 0
         * publisherName : 北京三快科技有限公司
         * level2CategoryId : 161
         * position : 0
         * favorite : false
         * isFavorite : false
         * appendSize : 0
         * level1CategoryName : 时尚购物
         * samDevAppHasMore : false
         * displayName : 美团
         * icon : AppStore/0e1f1411e9e9f5381639c9fe89c36e3154243c2ba
         * screenshot : AppStore/0fbc94230b7417ec0b29cd0c27afea4b9cc409cd5,AppStore/02bc95430c7b14ec7029c90c2cdfed4a92408ab9f,AppStore/07e7247bbaa6412d9ebb8b90f6073a581a543f385,AppStore/0fbc94230b7417ec0629c30c2bafeb4b9ec409cd5,AppStore/08b0d45da5d74cdcd15f0124bd3a5f00bdf434525
         * ratingTotalCount : 0
         * adType : 0
         * apkSize : 34304592
         * packageName : com.sankuai.meituan
         * updateTime : 1488506397462
         * grantCode : 0
         * versionCode : 486
         * diffFileSize : 0
         */

        private int addTime;
        private boolean hasSameDevApp;
        private int videoId;
        private String source;
        private String versionName;
        private HdIconBean hdIcon;
        private double ratingScore;
        private String briefShow;
        private int developerId;
        private int fitness;
        private int id;
        private int level1CategoryId;
        private String releaseKeyHash;
        private boolean relateAppHasMore;
        private int rId;
        private int suitableType;
        private boolean briefUseIntro;
        private int ads;
        private String publisherName;
        private int level2CategoryId;
        private int position;
        private boolean favorite;
        private boolean isFavorite;
        private int appendSize;
        private String level1CategoryName;
        private boolean samDevAppHasMore;
        private String displayName;
        private String icon;
        private String screenshot;
        private int ratingTotalCount;
        private int adType;
        private int apkSize;
        private String packageName;
        private long updateTime;
        private int grantCode;
        private int versionCode;
        private int diffFileSize;

        public int getAddTime() {
            return addTime;
        }

        public void setAddTime(int addTime) {
            this.addTime = addTime;
        }

        public boolean isHasSameDevApp() {
            return hasSameDevApp;
        }

        public void setHasSameDevApp(boolean hasSameDevApp) {
            this.hasSameDevApp = hasSameDevApp;
        }

        public int getVideoId() {
            return videoId;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        public HdIconBean getHdIcon() {
            return hdIcon;
        }

        public void setHdIcon(HdIconBean hdIcon) {
            this.hdIcon = hdIcon;
        }

        public double getRatingScore() {
            return ratingScore;
        }

        public void setRatingScore(double ratingScore) {
            this.ratingScore = ratingScore;
        }

        public String getBriefShow() {
            return briefShow;
        }

        public void setBriefShow(String briefShow) {
            this.briefShow = briefShow;
        }

        public int getDeveloperId() {
            return developerId;
        }

        public void setDeveloperId(int developerId) {
            this.developerId = developerId;
        }

        public int getFitness() {
            return fitness;
        }

        public void setFitness(int fitness) {
            this.fitness = fitness;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLevel1CategoryId() {
            return level1CategoryId;
        }

        public void setLevel1CategoryId(int level1CategoryId) {
            this.level1CategoryId = level1CategoryId;
        }

        public String getReleaseKeyHash() {
            return releaseKeyHash;
        }

        public void setReleaseKeyHash(String releaseKeyHash) {
            this.releaseKeyHash = releaseKeyHash;
        }

        public boolean isRelateAppHasMore() {
            return relateAppHasMore;
        }

        public void setRelateAppHasMore(boolean relateAppHasMore) {
            this.relateAppHasMore = relateAppHasMore;
        }

        public int getRId() {
            return rId;
        }

        public void setRId(int rId) {
            this.rId = rId;
        }

        public int getSuitableType() {
            return suitableType;
        }

        public void setSuitableType(int suitableType) {
            this.suitableType = suitableType;
        }

        public boolean isBriefUseIntro() {
            return briefUseIntro;
        }

        public void setBriefUseIntro(boolean briefUseIntro) {
            this.briefUseIntro = briefUseIntro;
        }

        public int getAds() {
            return ads;
        }

        public void setAds(int ads) {
            this.ads = ads;
        }

        public String getPublisherName() {
            return publisherName;
        }

        public void setPublisherName(String publisherName) {
            this.publisherName = publisherName;
        }

        public int getLevel2CategoryId() {
            return level2CategoryId;
        }

        public void setLevel2CategoryId(int level2CategoryId) {
            this.level2CategoryId = level2CategoryId;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public boolean isFavorite() {
            return favorite;
        }

        public void setFavorite(boolean favorite) {
            this.favorite = favorite;
        }

        public boolean isIsFavorite() {
            return isFavorite;
        }

        public void setIsFavorite(boolean isFavorite) {
            this.isFavorite = isFavorite;
        }

        public int getAppendSize() {
            return appendSize;
        }

        public void setAppendSize(int appendSize) {
            this.appendSize = appendSize;
        }

        public String getLevel1CategoryName() {
            return level1CategoryName;
        }

        public void setLevel1CategoryName(String level1CategoryName) {
            this.level1CategoryName = level1CategoryName;
        }

        public boolean isSamDevAppHasMore() {
            return samDevAppHasMore;
        }

        public void setSamDevAppHasMore(boolean samDevAppHasMore) {
            this.samDevAppHasMore = samDevAppHasMore;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getScreenshot() {
            return screenshot;
        }

        public void setScreenshot(String screenshot) {
            this.screenshot = screenshot;
        }

        public int getRatingTotalCount() {
            return ratingTotalCount;
        }

        public void setRatingTotalCount(int ratingTotalCount) {
            this.ratingTotalCount = ratingTotalCount;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public int getApkSize() {
            return apkSize;
        }

        public void setApkSize(int apkSize) {
            this.apkSize = apkSize;
        }

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getGrantCode() {
            return grantCode;
        }

        public void setGrantCode(int grantCode) {
            this.grantCode = grantCode;
        }

        public int getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(int versionCode) {
            this.versionCode = versionCode;
        }

        public int getDiffFileSize() {
            return diffFileSize;
        }

        public void setDiffFileSize(int diffFileSize) {
            this.diffFileSize = diffFileSize;
        }

        public static class HdIconBean {
            /**
             * main : AppStore/02d455182b6b0dccb2f490e29d6257f69ac43fab3
             */

            private String main;

            public String getMain() {
                return main;
            }

            public void setMain(String main) {
                this.main = main;
            }
        }
}

package com.seekerzhouk.android.littlenews.bean;

public class TransformBean {

    /**
     * msg : ok
     * url : http://v3-dy.ixigua.com/04e2ce7a11065e6fe134f14a3deafff1/5ba13714/video/m/220c9678662c7434fb58bbe4ed799ab8438115b7c6b000038a37aeedcab/
     * vinfo : {"cover":"https://p3.pstatp.com/large/bad100028c243328bf78.jpg","title":"#搞笑 猴：你这是在逗我呢？"}
     * userinfo : {"avatar":"https://p3.pstatp.com/aweme/100x100/b6ed0027ceaa30350fa3.jpeg","nickname":"倾洛半城"}
     */

    private String msg;
    private String url;
    private VinfoBean vinfo;
    private UserinfoBean userinfo;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public VinfoBean getVinfo() {
        return vinfo;
    }

    public void setVinfo(VinfoBean vinfo) {
        this.vinfo = vinfo;
    }

    public UserinfoBean getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserinfoBean userinfo) {
        this.userinfo = userinfo;
    }

    public static class VinfoBean {
        /**
         * cover : https://p3.pstatp.com/large/bad100028c243328bf78.jpg
         * title : #搞笑 猴：你这是在逗我呢？
         */

        private String cover;
        private String title;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class UserinfoBean {
        /**
         * avatar : https://p3.pstatp.com/aweme/100x100/b6ed0027ceaa30350fa3.jpeg
         * nickname : 倾洛半城
         */

        private String avatar;
        private String nickname;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }
}

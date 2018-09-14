package com.example.android.littlenews.bean;

import java.util.List;

public class NewsBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-09-10 00:00","title":"男子问警察\u201c我是不是犯事儿了\u201d 一查真是网上追逃人员","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_37/93F5858EB8CBF4244CDED114DCF933F08E15B3AE_w630_h496.jpg","url":"http://news.ifeng.com/a/20180910/60045732_0.shtml"},{"ctime":"2018-09-10 00:00","title":"网红殴打孕妇致其先兆流产：生下来也不是好东西","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_37/D974BC3C690C543C05C57032EB782C232CC8DE69_w440_h330.jpg","url":"http://news.ifeng.com/a/20180910/60045902_0.shtml"},{"ctime":"2018-09-10 00:00","title":"涟源官方回应：没查到\u201c史润龙\u201d，报道系移花接木","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/2018_37/68B5DF19164295FCC7067535AF0A539FE1B71EFB_w566_h719.png","url":"http://news.ifeng.com/a/20180910/60045449_0.shtml"},{"ctime":"2018-09-10 00:00","title":"胡锡进：冯小刚应坦然面对监督，不能一被骂就受不了","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_37/93F5858EB8CBF4244CDED114DCF933F08E15B3AE_w630_h496.jpg","url":"http://news.ifeng.com/a/20180910/60045452_0.shtml"},{"ctime":"2018-09-10 00:00","title":"加多宝与王老吉的\u201c红罐之争\u201d 终于尘埃落定","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/2018_37/68B5DF19164295FCC7067535AF0A539FE1B71EFB_w566_h719.png","url":"http://news.ifeng.com/a/20180910/60045250_0.shtml"},{"ctime":"2018-09-10 00:00","title":"胡锡进：房产税的制定不宜搞\u201c保密\u201d","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/2018_37/68B5DF19164295FCC7067535AF0A539FE1B71EFB_w566_h719.png","url":"http://news.ifeng.com/a/20180910/60044506_0.shtml"},{"ctime":"2018-09-10 00:00","title":"西安又有开发商自己揭发自己 卖了8年的房想收回去","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0910/D723A2C7C8F2BD00802CA02471CF75C552BEBCA4_size23_w540_h260.jpeg","url":"http://news.ifeng.com/a/20180910/60044102_0.shtml"},{"ctime":"2018-09-10 00:00","title":"滴滴仍给无营运证黑车司机派单 还替被扣车司机付罚款","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_37/25908F36D587C787C832DBB98047A63058B05D88_w603_h419.png","url":"http://news.ifeng.com/a/20180910/60043661_0.shtml"},{"ctime":"2018-09-10 00:00","title":"男子身份证被派出所\u201c错制\u201d 天降3000万债务成老赖","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_37/25908F36D587C787C832DBB98047A63058B05D88_w603_h419.png","url":"http://news.ifeng.com/a/20180910/60043369_0.shtml"},{"ctime":"2018-09-09 00:00","title":"赖昌星因心肌梗塞去世消息不实","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_37/25908F36D587C787C832DBB98047A63058B05D88_w603_h419.png","url":"http://news.ifeng.com/a/20180909/60042558_0.shtml"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2018-09-10 00:00
         * title : 男子问警察“我是不是犯事儿了” 一查真是网上追逃人员
         * description : 凤凰社会
         * picUrl : http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_37/93F5858EB8CBF4244CDED114DCF933F08E15B3AE_w630_h496.jpg
         * url : http://news.ifeng.com/a/20180910/60045732_0.shtml
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}

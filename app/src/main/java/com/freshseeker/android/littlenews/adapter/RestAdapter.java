package com.freshseeker.android.littlenews.adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.freshseeker.android.littlenews.config.MyDataBaseHelper;
import com.freshseeker.android.littlenews.fragment.MyItemClickListener;
import com.freshseeker.android.littlenews.R;
import com.freshseeker.android.littlenews.config.SQLTableString;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class RestAdapter extends RecyclerView.Adapter {
    private Context context;
    private LayoutInflater inflater;
    private MyItemClickListener myItemClickListener;
    private RequestOptions options;
    private int sectionNumber;
    private SQLiteDatabase db;

    public RestAdapter(Context context, int sectionNumber) {
        this.context = context;
        this.sectionNumber = sectionNumber;
        this.inflater = LayoutInflater.from(context);
        options = new RequestOptions().placeholder(R.drawable.ic_loading).error(R.drawable.ic_null);
        MyDataBaseHelper dbHelper = new MyDataBaseHelper(context, "TableStore.db", null, 1);
        db = dbHelper.getWritableDatabase();

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (SQLTableString.restTableName[sectionNumber].equals("Pictures")) {
            return new PicViewHolder(inflater.inflate(R.layout.item_rest_pic, null));
        } else {
            return new VideoViewHolder(inflater.inflate(R.layout.item_rest_video, null));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        if (SQLTableString.restTableName[sectionNumber].equals("Pictures")) {
            PicViewHolder picViewHolder = (PicViewHolder) holder;
            //查询出第(position+1)行数据
            final Cursor cursor = db.query(SQLTableString.restTableName[sectionNumber],
                    null, "id = ?", new String[]{String.valueOf(position + 1)},
                    null, null, null, null);
            if (cursor.moveToFirst()) {
                Glide.with(context)//使用Glide显示图片
                        .load(cursor.getString(cursor.getColumnIndex("url")))
                        .apply(options)
                        .into(picViewHolder.imageView);
                //为ItemView设置点击事件
                picViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    String url = cursor.getString(cursor.getColumnIndex("url"));
                    @Override
                    public void onClick(View v) {
                        myItemClickListener.onItemClick(url);//调用RestFragment中的onItemClick()方法。
                    }
                });
            }
            cursor.close();

        } else {
            VideoViewHolder videoViewHolder = (VideoViewHolder) holder;
            //查询出第(position+1)行数据
            final Cursor cursor = db.query(SQLTableString.restTableName[sectionNumber],
                    null, "id = ?", new String[]{String.valueOf(position + 1)},
                    null, null, null, null);

            if (cursor.moveToFirst()) {
                String url = cursor.getString(cursor.getColumnIndex("url"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String cover = cursor.getString(cursor.getColumnIndex("cover"));
                videoViewHolder.jzvdStd.setUp(url, title, Jzvd.SCREEN_WINDOW_NORMAL);
                Glide.with(context)
                        .load(cover)
                        .apply(options)
                        .into(videoViewHolder.jzvdStd.thumbImageView);
            }
            cursor.close();
        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    //绑定RestFragment传进来的点击监听器
    public void setOnItemClickListener(MyItemClickListener listener) {
        this.myItemClickListener = listener;
    }


    class PicViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        PicViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item_imgsrc);
        }
    }


    class VideoViewHolder extends RecyclerView.ViewHolder {

        private JzvdStd jzvdStd;

        VideoViewHolder(View itemView) {
            super(itemView);
            jzvdStd = itemView.findViewById(R.id.player_video);
        }
    }



}

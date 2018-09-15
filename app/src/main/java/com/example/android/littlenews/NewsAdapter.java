package com.example.android.littlenews;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.android.littlenews.bean.NewsBean;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter {
    private Context context;
    private LayoutInflater inflater;
    private NewsBean newsBean;
    private MyItemClickListener myItemClickListener;
    private RequestOptions options;
    private int sectionNumber;
    private MyDataBaseHelper dbHelper;
    private SQLiteDatabase db;

    NewsAdapter(Context context, int sectionNumber) {
        this.context = context;
        this.sectionNumber = sectionNumber;
        this.inflater = LayoutInflater.from(context);
        options = new RequestOptions().placeholder(R.drawable.ic_loading).error(R.drawable.ic_null);
        dbHelper = new MyDataBaseHelper(context, "TableStore", null, 1);
        db = dbHelper.getWritableDatabase();

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.news_item_rl, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ViewHolder viewHolder = (ViewHolder) holder;

        //查询出数据
        Cursor cursor = db.query(SQLTableString.newsTableName[sectionNumber],
                null, "id = ?", new String[]{String.valueOf(position + 1)},
                null, null, null, null);

        Log.i("NewsAdapter", "onBindViewHolder: --cursor.moveToFirst()="+ cursor.moveToFirst());
        if (cursor.moveToFirst()){
            Log.i("NewsAdapter", "onBindViewHolder: --"+ cursor.getString(cursor.getColumnIndex("picUrl")));

            Glide.with(context)//使用Glide显示图片
                    .load(cursor.getString(cursor.getColumnIndex("picUrl")))
                    .apply(options)
                    .into(viewHolder.imageView);
            viewHolder.title.setText(cursor.getString(cursor.getColumnIndex("title")));
            viewHolder.newsSource.setText(cursor.getString(cursor.getColumnIndex("description")));
        }
        cursor.close();

        //为ItemView设置点击事件
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myItemClickListener.onItemClick(position);//调用NewsFragment中的onItemClick()方法。
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    //绑定MainActivity传进来的点击监听器
    public void setOnItemClickListener(MyItemClickListener listener) {
        this.myItemClickListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView newsSource;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_item_title);
            newsSource = itemView.findViewById(R.id.tv_item_source);
            imageView = itemView.findViewById(R.id.iv_item_imgsrc);
        }
    }


}

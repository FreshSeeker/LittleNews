package com.freshseeker.android.littlenews;

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

public class NewsAdapter extends RecyclerView.Adapter {
    private Context context;
    private LayoutInflater inflater;
    private MyItemClickListener myItemClickListener;
    private RequestOptions options;
    private int sectionNumber;
    private SQLiteDatabase db;

    NewsAdapter(Context context, int sectionNumber) {
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
        return new ViewHolder(inflater.inflate(R.layout.item_news, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ViewHolder viewHolder = (ViewHolder) holder;

        //查询出第(position+1)行数据
        final Cursor cursor = db.query(SQLTableString.newsTableName[sectionNumber],
                null, "id = ?", new String[]{String.valueOf(position + 1)},
                null, null, null, null);

        Log.i("NewsAdapter", "onBindViewHolder: --cursor.moveToFirst()=" + cursor.moveToFirst());
        if (cursor.moveToFirst()) {
            Glide.with(context)//使用Glide显示图片
                    .load(cursor.getString(cursor.getColumnIndex("picUrl")))
                    .apply(options)
                    .into(viewHolder.imageView);
            viewHolder.title.setText(cursor.getString(cursor.getColumnIndex("title")));
            viewHolder.newsSource.setText(cursor.getString(cursor.getColumnIndex("description")));

            //为ItemView设置点击事件
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                String url = cursor.getString(cursor.getColumnIndex("url"));

                @Override
                public void onClick(View v) {
                    myItemClickListener.onItemClick(url);//调用NewsFragment中的onItemClick()方法。
                }
            });
        }
        cursor.close();

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    //绑定MainActivity传进来的点击监听器
    public void setOnItemClickListener(MyItemClickListener listener) {
        this.myItemClickListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView newsSource;
        private ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_item_desc);
            newsSource = itemView.findViewById(R.id.tv_item_source);
            imageView = itemView.findViewById(R.id.iv_item_imgsrc);
        }
    }


}

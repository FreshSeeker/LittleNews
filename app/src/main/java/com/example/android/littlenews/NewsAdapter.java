package com.example.android.littlenews;

import android.content.Context;
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
    private List<NewsBean.NewslistBean> itemList;
    private MyItemClickListener myItemClickListener;
    private RequestOptions options;
    private int sectionNumber;

    NewsAdapter(Context context, int sectionNumber) {
        this.context = context;
        this.sectionNumber = sectionNumber;
        this.inflater = LayoutInflater.from(context);
        options = new RequestOptions().placeholder(R.drawable.ic_loading).error(R.drawable.ic_null);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.news_item_rl, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ViewHolder viewHolder = (ViewHolder) holder;

        Log.i("---NewsAdapter---", "onBindViewHolder: position = " + position);

        if (position == 0) {
            try {
                newsBean = DataMap.newsInstance().get(String.valueOf(sectionNumber));
            } catch (Exception e) {
                Log.d("---NewsAdapter---", "onBindViewHolder: newsBean = " + null);
            } finally {
                if (newsBean != null) {
                    itemList = newsBean.getNewslist();
                }
            }

        }

        if (newsBean != null) {
            Glide.with(context)
                    .load(itemList.get(position).getPicUrl())
                    .apply(options)
                    .into(viewHolder.imageView);
            viewHolder.title.setText(itemList.get(position).getTitle());
            viewHolder.newsSource.setText(itemList.get(position).getDescription());
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myItemClickListener.onItemClick(position);
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

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
import com.example.android.littlenews.bean.GankBean;

import java.util.List;

public class GankAdapter extends RecyclerView.Adapter {
    private Context context;
    private LayoutInflater inflater;
    private GankBean gankBean;
    private List<GankBean.ResultsBean> itemList;
    private RequestOptions options;
    private int sectionNumber;

    GankAdapter(Context context, int sectionNumber) {
        this.context = context;
        this.sectionNumber = sectionNumber;
        this.inflater = LayoutInflater.from(context);
        options = new RequestOptions().placeholder(R.drawable.ic_loading).error(R.drawable.ic_null);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.gank_item_rl, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ViewHolder viewHolder = (ViewHolder) holder;

        Log.i("---GankAdapter---", "onBindViewHolder: position = " + position);

//        if (position == 0) {
//            try {
//                gankBean = DataMap.gankInstance().get(String.valueOf(sectionNumber));
//            } catch (Exception e) {
//                Log.e("---GankAdapter---", "onBindViewHolder: gankBean = " + null);
//            } finally {
//                if (gankBean != null) {
//                    itemList = gankBean.getResults();
//                }else {
//                    Log.i("---GankAdapter---", "onBindViewHolder: gankBean == null");
//                }
//            }
//        }
//
//        if (itemList != null) {
//            if (itemList.get(position).getImages() != null){
//                switch (itemList.get(position).getImages().size()){
//                    case 0:
//                        break;
//                    case 1:
//                        showPictures(position,0, viewHolder.imageView0);
//                        break;
//                    case 2:
//                        showPictures(position,0, viewHolder.imageView0);
//                        showPictures(position,1, viewHolder.imageView1);
//                        break;
//                    case 3:
//                        showPictures(position,0, viewHolder.imageView0);
//                        showPictures(position,1, viewHolder.imageView1);
//                        showPictures(position,2, viewHolder.imageView2);
//                        break;
//                }
//            }
//            viewHolder.desc.setText(itemList.get(position).getDesc());
//        }else {
//            Log.i("---GankAdapter---", "onBindViewHolder: gankBean == null");
//        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView desc;
        private ImageView imageView0;
        private ImageView imageView1;
        private ImageView imageView2;

        public ViewHolder(View itemView) {
            super(itemView);
            desc = itemView.findViewById(R.id.tv_item_desc);
            imageView0 = itemView.findViewById(R.id.iv_item_imgsrc0);
            imageView1 = itemView.findViewById(R.id.iv_item_imgsrc1);
            imageView2 = itemView.findViewById(R.id.iv_item_imgsrc2);
        }
    }

    private void showPictures(int position,int picPos, ImageView imageView){
        Glide.with(context)
                .load(itemList.get(position).getImages().get(picPos))
                .apply(options)
                .into(imageView);
    }

}

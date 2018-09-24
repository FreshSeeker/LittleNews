package com.freshseeker.android.littlenews;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class PictureDialog extends Dialog {

    private ImageView largeImageView;
    private String url;

    public PictureDialog(@NonNull Context context, String url) {
        super(context);
        this.url = url;
    }

    public PictureDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_picture_entry);
        largeImageView = findViewById(R.id.iv_large_image);

        //设置宽高
        WindowManager windowManager = getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        Point size = new Point();
        display.getSize(size);
        layoutParams.width = size.x;
        layoutParams.height = size.y;
        getWindow().setAttributes(layoutParams);

        RequestOptions options = new RequestOptions().placeholder(R.drawable.ic_loading).error(R.drawable.ic_null);
        Glide.with(getContext())
                .load(url)
                .apply(options)
                .into(largeImageView);

        largeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        largeImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new SavePicDialog(getContext(), url).show();
                return true;
            }
        });
    }
}

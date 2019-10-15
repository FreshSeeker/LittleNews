package com.seekerzhouk.android.littlenews.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.seekerzhouk.android.littlenews.R;

public class PictureDialog extends Dialog {

    private ImageView largeImageView;
    private String url;

    public PictureDialog(@NonNull Context context, int themeResId, String url) {
        super(context, themeResId);
        this.url = url;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_picture_entry);
        largeImageView = findViewById(R.id.iv_large_image);

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
                new SavePicDialog(getContext(), R.style.SavePicDialog, url).show();
                return true;
            }
        });
    }

    @Override
    public void show() {
        super.show();
        //设置宽高
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;

        getWindow().getDecorView().setPadding(0, 0, 0, 0);

        getWindow().setAttributes(layoutParams);
    }
}

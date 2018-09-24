package com.freshseeker.android.littlenews.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.freshseeker.android.littlenews.R;
import com.freshseeker.android.littlenews.module.GetImageCacheAsyncTask;

public class SavePicDialog extends Dialog {

    private TextView textSave;
    private String url;

    public SavePicDialog(@NonNull Context context,String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_save);

        //设置宽高
        WindowManager windowManager = getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        Point size = new Point();
        display.getSize(size);
        layoutParams.width = (int) (size.x*0.8);
        getWindow().setAttributes(layoutParams);

        textSave = findViewById(R.id.tv_save);
        textSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetImageCacheAsyncTask(getContext()).execute(url);
                dismiss();
            }
        });
    }
}

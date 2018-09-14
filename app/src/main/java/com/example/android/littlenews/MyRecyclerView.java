package com.example.android.littlenews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class MyRecyclerView extends RecyclerView {

    private OnBottomCallback mOnBottomCallback;

    public interface OnBottomCallback {
        void onBottom();
    }

    public void setOnBottomCallback(OnBottomCallback onBottomCallback) {
        this.mOnBottomCallback = onBottomCallback;
    }

    public MyRecyclerView(Context context) {
        this(context, null);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onScrolled(int dx, int dy) {

        if (isSlideToBottom()) {
            mOnBottomCallback.onBottom();
        }
    }

    public boolean isSlideToBottom() {
        return (this != null
                && this.computeVerticalScrollExtent() + this.computeVerticalScrollOffset()
                >= this.computeVerticalScrollRange());
    }

}

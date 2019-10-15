package com.seekerzhouk.android.littlenews.base;

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

    /**
     *
     *
     * @return 屏幕是否已经滑到底部
     *
     *（1）computeVerticalScrollOffset()：
     * 已经向下滚动的距离，为0时表示已处于顶部。
     *
     * （2）computeVerticalScrollRange()；
     * 整体的高度，注意是整体，包括在显示区域之外的。
     *
     * （3）computeVerticalScrollExtent()；
     * 显示区域的高度。
     */
    public boolean isSlideToBottom() {
        return (this != null
                && this.computeVerticalScrollExtent() + this.computeVerticalScrollOffset()
                >= this.computeVerticalScrollRange());
    }

}

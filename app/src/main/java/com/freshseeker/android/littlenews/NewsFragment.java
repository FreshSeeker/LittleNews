package com.freshseeker.android.littlenews;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class NewsFragment extends Fragment implements MyItemClickListener {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int INIT_STATE = 1;
    private int sectionNumber;
    private final int navigationItemNumber = 0;

    public NewsFragment() {
    }

    public static NewsFragment newInstance(int sectionNumber) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    private MyRecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private NewsAdapter newsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        assert getArguments() != null;
        sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER) - 1;
        final View rootView = inflater.inflate(R.layout.content_main, container, false);
        swipeRefreshLayout = rootView.findViewById(R.id.swipe_refresh);
        recyclerView = rootView.findViewById(R.id.recycler_view);

        Log.i("NewsFragment", "onCreateView: " + sectionNumber);
        initRecyclerView();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (INIT_STATE == 1) {
            new NetAndDataTask(getActivity(), navigationItemNumber, sectionNumber).execute();
            INIT_STATE = INIT_STATE + 1;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册eventbus
        EventBus.getDefault().register(this);
        Log.i("NewsFragment", "onCreate: " + sectionNumber);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //解除eventbus注册
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        Log.i("NewsFragment", "onDestroy: " + sectionNumber);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(MessageEvent messageEvent) {
        int secNumber = messageEvent.getsecNumber();
        int navNumber = messageEvent.getnavNumber();
        if (navigationItemNumber == navNumber && secNumber == sectionNumber) {
            newsAdapter.notifyDataSetChanged();
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    public void initRecyclerView() {

        //RecyclerView
        //布局管理器，使用线性布局
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        //绑定适配器
        newsAdapter = new NewsAdapter(getActivity(), sectionNumber);
        newsAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(newsAdapter);
        //分割线
        recyclerView.addItemDecoration(new MyDecoration());
        //动画效果
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //滑动到底部加载更多
        recyclerView.setOnBottomCallback(new MyRecyclerView.OnBottomCallback() {
            @Override
            public void onBottom() {
//                newsAdapter.notifyDataSetChanged();
            }
        });

        //下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new NetAndDataTask(getActivity(), navigationItemNumber, sectionNumber).execute();
//                InitData.initData(getActivity(), navigationItemNumber, sectionNumber);
//                newsAdapter.notifyDataSetChanged();
//                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(getResources().getDimensionPixelOffset(R.dimen.cardViewDivider), getResources().getDimensionPixelOffset(R.dimen.cardViewTop), getResources().getDimensionPixelOffset(R.dimen.cardViewDivider), 0);
        }
    }

    //跳转到WebView活动，打开对应的网页
    @Override
    public void onItemClick(String url) {
        Intent intent = new Intent(getActivity(), NewsDetailsActivity.class);
        intent.putExtra("baseUrl", url);
        startActivity(intent);

    }
}
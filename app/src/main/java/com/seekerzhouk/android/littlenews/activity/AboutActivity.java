package com.seekerzhouk.android.littlenews.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.seekerzhouk.android.littlenews.R;
import com.seekerzhouk.android.littlenews.utils.PackageInfoUtil;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView version = findViewById(R.id.tv_version);
        TextView gitHubLink = findViewById(R.id.tv_github_link);

        version.setText(PackageInfoUtil.getVersionName(this));
        gitHubLink.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        gitHubLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this, NewsDetailsActivity.class);
                intent.putExtra("baseUrl", getString(R.string.github_link));
                startActivity(intent);
            }
        });
    }
}

package com.ayuan.sharedelement;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @ProjectName: SharedElement
 * @Package: com.ayuan.sharedelement
 * @ClassName: HomeActivity
 * @CreateDate: 2020/3/6 17:36
 */
public class HomeActivity extends AppCompatActivity {
    private ImageView item_image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);
        initView();
        initData();
    }

    private void initView() {
        item_image = (ImageView) findViewById(R.id.item_image);
    }

    private void initData() {
        int name = getIntent().getIntExtra("name", R.drawable.ic_launcher_background);
        item_image.setImageResource(name);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }
}

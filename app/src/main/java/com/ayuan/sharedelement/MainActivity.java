package com.ayuan.sharedelement;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rc;
    private ArrayList<Integer> integers;
    private CustomerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);
        initView();
        initData();
    }

    private void initView() {
        rc = (RecyclerView) findViewById(R.id.rc);
    }

    private void initData() {
        // 需要显示的数据
        integers = new ArrayList<>();
        integers.add(R.mipmap.ic_launcher);
        integers.add(R.mipmap.ic_launcher);
        integers.add(R.mipmap.ic_launcher);
        integers.add(R.mipmap.ic_launcher);
        integers.add(R.mipmap.ic_launcher_round);
        integers.add(R.mipmap.ic_launcher_round);
        integers.add(R.mipmap.ic_launcher_round);
        integers.add(R.mipmap.ic_launcher_round);
        integers.add(R.mipmap.ic_launcher_round);
        integers.add(R.mipmap.ic_launcher_round);
        integers.add(R.drawable.ic_launcher_foreground);
        integers.add(R.drawable.ic_launcher_foreground);
        integers.add(R.drawable.ic_launcher_foreground);
        integers.add(R.drawable.ic_launcher_foreground);
        integers.add(R.drawable.ic_launcher_foreground);
        integers.add(R.drawable.ic_launcher_background);
        integers.add(R.drawable.ic_launcher_background);
        integers.add(R.drawable.ic_launcher_background);
        integers.add(R.drawable.ic_launcher_background);
        integers.add(R.drawable.ic_launcher_background);
        integers.add(R.drawable.ic_launcher_background);

        // 设置RecylerView的管理器
        rc.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        // 设置数据适配器
        adapter = new CustomerAdapter();
        rc.setAdapter(adapter);
    }

    class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View inflate = View.inflate(MainActivity.this, R.layout.item, null);
            return new ViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
            holder.item_image.setImageResource(integers.get(position));
            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("name", integers.get(position));
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, holder.item_image, holder.item_image.getTransitionName()).toBundle());
                }
            });
        }

        @Override
        public int getItemCount() {
            return integers.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public View rootView;
            public ImageView item_image;
            public LinearLayout root;

            public ViewHolder(View rootView) {
                super(rootView);
                this.rootView = rootView;
                this.item_image = (ImageView) rootView.findViewById(R.id.item_image);
                this.root = (LinearLayout) rootView.findViewById(R.id.root);
            }

        }
    }
}



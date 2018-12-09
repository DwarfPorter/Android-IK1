package ru.geekbrains.socialnetwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,  LinearLayoutManager.VERTICAL);
        itemDecoration.setDrawable(getDrawable(R.drawable.divider));
        recyclerView.addItemDecoration(itemDecoration);
        // строим источник данных
        SocialDataSource sourceData = new SocSourceBuilder()
                .setResources(getResources())
                .build();
        // установим адаптер
        final SocialChangableSource sourceChangableData = new SocChangableSource(sourceData);
        final SocnetAdapter adapter = new SocnetAdapter(sourceChangableData);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new SocnetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, String.format("позиция - %d", position), Toast.LENGTH_SHORT).show();
            }
        });

        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setAddDuration(1000);
        animator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(animator);

        Button add = findViewById(R.id.buttonAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sourceChangableData.add();
                adapter.notifyItemInserted(sourceChangableData.length());
            }
        });

        Button delete = findViewById(R.id.buttonDel);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sourceChangableData.delete();
                adapter.notifyItemRemoved(sourceChangableData.length());
            }
        });

    }
}

package edu.sjsu.android.farmzoo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends MenuActivity {

    //Add recyclerview object
    RecyclerView recyclerView;
    Button  buttonCall;
    //string1 is title string2 is descriptions
    String s1[], s2[], s3[];
    int images[ ] = {R.drawable.ragnar, R.drawable.celina, R.drawable.simon, R.drawable.pony1, R.drawable.bobby, R.drawable.sheep, R.drawable.bunny, R.drawable.goat};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find ID of recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.different_animals);
        s2 = getResources().getStringArray(R.array.description_animals);
        s3 = getResources().getStringArray(R.array.description_animals_long);
        //Initilize myadapter
        MyAdapter myAdapter = new MyAdapter(this, s1, s2, s3, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
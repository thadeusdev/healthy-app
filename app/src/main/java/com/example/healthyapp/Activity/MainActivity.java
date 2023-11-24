package com.example.healthyapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.healthyapp.Adapter.CategoryAdapter;
import com.example.healthyapp.Domain.CategoryDomain;
import com.example.healthyapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   private RecyclerView.Adapter catAdapter,bestDealAdapter;
   private RecyclerView recyclerViewCat, recyclerViewBestDeal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerViewCat();
        initLocation();
    }

    private void initLocation() {
        String[] items=new String[]{"LosAngles, USA","NewYork, USA"};
        final Spinner locationSpin=findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpin.setAdapter(adapter);
    }

    private void initRecyclerViewCat() {
        ArrayList<CategoryDomain> items=new ArrayList<>();
        items.add(new CategoryDomain("cat1","Vegetable"));
        items.add(new CategoryDomain("cat2","Fruits"));
        items.add(new CategoryDomain("cat3","Dairy"));
        items.add(new CategoryDomain("cat4","Drinks"));
        items.add(new CategoryDomain("cat5","Grain"));

        recyclerViewCat=findViewById(R.id.catView);
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        catAdapter=new CategoryAdapter(this,items);
        recyclerViewCat.setAdapter(catAdapter);
    }
}
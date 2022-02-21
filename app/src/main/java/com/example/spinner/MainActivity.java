package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner mySpinner,fruitSpinner;
    List<String> districts = new ArrayList<>();
    List<Fruit> fruitsList=new ArrayList<>();
    ArrayAdapter<String> myAdapter;
    MyAdapter fruitAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        districts.add("Kicukiro");
        districts.add("Nyarugenge");
        districts.add("Gasabo");
        fruitsList.add(new Fruit("Apple",R.drawable.apple));
        fruitsList.add(new Fruit("Banana",R.drawable.banana));
        fruitsList.add(new Fruit("Cherry",R.drawable.cherry));
        fruitsList.add(new Fruit("Grape",R.drawable.grape));
        fruitsList.add(new Fruit("Mango",R.drawable.mango));
        fruitsList.add(new Fruit("Orange",R.drawable.orange));
        fruitsList.add(new Fruit("Pear",R.drawable.pear));

        fruitAdapter=new MyAdapter(getApplicationContext(),fruitsList);
        fruitSpinner=findViewById(R.id.fruitSpiner);
        fruitSpinner.setAdapter(fruitAdapter);
        fruitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit= (Fruit) adapterView.getItemAtPosition(i);
                String frName=fruit.getFruitName();
                Toast.makeText(MainActivity.this, ""+frName, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        myAdapter=new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,districts);
        mySpinner=findViewById(R.id.mySpinner);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String distr = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Selected:"+distr, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
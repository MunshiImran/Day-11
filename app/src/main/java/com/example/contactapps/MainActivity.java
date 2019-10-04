package com.example.contactapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Contact> contacts;
    private RecyclerView recyclerView;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setData();
    }

    private void setData() {
        contacts.add(new Contact("Imran","01910301435",R.drawable.ic_account_circle_black_24dp));
        contacts.add(new Contact("Ammu","01834927999",R.drawable.ic_account_circle_black_24dp));
        contacts.add(new Contact("Munshi","01951879027",R.drawable.ic_account_circle_black_24dp));
        contacts.add(new Contact("Abbu","01816101465",R.drawable.ic_account_circle_black_24dp));
        contacts.add(new Contact("Istiak","01515200150",R.drawable.ic_account_circle_black_24dp));
        contacts.add(new Contact("Rohan","01769922677",R.drawable.ic_account_circle_black_24dp));
        contacts.add(new Contact("Imran","01521206441",R.drawable.ic_account_circle_black_24dp));
        contacts.add(new Contact("Munshi","01910301435",R.drawable.ic_account_circle_black_24dp));
        contacts.add(new Contact("Istiak","01515200150",R.drawable.ic_account_circle_black_24dp));
        adapter.notifyDataSetChanged();

    }


    private void init() {

        contacts = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContactAdapter(contacts,this);
        recyclerView.setAdapter(adapter);
    }
}

package com.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.chatapp.Adapter.FragmentsAdapter;
import com.chatapp.Models.Users;
import com.chatapp.databinding.ActivityMainBinding;
import com.chatapp.databinding.ActivitySignUpBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    FirebaseUser Users;

    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0b6156")));




        mAuth = FirebaseAuth.getInstance();

        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();
        if (id == R.id.settings) {
            Toast.makeText(this, "Settings is cliicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.groupChat) {
            Toast.makeText(this, "Group chat started", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.logout) {
          mAuth.signOut();
            Intent intent = new Intent(MainActivity.this,SignInActivity.class);
            startActivity(intent);

        }


        return super.onOptionsItemSelected(item);
    }
}
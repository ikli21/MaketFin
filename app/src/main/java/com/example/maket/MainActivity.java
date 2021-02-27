package com.example.maket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.maket.Dao.CategoryDao;
import com.example.maket.Database.Data;
import com.example.maket.Database.Entities.Category;

public class MainActivity extends AppCompatActivity {
    CategoryDao categoryDao;
    Category category = new Category();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void openTrue(View view) {
        Intent intent = new Intent(MainActivity.this, TrueScreen.class);
//        category.CategoryID=0;
//        category.Title = "Говядина";
//        category.URLPhoto = "https://images.app.goo.gl/u31yyA1v3ZqEV3tN7";
//        categoryDao.insert(category);
        startActivity(intent);
    }
}
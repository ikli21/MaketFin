package com.example.maket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;

import com.example.maket.Database.Data;
import com.example.maket.Database.Entities.Product;
import com.example.maket.databinding.ActivityProductBinding;

public class ProductActivity extends AppCompatActivity {
    ActivityProductBinding binding;


    Data data;
    Product currentProduct;
    int id = 0,idCategory=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        id= getIntent().getIntExtra(Data.ID,0);
        data=Data.getInstance(this);
        data.getProductInID(id).observe(ProductActivity.this, new Observer<Product>() {
            @Override
            public void onChanged(Product productsValue) {
                currentProduct=productsValue;
                binding.priceTV.setText(String.valueOf(currentProduct.Price));
                binding.nameTV.setText(currentProduct.ShortName);
                binding.fullnameTV.setText(currentProduct.TitleProduct);
                binding.descriptionTV.setText(currentProduct.Description);

                data.loadImage(currentProduct.URLPhotoProduct,binding.productImage);
                idCategory = currentProduct.ProductCategoryID;
            }
        });

    }
}
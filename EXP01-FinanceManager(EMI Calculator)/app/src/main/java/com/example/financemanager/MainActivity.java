package com.example.financemanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // IDs connect karna
        Button btnTaxNav = findViewById(R.id.btn_tax_nav);
        Button btnEmiNav = findViewById(R.id.btn_emi_nav);

        // EMI Screen navigation
        btnEmiNav.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, EMIActivity.class));
        });

        // Tax Screen navigation (Jab TaxActivity ban jayegi to ye error hat jayega)
        btnTaxNav.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TaxActivity.class));
        });

        // Is line se 'main' ID ka error jayega
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
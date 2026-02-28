package com.example.financemanager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TaxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax);

        EditText etBasic = findViewById(R.id.et_basic_salary);
        EditText etHra = findViewById(R.id.et_hra);
        EditText etSa = findViewById(R.id.et_sa);
        EditText etLta = findViewById(R.id.et_lta);
        Button btnCalc = findViewById(R.id.btn_calc_tax);
        TextView tvResult = findViewById(R.id.tv_tax_result);

        btnCalc.setOnClickListener(v -> {
            String bStr = etBasic.getText().toString();
            if (!bStr.isEmpty()) {
                double basic = Double.parseDouble(bStr);
                double hra = etHra.getText().toString().isEmpty() ? 0 : Double.parseDouble(etHra.getText().toString());
                double sa = etSa.getText().toString().isEmpty() ? 0 : Double.parseDouble(etSa.getText().toString());
                double lta = etLta.getText().toString().isEmpty() ? 0 : Double.parseDouble(etLta.getText().toString());

                double totalIncome = (basic + hra + sa + lta) * 12;
                double tax = 0;

                // Simple Tax Logic (Indian Slit Example)
                if (totalIncome > 1000000) tax = totalIncome * 0.30;
                else if (totalIncome > 500000) tax = totalIncome * 0.20;
                else if (totalIncome > 250000) tax = totalIncome * 0.05;

                tvResult.setText("Yearly Tax: ₹ " + String.format("%.2f", tax));
            } else {
                Toast.makeText(this, "Enter Basic Salary", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
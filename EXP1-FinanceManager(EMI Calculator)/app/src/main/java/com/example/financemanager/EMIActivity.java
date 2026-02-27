package com.example.financemanager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emiactivity);

        EditText etPrincipal = findViewById(R.id.et_principal);
        EditText etInterest = findViewById(R.id.et_interest);
        EditText etTenure = findViewById(R.id.et_tenure);
        Button btnCalculate = findViewById(R.id.btn_calculate);
        TextView tvEmi = findViewById(R.id.tv_emi_display);
        TextView tvTotalInt = findViewById(R.id.tv_total_interest);

        btnCalculate.setOnClickListener(v -> {
            String pStr = etPrincipal.getText().toString();
            String rStr = etInterest.getText().toString();
            String yStr = etTenure.getText().toString();

            if (!pStr.isEmpty() && !rStr.isEmpty() && !yStr.isEmpty()) {
                double p = Double.parseDouble(pStr);
                double r = Double.parseDouble(rStr) / 12 / 100; // Monthly interest
                int n = Integer.parseInt(yStr) * 12; // Total months

                // EMI Formula: [P x R x (1+R)^N] / [(1+R)^N - 1]
                double emi = (p * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
                double totalPayment = emi * n;
                double totalInterest = totalPayment - p;

                tvEmi.setText("EMI: ₹ " + String.format("%.2f", emi));
                tvTotalInt.setText("Total Interest for Loan: ₹ " + String.format("%.2f", totalInterest));
            } else {
                Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
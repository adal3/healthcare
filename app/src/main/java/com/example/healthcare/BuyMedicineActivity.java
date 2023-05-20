package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String [][] packages =
            {
                    {"Uprise-03 : Capsule","","","","50"},
                    {"Vitamin B Complex Capsule","","","","305"},
                    {"Dolo 650 Tablet","","","","75"},
                    {"Crocin 500 Tablet","","","","65"},
                    {"Vitamin D3 Tablet","","","","85"},
            };
    private String[] package_details ={
            "Building and keeping the bones and teeth strong\n" +
                    "Reduce Fatigue\n" +
                    "Boosting immunity",
            "Provide relief from Vitamin B deficiency",
            "Dolo 650 helps relieve pain and fever",
            "Bring down high temperature",
            "Reduces risk of Calcium deficiency\n" +
                    "Promotes mobility and flexibility\n"+
                    "Helps to reduce iron deficiency"

    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart, btnBack;
    android.widget.ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst=findViewById(R.id.imageViewHAD);
        btnBack=findViewById(R.id.buttonHADBack);
        btnGoToCart=findViewById(R.id.buttonBMDGoToCart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0; i<packages.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total cost: " + packages[i][4] + "/-");
            list.add(item);
        }

            sa = new SimpleAdapter(this, list,
                    R.layout.multi_lines,
                    new String[]{"line1", "line2", "line3", "line4", "line5",},
                    new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
            lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=  new Intent(BuyMedicineActivity.this, BuyMedicineDetailActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

    }
}

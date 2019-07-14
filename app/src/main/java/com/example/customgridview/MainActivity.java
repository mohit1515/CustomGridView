package com.example.customgridview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   // RelativeLayout r1;
    GridView grid;
    List<String> arrayList;
    EditText ecol,eitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void showgrid(View view) {
       // r1 = findViewById(R.id.rellay);
        grid = findViewById(R.id.gv);
        arrayList = new ArrayList<String>();
        ecol = findViewById(R.id.edtcol);
        eitem = findViewById(R.id.edtitem);
        String ecol1 = ecol.getText().toString();
        final int val = Integer.parseInt(ecol1);
        String eitem1 = eitem.getText().toString();
        int valitem  = Integer.parseInt(eitem1);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                int select = Integer.parseInt(selectedItem);

                // Display the selected/clicked item text and position on TextView
                //tv.setText("GridView item clicked : " +selectedItem
                  //      + "\nAt index position : " + position);
                //Toast.makeText(MainActivity.this, "select: "+select, Toast.LENGTH_SHORT).show();
                //Toast.makeText(MainActivity.this, "val: "+val, Toast.LENGTH_SHORT).show();
                int val1= select % val;
                if(val1 == 0){
                    Toast.makeText(MainActivity.this, "Left", Toast.LENGTH_SHORT).show();
                }
                else if(val1 == val-1){
                    Toast.makeText(MainActivity.this, "Right", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Middle", Toast.LENGTH_SHORT).show();
                }

                //Toast.makeText(MainActivity.this, "val1: "+val1, Toast.LENGTH_SHORT).show();
//                //if columns are odd
//                if(val%2 != 0){
//                if(val/2 == val1){
//                    Toast.makeText(MainActivity.this, "MIDDLE", Toast.LENGTH_SHORT).show();
//                }
//                else if(val/2 < val1){
//                    Toast.makeText(MainActivity.this, "RIGHT", Toast.LENGTH_SHORT).show();
//                }
//                else if(val/2 >val1){
//                    Toast.makeText(MainActivity.this, "LEFT", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//                //if columns are even
//                if(val%2 == 0){
//                    if(val/2 <= val1){
//                        Toast.makeText(MainActivity.this, "RIGHT", Toast.LENGTH_SHORT).show();
//                    }
//                    else if(val/2 >val1){
//                        Toast.makeText(MainActivity.this, "LEFT", Toast.LENGTH_SHORT).show();
//                    }
//                }



            }
        });
        /*arrayList.add("One");
        arrayList.add("two");
        arrayList.add("three");
        arrayList.add("four");
        arrayList.add("five");
        arrayList.add("six");
        arrayList.add("seven");
        arrayList.add("eight");*/
        for(int i= 0;i< valitem;i++){
            arrayList.add(String.valueOf(i));
        }


        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,arrayList);
        grid.setNumColumns(val);
        grid.setAdapter(adp);
    }
}

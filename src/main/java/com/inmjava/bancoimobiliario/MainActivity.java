package com.inmjava.bancoimobiliario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtNome  = (TextView) findViewById(R.id.txtNome);
        final TextView txtDinheiro  = (TextView) findViewById(R.id.txtDinheiro);

        ListView lv = (ListView) findViewById(R.id.lstParticipantes);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtNome.setText((position + 1) + " - " + parent.getItemAtPosition(position).toString());
                txtDinheiro.setText("");
            }
        });
        ArrayList<String> values = new ArrayList<>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,values);
        lv.setAdapter(arrayAdapter);
    }

    public void btnAdicionar(View v){
        ListView lv = (ListView) findViewById(R.id.lstParticipantes);
        ArrayAdapter<String> arrayAdapter = (ArrayAdapter<String>) lv.getAdapter();
        arrayAdapter.setNotifyOnChange(true);

        TextView tv = (TextView) findViewById(R.id.txtNome);
        TextView tv2 = (TextView) findViewById(R.id.txtDinheiro);

        NumberFormat nf = NumberFormat.getCurrencyInstance();

        arrayAdapter.add(tv.getText().toString() + " - " + nf.format(Integer.parseInt(tv2.getText().toString()) * 1000));

    }

    public void btnCredito(View v){
        TextView tv = (TextView) findViewById(R.id.txtNome);
        String[] info = tv.getText().toString().split(" - ");

        int position = Integer.parseInt(info[0]);

        ListView lv = (ListView) findViewById(R.id.lstParticipantes);
        View v2 = lv.getChildAt(position - 1);

        TextView tv2 = (TextView) v2.findViewById(android.R.id.text1);
        tv2.setText("Hey Ya!!");
    }

    public void btnDebito(View v){

    }

    public void btnTransferir(View v){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

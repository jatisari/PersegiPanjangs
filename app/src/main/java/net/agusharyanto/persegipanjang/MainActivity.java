package net.agusharyanto.persegipanjang;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtPanjang, edtLebar, edtLuas;
    private Button btnHitung;
    private TextView tvLuas;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPanjang = (EditText) findViewById(R.id.editTextPanjang);
        edtLebar = (EditText) findViewById(R.id.editTextLebar);
        edtLuas = (EditText) findViewById(R.id.editTextLuas);
        btnHitung = (Button) findViewById(R.id.buttonHitung);
        tvLuas = (TextView) findViewById(R.id.textViewLuas) ;

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuas();
            }
        });




    }

    private void hitungLuas() {
        if (isValidInput()) {
            int panjang = Integer.parseInt(edtPanjang.getText().toString());
            int lebar = Integer.parseInt(edtLebar.getText().toString());
            int luas = panjang * lebar;
            edtLuas.setText(String.valueOf(luas));
            tvLuas.setText(String.valueOf(luas));
        }
    }

    private boolean  isValidInput(){
        if (edtPanjang.getText().toString().equals("")){
            Toast.makeText(context, "Panjang harus diisi", Toast.LENGTH_SHORT).show();
            return  false;
        }
        if (edtLebar.getText().toString().equals("")){
            edtLebar.setError("Lebar Harus diisi");
            return  false;
        }
        return true;
    }


}

package formdatasederhana.hardi.com.volumecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtwidth, edtheight, edtlength;
    private Button btncalculate;
    private TextView tvresult;
    private static final String STATE_HASIL="state hasil";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtwidth = (EditText) findViewById(R.id.edt_width);
        edtlength = (EditText) findViewById(R.id.edt_length);
        edtheight = (EditText) findViewById(R.id.edt_height);
        btncalculate = (Button) findViewById(R.id.btn_calculate);
        tvresult = (TextView) findViewById(R.id.tv_result);
        btncalculate.setOnClickListener(this);

        if (savedInstanceState != null) {
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvresult.setText(hasil);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_calculate)
        {
            String length =edtlength.getText().toString().trim();
            String width =edtwidth.getText().toString().trim();
            String height =edtheight.getText().toString().trim();
            boolean isEmptyFields =false;

            if (TextUtils.isEmpty(length))
            {
                isEmptyFields=true;
                edtlength.setError("Field Cannot Be Null");
            }

            if (TextUtils.isEmpty(width))
            {
                isEmptyFields=true;
                edtwidth.setError("Field Cannot Be Null");
            }

            if (TextUtils.isEmpty(height))
            {
                isEmptyFields=true;
                edtheight.setError("Field Cannot Be Null");
            }

            if (!isEmptyFields )
            {
                double l=Double.parseDouble(length);
                double w=Double.parseDouble(width);
                double h=Double.parseDouble(height);
                double volume =l*w*h;
                tvresult.setText(String.valueOf(volume));
            }

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL,tvresult.getText().toString());
        super.onSaveInstanceState(outState);
    }
}

package ifpb.edu.br.textwatcher;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.util.Log;


public class MainActivity extends Activity {

    private EditText campoEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoEditText = (EditText) findViewById(R.id.campo);

        campoEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                Log.i("beforeTextChanged", s.toString());

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {

                Log.i("onTextChanged", s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

                Log.i("afterTextChanged", String.valueOf(s.length()));
            }
        });
    }
}
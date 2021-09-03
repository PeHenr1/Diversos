package peu.example.diversos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnOutra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOutra = (Button) findViewById(R.id.btnOutra);
        btnOutra.setOnClickListener( new abrirOutra() );
    }

    private class abrirOutra implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            Intent i = new Intent( getApplicationContext(), Outra.class );
            startActivity(i);
        }
    }
}
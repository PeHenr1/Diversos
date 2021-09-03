package peu.example.diversos;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Outra extends AppCompatActivity {

    private Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);

        /*
        //cria variavel pra armazenar e carrega ela
        ImageView img = new ImageView( getApplicationContext() );
        img.setImageResource( R.drawable.medico);

        // cria toast vazio, define duração, pega a img e mostra
        Toast t = new Toast( getApplicationContext() );
        t.setDuration( Toast.LENGTH_LONG);
        t.setView( img );
        t.show();

        /////////////
        */
        btnFechar = (Button) findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener( new EscutadorFechar() );
    }

    private class EscutadorDialogoCancela implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            Toast.makeText( getApplicationContext(), "Cancelando...", Toast.LENGTH_SHORT).show();
        }
    }

    private class EscutadorDialogoOK implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            finish(); //fecha o app
            Toast.makeText( getApplicationContext(), "Saindo...", Toast.LENGTH_SHORT).show();
        }
    }

    private class EscutadorFechar implements View.OnClickListener {

        @Override
        public void onClick(View view) {


            //cria caixa de dialogo, deefine titulo, texto, btn ação positiva e negativa
            AlertDialog.Builder dialogo = new AlertDialog.Builder( Outra.this);
            dialogo.setTitle("FECHANDO O APP");
            dialogo.setMessage("Deseja mesmo fechar o app ?");
            dialogo.setPositiveButton( "Fechar o App", new EscutadorDialogoOK() );
            dialogo.setNegativeButton( "Cancelar", new EscutadorDialogoCancela() );

            //define icone
            //dialogo.setIcon( R.drawable.medico);

            //proibe usuario de fazer outra coisa, TEM QUE ESCOLHER
            dialogo.setCancelable( false );

            //cria e exibe
            dialogo.create();
            dialogo.show();
        }
    }
}
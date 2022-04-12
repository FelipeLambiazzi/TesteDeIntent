package com.example.ExemploIntencao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class EnviarMensagemActivity2 extends AppCompatActivity {

    EditText textMensagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_mensagem2);
        textMensagem=(EditText)findViewById(R.id.editTextMensagem);

    }

    public void btnEnviarMensagemClick(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        //enviar a mensagem de texto
        intent.putExtra(intent.EXTRA_TEXT,textMensagem.getText().toString());
        startActivity(intent);

    }


    public void btnVoltarClick(View v){
        finish();
    }

}
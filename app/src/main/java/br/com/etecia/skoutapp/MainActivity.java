package br.com.etecia.skoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    // Declarar as variáveis globais que irão representar os objetos xml
    EditText edtUsuario, edtSenha;
    Button btnEntrar, btnSair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Apresentar ao java os componentes do xml
        edtSenha = findViewById(R.id.edtSenha);
        edtUsuario = findViewById(R.id.edtUsuario);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnSair = findViewById(R.id.btnSair);

        //criando a ação de botão sair
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Criando as variáveis
                String usuario, senha;

                //Atribuindo valores as variáveis
                usuario = edtUsuario.getText().toString();
                senha = edtSenha.getText().toString();

                //Validando o usuário e senha
                if (usuario.equals("etecia") && senha.equals("etecia")) {
                    //Abrirmos a janela MenuPrincipal
                    startActivity(new Intent(getApplicationContext(),
                            MenuPrincipalActivity.class));
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Usuário ou senha inválidos!!!",
                            Toast.LENGTH_SHORT).show();
                    edtUsuario.setText("");
                    edtSenha.setText("");
                    edtUsuario.requestFocus();
                }


            }
        });
    }
}
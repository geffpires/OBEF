package com.example.obef.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.audiofx.Visualizer;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.obef.Modelo.Alternativa;
import com.example.obef.Modelo.Aluno;
import com.example.obef.Modelo.Escola;
import com.example.obef.Modelo.Questao;
import com.example.obef.R;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView testviwe;
    private Button buttonEscolher;
    private Button buttonDica;
    private DatabaseReference firebaseDatabase;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButton5;
    private RadioButton radioButtonEscolhido;
    private RadioGroup radioGroup;
    private List<String> idQuestoes;
    private String questao = "-LbHIqN9xlO1IauQJ3hn";
    private Random rd;
    int numQuestao;
    private Escola escola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rd = new Random();
        idQuestoes = new ArrayList<String>();
        idQuestoes.add("-LbHIqNDaIxbhfh_bdtk");
        idQuestoes.add("-LbHL9frariPAQaU0HTh");
        idQuestoes.add("-LbHL9gJQTohk67ALQad");
        idQuestoes.add("-LbHL9gOhZKCDye-VV1l");
        idQuestoes.add("-LbHMTaPlHKOaaQRTfZP");
        numQuestao = rd.nextInt(idQuestoes.size());

        radioButton1 = (RadioButton) findViewById(R.id.rd1Id);
        radioButton2 = (RadioButton) findViewById(R.id.rd2Id);
        radioButton3 = (RadioButton) findViewById(R.id.rd3Id);
        radioButton4 = (RadioButton) findViewById(R.id.rd4Id);
        radioButton5 = (RadioButton) findViewById(R.id.rd5Id);

        radioButtonEscolhido = findViewById(R.id.rd1Id);

        radioGroup = findViewById(R.id.radioGroup);

        buttonEscolher = (Button) findViewById(R.id.escolherId);
        buttonDica = (Button) findViewById(R.id.dicaId);

        testviwe = findViewById(R.id.textoID);

        firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("questões");


       /* escola = new Escola("E. M. E. F. Daura Ribeiro da Silva", "Pedro Régis", "PB");
        escola.salvar();
        //Cadastro de Usuario/Aluno:
        Aluno aluno = new Aluno("Gefferson Pires Vieira", "geff", "12345", "gefferson.pires@dce.ufpb.br", "masculino", "3º ano", 001);
        aluno.salvar();*/


        BancoDeQuestoes bdquestoes = new BancoDeQuestoes();
        bdquestoes.recuperarQuestao("-LbHL9frariPAQaU0HTh");
        System.out.println(bdquestoes.getQuestao()+" sadjhaskdjhaskdj");


        /*Questao questao = new Questao("Joana ganhou de presente de aniversário R$ 60,00 " +
                "e quer comprar uma boneca. Para isto ela terá que " +
                "guardar metade do valor que ganhou.\n" +
                "Qual o valor que Joana terá que guardar para " +
                "comprar a boneca?",
                new Alternativa(false,"R$ 18,00","R$ 18,00 não é a metade de R$60."),
                new Alternativa(false,"R$ 24,00","R$ 24,00 não é a metade de R$60."),
                new Alternativa(true,"R$ 30,00","R$ 30,00 é a metade de R$60."),
                new Alternativa(false,"R$ 42,00","R$ 42,00 não é a metade de R$60."),
                new Alternativa(false,"R$ 60,00","R$ 60,00 não é a metade de R$60."),
                "É possível conseguir nossos desejos dividindo e guardando o dinheiro.", 1,100,"fácil");
        questao.salvar();*/

        /*Questao questao1 = new Questao("Imagine que você foi ao mercado levando R$ 15,00 no " +
                "bolso e na mão uma lista na qual constam 2 kg de arroz, 1 kg de frango e uma " +
                "dúzia de balas. Ao chegar lá, descobriu que o frango e o arroz subiram de preço e" +
                " agora custam R$ 8,70 e R$ 2,20 por quilo, respectivamente, e que as balas estão em promoção" +
                " por R$ 2,00 a dúzia. Considerando que frango e arroz são “itens essenciais” e que" +
                " você tem pouco dinheiro, a solução para seguir o orçamento é levar quais itens?",
                new Alternativa(true,"2 kg de arroz e 1 kg de frango."," "),
                new Alternativa(false,"2 kg de arroz, 1 kg de frango e uma dúzia de balas."," "),
                new Alternativa(false,"Apenas os 2 kg de arroz, já que o frango não é um item essencial."," "),
                new Alternativa(false,"Apenas 1 kg de frango, já que o arroz não é um item essencial."," "),
                new Alternativa(false,"Nenhum dos itens, já que todos os itens são essenciais."," "),
                " ", 3,100,"Fácil");
        questao1.salvar();

        Questao questao2 = new Questao("Se uma pessoa gasta R$ 1.000,00 e deste valor R$ 100,00 são" +
                " destinados à manutenção da casa, significa que 10% da sua despesa vai para a manutenção." +
                " Logo, o peso relativo da manutenção da casa no orçamento é de 10%." +
                " Se essa mesma pessoa gasta os mesmos R$ 1.000,00 e tem os seguintes gastos com" +
                " lazer: \n" +
                "R$ 20,00 na pizzaria;\n" +
                "R$ 45,00 festa surpresa para sua mãe;\n" +
                "R$ 15,00 ingresso do cinema;\n" +
                "R$ 50,00 no show do seu cantor favorito\n" +
                "Qual será o peso relativo do lazer dessa pessoa nos seus gastos?",
                new Alternativa(false,"10%"," "),
                new Alternativa(false,"11%"," "),
                new Alternativa(false,"12%"," "),
                new Alternativa(true,"13%"," "),
                new Alternativa(false,"14%"," "),
                " ", 3,100,"Fácil");
        questao2.salvar();*/


        buttonDica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String string2 = (String) dataSnapshot.child(idQuestoes.get(numQuestao)).child("dica").getValue();
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                        alertDialogBuilder.setMessage("DICA");
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.i("ENTRAR", "Não Entrou!");
                    }
                });
            }
        });

        buttonEscolher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();
                        Integer i = new Integer(idRadioButtonEscolhido - 2131165290);
                        Boolean escolhida = (Boolean) dataSnapshot.child(idQuestoes.get(numQuestao)).child("alternativa" + i.toString()).child("status").getValue();
                        if (escolhida == true) {
                            radioButtonEscolhido = findViewById(idRadioButtonEscolhido);
                            respostaCerta();
                        } else {
                            gameOver();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.i("ENTRAR", "Não Entrou!");
                    }
                });
            }
        });


        firebaseDatabase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String string = (String) dataSnapshot.child(idQuestoes.get(numQuestao)).child("enunciado").getValue();
                testviwe.setText(string);
                String alternativa1 = (String) dataSnapshot.child(idQuestoes.get(numQuestao)).child("alternativa1").child("texto").getValue();
                radioButton1.setText(alternativa1);
                String alternativa2 = (String) dataSnapshot.child(idQuestoes.get(numQuestao)).child("alternativa2").child("texto").getValue();
                radioButton2.setText(alternativa2);
                String alternativa3 = (String) dataSnapshot.child(idQuestoes.get(numQuestao)).child("alternativa3").child("texto").getValue();
                radioButton3.setText(alternativa3);
                String alternativa4 = (String) dataSnapshot.child(idQuestoes.get(numQuestao)).child("alternativa4").child("texto").getValue();
                radioButton4.setText(alternativa4);
                String alternativa5 = (String) dataSnapshot.child(idQuestoes.get(numQuestao)).child("alternativa5").child("texto").getValue();
                radioButton5.setText(alternativa5);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void gameOver() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setMessage("Resposta Incorreta!");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Novo jogo",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        numQuestao = rd.nextInt(idQuestoes.size());

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                });
        alertDialogBuilder.setNegativeButton("Voltar ao Menu",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }

                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void respostaCerta() {
        firebaseDatabase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String nPontuacao = dataSnapshot.child(idQuestoes.get(numQuestao)).child("valor").getValue().toString();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setMessage("Resposta Correta! Pontuação: " + nPontuacao + " Pontos!");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("Proxima Questão",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                numQuestao = rd.nextInt(idQuestoes.size());
                                proximaQuestao();
                            }
                        });
                alertDialogBuilder.setNegativeButton("Voltar ao Menu",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }

                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    private void proximaQuestao(){
        numQuestao = rd.nextInt(idQuestoes.size());
        firebaseDatabase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String string = (String) dataSnapshot.child(idQuestoes.get(numQuestao)).child("enunciado").getValue();
                testviwe.setText(string);
                String alternativa1 = (String) dataSnapshot.child(idQuestoes.get(numQuestao)).child("alternativa1").child("texto").getValue();
                radioButton1.setText(alternativa1);
                String alternativa2 = (String) dataSnapshot.child(idQuestoes.get(numQuestao)).child("alternativa2").child("texto").getValue();
                radioButton2.setText(alternativa2);
                String alternativa3 = (String) dataSnapshot.child(idQuestoes.get(numQuestao)).child("alternativa3").child("texto").getValue();
                radioButton3.setText(alternativa3);
                String alternativa4 = (String) dataSnapshot.child(idQuestoes.get(numQuestao)).child("alternativa4").child("texto").getValue();
                radioButton4.setText(alternativa4);
                String alternativa5 = (String) dataSnapshot.child(idQuestoes.get(numQuestao)).child("alternativa5").child("texto").getValue();
                radioButton5.setText(alternativa5);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}

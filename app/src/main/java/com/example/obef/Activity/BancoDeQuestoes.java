package com.example.obef.Activity;
import android.support.annotation.NonNull;

import com.example.obef.Modelo.Alternativa;
import com.example.obef.Modelo.Questao;
import com.example.obef.R;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class BancoDeQuestoes {
    private DatabaseReference firebaseDatabase;
    private Questao q2;
    public BancoDeQuestoes(){
        firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("questões");

    }
    public void recuperarQuestao(String idQuestao){

        firebaseDatabase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Questao q1=dataSnapshot.child("-LbHL9frariPAQaU0HTh").getValue(Questao.class);
                q2=q1;
                System.out.println(q1.getDificuldade()+" dentro do listener");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }
    public Questao getQuestao(){
        return q2;
    }

}

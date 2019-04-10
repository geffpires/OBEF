package com.example.obef.Modelo;

import com.example.obef.Configuração.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;



public class Alternativa {

    boolean status;
    String texto;
    String justificativa;

    public Alternativa(boolean status, String texto, String justificativa) {
        this.status = status;
        this.texto = texto;
        this.justificativa = justificativa;
    }

    public Alternativa() {
    }

    public void salvar(){
        DatabaseReference databaseFirebase = ConfiguracaoFirebase.getReference();
        databaseFirebase.child("alternativas").push().setValue(this);

    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public boolean isStatus() {
        return status;
    }

    public String getTexto() {
        return texto;
    }

    public String getJustificativa() {
        return justificativa;
    }


}

package com.example.obef.Modelo;

import com.example.obef.Configuração.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;

public class Aluno {

    String nome;
    String login;
    String senha;
    String email;
    String sexo;
    String serie;
    int idEscola;

    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSexo() {
        return sexo;
    }

    public String getSerie() {
        return serie;
    }

    public int getIdEscola() {
        return idEscola;
    }


    public Aluno(String nome, String login, String senha, String email, String sexo, String serie, int idEscola){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.sexo = sexo;
        this.serie = serie;
        this.idEscola = idEscola;
    }

    public void salvar() {
        DatabaseReference databaseFirebase = ConfiguracaoFirebase.getReference();
        databaseFirebase.child("Alunos").child(""+1).setValue(this);
    }

}

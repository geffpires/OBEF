package com.example.obef.Activity;

import com.example.obef.Modelo.Alternativa;
import com.example.obef.Modelo.Questao;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeQuestoes {
    List<Questao> questoes;
    Questao atual;
    BancoDeQuestoes banco;

    int indexAtual;
    public GerenciadorDeQuestoes() {
        this.questoes=new ArrayList<Questao>();
        indexAtual=0;
    }
    public Questao getQuestaoBanco() {
        return null;
    }
    public List<Questao> getQuestoesBanco(){
        return null;
    }
    public List<Questao> getDesafio() {
        // TODO Auto-generated method stub
        return null;
    }
}

package com.example.obef.Modelo;

import com.example.obef.Configuração.ConfiguracaoFirebase;
import com.example.obef.Modelo.Alternativa;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class Questao {

    private String enunciado;
    private Alternativa alternativa1;
    private Alternativa alternativa2;
    private Alternativa alternativa3;
    private Alternativa alternativa4;
    private Alternativa alternativa5;
    private String dica;
    private int nivel;
    private int valor;
    private String dificuldade;

    public Questao(String enunciado, Alternativa alternativa1, Alternativa alternativa2,
                   Alternativa alternativa3, Alternativa alternativa4, Alternativa alternativa5,
                   String dica, int nivel, int valor, String dificuldade) {
        this.enunciado = enunciado;
        this.alternativa1 = alternativa1;
        this.alternativa2 = alternativa2;
        this.alternativa3 = alternativa3;
        this.alternativa4 = alternativa4;
        this.alternativa5 = alternativa5;
        this.dica = dica;
        this.nivel = nivel;
        this.valor = valor;
        this.dificuldade = dificuldade;
    }

    public Questao() {
    }

    public void salvar() {
        DatabaseReference databaseFirebase = ConfiguracaoFirebase.getReference();
        databaseFirebase.child("questões").child("1").setValue(this);
    }

    public String getEnunciado() {
        return this.enunciado;
    }

    public Alternativa getAlternativa1() {
        return alternativa1;
    }

    public Alternativa getAlternativa2() {
        return alternativa2;
    }

    public Alternativa getAlternativa3() {
        return alternativa3;
    }

    public Alternativa getAlternativa4() {
        return alternativa4;
    }

    public Alternativa getAlternativa5() {
        return alternativa5;
    }

    public int getNivel() {
        return nivel;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setAlternativa1(Alternativa alternativa1) {
        this.alternativa1 = alternativa1;
    }

    public void setAlternativa2(Alternativa alternativa2) {
        this.alternativa2 = alternativa2;
    }

    public void setAlternativa3(Alternativa alternativa3) {
        this.alternativa3 = alternativa3;
    }

    public void setAlternativa4(Alternativa alternativa4) {
        this.alternativa4 = alternativa4;
    }

    public void setAlternativa5(Alternativa alternativa5) {
        this.alternativa5 = alternativa5;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public int getValor() {
        return valor;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public String getDica() {

        return dica;
    }
}

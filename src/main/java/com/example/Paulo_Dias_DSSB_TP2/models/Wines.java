package com.example.Paulo_Dias_DSSB_TP2.models;

public class Wines {
    private Long id;
    private String name;
    private double ibv;
    private String tipo;
    private String uva;
    private String safra;
    private String pais;
    private String regiao;
    private double preco;
    private int avaliacao;

    public Wines() {
    }

    public Wines(Long id, String name, double ibv, String tipo, String uva, String safra, String pais, String regiao, double preco, int avaliacao) {
        this.id = id;
        this.name = name;
        this.ibv = ibv;
        this.tipo = tipo;
        this.uva = uva;
        this.safra = safra;
        this.pais = pais;
        this.regiao = regiao;
        this.preco = preco;
        this.avaliacao = avaliacao;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSafra() {
        return safra;
    }

    public void setSafra(String safra) {
        this.safra = safra;
    }

    public String getUva() {
        return uva;
    }

    public void setUva(String uva) {
        this.uva = uva;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getIbv() {
        return ibv;
    }

    public void setIbv(double ibv) {
        this.ibv = ibv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
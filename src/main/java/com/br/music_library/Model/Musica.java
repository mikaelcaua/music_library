package com.br.music_library.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {
    public Musica() {
    }

    private String nome;
    private Integer avaliacao;
    private String generoMusical;
    @ManyToOne
    private Cantor cantor;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Cantor getCantor() {
        return cantor;
    }

    public void setCantor(Cantor cantor) {
        this.cantor = cantor;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }
}

package com.br.music_library.Model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "cantores")
public class Cantor {
    public Cantor() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String nome;
    private String generoMusical;
    private Integer idade;
    @OneToMany(mappedBy = "cantor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", nome='" + nome + '\'' +
                ", generoMusical='" + generoMusical;
    }
}

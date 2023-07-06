package com.ELD.Biblioteca.domain.biblioteca;

import jakarta.persistence.*;


@Entity
@Table(name = "Biblioteca")
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String editora;

    public Biblioteca(dadosDeCadastro dados) {
        this.nome = dados.name();
        this.editora = dados.editora();


    }

    public Biblioteca() {
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nome='" + nome + '\'' +
                ", editora='" + editora + '\'' +
                '}';
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEditora() {
        return editora;
    }

    public Long getId() {   return id;}

    public void atualizaDados(dadosDeAlteracao dados) {
        this.nome = dados.nome();
        this.editora = dados.editora();
    }
}






package com.br.espec.provaDB.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "Funcionario")
public class Funcionario extends AbstractPersistable<Long> {

    @Column(name = "nome_func", nullable = false)
    private String nome;

    @Column(name = "sexo_func", nullable = false)
    private char sexo;

    @Column(name = "telefone_func", nullable = false)
    private String telefone;

    @ManyToOne(fetch=FetchType.EAGER, cascade ={CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;

    public Funcionario() {}

    public Funcionario(String nome, char sexo, String telefone, Cargo cargo) {
        super();
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.cargo = cargo;
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario {" +
                "nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", telefone='" + telefone + '\'' +
                ", cargo=[" + (cargo.getId() == null ? false : " ID=" + cargo.getId() +  ", cargo="+ cargo.getCargo()) + "]" +
                '}';
    }
}

package com.br.espec.provaDB.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Cargo")
public class Cargo extends AbstractPersistable<Long> {

    @Column(name = "cargo_desc", nullable = false)
    private String cargo;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "cargo", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private Set<Funcionario> funcionarioList = new LinkedHashSet<>(0);

    public Cargo() {}

    public Cargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Set<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(Set<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "cargo='" + cargo + '\'' +
                ", funcionarioList=" + (funcionarioList.isEmpty() == false ? funcionarioList : false) +
                '}';
    }
}

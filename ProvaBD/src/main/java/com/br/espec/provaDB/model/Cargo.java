package com.br.espec.provaDB.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Cargo")
public class Cargo extends AbstractPersistable<Long> {

    @Column(name = "cargo_desc", nullable = false)
    private String cargo;

    @OneToMany(mappedBy = "id", targetEntity = Funcionario.class)
    private List<Funcionario> funcionarioList;

    Cargo() {}

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

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }
}

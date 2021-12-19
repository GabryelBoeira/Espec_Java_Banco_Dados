package com.br.espec.provaDB.service;

import com.br.espec.provaDB.model.Cargo;
import com.br.espec.provaDB.model.Funcionario;
import com.br.espec.provaDB.repository.FuncionarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FuncionarioService {

    private static final Logger LOG = LoggerFactory.getLogger(FuncionarioService.class);

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoService cargoService;

    @Transactional(propagation= Propagation.REQUIRED, noRollbackFor=Exception.class)
    public boolean deletarFuncionarioPorId(Long id) {
        try {
            funcionarioRepository.deletefuncionarioById(id);
            return true;
        } catch (Exception e) {
            LOG.error("deletarFuncionarioPorId -> ", e.getCause());
            return false;
        }
    }

    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public List<String> listarNomeTodosFuncionarios() {
        return funcionarioRepository.findAllFuncionariosNome();
    }

    public Integer totalFuncionario() {
        return funcionarioRepository.totalFuncionarios();
    }

    @Transactional(propagation= Propagation.REQUIRED, noRollbackFor=Exception.class)
    public Funcionario salvarFuncionario(Funcionario funcionario) {
        try {
            if (funcionario.getCargo().getId() == null) {
                funcionario.setCargo(cargoService.salvarCargo(funcionario.getCargo()));
            }

            return funcionarioRepository.save(funcionario);
        } catch (Exception e) {

            LOG.error("salvarFuncionario -> ", e.getCause());
            return null;
        }
    }
}

package com.br.espec.provaDB.service;

import com.br.espec.provaDB.model.Funcionario;
import com.br.espec.provaDB.repository.FuncionarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FuncionarioService {

    private static final Logger LOG = LoggerFactory.getLogger(FuncionarioService.class);
    private final FuncionarioRepository funcionarioRepository;
    private final CargoService cargoService;

    public FuncionarioService(final FuncionarioRepository funcionarioRepository, final CargoService cargoService) {
        this.cargoService = cargoService;
        this.funcionarioRepository = funcionarioRepository;
    }

    public boolean deletarFuncionarioPorId(Long id) {
        try {
            funcionarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            LOG.error("deletarFuncionarioPorId -> ", e.getCause());
            return false;
        }
    }

    @Transactional
    public Funcionario salvarFuncionario(Funcionario funcionario) {
        try {
            if (funcionario.getCargo().getId() == null) {
                funcionario.setCargo(cargoService.salvarCargo(funcionario.getCargo()));
            }

            return funcionarioRepository.save(funcionario);
        } catch (Exception e) {

            LOG.error("deletarCargoPorId -> ", e.getCause());
            return null;
        }
    }
}

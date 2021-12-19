package com.br.espec.provaDB.service;

import com.br.espec.provaDB.model.Cargo;
import com.br.espec.provaDB.repository.CargoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CargoService {

    private static final Logger LOG = LoggerFactory.getLogger(FuncionarioService.class);

    @Autowired
    private CargoRepository cargoRepository;

    @Transactional(propagation= Propagation.REQUIRED, noRollbackFor=Exception.class)
    public boolean deletarCargoPorId(Long id) {
        try {
            cargoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            LOG.error("deletarCargoPorId -> ", e.getCause());
            return false;
        }
    }

    public List<Cargo> listarTodosCargos() {
       return cargoRepository.findAll();
    }

    @Transactional(propagation= Propagation.REQUIRED, noRollbackFor=Exception.class)
    public Cargo salvarCargo(Cargo cargo) {
        try {

            return cargoRepository.saveAndFlush(cargo);
        } catch (Exception e) {

            LOG.error("deletarCargoPorId -> ", e.getCause());
            return null;
        }
    }
}

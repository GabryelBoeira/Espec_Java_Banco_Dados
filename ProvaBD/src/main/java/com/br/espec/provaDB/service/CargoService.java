package com.br.espec.provaDB.service;

import com.br.espec.provaDB.model.Cargo;
import com.br.espec.provaDB.repository.CargoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CargoService {

    private static final Logger LOG = LoggerFactory.getLogger(FuncionarioService.class);
    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public boolean deletarCargoPorId(Long id) {
        try {
            cargoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            LOG.error("deletarCargoPorId -> ", e.getCause());
            return false;
        }
    }

    @Transactional
    public Cargo salvarCargo(Cargo cargo) {
        try {

            return cargoRepository.save(cargo);
        } catch (Exception e) {

            LOG.error("deletarCargoPorId -> ", e.getCause());
            return null;
        }
    }
}

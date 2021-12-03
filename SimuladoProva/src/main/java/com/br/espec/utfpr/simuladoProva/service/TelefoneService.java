package com.br.espec.utfpr.simuladoProva.service;

import com.br.espec.utfpr.simuladoProva.model.Telefone;

public interface TelefoneService {

	Telefone salvarTelefone(final Telefone telefone);

	Boolean deletarTelefone(final Long id);
}

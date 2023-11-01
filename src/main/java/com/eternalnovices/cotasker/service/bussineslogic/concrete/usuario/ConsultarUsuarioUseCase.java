package com.eternalnovices.cotasker.service.bussineslogic.concrete.usuario;

import java.util.List;


import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.dao.UsuarioDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.UseCaseFind;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;
import com.eternalnovices.cotasker.service.mapper.entity.concrete.UsuarioEntityMapper;


public class ConsultarUsuarioUseCase implements UseCaseFind<UsuarioDomain>{
	private DAOFactory factoria;
	
	public ConsultarUsuarioUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public List<UsuarioDomain> execute(UsuarioDomain domain) {
		final var resultados  = getUsuarioDAO().consultar(UsuarioEntityMapper.convertToEntity(domain));
		return UsuarioEntityMapper.convertToListDomain(resultados);
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final void setFactoria(final DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000256);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000257);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
	
	private final UsuarioDAO getUsuarioDAO() {
		return getFactoria().obtenerUsuarioDAO();
	}
	
}

package com.eternalnovices.cotasker.service.facade.concrete.proyecto;

import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.data.dao.daofactory.enumerator.TipoDAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.concrete.proyecto.RegistrarProyectoUseCase;
import com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.proyecto.RegistrarProyectoValidator;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.dto.ProyectoDTO;
import com.eternalnovices.cotasker.service.facade.Facade;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.ProyectoDTOMapper;

public class RegistrarProyectoFacade implements Facade<ProyectoDTO>{

	@Override
	public void execute(final ProyectoDTO dto) {
		final ProyectoDomain domain = ProyectoDTOMapper.convertToDomain(dto);
		RegistrarProyectoValidator.ejecutar(domain);
		
		DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daofactory.iniciarTransaccion();
			var useCase = new RegistrarProyectoUseCase(daofactory);
			useCase.execute(domain);
			daofactory.confirmarTransaccion();
		} catch (CoTaskerException e) {
			daofactory.cancelarTransaccion();
			throw e;
		} catch (Exception e) {
			daofactory.cancelarTransaccion();
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000911);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000912);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		} finally {
			daofactory.cerrarConexion();
		}
	}
}

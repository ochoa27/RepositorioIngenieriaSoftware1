package com.eternalnovices.cotasker.service.facade.concrete.proyecto;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.data.dao.daofactory.enumerator.TipoDAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.concrete.proyecto.RegistrarProyectoUseCase;
import com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.proyecto.RegistrarProyectoValidator;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.dto.ProyectoDTO;
import com.eternalnovices.cotasker.service.facade.FacadeId;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.ProyectoDTOMapper;

public class RegistrarProyectoFacade implements FacadeId<ProyectoDTO, UUID>{

	@Override
	public UUID execute(final ProyectoDTO dto, UUID id) {
		final ProyectoDomain domain = ProyectoDTOMapper.convertToDomain(dto);
		RegistrarProyectoValidator.ejecutar(domain);
		
		DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		UUID res = UtilUUID.UUIDDEFECTO;
		try {
			daofactory.iniciarTransaccion();
			var useCase = new RegistrarProyectoUseCase(daofactory);
			res = useCase.execute(domain, id);
			daofactory.confirmarTransaccion();
		} catch (CoTaskerException e) {
			daofactory.cancelarTransaccion();
			throw e;
		} catch (Exception e) {
			daofactory.cancelarTransaccion();
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000309);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000333);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		} finally {
			daofactory.cerrarConexion();
		}
		
		return res;
	}
}

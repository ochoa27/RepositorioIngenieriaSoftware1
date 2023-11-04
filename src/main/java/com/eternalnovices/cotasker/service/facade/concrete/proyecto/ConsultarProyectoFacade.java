package com.eternalnovices.cotasker.service.facade.concrete.proyecto;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.data.dao.daofactory.enumerator.TipoDAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.concrete.proyecto.ConsultarProyectoUseCase;
import com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.proyecto.ConsultarProyectoValidator;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.dto.ProyectoDTO;
import com.eternalnovices.cotasker.service.facade.FacadeFind;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.ProyectoDTOMapper;


public class ConsultarProyectoFacade  implements FacadeFind<ProyectoDTO>{

	@Override
	public List<ProyectoDTO> execute(final ProyectoDTO dto) {
		final ProyectoDomain domain = ProyectoDTOMapper.convertToDomain(dto);
		ConsultarProyectoValidator.ejecutar(domain);
		List<ProyectoDTO> resultados = new ArrayList<ProyectoDTO>();
		
		DAOFactory daoFactory=DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		try {
			daoFactory.iniciarTransaccion();
			var useCase =new ConsultarProyectoUseCase(daoFactory);
			resultados = ProyectoDTOMapper.convertToListDTO(useCase.execute(domain));
			daoFactory.confirmarTransaccion();
		}catch (CoTaskerException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch (Exception exception) {
			daoFactory.cancelarTransaccion();
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000303);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000304);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}finally {
			daoFactory.cerrarConexion();
		}
		return resultados;
		}
}

package com.eternalnovices.cotasker.service.facade.concrete.listatareas;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.data.dao.daofactory.enumerator.TipoDAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.concrete.listatareas.ConsultarListaTareasUseCase;
import com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.listatareas.ConsultarListaTareasValidator;
import com.eternalnovices.cotasker.service.domain.listatareas.ListaTareasDomain;
import com.eternalnovices.cotasker.service.dto.ListaTareasDTO;
import com.eternalnovices.cotasker.service.facade.FacadeFind;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.ListaTareasDTOMapper;



public class ConsultarListaTareasFacade implements FacadeFind<ListaTareasDTO>{

	@Override
	public List<ListaTareasDTO> execute(final ListaTareasDTO dto) {
		final ListaTareasDomain domain = ListaTareasDTOMapper.convertToDomain(dto);
		ConsultarListaTareasValidator.ejecutar(domain);
		List<ListaTareasDTO> resultados = new ArrayList<ListaTareasDTO>();
		
		DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daofactory.iniciarTransaccion();
			var useCase = new ConsultarListaTareasUseCase(daofactory);
			resultados = ListaTareasDTOMapper.convertToListDTO(useCase.execute(domain));
			daofactory.confirmarTransaccion();
		} catch (CoTaskerException e) {
			daofactory.cancelarTransaccion();
			throw e;
		} catch (Exception e) {
			daofactory.cancelarTransaccion();
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000803);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000804);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		} finally {
			daofactory.cerrarConexion();
		}
		return resultados;
	}

}

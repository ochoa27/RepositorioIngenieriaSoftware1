package com.eternalnovices.cotasker.service.bussineslogic.concrete.tarea;

import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.data.dao.TareaDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.data.entity.TareaEntity;
import com.eternalnovices.cotasker.service.bussineslogic.UseCase;
import com.eternalnovices.cotasker.service.domain.fechas.FechasDomain;
import com.eternalnovices.cotasker.service.domain.listatareas.ListaTareasDomain;
import com.eternalnovices.cotasker.service.domain.tarea.TareaDomain;
import com.eternalnovices.cotasker.service.dto.EstadoDTO;
import com.eternalnovices.cotasker.service.dto.FechasDTO;
import com.eternalnovices.cotasker.service.dto.PrioridadDTO;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.EstadoDTOMapper;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.FechasDTOMapper;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.PrioridadDTOMapper;
import com.eternalnovices.cotasker.service.mapper.entity.concrete.TareaEntityMapper;


public class RegistrarTareaUseCase implements UseCase<TareaDomain>{

	private DAOFactory factoria;
	
	public RegistrarTareaUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(TareaDomain domain) {
		validarNoExistenciaMismoNombre(domain.getNombre(), domain.getListaTareas());
		domain = obtenerIdentificadorTarea(domain);
		registrar(domain);
	}
	
	private final TareaDomain obtenerIdentificadorTarea(TareaDomain domain) {
		Optional<TareaEntity> optional;
		UUID uuid;
		
		do {
			uuid = UtilUUID.generarRandomUUID();
			optional = getTareaDAO().consultarPorId(uuid);
		} while (optional.isPresent());
		
		return TareaDomain.crear(uuid, domain.getNombre(), domain.getDescripcion(), FechasDomain.crear(domain.getFecha().getFechaCreacion(),
						domain.getFecha().getFechaEstimadaInicio(),
						domain.getFecha().getFechaEstimadaFin()),
				domain.getPrioridad(), domain.getEstado(), domain.getListaTareas());
	}
	
	
	private final void validarNoExistenciaMismoNombre(final String nombre, final ListaTareasDomain listaTareas) {
		final var domain = TareaDomain.crear(null, nombre, null, FechasDTOMapper.convertToDomain(FechasDTO.crear()),
				PrioridadDTOMapper.convertToDomain(PrioridadDTO.crear()), EstadoDTOMapper.convertToDomain(EstadoDTO.crear()),
				listaTareas);
		final var entity = TareaEntityMapper.convertToEntity(domain);
		final var resultados = getTareaDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000281);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
	
	private void registrar(final TareaDomain domain) {
		getTareaDAO().crear(TareaEntityMapper.convertToEntity(domain));
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000282);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000283);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}

	private final TareaDAO getTareaDAO() {
		return getFactoria().obtenerTareaDAO();
	}
}

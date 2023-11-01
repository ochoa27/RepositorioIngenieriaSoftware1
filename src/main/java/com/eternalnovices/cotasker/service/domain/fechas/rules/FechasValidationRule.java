package com.eternalnovices.cotasker.service.domain.fechas.rules;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.ValidationRule;
import com.eternalnovices.cotasker.service.domain.fechas.FechasDomain;

public class FechasValidationRule implements ValidationRule<FechasDomain> {

	private static final ValidationRule<FechasDomain> instancia = new FechasValidationRule();
	
	private FechasValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final FechasDomain domain) {
		instancia.validar(domain);
	}
	
	@Override
	public void validar(FechasDomain dato) {
		if (UtilObjeto.esNulo(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
		validarLinealidadTiempoFechaCreacion(dato);
		validarLinealidadTiempoFechaEstimadaInicio(dato);
	}
	
	private final void validarLinealidadTiempoFechaCreacion(final FechasDomain domain) {
		if(domain.getFechaCreacion().before(domain.getFechaEstimadaInicio())) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000148);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
		
		if(domain.getFechaCreacion().before(domain.getFechaEstimadaFin())) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000149);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
	
	private final void validarLinealidadTiempoFechaEstimadaInicio(final FechasDomain domain) {
		if(domain.getFechaEstimadaInicio().before(domain.getFechaEstimadaFin())) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000148);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
	
}

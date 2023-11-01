package com.eternalnovices.cotasker.service.domain.proyecto.rules;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.ValidationRule;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;


public class ProyectoValidationRule implements ValidationRule<ProyectoDomain>{
	private static final ValidationRule<ProyectoDomain> instancia = new ProyectoValidationRule();
	
	private ProyectoValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final ProyectoDomain data) {
		instancia.validar(data);
	}
	
	@Override
	public void validar(ProyectoDomain data) {
		if(UtilObjeto.esNulo(data)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000261);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
} 



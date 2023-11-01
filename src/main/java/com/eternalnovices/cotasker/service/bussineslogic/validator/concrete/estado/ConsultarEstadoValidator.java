package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.estado;

import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.estado.EstadoDomain;
import com.eternalnovices.cotasker.service.domain.estado.rules.DescripcionEstadoValidationRule;
import com.eternalnovices.cotasker.service.domain.estado.rules.IdEstadoValidationRule;

public class ConsultarEstadoValidator implements Validator<EstadoDomain>{
	private static final Validator<EstadoDomain> instancia = new ConsultarEstadoValidator();
	
	public static final void ejecutar(final EstadoDomain data) {
		instancia.execute(data);
	}

	@Override
	public void execute(EstadoDomain data) {
		if(!UtilObjeto.esNulo(data)) {
			if(!UtilUUID.esNulo(data.getIdEstado())) {
				IdEstadoValidationRule.ejecutarValidacion(data.getIdEstado());
			}
			
			if(!UtilTexto.estaVacio(data.getDescripcion())) {
				DescripcionEstadoValidationRule.ejecutarValidacion(data.getDescripcion());
			}
		}
	}
}

package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.prioridad;

import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.prioridad.PrioridadDomain;
import com.eternalnovices.cotasker.service.domain.prioridad.rules.DescripcionPrioridadValidationRule;
import com.eternalnovices.cotasker.service.domain.prioridad.rules.IdPrioridadValidationRule;

public class ConsultarPrioridadValidator implements Validator<PrioridadDomain>{
	private static final Validator<PrioridadDomain> instancia = new ConsultarPrioridadValidator();
	
	public static final void ejecutar(final PrioridadDomain data) {
		instancia.execute(data);
	}

	@Override
	public void execute(PrioridadDomain data) {
		if(!UtilObjeto.esNulo(data)) {
			if(!UtilUUID.esNulo(data.getIdPrioridad())) {
				IdPrioridadValidationRule.ejecutarValidacion(data.getIdPrioridad());
			}
			
			if(!UtilTexto.estaVacio(data.getDescripcion())) {
				DescripcionPrioridadValidationRule.ejecutarValidacion(data.getDescripcion());
			}
		}
	}
}

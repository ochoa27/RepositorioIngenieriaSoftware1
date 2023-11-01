package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.prioridad;

import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.prioridad.PrioridadDomain;
import com.eternalnovices.cotasker.service.domain.prioridad.rules.DescripcionPrioridadValidationRule;
import com.eternalnovices.cotasker.service.domain.prioridad.rules.IdPrioridadValidationRule;
import com.eternalnovices.cotasker.service.domain.prioridad.rules.PrioridadValidationRule;

public class ModificarPrioridadValidator implements Validator<PrioridadDomain>{
	private static final Validator<PrioridadDomain> instancia = new ModificarPrioridadValidator();
	
	public static final void ejecutar(final PrioridadDomain data) {
		instancia.execute(data);
	}

	@Override
	public void execute(PrioridadDomain data) {
		PrioridadValidationRule.ejecutarValidacion(data);
		IdPrioridadValidationRule.ejecutarValidacion(data.getIdPrioridad());
		DescripcionPrioridadValidationRule.ejecutarValidacion(data.getDescripcion());
	}
}

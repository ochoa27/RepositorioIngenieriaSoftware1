package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.estado;

import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.estado.EstadoDomain;
import com.eternalnovices.cotasker.service.domain.estado.rules.DescripcionEstadoValidationRule;
import com.eternalnovices.cotasker.service.domain.estado.rules.EstadoValidationRule;
import com.eternalnovices.cotasker.service.domain.estado.rules.IdEstadoValidationRule;

public class ModificarEstadoValidator implements Validator<EstadoDomain>{
	private static final Validator<EstadoDomain> instancia = new ModificarEstadoValidator();
	
	public static final void ejecutar(final EstadoDomain data) {
		instancia.execute(data);
	}

	@Override
	public void execute(EstadoDomain data) {
		EstadoValidationRule.ejecutarValidacion(data);
		IdEstadoValidationRule.ejecutarValidacion(data.getIdEstado());
		DescripcionEstadoValidationRule.ejecutarValidacion(data.getDescripcion());
	}
}

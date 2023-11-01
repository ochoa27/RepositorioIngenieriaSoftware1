package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.proyecto;

import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.IdProyectoValidationRule;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.ProyectoValidationRule;


public class EliminarProyectoValidator implements Validator<ProyectoDomain> {
	private static final Validator<ProyectoDomain> instancia = new EliminarProyectoValidator();
	
	private EliminarProyectoValidator() {
		super();
	}
	
	public static final void ejecutar(final ProyectoDomain domain) {
		instancia.execute(domain);
	}
	
	@Override
	public void execute(ProyectoDomain domain) {
		ProyectoValidationRule.ejecutarValidacion(domain);
		IdProyectoValidationRule.ejecutarValidacion(domain.getIdProyecto());
	}
}



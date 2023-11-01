package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.proyecto;

import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.DescripcionProyectoValitationRule;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.NombreProyectoValitadionRule;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.ProyectoValidationRule;

public class RegistrarProyectoValidator implements Validator<ProyectoDomain> {
	private static final Validator<ProyectoDomain> instancia= new RegistrarProyectoValidator();
	
	private RegistrarProyectoValidator() {
		 super();
	 }
	 
	 public static final void  ejecutar(final ProyectoDomain domain) {
		 instancia.execute(domain);
	 }

	@Override
	public void execute(ProyectoDomain domain) {
		ProyectoValidationRule.ejecutarValidacion(domain);
		NombreProyectoValitadionRule.ejecutarValidacion(domain.getNombre());
		DescripcionProyectoValitationRule.ejecutarValidacion(domain.getDescripcion());
	}
}

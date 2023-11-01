package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.listatareas;

import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.fechas.rules.FechaCreacionFechasValidationRule;
import com.eternalnovices.cotasker.service.domain.fechas.rules.FechasValidationRule;
import com.eternalnovices.cotasker.service.domain.listatareas.ListaTareasDomain;
import com.eternalnovices.cotasker.service.domain.listatareas.rules.DescripcionListaTareasValitationRule;
import com.eternalnovices.cotasker.service.domain.listatareas.rules.IdListaTareasValidationRule;
import com.eternalnovices.cotasker.service.domain.listatareas.rules.ListaTareasValidationRule;
import com.eternalnovices.cotasker.service.domain.listatareas.rules.NombreListaTareasValitadionRule;
import com.eternalnovices.cotasker.service.domain.prioridad.rules.IdPrioridadValidationRule;
import com.eternalnovices.cotasker.service.domain.proyecto.rules.IdProyectoValidationRule;


public final class ModificarListaTareasValidator implements Validator<ListaTareasDomain>{
	private static final Validator<ListaTareasDomain> instancia = new ModificarListaTareasValidator();
	
	private ModificarListaTareasValidator() {
		super();
	}
	
	public static final void ejecutar(final ListaTareasDomain domain) {
		instancia.execute(domain);
	}
	
	@Override
	public void execute(ListaTareasDomain domain) {
		ListaTareasValidationRule.ejecutarValidacion(domain);
		IdListaTareasValidationRule.ejecutarValidacion(domain.getIdListaTareas());
		NombreListaTareasValitadionRule.ejecutarValidacion(domain.getNombre());
		DescripcionListaTareasValitationRule.ejecutarValidacion(domain.getDescripcion());
		FechaCreacionFechasValidationRule.ejecutarValidacion(domain.getFecha().getFechaCreacion());
		FechasValidationRule.ejecutarValidacion(domain.getFecha());
		IdPrioridadValidationRule.ejecutarValidacion(domain.getPrioridad().getIdPrioridad());
		IdProyectoValidationRule.ejecutarValidacion(domain.getProyecto().getIdProyecto());
	}

}

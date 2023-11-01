package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.tarea;

import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.estado.rules.IdEstadoValidationRule;
import com.eternalnovices.cotasker.service.domain.fechas.rules.FechaCreacionFechasValidationRule;
import com.eternalnovices.cotasker.service.domain.fechas.rules.FechasValidationRule;
import com.eternalnovices.cotasker.service.domain.listatareas.rules.IdListaTareasValidationRule;
import com.eternalnovices.cotasker.service.domain.prioridad.rules.IdPrioridadValidationRule;
import com.eternalnovices.cotasker.service.domain.tarea.TareaDomain;
import com.eternalnovices.cotasker.service.domain.tarea.rules.DescripcionTareaValitationRule;
import com.eternalnovices.cotasker.service.domain.tarea.rules.NombreTareaValitadionRule;
import com.eternalnovices.cotasker.service.domain.tarea.rules.TareaValidationRule;


public final class RegistrarTareaValidator implements Validator<TareaDomain>{
	private static final Validator<TareaDomain> instancia = new RegistrarTareaValidator();
	
	private RegistrarTareaValidator() {
		super();
	}
	
	public static final void ejecutar(final TareaDomain data) {
		instancia.execute(data);
	}
	
	@Override
	public void execute(TareaDomain domain) {
		TareaValidationRule.ejecutarValidacion(domain);
		NombreTareaValitadionRule.ejecutarValidacion(domain.getNombre());
		DescripcionTareaValitationRule.ejecutarValidacion(domain.getDescripcion());
		FechaCreacionFechasValidationRule.ejecutarValidacion(domain.getFecha().getFechaCreacion());
		FechasValidationRule.ejecutarValidacion(domain.getFecha());
		IdPrioridadValidationRule.ejecutarValidacion(domain.getPrioridad().getIdPrioridad());
		IdEstadoValidationRule.ejecutarValidacion(domain.getEstado().getIdEstado());
		IdListaTareasValidationRule.ejecutarValidacion(domain.getListaTareas().getIdListaTareas());
	}

}

package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.tarea;

import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.tarea.TareaDomain;
import com.eternalnovices.cotasker.service.domain.tarea.rules.IdTareaValidationRule;
import com.eternalnovices.cotasker.service.domain.tarea.rules.TareaValidationRule;

public final class EliminarTareaValidator implements Validator<TareaDomain>{
	private static final Validator<TareaDomain> instancia = new EliminarTareaValidator();
	
	private EliminarTareaValidator() {
		super();
	}
	
	public static final void ejecutar(final TareaDomain domain) {
		instancia.execute(domain);
	}
	
	@Override
	public void execute(TareaDomain domain) {
		TareaValidationRule.ejecutarValidacion(domain);
		IdTareaValidationRule.ejecutarValidacion(domain.getIdTarea());
	}

}
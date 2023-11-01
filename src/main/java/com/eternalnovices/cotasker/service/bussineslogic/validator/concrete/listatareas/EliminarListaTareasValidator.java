package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.listatareas;

import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.listatareas.ListaTareasDomain;
import com.eternalnovices.cotasker.service.domain.listatareas.rules.IdListaTareasValidationRule;
import com.eternalnovices.cotasker.service.domain.listatareas.rules.ListaTareasValidationRule;


public final class EliminarListaTareasValidator implements Validator<ListaTareasDomain>{
	private static final Validator<ListaTareasDomain> instancia = new EliminarListaTareasValidator();
	
	private EliminarListaTareasValidator() {
		super();
	}
	
	public static final void ejecutar(final ListaTareasDomain domain) {
		instancia.execute(domain);
	}
	
	@Override
	public void execute(ListaTareasDomain domain) {
		ListaTareasValidationRule.ejecutarValidacion(domain);
		IdListaTareasValidationRule.ejecutarValidacion(domain.getIdListaTareas());
	}

}
package com.eternalnovices.cotasker.service.facade;

import java.util.List;

public interface FacadeFind<T> {
	
	List<T> execute(T dto);
}

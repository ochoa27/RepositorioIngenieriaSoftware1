package com.eternalnovices.cotasker.service.bussineslogic;

public interface UseCase<D> {
	
	void execute(D domain);
}

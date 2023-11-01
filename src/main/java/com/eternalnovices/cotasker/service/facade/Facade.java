package com.eternalnovices.cotasker.service.facade;

public interface Facade<T> {
	
	void execute(T dto);
}

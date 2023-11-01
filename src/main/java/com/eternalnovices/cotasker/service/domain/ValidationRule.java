package com.eternalnovices.cotasker.service.domain;

public interface ValidationRule<T> {
	void validar(T dato);
}

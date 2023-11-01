package com.eternalnovices.cotasker.service.bussineslogic.validator;

public interface Validator<T> {
	void execute(T data);
}

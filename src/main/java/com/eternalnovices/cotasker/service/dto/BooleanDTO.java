package com.eternalnovices.cotasker.service.dto;

public class BooleanDTO {

	private boolean valor;
	private boolean valorDefecto;
	
	public BooleanDTO() {
		setValor(false);
		setValorDefecto(true);
	}
	
	public BooleanDTO(final boolean valor, final boolean valorDefecto) {
		setValor(valor);
		setValorDefecto(valorDefecto);
	}
	
	public static final BooleanDTO crear() {
		return new BooleanDTO();
	}

	public final boolean isValor() {
		return valor;
	}
	
	public final boolean isValorDefecto() {
		return valorDefecto;
	}

	public final BooleanDTO setValor(final boolean valor) {
		this.valor = valor;
		return this;
	}

	public final BooleanDTO setValorDefecto(final boolean valorDefecto) {
		this.valorDefecto = valorDefecto;
		return this;
	}
	
	
}

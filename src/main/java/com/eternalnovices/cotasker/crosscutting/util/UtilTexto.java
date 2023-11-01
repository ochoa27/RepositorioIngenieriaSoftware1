package com.eternalnovices.cotasker.crosscutting.util;

public final class UtilTexto {
	
	public static final String VACIO = "";
	private static final String PATTERN_SOLO_LETRAS = "^[a-zA-ZÁÉÍÓÚáéíóú]+";
	private static final String PATTERN_SOLO_LETRAS_ESPACIOS = "^[a-zA-ZÁÉÍÓÚáéíóú ]+";
	private static final String PATTERN_SOLO_LETRAS_DIGITOS_ESPACIOS = "^[0-9a-zA-ZÁÉÍÓÚáéíóú ]+";
	private static final String PATTERN_CORREO_ELECTRONICO = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
	private static final String PATTERN_CONTRASENA= "^[A-Za-z0-9\\\\s#\\\\-\\\\/]+$";
	
	private UtilTexto() {
		super();
	}
	
	public static final String obtenerValorDefecto(final String valor, final String valorDefecto) {
		return UtilObjeto.obtenerValorDefecto(valor, valorDefecto);
	}
	
	public static final String obtenerValorDefecto(final String valor) {
		return obtenerValorDefecto(valor, VACIO);
	}
	
	public static final String aplicarTrim(final String valor) {
		return obtenerValorDefecto(valor).trim();
	}
	
	public static final boolean igualSinTrim(final String valorUno, final String valorDos) {
		return obtenerValorDefecto(valorUno).equals(obtenerValorDefecto(valorDos));
	}
	
	public static final boolean igualSinTrimIgnoreCase(final String valorUno, final String valorDos) {
		return obtenerValorDefecto(valorUno).equalsIgnoreCase(obtenerValorDefecto(valorDos));
	}
	
	public static final boolean igualConTrim(final String valor1, final String valor2) {
		return aplicarTrim(valor1).equalsIgnoreCase(aplicarTrim(valor2));
	}
	
	public static final boolean igualConTrimIgnoreCase(final String valor1, final String valor2) {
		return aplicarTrim(valor1).equals(aplicarTrim(valor2));
	}
	public static final boolean estaNulo(final String valor) {
		return UtilObjeto.esNulo(valor);
	}
	
	public static final boolean estaVacio(final String valor) {
		return igualConTrim(valor, VACIO);
	}
	
	public static final boolean longitudMinimaValida(final String valor, final int longitud) {
		return aplicarTrim(valor).length() >= longitud;
	}
	
	public static final boolean longitudMaximaValida(final String valor, final int longitud) {
		return aplicarTrim(valor).length() <= longitud;
	}
	
	public static final boolean longitudValida(final String valor, final int longitudMinima, final int longitudMaxima) {
		return longitudMinimaValida(valor, longitudMinima) && longitudMaximaValida(valor, longitudMaxima);
	}
	
	public static final boolean contieneSoloLetras(final String valor) {
		return obtenerValorDefecto(valor).matches(PATTERN_SOLO_LETRAS);
	}
	
	public static final boolean contieneSoloLetrasDigitosEspacios(final String valor) {
		return obtenerValorDefecto(valor).matches(PATTERN_SOLO_LETRAS_DIGITOS_ESPACIOS);
	}
	
	public static final boolean contieneFormatoCorreo(final String valor) {
		return obtenerValorDefecto(valor).matches(PATTERN_CORREO_ELECTRONICO);
	}
	public static final boolean contieneFormatoContrasena(final String valor) {
		return obtenerValorDefecto(valor).matches(PATTERN_CONTRASENA);
	}
	public static final boolean contieneSoloLetrasEspacios(final String valor) {
		return obtenerValorDefecto(valor).matches(PATTERN_SOLO_LETRAS_ESPACIOS);
	}
}

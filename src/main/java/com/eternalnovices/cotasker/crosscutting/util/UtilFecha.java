package com.eternalnovices.cotasker.crosscutting.util;

import java.sql.Date;
import java.util.Objects;

public class UtilFecha {
    public static final Date FECHADEFECTO = Date.valueOf("2500-12-31");

    private UtilFecha() {
        super();
    }

    public static final boolean esNulo(final Date fecha) {
        return Objects.isNull(fecha) || fecha == FECHADEFECTO;
    }

    public static final Date obtenerValorDefecto(final Date fecha, final Date valorDefecto) {
        return esNulo(fecha) ? valorDefecto : fecha;
    }
    
    public static final Date obtenerFechaActual() {
    	return new Date(new java.util.Date().getTime());
    }
}

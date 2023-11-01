package com.eternalnovices.cotasker.crosscutting.messages;

import java.util.HashMap;
import java.util.Map;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.CrosscuttingCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CategoriaMensaje;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.TipoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;



public class CatalogoMensajes {
	private static final Map<CodigoMensaje, Mensaje> MENSAJES = new HashMap<>();
	
	static {
		cargarMensajes();
	}
	
	private CatalogoMensajes() {
		super();
	}
	
	private static final void cargarMensajes() {
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000001, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No se recibió el codigo del mensaje que se queria crear. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000002, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No existe un mensaje con el código indicado. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000003, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible obtener un mensaje con un código vacío o nulo. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000004, TipoMensaje.USUARIO, CategoriaMensaje.FATAL, 
				"Se ha presentado un problema inesperado tratando de llevar a cabo la opereación deseada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000005, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de validar si la conexión SQL estaba abierta, la conexión se encontraba nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000006, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de validar si la conexión SQL estaba abierta. Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000007, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de validar si la conexión SQL estaba abierta. Se presento una excepcion inesperada. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000008, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cerrar la conexión SQL, la conexión esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000009, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cerrar la conexión SQL, la conexión no se encontraba abierta"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000010, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cerrar la conexión SQL. Se presento una excepcion inesperada. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000011, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de iniciar la transacción SQL, la conexión esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000012, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de iniciar la transacción, la conexión no se encontraba abierta"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000013, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de iniciar la transacción, la transacción ya ha sido inciada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000014, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de iniciar la transacción. Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000015, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de iniciar la transacción. Se presento una excepcion inesperada. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000016, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de confirmar la transacción SQL, la conexión esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000017, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de confirmar la transacción, la conexión no se encontraba abierta"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000018, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de confirmar la transacción, la transacción ya ha sido confirmada"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000019, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de confirmar la transacción. Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000020, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de confirmar la transacción. Se presento una excepcion inesperada. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000021, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cancelar la transacción SQL, la conexión esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000022, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cancelar la transacción, la conexión no se encontraba abierta"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000023, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cancelar la transacción, la transacción ya ha sido confirmada"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000024, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cancelar la transacción. Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000025, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cancelar la transacción. Se presento una excepcion inesperada. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000026, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de conectar con la base de datos. Motor de base de datos que se trata de conectar no usado por la app..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000027, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de establecer la coneccion con el servidor.Por favor verifique la traza del error presentado...."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000033, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información de la prioridad deseada"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000034, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id un tipo de identificación en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000035, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar por id un estado de tarea en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000036, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de prepar la consulta por id de un estado de tarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000037, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de insertar un tipo de identificación en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000038, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de insertar un tipo de identificación en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000039, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de insertar un dato en la base de datos..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000040, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar la prioridad deseado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000041, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar la prioridad en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000042, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar la prioridad en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000043, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema al consultar la prioridad deseada"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000044, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id una prioridad en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000045, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de procesar los datos de una consulta por id de una prioridaden la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000050, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema funcion colocarParametrosConsulta en PrioridadDAO tratando de consultar prioridad.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000051, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion colocarParametrosConsulta en PrioridadDAO tratando de consultar prioridad.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000053, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en funcion ejecutarConsulta en PrioridadDAO tratando de consultar prioridad.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000054, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion ejecutarConsulta en PrioridadDAO tratando de consultar prioridad.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000055, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar el estado de tarea deseado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000056, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar el estado de tarea en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado, el problema se presenta en estado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000057, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar el estado de tarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado, el problema se presenta en estado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000058, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del estado de tarea deseado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000060, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id del estado de tarea en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000059, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de procesar los datos de una consulta por id del estado de tarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000061, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de consultar el el estado de una tarea por id, el problema se presento en la base de datos . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000061, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de consultar el el estado de una tarea por id. por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000063, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del estado de tarea "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000064, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de consultar el el estado de una tarea, el problema se presento en la base de datos . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000065, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de consultar el el estado de una tarea. por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000067, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de ejecutar la consulta de un  estado de  tarea, el problema se presento en la base de datos . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000068, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de ejecutar la consulta de un  estado de  tarea por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000066, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de ejecutar la consulta la información del estado de tarea "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000069, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion colocar los parametros para una consulta  de un  estado de  tarea, el problema se presento en la base de datos . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000070, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion colocar los parametros para una consulta  de un  estado de  tarea. por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000071, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de crear un usuario ... "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000072, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de crear un usuario . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000073, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de crear un usuario . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000076, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de modificar un usuario . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000075, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de modificar un usuario . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000074, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar un usuario ... "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000077, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar un usuario ... "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000078, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de eliminar  un usuario . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000079, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de eliminar un usuario . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000080, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar  un usuario por id ... "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000081, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de consultar  un usuario por id . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000082, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de consultar  un usuario por id . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000083, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de ejecutar una consulta de un usuario por id . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000084, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de ejecutar una consulta de un usuario por id . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000085, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar  un usuario  ... "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000086, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de consultar  un usuario  . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000087, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de consultar  un usuario  . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000088, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de ejecutar la consultar  un usuario  . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000089, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando ejecutar la consultar  un usuario  . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000090, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de colocar los parametros de la consulta de un usuario  . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000091, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de colocar los parametros de la consulta de  un usuario  . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000101, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de insetar una asignación de un proyecto con un usuario"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000102, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de insertar un usuarioProyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000103, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de insertar un usuarioProyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000104, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar un usuarioProyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000105, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de modificar un usuarioProyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000106, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de modificar la relación entre un usuario y un proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000107, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar un usuarioProyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000108, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de eliminar un usuarioProyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000109, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de eliminar la relación entre un usuario y un proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000110, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información de la relación entre un usuario y un proyecto deseada"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000111, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id de usuarioproyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000112, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de procesar los datos de una consulta por id de usuarioproyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000113, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de preparar la consulta por id de un usuarioproyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000114, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de prepar la consulta por id de un usuarioproyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000116, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema funcion colocarParametrosConsulta en UsuarioProyectoDAO tratando de consultar usuariosproyectos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000117, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion colocarParametrosConsulta en UsuarioProyectoDAO tratando de consultar usuariosproyectos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000118, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en funcion ejecutarConsulta en UsuarioProyectoDAO tratando de consultar usuariosproyectos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000119, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion ejecutarConsulta en UsuarioProyectoDAO tratando de consultar usuariosproyectos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000120, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en consultar UsuarioProyectoDAO tratando de consultar usuariosproyectos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000121, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en consultar UsuarioProyectoDAO tratando de consultar usuariosproyectos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000122, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de insetar una tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000123, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de insertar una tarea en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000124, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de insertar una tarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000125, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de modificar una tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000126, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar una tarea en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000127, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de modificar una tarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000128, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de eliminar una tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000129, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar una tarea en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000130, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de eliminar una tarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000131, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información de la tarae deseada"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000132, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de preparar la consulta por id de una tarae en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000133, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de prepar la consulta por id de una tarae en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000134, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id de una tarea en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000135, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de procesar los datos de una consulta por id de una tarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000136, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en consultar TareaoDAO tratando de consultar tareas.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000137, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en consultar TareaoDAO tratando de consultar tareas.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000138, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema funcion colocarParametrosConsulta en TareaoDAO tratando de consultar tareas.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000139, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion colocarParametrosConsulta en TareaoDAO tratando de consultar taraes.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000140, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en funcion ejecutarConsulta en TareaoDAO tratando de consultar taraes.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000115, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion ejecutarConsulta en TareaoDAO tratando de consultar taraes.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000092, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La fecha de creación es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000093, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El identificador de prioridad es un dato obligatorio y no puede ser igual al UUID por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000094, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud de la descripción de prioridad no es valida. La longitud maxima son 25 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000095, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripción de prioridad es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000096, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripción de prioridad solo puede contener letras"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000097, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El identificador de estado es un dato obligatorio y no puede ser igual al UUID por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000098, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud de la descripción de estado no es valida. La longitud maxima son 25 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000099, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripción de estado es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000100, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripción de estado solo puede contener letras"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000141, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase FechasEntityMapper.No es posible mapear las fechas dominio a partir de una entidad de fechas entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000150, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toEntity de la clase FechasEntityMapper.No es posible mapear las fehas entity a partir de una entidad de fechas dominio nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000151, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase PrioridadEntityMapper.No es posible mapear una prioridad dominio a partir de una entidad de una prioridad entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000152, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toEntity de la clase PrioridadEntityMapper.No es posible mapear una prioridad entity a partir de una entidad de una prioridad dominio nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000153, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase EstadoEntityMapper.No es posible mapear un estado dominio a partir de una entidad de un estado entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000154, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toEntity de la clase EstadoEntityMapper.No es posible mapear un estado entity a partir de una entidad de un estado dominio nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000155, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El identificador de proyecto  es un dato obligatorio y no puede ser igual al UUID por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000156, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud del nombre del proyecto  no es valida. La longitud maxima son 30 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000157, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El nombre del proyecto solo puede contener letras, digitos o espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000158, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El nombre del proyecto  es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000161, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud de la descripcion  del proyecto  no es valida. La longitud maxima son 60 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000159, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripcion del proyecto solo puede contener letras, digitos o espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000160, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripcion  del proyecto  es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000162, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar una Lista de Tareas en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000163, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de modificar una tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000164, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de modificar una Listatareas en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000165, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de crear una Lista de tareas"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000166, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de insertar una ListaTareas en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000167, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de insertar una ListaTarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000168, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de eliminar una lista de tareas"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000169, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar una lista de tareas en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000170, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de eliminar una lista de tareas en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000171, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información de la lista de tareas deseada"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000172, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de preparar la consulta por id de una lista de tareas en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000173, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de preparar la consulta por id de una lista de tareas en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000174, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id de una lista de tareas en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000175, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de procesar los datos de una consulta por id de una lista de tareas en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000176, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en consultar ListaTareaDAO tratando de consultar tareas.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000177, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en consultar ListaTareaDAO tratando de consultar tareas.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000178, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema funcion colocarParametrosConsulta en ListaTareaDAO tratando de consultar tareas.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000179, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion colocarParametrosConsulta en ListaTareaDAO tratando de consultar taraes.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000180, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en funcion ejecutarConsulta en ListaTareaDAO tratando de consultar taraes.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000181, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion ejecutarConsulta en ListaTareaDAO tratando de consultar taraes.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000182, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de crear un proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000183, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de insertar un proyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000184, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de insertar un proyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000185, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de modificar un proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000186, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar un proyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000187, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de modificar un proyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000188, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de eliminar un proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000189, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar un proyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000190, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de eliminar un proyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000191, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del proyecto deseada"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000192, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de preparar la consulta por id de un proyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000193, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de preparar la consulta por id de un proyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000194, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id de un proyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000195, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de procesar los datos de una consulta por id de un proyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000196, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en consultar ProyectoDAO tratando de consultar tareas.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000197, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en consultar ProyectoDAO tratando de consultar tareas.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000198, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema funcion colocarParametrosConsulta en ProyectoDAO tratando de consultar tareas.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000199, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion colocarParametrosConsulta en ProyectoDAO tratando de consultar taraes.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000200, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en funcion ejecutarConsulta en ProyectoDAO tratando de consultar proyectos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000201, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion ejecutarConsulta en ProyectoDAO tratando de consultar taraes.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000160, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El id del Usuario   es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000203, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud del nombre del usuario no es valida. La longitud maxima son 100 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000204, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El nombre del usuario  es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000205, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El nombre del usuario solo debe contener digitos letras o espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000206, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud del apellido del usuario no es valida. La longitud maxima son 100 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000207, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El apellido del usuario  es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000208, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El apellido del usuario solo debe contener digitos letras o espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000209, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud de la contraseña del usuario no es valida. La longitud maxima son 100 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000210, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La contraseña del usuario  es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000211, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La contraseña del usuario solo debe contener digitos letras o espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000212, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud del correo electronico del usuario no es valida. La longitud maxima son 100 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000213, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El correo  del usuario  es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000214, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El correo del usuario no cumple con los requisitos de un correo electronico"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000215, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La comfirmacion del correo del  usuario debe ser obligatoria"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000216, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase ProyectoEntityMApper.No es posible mapear un proyecto dominio a partir de una entidad de un proyecto entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000217, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toEntity de la clase ProyectoEntityMApper.No es posible mapear el proyecto entity a partir de una entidad de proyectos dominio nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000218, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase UsuarioEntityMApper.No es posible mapear el usuario domain a partir de una entidad de usuario entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000219, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toEntity de la clase UsuarioEntityMApper.No es posible mapear el usuario entity a partir de una entidad de usuario Domain nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000220, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase UsuarioProyectoEntityMApper.No es posible mapear el UsuarioProyecto domain a partir de una entidad de UsuarioProyecto entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000221, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toEntity de la clase UsuarioProyectoEntityMApper.No es posible mapear el UsuarioProyecto entity a partir de una entidad de UsuarioProyecto Domain nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000222, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase ListaTareasEntityMapper.No es posible mapear una prioridad dominio a partir de una entidad de una prioridad entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000223, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toEntity de la clase ListaTareasEntityMapper.No es posible mapear una prioridad entity a partir de una entidad de una prioridad dominio nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000224, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase TareaEntityMapper.No es posible mapear una prioridad dominio a partir de una entidad de una prioridad entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000225, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toEntity de la clase TareaEntityMapper.No es posible mapear una prioridad entity a partir de una entidad de una prioridad dominio nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000226, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripcion de la lista de tareas solo puede contener letras, digitos o espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000227, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud de la descripcion de la lista de tareas no es valida. La longitud maxima son 60 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000228, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripcion  de la lista de tareas es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000229, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El identificador de la lista de tareas es un dato obligatorio y no puede ser igual al UUID por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000230, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El nombre de la lista de tareas solo puede contener letras, digitos o espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000231, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El nombre de la lista de tareas es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000232, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud del nombre de la lista de tareas no es valida. La longitud maxima son 30 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000233, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripcion de la tarea solo puede contener letras, digitos o espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000234, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud de la descripcion de la tarea no es valida. La longitud maxima son 60 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000235, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripcion  de la lista de tareas es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000236, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El identificador de la tarea es un dato obligatorio y no puede ser igual al UUID por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000237, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El nombre de la tarea solo puede contener letras, digitos o espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000238, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El nombre de la tarea es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000239, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud del nombre de la tarea no es valida. La longitud maxima son 30 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000240, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase UsuarioDTOMapper.No es posible mapear un usuario domain a partir de una entidad de tipo usuario dto nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000241, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDTO de la clase UsuarioDTOMapper.No es posible mapear un tipo de usuario dto a partir de una entidad de usuario domain nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000243, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase ProyectoDTOMapper.No es posible mapear un proyecto domain a partir de una entidad de tipo proyecto dto nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000244, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDTO de la clase ProyectoDTOMapper.No es posible mapear un tipo de Proyecto dto a partir de una entidad de Proyecto domain nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000245, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase UsuarioProyectoDTOMapper.No es posible mapear un UsuarioProyecto domain a partir de una entidad de tipo UsuarioProyecto dto nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000246, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDTO de la clase UsuarioProyectoDTOMapper.No es posible mapear un tipo de UsuarioProyecto dto a partir de una entidad de UsuarioProyecto domain nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000247, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase ListaTareasDTOMapper.No es posible mapear una ListaTareasDomain a partir de una entidad de tipo ListaTareasDTO nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000248, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDTO de la clase ListaTareasDTOMapper.No es posible mapear un tipo de ListaTareasDTO a partir de una entidad de ListaTareasDomain nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000249, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase TareaDTOMapper.No es posible mapear una TareaDomain a partir de una entidad de tipo TareaDTO nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000250, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDTO de la clase TareaDTOMapper.No es posible mapear un tipo de TareaDTO a partir de una entidad de TareaDomain nula"));	
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000142, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase FechasDTOMapper.No es posible mapear fechas domain a partir de fechas dto nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000143, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDTO de la clase FechasDTOMapper.No es posible mapear fechas dto a partir de fechas domain nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000144, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase PrioridadDTOMapper.No es posible mapear una prioridad domain a partir de una de prioridad dto nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000145, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDTO de la clase PrioridadDTOMapper.No es posible mapear una prioridad dto a partir de una de prioridad domain nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000146, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase EstadoDTOMapper.No es posible mapear un estado domain a partir de un estado dto nulo"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000147, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDTO de la clase EstadoDTOMapper.No es posible mapear un estado dto a partir de un estado domain nulo"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000148, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"La fecha estimada de inicio no puede ser antes de su fecha de creación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000149, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"La fecha estimada de fin no puede ser antes de su fecha de creación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000251, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No es posible llevar a cabo la operación deseada con la tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000252, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No es posible llevar a cabo la operación deseada con la tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000258, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo la modificacion de un usuario"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000259, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase ModificarUsuarioUseCase.Debido a que la factoria con la cual se desea crear esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000256, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo la consulta de un usuario"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000257, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase ConsultarUsuarioUseCase.Debido a que la factoria con la cual se desea crear��esta��nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000254, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo el registro de un usuario"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000255, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase RegistrarUsuarioUseCase.Debido a que la factoria con la cual se desea crear��esta��nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000253, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No se puede registrar un usuario con un correo electronico ya registrado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000260, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No es posible llevar a cabo la operación deseada con el usuario"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000261, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No es posible llevar a cabo la operación deseada con el proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000262, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No es posible llevar a cabo la operación deseada con el Usuarioproyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000263, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de eliminar  un usuario"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000264, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase EliminarUsuarioUseCase.Debido a que la factoria con la cual se desea eliminar esta��nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000265, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No se puede eliminar el Usuario. El Usuario a eliminar no esta registrado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000268, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo la consulta de un Proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000269, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase ConsultarProyectoUseCase.Debido a que la factoria con la cual se desea crear��esta��nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000270, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo el registro  de un Proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000271, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase ConsultarProyectoUseCase.Debido a que la factoria con la cual se desea registrar��esta��nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000272, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No se puede registrar un Proyecto con el mismo nombre"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000801, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo la consulta de datos de una lista de tareas"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000802, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase ConsultarListaTareasUseCase.Debido a que la factoria con la cual se desea crear esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000803, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un error inesperado tratando de consultar una lista de tareas"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000804, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en función execute en ConsultarListaTareasFacade tratando de consultar una lista de tareas.Se presento una excepción de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000805, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo la consulta de datos de una tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000806, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase ConsultarTareaUseCase.Debido a que la factoria con la cual se desea crear esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000807, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un error inesperado tratando de consultar una tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000808, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en función execute en ConsultarTareaFacade tratando de consultar una tarea.Se presento una excepción de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000809, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Ya existe una tarea con ese nombre"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000810, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo el registro de datos de una nueva tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000811, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase RegistroTareaUseCase.Debido a que la factoria con la cual se desea crear esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000812, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un error inesperado tratando de registrar una Tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000813, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en función execute en RegistrarTareaFacade tratando de insertar una nueva tarea.Se presento una excepción de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000814, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Ya existe una lista de tareas con ese nombre"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000000901, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo la modificacion  de datos de un proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000000902, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase RegistroProyectoUseCase.Debido a que la factoria con la cual se desea modificar esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000815, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un error inesperado tratando de registrar una lista de tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000816, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en función execute en RegistrarListaTareasFacade tratando de insertar una nueva lista de tareas.Se presento una excepción de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000817, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No hay una parea existente para eliminar"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000818, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar la eliminación de la tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000819, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase EliminarTareaUseCase.Debido a que la factoria con la cual se desea crear esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000820, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"La Lista de tareas a elimianar contiene aun tareas"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000821, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo la eliminacion de la lista de tareas"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000822, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase EliminarListaTareasUseCase.Debido a que la factoria con la cual se desea crear esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000821, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo la eliminzacion de la lista de tareas"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000822, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase EliminarListaTareasUseCase.Debido a que la factoria con la cual se desea eliminar esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000823, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"La lista de tareas a eliminar no existe"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000823, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"La tarea a eliminar no existe"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000824, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un error inesperado tratando de eliminar una tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000825, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en función execute en EliminarTareaFacade tratando de eliminar una tarea.Se presento una excepción de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000826, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase BooleanEntityMapper.No es posible mapear un Boolean dominio a partir de una entidad de Boolean entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000827, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toEntity de la clase BooleanEntityMapper.No es posible mapear un Boolean entity a partir de una entidad de un Boolean domain nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000828, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No existe un usuario a modificar"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000829, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No se puede modificar el usuario deseado. Ya existe un usuario con el correo electronico a modificar"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000830, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No existe un proyecto existen a actualizar"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000905, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un error inesperado tratando de consultar un Proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000906, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en función execute en ConsultarProyectoFacade tratando de consultar un Proyecto.Se presento una excepción de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000907, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un error inesperado tratando de modificar un Proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000908, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en función execute en ModificarProyectoFacade tratando de modificar un Proyecto.Se presento una excepción de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000909, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un error inesperado tratando de eliminar un Proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000910, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en función execute en EliminarProyectoFacade tratando de eliminar un Proyecto.Se presento una excepción de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000911, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un error inesperado tratando de registrar un nuevo Proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000912, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en función execute en RegistrarProyectoFacade tratando de insertar un nuevo Proyecto.Se presento una excepción de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000831, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un error inesperado tratando de consultar un usuario"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000832, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en función execute en ConsultarUsuarioFacade tratando de consultar un usuario.Se presento una excepción de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000833, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un error inesperado tratando de eliminar un usuario"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000834, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en función execute en EliminarUsuarioFacade tratando de eliminar un usuario.Se presento una excepción de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000835, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un error inesperado tratando de registrar un usuario"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000836, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en función execute en RegistrarUsuarioFacade tratando de insertar un nuevo usuario.Se presento una excepción de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000837, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un error inesperado tratando de modificar un usuario"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000838, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en función execute en ModificarUsuarioFacade tratando de modificar un usuario.Se presento una excepción de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000913, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo la eliminacion del Proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000914, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase EliminarProyectoUseCase.Debido a que la factoria con la cual se desea eliminar esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000915, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El Proyecto a elimianar es utilizado actualmente por  un Usuario"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000916, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No existe un Proyecto existente a eliminar"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000917, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo el Registro de un usuario en el proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000918, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase RegistrarUsuarioProyectoUseCase.Debido a que la factoria con la cual se desea registrar esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000919, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo la eliminacion de un usuario en el proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000920, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase EliminarUsuarioProyectoUseCase.Debido a que la factoria con la cual se desea registrar esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000839, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No existe un UsuarioProyecto existente a eliminar"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000840, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase EliminarUsuarioProyectoUseCase.Debido a que la factoria con la cual se desea Eliminar esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000841, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo la eliminacion de un UsuarioProyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000700, TipoMensaje.USUARIO, CategoriaMensaje.CONFIRMACION,
				"El usuario fue registrado exitosamente"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000701, TipoMensaje.USUARIO, CategoriaMensaje.CONFIRMACION,
				"Logueado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000702, TipoMensaje.USUARIO, CategoriaMensaje.CONFIRMACION,
				"No logueado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000703, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema al crear la conexión SQL. No se ha podido obtener las variables de entorno"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000704, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de crear la conexión SQL. Se presento una excepción de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000705, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de crear la conexión SQL. Se presento una excepción inesperada. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000706, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de crear DAO deseado. La conexión esta cerrada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000921, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un error inesperado tratando de registrar un usuarioProyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000922, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en función execute en RegistrarusuarioProyectoFacade tratando de insertar un nuevo usuarioProyecto.Se presento una excepción de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000923, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un error inesperado tratando de eliminar un usuarioProyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000924, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en función execute en EliminarusuarioProyectoFacade tratando de eliminar un usuarioProyecto.Se presento una excepción de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000842, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Ya existe un UsuarioProyecto con los mismos id"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000843, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo el Registro de un UsuarioProyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000844, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase RegistrarUsuarioProyectoUseCase.Debido a que la factoria con la cual se desea registrar esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000707, TipoMensaje.USUARIO, CategoriaMensaje.CONFIRMACION,
				"El proyecto fue registrado exitosamente"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000708, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo el registro de un proyecto"));
	}
	
	
	private static final void agregarMensaje(final Mensaje mensaje) {
		MENSAJES.put(mensaje.getCodigo(), mensaje);
	}
	
	public static final Mensaje obtenerMensaje(final CodigoMensaje codigo) {
		
		if(UtilObjeto.esNulo(codigo)) {
			var  mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var  mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M0000000003);
			throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		if(!MENSAJES.containsKey(codigo)) {
			var  mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var  mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M0000000002);
			throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);			
		}
		
		return MENSAJES.get(codigo);
	}
	
	public static final String obtenerContenidoMensaje(final CodigoMensaje codigo) {
		return obtenerMensaje(codigo).getContenido();
	}
}

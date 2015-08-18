package com.praxis.siho.test.common.constants;

import com.praxis.siho.test.common.SetTestVariables;

public class PageURLsConstants {
    public static final String URL                        = SetTestVariables.configProp.getProperty("siho.url");   
    public static final String PAGE_LOGIN                 = URL + "login.xhtml";
    public static final String PAGE_MAIN                  = URL + "views/registroHorario.xhtml";
    
    //MODULO ASIGNACIONES
    public static final String PAGE_REGISTRO_DESASIGNACION= URL + "views/registroDesasignacion.xhtml";
    public static final String PAGE_CONSULTA_ASIGNACIONES = URL + "views/consultaAsignaciones.xhtml";
    public static final String PAGE_STATUS_ASIGNACION     = URL + "views/statusdelaAsignacion.xhtml";
    public static final String PAGE_TIPO_ASIGNACION       = URL + "views/tipoAsignacion.xhtml";
    public static final String PAGE_LINEA_TECNOLOGICA     = URL + "views/lineaTecnologica.xhtml";
    public static final String PAGE_PROX_DESASIGNARSE     = URL + "views/proximosADesasignarse.xhtml";
    
    //MODULO ACTIVIDADES
    public static final String PAGE_CAPTURA_ACTIVIDADES   = URL + "views/capturaActividades.xhtml";
    public static final String PAGE_CAT_ACTIVIDADES       = URL + "views/catalogoActividades.xhtml";
    public static final String PAGE_ASIG_CAT_ACTIV_PROY   = URL + "views/asignarCatalogoActividad" +
            "esaProyecto.xhtml";
    public static final String PAGE_BLOQ_MENSUAL_ACTIVI   = URL + "views/bloqueoMensualActividades.xhtml";
    
    //HORARIOS
    public static final String PAGE_REGISTRO_HORARIO      = URL + "views/registroHorario.xhtml";
    public static final String PAGE_ADM_HORARIOS          = URL + "views/administracionHorarios.xhtml";
    public static final String PAGE_CONSULTA_HORARIOS	  = URL + "views/consultaHorarios.xhtml";
    public static final String PAGE_CONTROL_HORARIOS	  = URL + "views/controlHorarios.xhtml";
    public static final String PAGE_PUNTUALIDAD_ASIST	  = URL + "views/puntualidadAsistencia.xhtml";
    
    //REPORTES
    public static final String PAGE_REPORTES_ASIGNACIONES = URL + "views/reportesAsignaciones.xhtml";
    public static final String PAGE_VALOR_DEVENGADO       = URL + "views/valorDevengado.xhtml";
    
    //PROYECTOS
    public static final String PAGE_CATALOGO_GERENTES     = URL + "views/catalogoGerentes.xhtml";
    public static final String PAGE_CATALOGO_PROYECTOS    = URL + "views/catalogoProyectos.xhtml";
    
    //TRANSFERENCIA A NOMINA
    public static final String PAGE_TRANSFERENCIA_NOMINA  = URL + "views/transferenciaNomina.xhtml";
    
    //RENTABILIDAD
    public static final String PAGE_CONTROL_CAMBIOS       = URL + "views/ControlDeCambios.xhtml";
    public static final String PAGE_RENTABILIDAD_PROYECTO = URL + "views/rentabilidadProyectos.xhtml";
    public static final String PAGE_RENTABILIDAD_CURSO    = URL + "views/rentabilidadCurso.xhtml";

    //PSP
    public static final String PAGE_CONFIG_PROYECTOS      = URL + "views/configuracionProyecto.xhtml";
    public static final String PAGE_ESTIMACION_TAMANIO    = URL + "views/estimacionTamano.xhtml";
    public static final String PAGE_ASISTENTE_PROBE       = URL + "views/AsistentePROBE.xhtml";
    public static final String PAGE_PLANEACION_ACT        = URL + "views/capturaActividadesPSP.xhtml.xhtml";
    public static final String PAGE_CAPTURA_DEFECTOS      = URL + "views/capturaDefectos.xhtml";
    public static final String PAGE_BITACORA_DEFECTOS     = URL + "views/BitacoraDefectosPSP.xhtml";
    public static final String PAGE_RESUMEN_PSP           = URL + "views/resumenMetricasGenerales.xhtml";
    public static final String PAGE_CAT_NIVEL_FASE_ACT    = URL + "views/CatalogoNivelFaseActividadPSP.xhtml";
    public static final String PAGE_CAT_PLANTILLAS        = URL + "views/CatalogoPlantillasPSP.xhtml";
    public static final String PAGE_CAT_DEFECTOS          = URL + "views/CatalogoDefectosPSP.xhtml";
    public static final String PAGE_CAT_TIPO_MEDIDA       = URL + "views/catalogoTipoMedida.xhtml";
    public static final String PAGE_CAT_TIPO_FUNC         = URL + "views/catalogoTipoFuncionalidad.xhtml";
    public static final String PAGE_CAT_TAMANIO_RELATIVO  = URL + "views/catalogoTamanoRelativo.xhtml";
}

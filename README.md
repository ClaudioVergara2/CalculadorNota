# Sistema de Gestión de Notas de Curso

Este sistema de gestión de notas de curso permite calcular la nota final de un estudiante en base a sus evaluaciones, asistencia y examen. A continuación se detallan las funcionalidades y reglas:

## Entrada de Datos

- Evaluaciones (Evaluación 1, Evaluación 2 y Evaluación 3): Valores entre 1.0 y 7.0.
- Asistencia: Número entero del 1 al 100.
- Examen: Valores entre 1.0 y 7.0.

## Cálculo de Nota de Presentación

La nota de presentación se calcula de la siguiente manera:
- Evaluación 1 * 25%
- Evaluación 2 * 35%
- Evaluación 3 * 40%

## Cálculo de Nota Final

La nota final se calcula como:
- Nota de presentación (60%)
- Nota de examen (40%)

## Eximirse del Examen

Para eximirse del examen, se deben cumplir las siguientes condiciones:
- El promedio de las 3 evaluaciones debe ser mayor o igual a 4.0.
- La asistencia debe ser mayor a 0.

En este caso:
- La nota del examen es igual a la nota de presentación.
- La nota final es igual a la nota de presentación.

## No Tener Derecho a Examen

No se tiene derecho a examen en los siguientes casos:
- La nota de presentación es inferior a 2.0.
- La asistencia es 0.

En este caso:
- La nota del examen es igual a la nota de presentación.
- La nota final es igual a la nota de presentación.

## Validaciones

Se realizan las siguientes validaciones:
- Rangos de números para las evaluaciones, asistencia y examen.
- Verificación de que todos los datos requeridos estén ingresados.
- Deshabilitación del ingreso de la nota de examen cuando el estudiante está eximido o no tiene derecho al examen.

## Resultados

Se muestran los siguientes resultados y visualizaciones:
- Mensajes de APROBACIÓN, EXIMICIÓN y REPROBACIÓN DEL RAMO, según corresponda.
- Imágenes de estado, por ejemplo, un semáforo en verde para APROBADO o uno en rojo para REPROBADO.
- Botón de reinicio que permite borrar todos los valores ingresados para volver a calcular la nota de presentación.

## Vista
![Vista](https://github.com/ClaudioVergara2/CalculadorNota/blob/main/Prototipo.jpg)

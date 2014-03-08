Readme.txt

================================================================================
Autores  =======================================================================
================================================================================

Nombre de los Autores
------------------------

Alejandra Cruz Gaviria

Paola Andrea Madrid Arango 


Cesar Augusto Quiroz Zora

Jaime Adalberto Trujillo de la Torre 


================================================================================
Versión ========================================================================
================================================================================

Versión 1.0 03-03-2014
    - Se utilizó Refletion para leer todas las clases que heredaban de
      TransactionProcessor en un paquete específico.
    - Se creó una consola en la que el usuario ponía el nombre de la  
      Implementación que se quería usar.
    - Se utilizó el Binding Provider de Google Guice para inyectar la 
      dependencia de la interfaz TransactionProcesor al metodo Charge de la 
      clase billingService en el metodo chargeOrder
    
Versión 2.0 05-03-2014 
    - Se creó una menu para que el programa se ejecute hasta que el usuario 
      decidiera salirse.
    - Una de las opciones del menú muestra todas las implementaciones activas 
      que se encuentran el programa 
    - Se separó la interfaz TransactionProcesor principal del Proyecto
      billingservice-guice en un proyecto llamado billingservice-core 
    - Se generó el proyecto externaljar-billingservice para ejemplificar la 
      lectura de las nuevas especificaciones en runtime

================================================================================
Instalación y ejecución el programa ============================================
================================================================================

1. Clonar el contenido de la carpeta dependecy_injection_workshop
2. Importar los siguinetes proyectos como proyectos Maven: 
	- billingservice-core
	- billingservice-guice
3. Importar el siguinte proyecto como un proyecto Java
	- externaljar-billingservice
4. Se debe modificar la línea 39 colocando la ruta de la carpeta donde desea 
   que el sistema identifique los jar a cargar en runtime, 
   ejemplo: D:/TEMP/JARFILES
5. Exportar el jar del proyecto billingservice-core
6. Cargar el jar en el proyecto billingservice-guice

7. Como ejemplo se adiciono el proyecto externaljar-billingservice el cual 
   contiene una serie de implementaciones de la interface TransactionProcessor, 
   de este poryecto se pretende exportar el jar y cargarlo en 
   billingservice-guice cuando el programa se encuentre corriendo, y poder 
   evaluar la carga de la inyección de dependencias en runtime


================================================================================

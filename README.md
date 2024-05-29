# Mi Proyecto Wordle

Este es un proyecto de un juego de Wordle desarrollado en JavaFX.

## Instalación
Clona el repositorio y abre el proyecto con tu IDE favorito.

## Estructura de Código

Contiene 5 clases, dos son controladoras de las correspondientes principales, y la otra es la que lanza la aplicación.

## Recursos Usados

Hay un archivo con estilos llamado "letras.css" que se encarga de dar estilos principalmente a las letras mediante el juego se lleva a cabo, después está
la carpeta img con sus correspondientes imágenes dentro, y después dentro de la misma carpeta de los recursos, los varios FXML creados para esta aplicación.

------------------------------------------------------------------------

## Funcionamiento de la aplicación

Se desplegará el menú inicial nada más comenzar con sus tres opciones básicas:

1 - Iniciar Juego: Comenzará la partida

2 - Salir App: Saldrá de la APP y se cerrará la ventana

3 - Estructura GitHub: Entrará al repositorio de GitHub (este mismo), donde se encuentra el proyecto guardado

 // Una vez dentro de la aplicación inicial el usuario comienza el juego:

----------------------------------------------------------------------------

      1.1 Inicio de partida: 
      
      Se llama al método initialize nada más comenzar el juego que se encarga de elegir una palabra al azar de las que contiene el txt del proyecto, y poner los 
      estilos al fondo, con la palabra ya elegida por la APP y este método iniciado, el usuario puede comenzar a jugar.

      1.2 Continuación del juego: 
      
      El juego consiste en la lógica del Wordle de toda la vida, una palabra a ser adivinada, en la que el usuario 
      tiene 5 casillas y 5 filas para ir probando una letra en cada casilla. Si una letra es correcta, se pondrá de color verde, si está en la palabra,
      no en ese sitio exacto, de color amarillo, y si no está en la palabra, se marcará de color gris. Una vez introducidas las letras, el usuario puede
      borrar, ya que puede haber missclickeado alguna letra seleccionando las casillas, o enviar la palabra que será comprobada con la lógica ya dicha 
      anteriormente del programa, los métodos que controla toda esta lógica es el método comprobarPalabra, añadirLetra y borrarLetra

      1.3 Fin de la partida (Victoria/Derrota):

          Caso Victoria: En el caso de que el jugador acierte la palabra, independientermente del intento, el programa desmarcará las casillas del programa,
          ya que al haber adivinado y acertado la palabra, es ilógico introducirla más veces, también se mostrará el icono de Victoria gracias al componente
          añadido al programa, y saldrán los botones de "Volver al menú" o "Reiniciar Partida", si el usuario desea jugar de nuevo, o por lo contrario dejar de jugar.


          Caso Derrota: En el caso de que el jugador no acierte, gastando todos sus intentos, se mostará el icono de derrota, y también saldrán los botones de reinicio
          o salir ya detallados antes, ya que no ha estado fino en este intento, deberá tener más cuidado para la próxima vez e intentar afinar su instinto.

          

      

      



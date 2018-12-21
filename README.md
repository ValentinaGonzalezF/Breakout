# BreakOut
## Descripción 
Breakout es un juego de arcade que consiste en utilizar una barra horizontal y una bola que
rebota en las paredes de la pantalla, para golpear Bricks posicionados en la parte superior de la
pantalla. Cada vez que la bola choca con un Brick, esta rebota y puede destruirlo, atribuyendo un
puntaje al jugador acorde a la dificultad de destruir dicho Brick. Si la bola toca la parte inferior
de la pantalla, esta se considera una bola perdida y el jugador pierde una vida. El empezar el juego,  las vidas son 3.
Existen 3 tipos de Bricks inicialmente, los cuales son Wooden, Glass y Metal.

## Logica
En esta tarea se implementó la lógica del juego Breakout. En este juego hay primero Bricks, los cuales pueden ser de tres tipos Wooden,Glass o Metal, por lo que se optó por implementar una interfaz llamada Brick que tuviera todos los métodos comunes entre estos tipo de Bricks. Posteriormente, se creó una clase abstracta Brick la cual sería el padre de las clases WoodenBrick, MetalBrick y GlassBrick. A esta clase padre se le implementó la interfaz y a las Clases MetalBrick, GlassBrick y WoodenBrick, que son una extensión de la clase AbstractBrick. 

Luego estan los niveles, en el cual ya se tenia la interfaz Level, por lo que se decidió implementar una clase AbstractLevel que implementaba esta interfaz para implementar los métodos pedidos. Luego, habian dos tipos de niveles, los normales y los que son null, ya que en enunciado se especifica que el juego parte con un nivel vacio, por lo que se optó crear la clase NullLevel basandose en el Null Object Pattern que permite trabajar de forma más facil los objetos nulos. Al tener esas subclases de AbstractLevel, las que son ClassLevel y NullLevel, se tuvo que especificar algunos métodos, ya que NullLevel debe tener métodos que comparte con los otros pero que difieren en el valor que entrega.

Luego, se encontrada la clase Facade que usaba los métodos de la clase Game, por lo que en cada método de Facade se llamó al mismo método pero de la clase Game. En Game estaba toda la lógica de juego.

Como el juego consiste en crear niveles que contienen cada uno una lista de Bricks que es diferente y en cada nivel se destruyen los bricks opté por implementar el Observer Pattern y el Visitor Pattern. En donde los brick serian observados y visitados por el nivel, el nivel seria observado por el Game.

Cuando se crea un nivel, todos los brick que se crean y que estarán en la lista de brick del nivel, se les agrega el observador level, que será el mismo nivel al que pertenecen los ladrillos. Luego como el nivel es el observador verá cuando los bricks se destruyen. Si un brick se destruye, es decir, cuando el hitPoints llegé a 0, se mandará un notify a los observadores del Brick (level). Luego el nivel al recibir la notificación,este hará un update en donde verificará si el que le mando la notificacion fue un Brick, luego llamara a brick.accept, lo que es que acepte la solicitud de mandar un visitor al brick. Luego el visitor sumará el puntaje de ese brick a los puntos actuales del nivel para luego mandar un notify a los observadores que tiene el nivel, es decir, le avisa a la clase Game, ya que game empieza con un nivel y luego va cambiando de nivel, por lo que cada nivel que tenga Game será observado por este mismo. Cuando el nivel de avise a Game, este haŕá un update en donde verificara si le notifico un level y verá en los atributos de game si el ultimo que se destruyo fue un metalBrick, si fue así, agregará una pelota al juego. Luego verá si los puntos del nivel son iguales a los puntos que se pueden obtener, si es así, se pasa de nivel. Siendo a grandes rasgos la implementación del juego.



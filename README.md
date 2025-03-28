# ParcialAREP2

## Implementación del round robbin

![img.png](img/img.png)

Genera internamente una solicitud get a mathservice que se corre en otro puerto, subiendo a aws se usa con los dominios y un currentLog

## Implementación de MathService

![img_1.png](img/img_1.png)

corre por el puerto 35000

## Implementación del ProxyServer

![img_2.png](img/img_2.png)

corre por el puerto 8585, llama al roudRobbin para que gestione la maquina donde se correrá el servicio de MathService
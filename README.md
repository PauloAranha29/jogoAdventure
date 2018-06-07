jogoAdventure


Programa��o Orientada a Objetos
Professores: Bernardo Copstein 

Trabalho Final 2018/1

T�tulo: 
Cria��o de um jogo tipo �Adventure�

Objetivos:
Desenvolver um jogo tipo �Adventure� a partir de um conjunto de classes fornecido pelo professor.
Explorar os conceitos de programa��o orientada a objetos desenvolvidos ao longo do semestre com destaque para o desenvolvimento de aplica��es por deriva��o a partir de um framework.
Trabalhar os conceitos de reuso por heran�a, polimorfismo e explorar o uso da APIs de cole��es dispon�veis na linguagem Java conjuntamente com fun��es lambda.

Contextualiza��o:
Um jogo de �Adventure� � um jogo onde o jogador controla um personagem que percorre um labirinto ou mundo imagin�rio buscando desvendar um enigma.
Neste trabalho dever� ser desenvolvido um jogo tipo �Adventure� simplificado. O labirinto ser� constru�do como um conjunto de salas interligadas umas as outras por portas (cada sala pode ter tantas portas quanto necess�rio). 
Cada sala dever� ter uma representa��o visual (imagem) e uma descri��o textual associadas. Toda a vez que o personagem entra em uma sala tanto a imagem como a descri��o textual s�o exibidas. O jogador poder� solicitar uma lista das ferramentas dispon�veis na sala e optar ou n�o por recolher estas ferramentas. Toda ferramenta recolhida � guardada em sua mochila. Tamb�m deve ser poss�vel listar os objetos dispon�veis na sala. Os objetos podem sofrer a��o de certas ferramentas. Cabe ao usu�rio optar por usar ou n�o as ferramentas sobre os objetos. Na medida que as ferramentas s�o usadas sobre os objetos da forma correta os objetos pode se modificar ou novos objetos e ferramentas podem surgir de maneira a ajudar o personagem a descobrir o mist�rio. 
O jogador atrav�s de seu personagem permanece percorrendo as diferentes salas do jogo at� descobrir a solu��o do mist�rio. S� ent�o o jogo acaba.

Classes disponibilizadas
Para o desenvolvimento deste trabalho � disponibilizado um projeto �Eclipse� com dois conjuntos de classes: um conjunto de classes b�sicas a partir das quais deve ser derivado o jogo que ser� desenvolvido. A qualidade da modelagem a partir destas classes b�sicas ser� considerada na avalia��o do trabalho. O segundo conjunto de classes � um exemplo de jogo simples. Esta vers�o simplificada em modo texto serve apenas para oferecer uma ideia inicial de como as classes b�sicas fornecidas podem ser usadas para o desenvolvimento do trabalho.

Requisitos m�nimos
O jogo apresentado dever� ter seu labirinto composto por no m�nimo 5 salas onde devem estar distribu�dos pelo menos 3 objetos e 3 ferramentas diferentes. Todas as salas, objetos e ferramentas devem ter de ser usados em algum momento de maneira a levar a conclus�o da hist�ria. Os objetos e salas do exemplo fornecido pelo professor n�o podem ser reusados (apenas as classes b�sicas que s�o obrigat�rias).

A interface com o usu�rio dever� ser gr�fica sendo desenvolvida em JavaFX. Para cada sala do labirinto deve existir, pelo menos, uma representa��o visual.

Deve ser poss�vel interromper o jogo a qualquer tempo e restaurar seu estado mais tarde. Um arquivo texto deve ser usado para tanto.

A criatividade da hist�ria, a qualidade da interface com o usu�rio, a modelagem das classes/arquitetura do sistema, o uso da API de cole��es e o respeito as boas pr�ticas de programa��o ser�o igualmente avaliados.



Entreg�veis
Diagrama de classes;
C�digo fonte do sistema com instru��es de compila��o, configura��o e execu��o;
Execut�vel do sistema (capaz de executar fora do ambiente de um IDE);
Instru��es de uso do jogo;
Orienta��es sobre como fazer para solucionar o enigma e encerrar o jogo.

Outras Informa��es
O trabalho deve ser feito em grupos de at� 4 alunos ou individualmente at� a data especificada.
Cada aluno ou grupo dever� entregar no Moodle um arquivo zip contendo todos os entreg�veis listados anteriormente. Deve ser feito o upload deste arquivo na tarefa indicada para isto no Moodle at� a data e hor�rio especificados.
Os trabalhos dever�o ser apresentados em sala de aula para os demais colegas. A apresenta��o dever� tratar dos seguintes t�picos:
Tema proposto
Desafio a ser vencido (no jogo)
Demonstra��o do jogo
Apresenta��o da arquitetura do sistema, diagrama de classes, estruturas utilizadas
Resumo dos desafios enfrentados para conseguir finalizar o trabalho
Os trabalhos n�o podem apresentar erros de compila��o e as solu��es de cada aluno ou grupo devem ser originais.





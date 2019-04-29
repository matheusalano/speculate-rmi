all:			SpeculateClient.class SpeculateServer.class \
			SpeculateImpl.class SpeculateInterface.class

Jogador.class:		Jogador.java
			@javac Jogador.java

Tabuleiro.class:	Tabuleiro.java
			@javac Tabuleiro.java

Speculate.class:	Speculate.java Jogador.class Tabuleiro.class
			@javac Speculate.java

SpeculateInterface.class:	SpeculateInterface.java
				@javac SpeculateInterface.java

SpeculateImpl.class:	SpeculateImpl.java SpeculateInterface.class Speculate.class
			@javac SpeculateImpl.java

SpeculateClient.class:	SpeculateClient.java
			@javac SpeculateClient.java

SpeculateServer.class:	SpeculateServer.java
			@javac SpeculateServer.java

run-client:		all
			@java SpeculateClient

run-server:		all
			@java SpeculateServer

clean:
			@rm -f *.class *~

info:
			@echo "(c) Matheus Alano (29 abr. 2019)"


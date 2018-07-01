/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adventure.src.adventure;

import Adventure.src.adventure.ClassesBasicas.Mochila;
import Adventure.src.adventure.ClassesBasicas.Sala;
import Adventure.src.adventure.Salas.SalaIntermediaria;
import Adventure.src.adventure.Salas.Subsolo;
import adventure.Salas.HallEntrada;
import adventure.Salas.MesaninoHolografico;
import adventure.Salas.SalaDireita;
import adventure.Salas.SalaEsquerda;

import java.util.Scanner;

public class Engine {
    private Scanner in;
    private Sala salaIncial;
    private Mochila mochila;
    private Sala salaCorrente;
    private boolean fim;

    public Engine(){
        in = new Scanner(System.in);
        mochila = new Mochila();
        criaLabirinto();
        salaIncial.entra(mochila);
        salaCorrente = salaIncial;
        fim = false;
    }
    public void criaLabirinto(){
        Sala hallEntrada = new HallEntrada();
        Sala mesaninoHolografico = new MesaninoHolografico();
        Sala salaDireita = new SalaDireita();
        Sala salaEsquerda = new SalaEsquerda();
        Sala salaIntermediaria = new SalaIntermediaria();
        Sala subsolo = new Subsolo();

        //portas pro hall de entrada
        hallEntrada.getPortas().put(salaDireita.getNome(), salaDireita);
        hallEntrada.getPortas().put(salaEsquerda.getNome(), salaEsquerda);
        // portas pra salaDireita
        salaDireita.getPortas().put(subsolo.getNome(), subsolo);
        salaDireita.getPortas().put(hallEntrada.getNome(), hallEntrada);
        // portas pra salaEsquerda

        // portas pro MesaninoHolografico
        mesaninoHolografico.getPortas().put(hallEntrada.getNome(), hallEntrada);
        // portas pra salaIntermediaria
        salaIntermediaria.getPortas().put(subsolo.getNome(), subsolo);
        salaIntermediaria.getPortas().put(mesaninoHolografico.getNome(), mesaninoHolografico);
        //portas pro Subsolo
        subsolo.getPortas().put(salaIntermediaria.getNome(), salaIntermediaria);
    }
}

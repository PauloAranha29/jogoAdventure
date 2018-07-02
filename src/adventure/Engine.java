/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

import adventure.ClassesBasicas.Mochila;
import adventure.ClassesBasicas.Sala;
import adventure.Salas.SalaEsquerda;
import adventure.Salas.SalaIntermediaria;
import adventure.Salas.Subsolo;
import adventure.Salas.HallEntrada;
import adventure.Salas.MesaninoHolografico;
import adventure.Salas.SalaDireita;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.Scanner;

public class Engine {
    private App janP;
    private Scanner in;
    private Sala salaIncial;
    private Mochila mochila;
    private Sala salaCorrente;
    private boolean fim;

    public Engine(App jp){
        janP = jp;
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

        /////// TESTE
        //hallEntrada.getPortas().put(mesaninoHolografico.getNome(), mesaninoHolografico);
        /////////////////

        // portas pra salaEsquerda
        salaEsquerda.getPortas().put(hallEntrada.getNome(), hallEntrada);

        // portas pra salaDireita
        salaDireita.getPortas().put(hallEntrada.getNome(), hallEntrada);
        salaDireita.getPortas().put(subsolo.getNome(), subsolo);

        //portas pro Subsolo
        subsolo.getPortas().put(salaIntermediaria.getNome(), salaIntermediaria);
        subsolo.getPortas().put(salaDireita.getNome(), salaDireita);

        // portas pra salaIntermediaria
        salaIntermediaria.getPortas().put(subsolo.getNome(), subsolo);
        salaIntermediaria.getPortas().put(mesaninoHolografico.getNome(), mesaninoHolografico);

        // portas pro MesaninoHolografico
        mesaninoHolografico.getPortas().put(hallEntrada.getNome(), hallEntrada);
        mesaninoHolografico.getPortas().put(salaIntermediaria.getNome(), salaIntermediaria);

        salaIncial = hallEntrada;
    }

    public void joga(String acao){
        if (fim) {
            //fimDeJogo();
            return;
        }
            String[] tokens = acao.split(" ");
            switch (tokens[0]) {
                case "fim":
                    fim = true;
                    break;
                case "pega":
                    if (salaCorrente.pega(tokens[1])) {
                        janP.exibeTexto("\nOk! " + tokens[1] + " na mochila!\n");
                    } else {
                        janP.exibeTexto("\nObjeto " + tokens[1] + " não encontrado.\n");
                    }
                    break;
                case "DigitaSenha":
                    salaCorrente.DigitaSenha(Integer.parseInt(tokens[1]));
                    janP.exibeTexto("\n"+salaCorrente.textoDescricao()+"\n");
                    janP.setImagem(Integer.parseInt(salaCorrente.getRepVisual()));

                    break;
                case "DigitaOpcao":
                    salaCorrente.DigitaOpcao(Integer.parseInt(tokens[1]));
                    janP.exibeTexto("\n"+salaCorrente.textoDescricao()+"\n");
                    janP.setImagem(Integer.parseInt(salaCorrente.getRepVisual()));

                    break;
                case "inventario":
                    janP.exibeTexto("\nConteudo da mochila: " + mochila.inventario()+"\n");
                    break;
                case "usa":
                    try {
                        if (salaCorrente.usa(tokens[1])) {
                            janP.exibeTexto("\nFeito !!");
                        } else {
                            janP.exibeTexto("\nNão é possível usar " + tokens[1] + " nesta sala");
                        }
                    } catch (FimDeJogoException e) {
                        fim = true;
                        fimDeJogo();
                    }
                    janP.exibeTexto("\n"+salaCorrente.textoDescricao()+"\n");
                    janP.setImagem(Integer.parseInt(salaCorrente.getRepVisual()));
                    break;
                case "sai":
                    Sala novaSala = salaCorrente.sai(tokens[1]);
                    if (novaSala == null) {
                        janP.exibeTexto("\nSala desconhecida ...\n");
                    } else {
                        novaSala.entra(mochila);
                        salaCorrente = novaSala;
                        janP.exibeTexto("\n"+salaCorrente.textoDescricao()+"\n");
                        janP.setImagem(Integer.parseInt(salaCorrente.getRepVisual()));
                    }
                    break;
                case "start":
                    janP.exibeTexto("\n"+salaCorrente.textoDescricao()+"\n");
                    janP.setImagem(Integer.parseInt(salaCorrente.getRepVisual()));
                    break;
                default:
                    janP.exibeTexto("\nComando desconhecido: " + tokens[0]);
                    break;
            }

    }
    private void fimDeJogo() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Fim de jogo !!");
        alert.setHeaderText("Parabéns !!");
        alert.setContentText("Você conseguiu abrir o cofre !!\nFIM DE JOGO");
        alert.showAndWait();
    }
}

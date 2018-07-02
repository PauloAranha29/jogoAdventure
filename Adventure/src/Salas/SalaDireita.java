/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Salas;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Sala;
import Ferramentas.JogoChaves;
import Ferramentas.Lanterna;
import ObjetosCriados.ChaoMovel;

/**
 *
 * @author Henrique
 */
public class SalaDireita extends Sala {

    private static Boolean portaAberta;

    public SalaDireita() {
        super("SalaDireita");
        portaAberta = false;
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Voce esta no ").append(this.getNome()).append("\n");
        descricao.append("você se encontra em uma sala bem iluminada, porém completamente vazia.\n");
        descricao.append(" No chão há uma espécie de controle com uma grande botão vermelho escrito\n");
        descricao.append("“Não aperte” no centro que parece estar quebrado...\n");
        descricao.append("O que você faz?\n");
        descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
        descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
        descricao.append("Portas: ").append(this.portasDisponiveis().toString()).append("\n");
        return descricao.toString();

    }

    @Override
    public boolean pega(String nomeFerramenta) {
        boolean ok = super.pega(nomeFerramenta);
        if (ok) {
            this.getFerramentas().remove(nomeFerramenta);
            return true;
        }
        return false;
    }

    @Override
    public boolean usa(String ferramenta) {
        Ferramenta f = this.getMochila().usar(ferramenta);
        if (f == null || !(f instanceof JogoChaves)) {
            return false;
        }
        if (f instanceof JogoChaves) {
            portaAberta = true;
            return true;
        } else {
            return false;
        }
    }

    public static boolean proximaSala() {

        return portaAberta;

    }

}

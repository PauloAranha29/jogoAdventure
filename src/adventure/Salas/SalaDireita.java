/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure.Salas;

import adventure.ClassesBasicas.Ferramenta;
import adventure.ClassesBasicas.Sala;
import adventure.Ferramentas.JogoChaves;
import adventure.ObjetosCriados.ChaoMovel;

/**
 *
 * @author Henrique
 */
public class SalaDireita extends Sala {

    public SalaDireita() {
        super("SalaDireita","1");
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Voce esta no ").append(this.getNome()).append("\n");
        descricao.append("você se encontra em uma sala bem iluminada, porém completamente vazia.\n");
        descricao.append(" No chão há uma espécie de controle com uma grande botão vermelho escrito\n");
        descricao.append("“Não aperte, sua besta” no centro que parece estar quebrado...\n");
        descricao.append("O que você faz?\n");
        descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
        descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
        descricao.append("Portas: ").append(this.portasDisponiveis().toString()).append("\n");
        return descricao.toString();
    }

    @Override
    public boolean DigitaSenha(Integer senha) {
        return false;
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
        ChaoMovel cm = (ChaoMovel) this.getObjetos().get("Chão Aberto");
        cm.usar(f);
        return true; // E nosso herói cai no subsolo...
    }

}

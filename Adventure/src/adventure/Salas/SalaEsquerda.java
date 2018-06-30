/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure.Salas;

import Adventure.src.adventure.ClassesBasicas.Ferramenta;
import Adventure.src.adventure.ClassesBasicas.Sala;
import Adventure.src.adventure.Ferramentas.JogoChaves;
import Adventure.src.adventure.Ferramentas.Lanterna;

/**
 *
 * @author Henrique
 */
public class SalaEsquerda extends Sala {

    private boolean escuro;
    private boolean cont = false;
    private int cont2 = 0;

    public SalaEsquerda() {
        super("SalaEsquerda");
        escuro = true;
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Voce esta na ").append(this.getNome()).append("\n");
        if (escuro) {
            descricao.append("Esta escuro aqui e você não consegue ver nada");

        } else if (!escuro) {
            descricao.append("você verifica um teclado numérico, e uma porta mais a frente.\n");
            descricao.append("Não há nada que você possa fazer aqui.\n");
            descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
            descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");

        } else if (cont == true && cont2 == 1);
        {
            descricao.append("Você então apaga sua lanterna e caminha para a saída, tropeçando em\n");
            descricao.append("um JogoChaves! Mais sorte do que juízo... \n");
            JogoChaves jogoChaves = new JogoChaves();
            this.getFerramentas().put(jogoChaves.getDescricao(), jogoChaves);

        }

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
    public boolean usa(String ferramenta) { // pode usar somente a lanterna
        Ferramenta f = this.getMochila().usar(ferramenta);
        if (f == null) {
            return false;
        }
        if (f instanceof Lanterna) {
            escuro = false;
            cont = false;
            return true;
        } else {
            return false;
        }
    }
    // método criado somente para essa classe

    public boolean guarda(String ferramenta) { //guarda lanterna e libera JogoChaves
        Ferramenta f = this.getMochila().usar(ferramenta);
        if (f == null) {
            return false;
        }
        if (f instanceof Lanterna) {
            escuro = true;
            cont = true;
            cont2++;
            return true;
        } else {
            return false;
        }
    }

}

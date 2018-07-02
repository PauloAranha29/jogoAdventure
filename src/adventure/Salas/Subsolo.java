/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure.Salas;

import adventure.ClassesBasicas.Ferramenta;
import adventure.ClassesBasicas.Sala;
import adventure.Ferramentas.BombaNeutrons;
import adventure.Ferramentas.Lanterna;
import adventure.Ferramentas.PistolaLaser;
import adventure.ObjetosCriados.Esqueleto;

/**
 *
 * @author Henrique
 */
public class Subsolo extends Sala {

    private boolean escuro;
    private boolean examinado;
    private boolean esqueletoExplodido;



    public Subsolo() {
        super("Subsolo","4");
        escuro = true;
        examinado = false;
        esqueletoExplodido = false;

        Esqueleto esqueleto = new Esqueleto();
        this.getObjetos().put("Esqueleto", esqueleto);

        BombaNeutrons bombaNeutrons = new BombaNeutrons();
        this.getFerramentas().put(bombaNeutrons.getDescricao(), bombaNeutrons);
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Voce esta no ").append(this.getNome()).append("\n");

        if (escuro) {
            descricao.append("O ambiente está completamente úmido e escuro, ");
            descricao.append("sem a menor possibilidade de enxergar nada. \n");
            
        } else if (!escuro && esqueletoExplodido) {

            descricao.append("Você então usa a arma laser em direção ao esqueleto \n");
            descricao.append("transformando-o em uma pilha de ossos e \n");
            descricao.append("usando para subir e chegar até a janela.\n");


        } else if (!escuro) {
            descricao.append("Você acende sua lanterna e a sala se ilumina, revelando que não há portas,\n");
            descricao.append("porém você nota uma grande janela no alto da sala, que não pode ser alcançada. \n");
            descricao.append("A sua direita você se depara com um esqueleto de um humanóide gigante,\n");
            descricao.append("morto há tempos para sua felicidade.\n");
            descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
            descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
        }

        descricao.append("Portas: ").append(this.portasDisponiveis().toString()).append("\n");
        return descricao.toString();
    }

    @Override
    public boolean usa(String ferramenta) { // pode usar somente a lanterna e pistolaLaser
        Ferramenta f = this.getMochila().usar(ferramenta);
        if (f == null || !(f instanceof Lanterna || f instanceof PistolaLaser)) {
            return false;
        }
        if (f instanceof Lanterna) {
            escuro = false;
            setRepVisual("5");
            return true;
        }
        //libera para nosso heroi passar de sala
        if (f instanceof PistolaLaser && escuro == false) {
            (this.getObjetos().get("Esqueleto")).setAcaoOk(true);
            esqueletoExplodido = true;


        }
        return false;
    }

    //método criado para esta classe
    @Override
    public boolean examina() {
        examinado = true;
        return examinado; // libera a BombaNeutrons
    }

}

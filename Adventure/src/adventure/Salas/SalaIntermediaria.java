/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure.Salas;

import Adventure.src.adventure.ClassesBasicas.Ferramenta;
import Adventure.src.adventure.ClassesBasicas.Sala;
import Adventure.src.adventure.Ferramentas.BombaNeutrons;
import Adventure.src.adventure.Ferramentas.Lanterna;
import Adventure.src.adventure.Ferramentas.PistolaLaser;

import Adventure.src.adventure.ClassesBasicas.Sala;

/**
 *
 * @author Henrique
 */
public class SalaIntermediaria extends Sala {
     private boolean bombaJogada;
     
    public SalaIntermediaria() {
        super("SalaIntermediaria");
        bombaJogada = false;
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Voce esta no ").append(this.getNome()).append("\n");
        descricao.append("É uma sala com grandes computadores, possívelmente \n");
        descricao.append("usado pelos humanóides gigantes.\n");
        descricao.append("Há duas portas, uma a direita e uma a esquerda,\n");
        descricao.append("também de tamanho descomunal.\n");
        descricao.append("O que você faz?");
        
    if(bombaJogada){
        
        descricao.append("Sabendo que a bomba de nêutrons têm a capacidade de\n");
        descricao.append("anular componentes eletrônicos, você retira uma\n");
        descricao.append("pequena cápsula do bolso de cor azul-esverdeada, e \n");
        descricao.append("atira contra o chão. De repente a porta a sua esquerda\n");
        descricao.append("se abre, e um dos gigantes corre em sua direção\n");
        descricao.append("rapidamente, pronunciando palavras que para você são\n");
        descricao.append("são imcompreensíveis. O que você faz?\n");
        descricao.append("\n");
        descricao.append("1 – Saca a pistola laser e atira contra o gigante; \n");
        descricao.append("\n");
        descricao.append("2 – Começa a chorar;\n");
        descricao.append("\n");
        descricao.append("3 - Se abaixa e rola para baixo da mesa;\n");
        
    }  
        
        descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
        descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
        descricao.append("Portas: ").append(this.portasDisponiveis().toString()).append("\n");
        return descricao.toString();
    }

    @Override
    public boolean usa(String ferramenta) { // joga BombaNeutrons
         Ferramenta f = this.getMochila().usar(ferramenta);
         
         if(f == null || !(f instanceof BombaNeutrons))
             
             return false;
         
         if (f instanceof BombaNeutrons) {
            bombaJogada = true;
            return true;
        } else {
            return false;
        }
    }
    
    // classe desenvolvida para esta sala
    public Integer getOpcao(Integer opcao){

       if(opcao == null || opcao < 1 || opcao > 3) 
        {throw new IllegalArgumentException("opção inválida");}  
       if(opcao == 1){return 1;} 
       if(opcao == 2){return 2;}  
       if(opcao == 3){return 3;} 
      return opcao; 
}
       


    }
    
}

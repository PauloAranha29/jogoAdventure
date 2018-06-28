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
import Adventure.src.adventure.Ferramentas.PistolaLaser;
import java.util.Scanner;

/**
 *
 * @author Henrique
 */
public class SalaEsquerda extends Sala {
   private boolean escuro;
   int cont = 0;
    public SalaEsquerda() {
        super("SalaEsquerda");
          escuro = true;
          JogoChaves jogoChaves = new JogoChaves();
	  this.getFerramentas().put(jogoChaves.getDescricao(), jogoChaves);
        
    }

    @Override
    public String textoDescricao() {
        	StringBuilder descricao = new StringBuilder();
		descricao.append("Voce esta na ").append(this.getNome()).append("\n");
		if (escuro) { cont++;
			descricao.append("Esta escuro aqui e você não consegue ver nada");
                        
		}else if(!escuro) {
		    descricao.append("você verifica um teclado numérico, e uma porta mais a frente.\n");
                    descricao.append("Não há nada que você possa fazer aqui.\n");
		    descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
		    descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
                    
		}else if(escuro && cont > 0);{
                 descricao.append("Você então apaga sua lanterna e caminha para a saída, tropeçando em\n");
                descricao.append("Um JogoChaves! Mais sorte do que juízo... \n");}
                
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
        return false;
    }
        Scanner in = new Scanner(System.in);
        
}

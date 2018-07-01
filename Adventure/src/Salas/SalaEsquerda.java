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
import adventure.FimDeJogoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Henrique
 */
public class SalaEsquerda extends Sala {

    private boolean escuro;
    private boolean cont;
    private int cont2;
    Integer senha;

    public SalaEsquerda() {
        super("SalaEsquerda");
        escuro = true;
        cont = false;
        cont2 = 0;
        senha = null;
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Voce esta na ").append(this.getNome()).append("\n");
        if (escuro) {
            descricao.append("Esta escuro aqui e você não consegue ver nada");

        } 
        if (!escuro) {
            descricao.append("você verifica um teclado numérico, e uma porta mais a frente.\n");
            descricao.append("Você pensa em digitar alguns algarismo, para ver\n");
            descricao.append("se consegue destravar a porta a sua frente, entao você lembra\n");
            descricao.append("dos riscos. O que terá atrás daquela porta?\n");
        
        }
        
        if(senha == 1){
            
            descricao.append("Você digita a senha 1234. A porta a sua frente abre \n");
            descricao.append(", e uma silhueta aparece a sua frente.Você não \n");
            descricao.append("consegue identificar devido a forte luz atrás de você, \n");
            descricao.append("mas claramente é uma silhueta feminina. Ela se  \n");
            descricao.append("aproxima de você e lhe abraça, mas neste momento\n");
            descricao.append("você nota algo errado: quarto braços envolvem você, \n");
            descricao.append(" e uma carantonha de um olho só o fita.\n");
            descricao.append(". Você então reconhece a princesa Sebóia, do  \n");
            descricao.append("planeta Pegajosus.Você tenta se livrar dos tentáculos,\n");
            descricao.append(" mas a princesa, na euforia do seu amor e  \n");
            descricao.append("pronunciando palavras de agradecimentos\n");
            descricao.append("que para você são indecifráveis, o abraça cada vez\n");
            descricao.append(" mais forte, por fim sufocando-o até a morte na \n");
            descricao.append("euforia do seu amor.\n");
             try {
                throw new FimDeJogoException();
            } catch (FimDeJogoException ex) {
                System.out.println("Fim de jogo");
            }
        }
        
          if(senha == 2){
              
            descricao.append(" Você digita a senha 5678 e a porta a frente se \n");
            descricao.append("abre, com a princesa Isthar a sua frente. Ela o \n");
            descricao.append("reconhece imediatamente e corre aos seus braços, \n");
            descricao.append("envolvendo-o com o seu corpo pequeno e perfumado, \n");
            descricao.append("fitando-o com os seus lindos olhos verdes, cheios \n");
            descricao.append("de lágrimas. Vocês voltam para nave e decolam para\n");
            descricao.append(" casa, deixando para trás o terrível DalhiNinguemScapus.\n");
               try {
                throw new FimDeJogoException();
            } catch (FimDeJogoException ex) {
                System.out.println("Fim de jogo");
                System.out.println("Vencedores não usam drogas");
            }
        
        }
          
        if(senha == 3){
              
            descricao.append("Você digita a senha, coma esperança de ter a  \n");
            descricao.append("princesa Isthar em seus braços novamente...\n");
            descricao.append("mas algo dá errado! Sirenes começam a tocar, e\n");
            descricao.append("ntes que você consiga reagir, já está cercado por\n");
            descricao.append("quatro enormes gigantes, que rapidamente o\n");
            descricao.append("imobilizam. Você acaa de se tornar mais um\n");
            descricao.append("prisioneiro do terrível...\n");
            descricao.append("\n");
            descricao.append("DalhiNinguemScapus!\n");
            descricao.append("\n");
              try {
                throw new FimDeJogoException();
            } catch (FimDeJogoException ex) {
                System.out.println("Fim de jogo");
            }
           
        }
          
        if (cont == true && cont2 == 1);{
            descricao.append("Você então apaga sua lanterna e caminha para a saída, tropeçando em\n");
            descricao.append("um JogoChaves! Mais sorte do que juízo... \n");
            JogoChaves jogoChaves = new JogoChaves();
            this.getFerramentas().put(jogoChaves.getDescricao(), jogoChaves);

        }
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
    
        // classe desenvolvida para esta sala
    public Integer getSenhaFinal(Integer senha) {
        
        List<Integer> lista = new ArrayList<>();
        lista.add(senha);
        
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("opção inválida");
        }
       
        if (lista.contains(01234)) {
            return this.senha = 1; 
        }
        if (lista.contains(65789)) {
            return this.senha =  2;
        }
        
        else{return this.senha = 3;}
    }
    Scanner in = new Scanner(System.in);

}

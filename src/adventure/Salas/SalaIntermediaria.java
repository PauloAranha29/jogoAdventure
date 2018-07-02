/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure.Salas;

import adventure.ClassesBasicas.Ferramenta;
import adventure.ClassesBasicas.Sala;
import adventure.Ferramentas.BombaNeutrons;
import adventure.FimDeJogoException;
import javafx.scene.control.Alert;

import java.util.Scanner;

/**
 *
 * @author Henrique
 */
public class SalaIntermediaria extends Sala {

    private boolean bombaJogada;
    private Integer opcao2;

    public SalaIntermediaria() {
        super("SalaIntermediaria","6");
        bombaJogada = false;
        opcao2 = 0;
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
        descricao.append("\n\nComandos: [usa ***, sai ***]");

        if (bombaJogada) {

            descricao.append("\n\nSabendo que a bomba de nêutrons têm a capacidade de\n");
            descricao.append("anular componentes eletrônicos, você retira uma\n");
            descricao.append("pequena cápsula do bolso de cor azul-esverdeada, e \n");
            descricao.append("atira contra o chão. De repente a porta a sua esquerda\n");
            descricao.append("se abre, e um dos gigantes corre em sua direção\n");
            descricao.append("rapidamente, pronunciando palavras que para você são\n");
            descricao.append("são incompreensíveis. O que você faz?\n");
            descricao.append("\n");
            descricao.append("1 – Saca a pistola laser e atira contra o gigante; \n");
            descricao.append("\n");
            descricao.append("2 – Começa a chorar;\n");
            descricao.append("\n");
            descricao.append("3 - Se abaixa e rola para baixo da mesa;\n");
            descricao.append("\nComandos: [DigitaOpcao ***, sai ***]");

        }

        if (opcao2 == 1) {

            setRepVisual("15");
            fimDeJogo();
            descricao.append("\n\nVocê, rápido como um raio e feroz como um dragão de Draxila,\n");
            descricao.append("saca sua pistola fazendo um rombo no corpo do gigante\n");
            descricao.append("que tomba morto ao seu lado. Porém, como sua pistola estava\n");
            descricao.append("ajustada para a carga máxima,também faz um rombo nas paredes\n");
            descricao.append("da sala, fazendo entrar um gás tóxico pela abertura.No mesmo\n");
            descricao.append("instante seu corpo começa a ficar trêmulo, sua visão embaçada\n");
            descricao.append("e você cai ao chão. Instantes antes de morrer, seus pensamentos\n");
            descricao.append("giram em torno da princesa Isthar, de vocês casando e tendo filhos\n");
            descricao.append("com a bênção do rei. Em seguida você se vê trocando as fraldas dos\n");
            descricao.append("seus cinco filhos, as contas chegando e a princesa reclamando que você\n");
            descricao.append("não limpou os sapatos antes de entrar em casa, que você está fedendo\n");
            descricao.append("a cerveja Weissfuder, que é um inútil, etc, etc, etc. Então você morre,\n");
            descricao.append("feliz por ter escapado de semelhante destino.");
            try {
                throw new FimDeJogoException();
            } catch (FimDeJogoException ex) {
                System.out.println("Fim de jogo");
            }
        }

        if (opcao2 == 2) {
            setRepVisual("16");
            fimDeJogo();
            descricao.append("\n\nVocê começa a chorar e o seu medo faz com que você \n");
            descricao.append("urine nas calças.Infelizmente o gigante não se comove \n");
            descricao.append("com a sua reação,, pegando você pelo pescoço e o  \n");
            descricao.append("examinando de cima a baixo. Em seguida ele o  \n");
            descricao.append("estrangula lentamente, até você perder a consciência e \n");
            descricao.append("morrer. Tsc,tsc,tsc, esperava um fim mais heróico para um capitão estelar!\n");
            descricao.append("um capitão estelar!");
            try {
                throw new FimDeJogoException();
            } catch (FimDeJogoException ex) {
                System.out.println("Fim de jogo");
            }
        }

        if (opcao2 == 3) {
            setRepVisual("17");
            descricao.append("Você se abaixa e rapidamente rola para baixo de um \n");
            descricao.append("dos computadores laterais.\n");
            descricao.append("Seu movimento é tão rápido que o gigante tropeça em  \n");
            descricao.append("seus próprios pés");
            descricao.append("pés e cai violentamente, batendo a cabeça a porta a da \n");
            descricao.append("direita, abrindo-a.\n");
            descricao.append("\nObjetos: ").append(this.objetosDisponiveis().toString()).append("\n");
            descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
            descricao.append("Portas: ").append(this.portasDisponiveis().toString()).append("\n");
        }
        // e assim nosso herói pode passar para o mesanino holográfico

        return descricao.toString();
    }

    @Override
    public boolean DigitaSenha(Integer senha) {
        return false;
    }
    @Override
    public boolean DigitaOpcao(Integer opcao) {
        opcao2 = opcao;
        return true;
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
    public boolean usa(String ferramenta) { // joga BombaNeutrons
        Ferramenta f = this.getMochila().usar(ferramenta);

        if (f == null || !(f instanceof BombaNeutrons)) {
            return false;
        }

        if (f instanceof BombaNeutrons) {
            bombaJogada = true;
            setRepVisual("14");
            return true;
        } else {
            return false;
        }
    }
    private void fimDeJogo() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fim de jogo !!");
        alert.setHeaderText("Sniff, sniff");
        alert.setContentText("Infelizmente, você não foi sábio nas escolhas !!\nFIM DE JOGO");
        alert.showAndWait();
    }

    Scanner in = new Scanner(System.in);
}

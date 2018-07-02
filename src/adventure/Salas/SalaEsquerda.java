/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure.Salas;
import adventure.ClassesBasicas.Ferramenta;
import adventure.ClassesBasicas.Sala;
import adventure.Ferramentas.JogoChaves;
import adventure.Ferramentas.Lanterna;
import adventure.Ferramentas.PistolaLaser;
import javafx.scene.control.Alert;

import static adventure.Salas.SalaEsquerda.senha2;
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
    static Integer senha2;

    public SalaEsquerda() {
        super("SalaEsquerda","2");
        escuro = true;
        senha2 = 0;
        JogoChaves jogoChaves = new JogoChaves();
        this.getFerramentas().put(jogoChaves.getDescricao(), jogoChaves);
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Voce esta na ").append(this.getNome()).append("\n");
        if (escuro) {
            descricao.append("Esta escuro aqui e você não consegue ver nada\n");

        }

        else if (!escuro && senha2 == 2) {
            fimDeJogo();

            descricao.append("\nVocê digita a senha 1234. A porta a sua frente abre \n");
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
            // throw new FimDeJogoException();
        }

        else if (!escuro && senha2 == 1) {
            fimDeJogo();

            descricao.append("\nVocê digita a senha 5678 e a porta a frente se \n");
            descricao.append("abre, com a princesa Isthar a sua frente. Ela o \n");
            descricao.append("reconhece imediatamente e corre aos seus braços, \n");
            descricao.append("envolvendo-o com o seu corpo pequeno e perfumado, \n");
            descricao.append("fitando-o com os seus lindos olhos verdes, cheios \n");
            descricao.append("de lágrimas. Vocês voltam para nave e decolam para\n");
            descricao.append(" casa, deixando para trás o terrível DalhiNinguemScapus.\n");
            //  throw new FimDeJogoException();
        }

        else if (!escuro && senha2 == 3) {
            fimDeJogo();

            descricao.append("\nVocê digita a senha, com a esperança de ter a  \n");
            descricao.append("princesa Isthar em seus braços novamente...\n");
            descricao.append("mas algo dá errado! Sirenes começam a tocar, e\n");
            descricao.append("antes que você consiga reagir, já está cercado por\n");
            descricao.append("quatro enormes gigantes, que rapidamente o\n");
            descricao.append("imobilizam. Você acaba de se tornar mais um\n");
            descricao.append("prisioneiro do terrível...\n");
            descricao.append("\n");
            descricao.append("DalhiNinguemScapus!\n");
            descricao.append("\n");
            // throw new FimDeJogoException();

        }else if (!escuro) {
            descricao.append("\nVocê verifica um teclado numérico, e uma porta mais a frente.\n");
            descricao.append("Você pensa em digitar alguns algarismo, para ver\n");
            descricao.append("se consegue destravar a porta a sua frente, entao você lembra\n");
            descricao.append("dos riscos. O que terá atrás daquela porta?\n");
            descricao.append("Você também acha um JogoChaves! Mais sorte do que juízo... \n");
            descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
            descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
            descricao.append("Portas: ").append(this.portasDisponiveis().toString()).append("\n");
            descricao.append("Comandos: [DigitaSenha ***, pega ***, sai ***]");

        }


        return descricao.toString();
    }

    @Override
    public boolean DigitaSenha(Integer senha) {
        if(senha == 1234) {
            senha2 = 2;
            setRepVisual("11");
            //fimDeJogo();
        }
        else if (senha == 5678){

            setRepVisual("9");
            senha2 = 1;
        }
        else {
            senha2 = 3;
            setRepVisual("10");
            //senhaErrada();

        }
        return true;

    }
    private void fimDeJogo() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fim de jogo !!");
        alert.setHeaderText("Fim de Jogo");
        alert.setContentText("Você chegou ao final do jogo!");
        alert.showAndWait();
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
            setRepVisual("3");
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
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Sala sai(String sala) {
        Sala aux = super.sai(sala);
        if (aux != null) {
            escuro = true;
            setRepVisual("2");
        }
        return aux;
    }

    Scanner in = new Scanner(System.in);

}
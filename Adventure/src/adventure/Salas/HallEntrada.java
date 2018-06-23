/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adventure.src.adventure.Salas;

import Adventure.src.adventure.ClassesBasicas.Sala;
import Adventure.src.adventure.Ferramentas.Lanterna;
import Adventure.src.adventure.Ferramentas.PistolaLaser;

import java.util.Scanner;

/**
 *
 * @author Henrique
 */
public class HallEntrada extends Sala {


    public HallEntrada() {
        super("HallEntrada");
        Lanterna lanterna = new Lanterna();
        PistolaLaser pistolaLaser = new PistolaLaser();
        this.getFerramentas().put(lanterna.getDescricao(),lanterna);
        this.getFerramentas().put(pistolaLaser.getDescricao(),pistolaLaser);
    }
    @Override
    public String textoDescricao(){
        StringBuilder descricao = new StringBuilder();
        descricao.append("Você, capitão mor da guarda real do planeta LongisPraKarambis, foi escolhido por suas\n " +
                "habilidades especiais e destacada inteligência para o resgate da princesa Isthar, que foi raptada pelo\n" +
                " vilão Malus, o Terrível. Após semanas de investigações, seus homens descobrem\n " +
                "que a princesa está presa no asteroide principal do quadrante sul da galáxia,\n " +
                "o temível DalhiNinguemScapus. Poderá você resgatar a princesa desta terrível armadilha?\n\n"+
                "Você finalmente chega ao DalhiNinguemScapus, que seria um asteróide como qualquer outro se não se\n " +
                "destacasse pelo tamanho e por sua aparência sinistra, parecendo formar a face de uma caveira\n " +
                "em um dos lados. Você pousa sua nave pelo lado norte, sabendo que ali se encontra uma estreita\n" +
                " passagem para a sala principal. Munido apenas de sua pistola laser,\n " +
                "uma lanterna e muita coragem, você abre a cabine de sua nave e se encontra em frente a duas portas\n, " +
                "uma a direita e outra a esquerda. O que você faz?");
        return  descricao.toString();
    }

    @Override
    public boolean usa(String ferramenta) {
        return false;
    }
    Scanner in = new Scanner(System.in);
    
@Override
    public Sala sai (String sala){
        Sala aux = super.sai(sala);

    }
}

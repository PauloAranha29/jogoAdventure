/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure.ObjetosCriados;

import Adventure.src.adventure.ClassesBasicas.Ferramenta;
import Adventure.src.adventure.ClassesBasicas.Objeto;
import Adventure.src.adventure.Ferramentas.JogoChaves;

/**
 *
 * @author Henrique
 */
public class DisplayGigante extends Objeto {

    public DisplayGigante(String descricaoAntesAcao, String descricaoDepoisAcao) {
        super("Display apagado", "123456");
    }

    @Override
    public boolean usar(Ferramenta f) {
        if (f instanceof JogoChaves) {
            System.out.println("Usou " + f.getDescricao());
            this.setAcaoOk(true);
            return true;
        }
        return false;
    }

}

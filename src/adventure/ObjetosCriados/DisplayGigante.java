/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure.ObjetosCriados;

import adventure.ClassesBasicas.Ferramenta;
import adventure.ClassesBasicas.Objeto;
import adventure.Ferramentas.JogoChaves;

/**
 *
 * @author Henrique
 */
public class DisplayGigante extends Objeto {

    public DisplayGigante() {
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

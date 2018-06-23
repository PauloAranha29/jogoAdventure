/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adventure.src.adventure.Salas;

import Adventure.src.adventure.ClassesBasicas.Sala;

/**
 *
 * @author Henrique
 */
public class SalaDireita extends Sala {

    public SalaDireita() {
        super("SalaDireita");
    }

    @Override
    public String textoDescricao() {
        return null;
    }

    @Override
    public boolean usa(String ferramenta) {
        return false;
    }
}

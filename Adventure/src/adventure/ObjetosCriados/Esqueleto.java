/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure.ObjetosCriados;

import Adventure.src.adventure.ClassesBasicas.Ferramenta;
import Adventure.src.adventure.ClassesBasicas.Objeto;
import Adventure.src.adventure.Ferramentas.PistolaLaser;

/**
 *
 * @author Henrique
 */
public class Esqueleto extends Objeto {

    public Esqueleto() {
		super("Esqueleto caído","Monte de ossos");
	}
    
     @Override
    public boolean usar(Ferramenta f) {
        if (f instanceof PistolaLaser) {
			System.out.println("Usou "+f.getDescricao());
			this.setAcaoOk(true);
			return true;
		}
		return false;
    }
    
}

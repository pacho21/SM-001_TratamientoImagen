/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.pkg001;

import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;

/**
 *
 * @author Pacho
 */
public class Imagen extends BufferedImage{

    public Imagen(BufferedImage i) {
        super(i.getWidth(),i.getHeight(),i.getType());
        setData(i.getData());
    }
    
   
    
    /*Aqui en esta clase es donde codificaremos nuestras caracteristicas de calcular los RGB!!
    */
   
    
}

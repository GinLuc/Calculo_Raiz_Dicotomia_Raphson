/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.ArrayList;

/**
 *
 * @author GianL and FelipeSdS
 */


//Essa classe é responsável pela verificação da entrada dos valores corretos no programa
public class Verificacao {
    
    //
    public ArrayList<Double> VerificaNegativo(double valor, double exp) {
        ArrayList<Double> v = new ArrayList<Double>();
        
        if (valor < 0 ) {
            v.add(0, valor * 2);
            v.add(1, exp * 2);
        }
        else {
            v.add(0, valor);
            v.add(1, 1/exp);
        }
        
        return v;
    }
    
    
    
}

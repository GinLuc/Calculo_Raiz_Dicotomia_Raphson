/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author Mário Alvial(http://blog.alura.com.br/author/mario-alvial/)
 */
public class Formatacao {

   public static String ArredondaValor(double valor) {
    DecimalFormat df = new DecimalFormat("0.00");
    df.setRoundingMode(RoundingMode.HALF_UP);
    return df.format(valor);
   }
   
}

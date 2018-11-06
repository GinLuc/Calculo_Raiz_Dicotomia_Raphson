/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import static java.lang.Math.pow;
import java.util.ArrayList;

/**
 *
 * @author GianL and FelipeSdS
 */


//Essa classe é responsável pela verificação da entrada dos valores corretos no programa
public class Verificacao {
    
    // Método de Verificação de valor Negativo, aonde ele tem como entrada o valor a ser analisado 
    //e o expoente que será passado nos cálculos futuros  
    public ArrayList<Double> VerificaNegativo(double valor, double exp) {
        ArrayList<Double> v = new ArrayList<Double>(); //ArrayList do tipo Double criada para armazenar o novo valor e o expoente
        
        // Se o valor for negativo, usaremos ele ao quadrado, juntamente com o dobro do inverso do expoente, pois assim, conseguimos converter
        //o valor negativo, sendo ele ao quadrado, para positivo e, sendo o expoente par, elevando-o à 1/4, no caso da raíz quadrada, consegue-se o mesmo
        //resultado que o equivalente 
        if (valor<0 && exp % 2==0) { 
            v.add(0, pow(valor, 2)); //Caso o valor seja negativo, deve-se adicionar na primeira posição do ArrayList o valor elevado ao quadrado
            v.add(1, 1/(exp * 2)); //No caso de o valor seja negativo, deve-se adicionar na segunda posição do ArrayList o dobro do valor do expoente 
        }
        else {
            v.add(0, valor); //Caso o valor seja positivo, deve-se adicionar na primeira posição do ArrayList seu valor ìntegro
            v.add(1, 1/exp); //Caso o valor seja positivo, deve-se adicionar na primeira posição do ArrayList seu expoente inverso, pois este será usado para raíz
        }
        
        return v;
    }

}

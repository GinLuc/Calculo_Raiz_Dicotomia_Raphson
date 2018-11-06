/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Util.*;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GianL and FelipeSdS
 */

public class NewtonRaphson {
    private static double xi;       //Variável do Valor Inicial, ou Xi
    private static double fxi;     //Cariável da Função de Xi 
    private static double fdxi;    //Variável da Derivada de Xi
    private static double xf;      //Variável que representa o X a ser substituído no Xi na próxima interação
    private static double modulo;   //Variável que representa o Módulo(|Xf - Xi|)
    private static int interacao;   //Varável que representa o número de interações, descartando a interação com o valor de entrada

    Verificacao ver = new Verificacao();
    
    public static ArrayList<Double> val_exp = new ArrayList<Double>();
    
    
    
//Construtor: Aqui ocorre a entrada dos valores necessários para serem usados nos cálculos
    public NewtonRaphson (double xi, int interacao) {
        val_exp = ver.VerificaNegativo(xi, 2);
        setXi(val_exp.get(0));      //permite a entrada do valor Xi
        setFxi(val_exp.get(0), val_exp.get(1));     //Permite a entrada do valor Xi para ser usado no Fxi
        setFdxi(val_exp.get(0), val_exp.get(1));    //Permite a entrada do valor Xi para ser usado no Fdxi(ou Função Derivada de Fxi)
        setXf(xi, getFxi(), getFdxi()); //Permite a entrada de Xi, Fxi e Fdxi para serem usados no cálculo do próximo valor de Xi
        setInteracao(interacao);        //Permite a entrada do valor Interacao
        setModulo(xi, getXf());     // Permite a entrada do valor Xi e Xf(próximo valor assumido por Xi) para serem usados no Modulo 
    }
    
    
    public NewtonRaphson (double xf) {
        val_exp = ver.VerificaNegativo(xf, 2);
        setXi(val_exp.get(0));      
        setFxi(val_exp.get(0), val_exp.get(1));     
        setFdxi(val_exp.get(0), val_exp.get(1));   
        setXf(xf, getFxi(), getFdxi());       
        setModulo(xf, getXf());
    }
    
//Getters: Ocorrem o retorno dos valores inseridos nos Setters
    public static double getXi() {
        return xi;
    }
    
    public static double getFxi() {
        return fxi;
    }
    
    public static double getFdxi() {
        return fdxi;
    }
    
    public static double getXf() {
        return xf;
    }
    
    public static double getModulo() {
        return modulo;
    }
    
    public static double getInteracao() {
        return interacao;
    }
    
//Setters: ocorrem a inserção dos valores, obtidos através do Construtor
    public static void setXi(double xi) {
        NewtonRaphson.xi = xi;
    }
    
    public static void setFxi(double xi, double exp) {
        NewtonRaphson.fxi = pow(xi, exp); //Definição da Variável Fxi à raíz quadrada da Variável Xi
    }
    
    public static void setFdxi(double xi, double exp) {
        NewtonRaphson.fdxi = (1 / pow(xi, exp)) / 2; // Definição da Variável Fdxi à Derivada de Raíz Quadrada de Fxi, sendo essa: 1/2 * RAIZ(1/xi)
    }
    
    public static void setXf(double xi, double fxi, double fdxi) {
        NewtonRaphson.xf = xi - (fxi/fdxi); //Definição do próximo valor a ser utilizado, aonde: Xf = Xi - (F(xi) / F'(Xi))
    }
    
    public static void setModulo(double xi, double xf) {
        NewtonRaphson.modulo = abs(xf - xi); //Definição do Módulo entre o Valor Final(ou Xf) e o Valor Inicial(ou Xi) 
    }
    
    public static void setInteracao(int interacao) {
        NewtonRaphson.interacao = interacao;
    }
    
//Método para passar o valor adquirido em Xf para novo Xi    
    public static void passaValor(double xf) {
         //Definição do próximo valor a ser 
         new NewtonRaphson(xf);
    }
    
    
    
//Método para definição da Tabela a ser mostrada na View com TabbedPane
    public static DefaultTableModel getTableModel() {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Xi");
        modelo.addColumn("f(Xi)");
        modelo.addColumn("f '(Xi)");
        modelo.addColumn("Xi - (f(Xi)/f'(Xi))");
        modelo.addColumn("|Xf - Xi|");
        
        int i=0; //Variável local com o objetivo de ser usada para percorrer a tabela
        
        //Inserção dos valores adquridos com os setters, retornando-os com os getters
        while (i <= getInteracao()) {
            String vlxi = Formatacao.ArredondaValor(getXi());
            String vlfxi = Formatacao.ArredondaValor(getFxi());
            String vlfdxi = Formatacao.ArredondaValor(getFdxi());
            String vlxf = Double.toString(Math.round(getXf()));
            String vlmodulo = Formatacao.ArredondaValor(getModulo());

            String[] s = {vlxi, vlfxi, vlfdxi, vlxf, vlmodulo};
            modelo.addRow(s);  
            passaValor(getXf());
            i++;
            
        }
        return modelo;
    }

}

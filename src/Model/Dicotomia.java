/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Util.Verificacao;
import static java.lang.Math.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GianL and FelipeSdS
 */
public class Dicotomia {
    private static double x1;
    private static double x2 = 0;
    private static double fx1;
    private static double fx2;
    private static double pm;      //Variável P.M., aonde este é o Ponto Médio entre os dois valores escolhidos: (x1 + x2) / 2
    private static double fpm;
    private static double modulo;
    private static int interacao;
 
    
    Verificacao ver = new Verificacao();
    
    public static ArrayList<Double> val_expx1 = new ArrayList<Double>();
    public static ArrayList<Double> val_expx2 = new ArrayList<Double>();
    public static ArrayList<Double> val_exppm = new ArrayList<Double>();
    
    
//Construtor: Aqui ocorre a entrada dos valores necessários para serem usados nos cálculos
    public Dicotomia (double x1, int interacao) {
        val_expx1 = ver.VerificaNegativo(x1, 2);
        val_expx2 = ver.VerificaNegativo(getX2(), 2);
        val_exppm = ver.VerificaNegativo(getPm(), 2);
        setX1(val_expx1.get(0));
        setX2(0);
        setFx1(val_expx1.get(0), val_expx1.get(1));
        setFx2(val_expx2.get(0), val_expx2.get(1));
        setPm(getX1(), getX2());
        setFpm(val_exppm.get(0), val_exppm.get(1));
        setInteracao(interacao);
        setModulo(getX1(), getX2());
    }
    
    
    public Dicotomia(double x1, double x2) {
        val_expx1 = ver.VerificaNegativo(x1, 2);
        val_expx2 = ver.VerificaNegativo(x2, 2);
        val_exppm = ver.VerificaNegativo(getPm(), 2);
        setX1(val_expx1.get(0));
        setX2(val_expx2.get(0));
        setFx1(val_expx1.get(0), val_expx1.get(1));
        setFx2(val_expx2.get(0), val_expx2.get(1));
        setPm(getX1(), getX2());
        setFpm(val_exppm.get(0), val_exppm.get(1));
        setModulo(getX1(), getX2());
    }
    
//Getters: Ocorrem o retorno dos valores inseridos nos Setters   
    public static double getX1() {
        return x1;
    }
    
    public static double getX2() {
        return x2;
    }
    
    public static double getFx1() {
        return fx1;
    }
    
    public static double getFx2() {
        return fx2;
    }
    
    public static double getPm() {
        return pm;
    }
    
    public static double getFpm() {
        return fpm;
    }
    
    public static double getModulo() {
        return modulo;
    }
    
    public static double getInteracao() {
        return interacao;
    }
    
    
//Setters: ocorrem a inserção dos valores, obtidos através do Construtor
    public static void setX1(double x1) {
        Dicotomia.x1 = x1;
    }
    
    public static void setX2(double x2) {
        Dicotomia.x2 = x2;
    }
    
    public static void setFx1(double x1, double exp) {
        Dicotomia.fx1 = pow(x1, exp);
    }
    
    public static void setFx2(double x2, double exp) {
        Dicotomia.fx2 = pow(x2,exp);
    }
    
    public static void setPm(double x1, double x2) {
        Dicotomia.pm = (x1 + x2) / 2;
    }
    
    public static void setFpm(double pm, double exp) {
        Dicotomia.fpm = pow(pm, exp);
    }
    
    public static void setModulo (double x1, double x2) {
        Dicotomia.modulo = abs(x1 - x2);
    }
    
    public static void setInteracao(int interacao) {
        Dicotomia.interacao = interacao;
    }
    

    
 //Método para troca de Valores com Relação ao Dicotomia, aonde caso o valor retornado por Fx1 seja negativo igualmente ao
 //Fpm, ele deve passar o Pm para o X1, enquanto o mesmo vale para Fx2 e X2.
    public static void passaValor(double x1, double x2, double fx1,double fx2, double fpm, double pm) {
        if(fpm < 0.0) {
            if (fx1 < 0)
                new Dicotomia(pm, x2);
            else if (fx2 < 0)
                new Dicotomia(x1, pm); 
        }
        else {
            if (fx1 >= 0)
                new Dicotomia(pm, x2);
            else if (fx2 >= 0)
                new Dicotomia(x1, pm);
        }
            
       
    }
    
    
    
    public static DefaultTableModel getTableModel() {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("X1");
        modelo.addColumn("f(X1)");
        modelo.addColumn("X2");
        modelo.addColumn("f(X2)");
        modelo.addColumn("P.M.");       
        modelo.addColumn("f(P.M.)");       
        modelo.addColumn("|X1 - X2|");       
        int i=0 ;

        for (i=0;i <= getInteracao();i++) {
            String vlx1 = Double.toString(getX1());
            String vlx2 = Double.toString(getX2());
            String vlfx1 = Double.toString(getFx1());
            String vlfx2 = Double.toString(getFx2());
            String vlpm = Double.toString(getPm());
            String vlfpm = Double.toString(getFpm());
            String vlmodulo = Double.toString(getModulo());

            String[] s = {vlx1, vlfx1, vlx2, vlfx2, vlpm, vlfpm, vlmodulo};
            modelo.addRow(s);  
            passaValor(getX1(), getX2(), getFx1(), getFx2(), getFpm(), getPm());
        }

        return modelo;
    }
    
}

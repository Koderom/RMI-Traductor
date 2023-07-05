/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Events;

import java.util.EventObject;

/**
 *
 * @author MIRKO
 */
public class TranslationReadyEvent extends EventObject{
    String resultado;

    public TranslationReadyEvent(String resultado, Object source) {
        super(source);
        this.resultado = resultado;
    }
    public String getResultado(){
        return this.resultado;
    }
}

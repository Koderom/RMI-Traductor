/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Events;

import java.util.EventListener;

/**
 *
 * @author MIRKO
 */
public interface TraductorListener extends EventListener{
    public void onTranslationReady(TranslationReadyEvent event);
}

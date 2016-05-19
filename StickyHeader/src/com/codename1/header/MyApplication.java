package com.codename1.header;


import com.codename1.ui.StickyHeader;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Component;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    private Resources theme;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
        Form hi = new Form("Sticky Header");
        hi.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        hi.setScrollableY(true);

        for (int j = 0; j < 10; j++) {
            StickyHeader header = new StickyHeader();
            header.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            header.setUIID("Header");
            Label headerLbl = new Label("header" + j);
            headerLbl.getAllStyles().setAlignment(Component.CENTER);
            header.add(headerLbl);
            hi.addComponent(header);                        
            for (int i = 0; i < 10; i++) {
                hi.addComponent(new Label("Label " + ((j*10) + i)));            
            }
        }
        
        hi.show();
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }
    
    public void destroy() {
    }

}

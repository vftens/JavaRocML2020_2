/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.saveload;

import personalfinance.settings.Settings;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import personalfinance.settings.Settings;

/**
 *
 * @author Admin
 */
public class SaveLoad {
    
    public static void load(SaveData sd) {
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            Wrapper wrapper = (Wrapper) um.unmarshal(Settings.getFileSave());
            sd.setAccounts(wrapper.getAccounts());
            sd.setArticles(wrapper.getArticles());
            sd.setTransactions(wrapper.getTransactions());
            sd.setTransfers(wrapper.getTransfers());
            sd.setCurrencies(wrapper.getCurrencies());
        } catch (JAXBException ex) {
            // TODO Stack, description
            System.out.println("Файл не существует!" +
                    ex +
                    sd// empty
                    );
            Logger.getLogger(SaveLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void save(SaveData sd) {
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            Wrapper wrapper = new Wrapper();
            
            wrapper.setAccounts(sd.getAccounts());
            wrapper.setArticles(sd.getArticles());
            wrapper.setTransactions(sd.getTransactions());
            wrapper.setTransfers(sd.getTransfers());
            wrapper.setCurrencies(sd.getCurrencies());
            
            m.marshal(wrapper, Settings.getFileSave());
            
        } catch (JAXBException ex) {
            Logger.getLogger(SaveLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

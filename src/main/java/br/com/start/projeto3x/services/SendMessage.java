package br.com.start.projeto3x.services;

import com.google.gson.JsonObject;

import br.com.start.projeto3x.dominios.Message;

public class SendMessage {

    


    public static Boolean sendBroke(Message message) throws Exception {

        DeviceIot device = new DeviceIot();

        JsonObject data = new JsonObject();

        data.addProperty("name", message.getName());
        data.addProperty("text", message.getText());

        boolean response = device.send(data) ? true : false ;

        return response;

    }
    

    



}

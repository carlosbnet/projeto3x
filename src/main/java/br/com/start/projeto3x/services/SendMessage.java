package br.com.start.projeto3x.services;

import com.google.gson.JsonObject;

import br.com.start.projeto3x.dominios.Message;

public class SendMessage {

    public static Boolean sendBroke(Message message, int quantMessage) throws Exception {

        DeviceIot device = new DeviceIot();

        JsonObject data = new JsonObject();

        data.addProperty("name", message.getName());
        data.addProperty("content", message.getContent());
        data.addProperty("type", message.getType());
        data.addProperty("quantMessage", quantMessage);
        data.addProperty("codigoMSG", message.getCodigoMSG());
        data.addProperty("quantSlides", message.getQuantSlides());
        data.addProperty("direction", message.getDirection());
        data.addProperty("velocity", message.getVelocity());

        boolean response = device.SendAndSubscribeToJSONEvent(data) ? true : false;

        return response;
        
    }

}

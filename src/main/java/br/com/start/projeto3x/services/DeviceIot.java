package br.com.start.projeto3x.services;

import com.ibm.wiotp.sdk.app.ApplicationClient;
import com.ibm.wiotp.sdk.app.config.ApplicationConfig;
import com.ibm.wiotp.sdk.app.messages.Event;

import com.google.gson.JsonObject;
import com.ibm.wiotp.sdk.codecs.JsonCodec;
import com.ibm.wiotp.sdk.device.DeviceClient;

public class DeviceIot {

  protected ApplicationClient client;
  public static boolean isSending = false;

  private String deviceType = "arduino";
  private String deviceId = "yd12";

  public DeviceIot() throws Exception {

    ApplicationConfig config = ApplicationConfig.generateFromEnv();

    this.client = new ApplicationClient(config);
    this.client.registerCodec(new JsonCodec());

  }

  public ApplicationClient getClient() {
    return client;
  }

  public boolean SendAndSubscribeToJSONEvent(JsonObject data) throws Exception {

    client.connect();
    System.out.println("Client is connected :" + client.isConnected());
   
    // Create the subscription
    AppEventCallbackJson evtCallback = new AppEventCallbackJson();

    client.registerEventCallback(evtCallback);
    client.subscribeToDeviceEvents(deviceType, deviceId);

    int count = 0;
    Event<JsonObject> evt = evtCallback.getEvent();
    
    while (evt == null && ++count <= 30) {
      try {
        isSending = true;
        boolean success = client.publishCommand(deviceType, deviceId, "teste", data);

        if (success) {
          System.out.println("Enviando dados: " + count);
        }
       
        // Check for event
        evt = evtCallback.getEvent();
        Thread.sleep(1000);

      } catch (InterruptedException e) {

      }
    }

    if (evt != null) {
      System.out.println("Response endpoint: " + evt.getData());
    }

    if (evt != null || count >= 30) {
      isSending = false;
    }

    return (evt != null);
  }

}
package br.com.start.projeto3x.services;

import com.ibm.wiotp.sdk.app.ApplicationClient;
import com.ibm.wiotp.sdk.app.config.ApplicationConfig;
import com.google.gson.JsonObject;
import com.ibm.wiotp.sdk.codecs.JsonCodec;


public class DeviceIot {
 
  protected ApplicationClient client;
 

  public DeviceIot() throws Exception {

    ApplicationConfig config = ApplicationConfig.generateFromEnv(); 
  
    this.client = new ApplicationClient(config);
    this.client.registerCodec(new JsonCodec());
    
  }

  public ApplicationClient getClient(){
      return client;
  }



  public boolean send(JsonObject data) {

    try {

      client.connect();
      System.out.println("Start publishing event every second...");

      // Send a dataset every 1 second, until we are told to quit
     // while (!quit) {

        System.out.println(data);

        client.publishCommand("arduino", "yd12", "teste", data);
        Thread.sleep(5000);
     // }

      // Once told to stop, cleanly disconnect from the service
      client.disconnect();
      
    
    } catch (Exception e) {
      e.printStackTrace();
    }

    return true;

  }

 
}
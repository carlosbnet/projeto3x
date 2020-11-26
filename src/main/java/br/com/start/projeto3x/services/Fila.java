package br.com.start.projeto3x.services;

import br.com.start.projeto3x.dominios.Message;
import lombok.Data;

import java.util.ArrayList;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.EnableScheduling;

@Data
@Component
@EnableScheduling
public class Fila {

    private static ArrayList<Message> elementos = new ArrayList<>();

    public static boolean sendOk = false;

    public static void enfileira(Message message) throws Exception {

        elementos.add(message);
        System.out.println("Nova mensagem!!!!");
    }

    @Scheduled(fixedRate = 10000)
    public static void desenfileirar() throws Exception {

        if (elementos.size() > 0 && DeviceIot.isSending == false) {

            Message message = elementos.get(0);

            if (SendMessage.sendBroke(message, elementos.size())) {
                sendOk = true;
                System.out.println("Mensagem Enviada...");
                System.out.println("Removendo....");
                elementos.remove(0);
                System.out.println("Quantidade Mensagem: " + elementos.size());
            } else {
                System.out.println("--------------------------------");
                System.out.println("   Erro: Mensagem não enviada   ");
                System.out.println("--------------------------------");

            }

        }

    }

    @Scheduled(fixedRate = 5000)
    public void verificaCaixaEntrada() {
        System.out.println("Caixa de Entrada: " + elementos.size());
    }

}

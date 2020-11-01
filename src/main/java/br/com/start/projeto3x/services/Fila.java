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

    public static void enfileira(Message message) throws Exception {

        elementos.add(message);
        System.out.println("Caixa de Entrada: " + elementos.size());
    }

    @Scheduled(fixedRate = 10000)
    public static void desenfileirar() throws Exception {

        if ((elementos.size() > 0)) {

            Message message = elementos.get(0);
            boolean sendOk = false;

            while (sendOk == false) {

                if (SendMessage.sendBroke(message)) {
                    sendOk = true;
                }

            }

            System.out.println("Removendo....");
            elementos.remove(0);
            System.out.println("Quantidade Mensagem: " + elementos.size());

        } else {
            System.out.println("Sem Messagens....");
        }

    }

}

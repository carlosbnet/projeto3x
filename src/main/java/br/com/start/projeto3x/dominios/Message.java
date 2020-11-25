package br.com.start.projeto3x.dominios;

import lombok.Data;

@Data
public class Message {

    private String name;
    private String content;
    private String type;
    private int codigoMSG;
    private int velocity;
    private int direction;
    private int quantSlides;


    public Message(String name, String content, String type, int codigoMSG, int velocity, int direction, int quantSlides) {
        this.name = name;
        this.content = content;
        this.type = type;
        this.codigoMSG = codigoMSG;
        this.velocity = velocity;
        this.direction = direction;
        this.quantSlides = quantSlides;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCodigoMSG() {
        return codigoMSG;
    }

    public void setCodigoMSG(int codigoMSG) {
        this.codigoMSG = codigoMSG;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getQuantSlides() {
        return quantSlides;
    }

    public void setQuantSlides(int quantSlides) {
        this.quantSlides = quantSlides;
    }

}

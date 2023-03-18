package br.com.ufrpe.uast.psdiot.dto;


import lombok.Data;

@Data
public class MqttPublishDto {

    String topic;
    String message;

}

package br.com.ufrpe.uast.psdiot.controller;

import br.com.ufrpe.uast.psdiot.dto.MqttPublishDto;
import br.com.ufrpe.uast.psdiot.mqtt.MqttGatway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mqtt")
public class MqttController {

    private final MqttGatway mqttGatway;

    @Autowired
    public MqttController(MqttGatway mqttGatway) {
        this.mqttGatway = mqttGatway;
    }

    @PostMapping("/publish")
    public ResponseEntity<?> publish(@RequestBody MqttPublishDto mqttPublishDto) {
        try {

            mqttGatway.sendToMqtt(mqttPublishDto.getMessage(), mqttPublishDto.getTopic());

            return ResponseEntity.ok("Sucess");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}

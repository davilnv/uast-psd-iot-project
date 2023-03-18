package br.com.ufrpe.uast.psdiot.mqtt;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;


@Service
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGatway {

    void sendToMqtt(String data, @Header(MqttHeaders.TOPIC) String topic);

}

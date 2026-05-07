package net.javaguides.springboot;


import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.HttpConnectStrategy;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import okhttp3.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangesProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMenssage() throws InterruptedException {

        String topic = "wikimedia_recentchange";

        BackgroundEventHandler backgroundEventHandler =
                new WikimediaChangesHandler(kafkaTemplate, topic);

        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        // for the devs: add your personal email replace with "tatcho156@gmail.com"
        HttpConnectStrategy connectStrategy = HttpConnectStrategy.http(URI.create(url))
                .headers(Headers.of(Map.of(
                        "User-Agent", "spring-kafka-app/1.0 (tatcho156@gmail.com)"
                )));

        EventSource.Builder eventSourceBuilder =
                new EventSource.Builder(connectStrategy);

        BackgroundEventSource.Builder builder =
                new BackgroundEventSource.Builder(backgroundEventHandler, eventSourceBuilder);

        BackgroundEventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);
    }

}

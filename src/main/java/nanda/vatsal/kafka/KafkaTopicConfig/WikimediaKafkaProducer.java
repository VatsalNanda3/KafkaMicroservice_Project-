package nanda.vatsal.kafka.KafkaTopicConfig;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@EnableAutoConfiguration
@Service
public class WikimediaKafkaProducer {
	
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaKafkaProducer.class);
	 
	 @Autowired 
	 private KafkaTemplate<String,String> kafkaTemplate;
	 
	 public void sendMessage() throws InterruptedException {
	        // to read real time stream data from wikimedia, we use event source
	        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, "wikimedia_recentchange");
	        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
	        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
	        EventSource eventSource = builder.build();
	        eventSource.start();

	       TimeUnit.MINUTES.sleep(1);
	        
	    }
	 
	

}

package nanda.vatsal.kafka.KafkaConsumerDatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import nanda.vatsal.kafka.entity.WikimediaEntity;
import nanda.vatsal.kafka.repository.WikimediaRepositiory;

@EnableAutoConfiguration
@Service
public class KafkaConsumerDatabase {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumerDatabase.class);
	
	
	//@Autowired
	private WikimediaRepositiory wikimediaRepository;
	
	@KafkaListener(topics="wikimedia_recentchange",groupId="myGroup")
	public void consume(String eventMessage) {
		
		LOGGER.info(String.format("Event message receieved%s" , eventMessage));
		
		WikimediaEntity wikimediaEntity= new WikimediaEntity();
		wikimediaEntity.setWikiEventData(eventMessage);
		
		wikimediaRepository.save(wikimediaEntity);
		
		
		
	}

}

package nanda.vatsal.kafka.Kafka.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nanda.vatsal.kafka.KafkaTopicConfig.WikimediaKafkaProducer;

@SpringBootApplication(scanBasePackages= {"nanda.vatsal.kafka.KafkaTopicConfig","nanda.vatsal.kafka.KafkaConsumerDatabase","nanda.vatsal.kafka.entity","nanda.vatsalkafka.repository"})
public class KafkaMicroserviceApplication  implements CommandLineRunner{

	@Autowired 
	private WikimediaKafkaProducer wikimediaKafkaProducer;
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaMicroserviceApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		wikimediaKafkaProducer.sendMessage();
		
	}
	
	
	
	
	

}

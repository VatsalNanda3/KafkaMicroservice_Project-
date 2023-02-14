package nanda.vatsal.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanda.vatsal.kafka.entity.WikimediaEntity;

@Repository
public interface WikimediaRepositiory extends JpaRepository<WikimediaEntity,Integer> {

}

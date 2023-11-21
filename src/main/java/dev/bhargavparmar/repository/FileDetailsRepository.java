package dev.bhargavparmar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.bhargavparmar.model.FileDetails;

@Repository
public interface FileDetailsRepository extends JpaRepository<FileDetails, Long>{

}

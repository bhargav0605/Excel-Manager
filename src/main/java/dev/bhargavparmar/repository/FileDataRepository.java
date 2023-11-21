package dev.bhargavparmar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.bhargavparmar.model.FileData;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long>{

}

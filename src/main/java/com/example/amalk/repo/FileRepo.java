package com.example.amalk.repo;

import com.example.amalk.models.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<FileInfo, Long> {
}

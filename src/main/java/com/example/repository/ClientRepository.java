package com.example.repository;

import com.example.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
    List<ClientModel> findByClientNameAndClientSurname(String clientName, String clientSurname);
}

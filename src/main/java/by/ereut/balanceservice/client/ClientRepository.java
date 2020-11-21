package by.ereut.balanceservice.client;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Profile({"dev","test"})
public interface ClientRepository extends JpaRepository<Client, Long> {
}

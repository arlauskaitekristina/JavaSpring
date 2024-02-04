package spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

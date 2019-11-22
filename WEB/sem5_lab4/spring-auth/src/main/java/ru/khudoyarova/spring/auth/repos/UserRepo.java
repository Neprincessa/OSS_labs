package ru.khudoyarova.spring.auth.repos;

import ru.khudoyarova.spring.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public interface UserRepo extends JpaRepository<User, Long>
{
	User findByUsername(String email);
	User findByName(String name);
	List<User> findAllByActiveTrue();
}

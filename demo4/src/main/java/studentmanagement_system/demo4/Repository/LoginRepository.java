package studentmanagement_system.demo4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studentmanagement_system.demo4.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

    public Login findByUserNameAndPassword(String userName, String password);
    
    
}

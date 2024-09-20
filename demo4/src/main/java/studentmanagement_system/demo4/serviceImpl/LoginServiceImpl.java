package studentmanagement_system.demo4.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentmanagement_system.demo4.Repository.LoginRepository;
import studentmanagement_system.demo4.entity.Login;
import studentmanagement_system.demo4.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    LoginRepository lrepo;

    @Override
    public Login loginUser(String userName, String password) {

       Login login =  lrepo.findByUserNameAndPassword(userName, password);

        return login;
    }
    
}

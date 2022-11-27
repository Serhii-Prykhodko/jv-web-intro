package mate.academy.service;

import mate.academy.dao.UserDao;
import mate.academy.dao.UserDaoImpl;
import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;

import java.util.Optional;

public class AuthenticationServiceImpl implements AuthenticationService{
    private UserDao userDao = new UserDaoImpl();
        @Override
    public User login(String username, String password) throws AuthenticationException {
            Optional<User> user = userDao.findByUsername(username);
            if (user.isEmpty()) {
                throw new AuthenticationException("Username or password was incorrect");
            }
            if (user.get().getPassword().equals(password)) {
                return user.get();
            }
            throw new AuthenticationException("Username or password was incorrect");
    }
}

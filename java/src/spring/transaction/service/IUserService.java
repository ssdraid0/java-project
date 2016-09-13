package spring.transaction.service;

import spring.transaction.model.UserModel;

public interface IUserService {
    
    public void save(UserModel user);
    
    public int countAll();
}

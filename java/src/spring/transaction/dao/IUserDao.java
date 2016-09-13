package spring.transaction.dao;

import spring.transaction.model.UserModel;

public interface IUserDao {
    
    public void save(UserModel user);
    
    public int countAll();
    
}

package spring.transaction.dao;

import spring.transaction.model.AddressModel;

public interface IAddressDao {
    
    public void save(AddressModel address);

    public int countAll();
}

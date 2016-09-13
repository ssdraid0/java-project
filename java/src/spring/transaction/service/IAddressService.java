package spring.transaction.service;

import spring.transaction.model.AddressModel;

public interface IAddressService {
    
    public void save(AddressModel address);
    
    public int countAll();
}

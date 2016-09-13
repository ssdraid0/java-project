package spring.transaction.service.impl;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import spring.transaction.dao.IAddressDao;
import spring.transaction.model.AddressModel;
import spring.transaction.service.IAddressService;
import spring.transaction.util.TransactionTemplateUtils;

public class AddressServiceImpl implements IAddressService
{

    private IAddressDao addressDao;

    private PlatformTransactionManager txManager;

    public void setAddressDao(IAddressDao addressDao)
    {
        this.addressDao = addressDao;
    }

    public void setTxManager(PlatformTransactionManager txManager)
    {
        this.txManager = txManager;
    }

    @Override
    public void save(final AddressModel address)
    {
        TransactionTemplate transactionTemplate = TransactionTemplateUtils.getRequiredTransactionTemplate(txManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult()
        {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status)
            {
                addressDao.save(address);
                throw new RuntimeException();  
            }
        });
    }

    @Override
    public int countAll()
    {
        return addressDao.countAll();
    }

}

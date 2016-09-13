package spring.transaction.service.impl;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import spring.transaction.dao.IUserDao;
import spring.transaction.model.UserModel;
import spring.transaction.service.IAddressService;
import spring.transaction.service.IUserService;
import spring.transaction.util.TransactionTemplateUtils;

public class UserServiceImpl implements IUserService
{

    private IUserDao userDao;

    private IAddressService addressService;

    private PlatformTransactionManager txManager;

    public void setUserDao(IUserDao userDao)
    {
        this.userDao = userDao;
    }

    public void setTxManager(PlatformTransactionManager txManager)
    {
        this.txManager = txManager;
    }

    public void setAddressService(IAddressService addressService)
    {
        this.addressService = addressService;
    }

    @Override
    public void save(final UserModel user)
    {
        TransactionTemplate transactionTemplate = TransactionTemplateUtils.getRequiredTransactionTemplate(txManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult()
        {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status)
            {
                userDao.save(user);
                user.getAddress().setUserId(user.getId());
                try
                {
                    addressService.save(user.getAddress());
                } catch (RuntimeException e)
                {
                }

            }
        });

    }

    @Override
    public int countAll()
    {
        return userDao.countAll();
    }

}

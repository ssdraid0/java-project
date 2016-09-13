package spring.transaction.util;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

public class TransactionTemplateUtils
{

    public static TransactionTemplate getTransactionTemplate(PlatformTransactionManager txManager,
            int propagationBehavior, int isolationLevel)
    {

        TransactionTemplate transactionTemplate = new TransactionTemplate(txManager);
        transactionTemplate.setPropagationBehavior(propagationBehavior);
        transactionTemplate.setIsolationLevel(isolationLevel);
        return transactionTemplate;
    }

    public static TransactionTemplate getRequiredTransactionTemplate(PlatformTransactionManager txManager)
    {
        return getTransactionTemplate(txManager, TransactionDefinition.PROPAGATION_REQUIRED,
                TransactionDefinition.ISOLATION_READ_COMMITTED);
    }
    
    public static TransactionTemplate getRequiresNewTransactionTemplate(PlatformTransactionManager txManager)
    {
        return getTransactionTemplate(txManager, TransactionDefinition.PROPAGATION_REQUIRES_NEW,
                TransactionDefinition.ISOLATION_READ_COMMITTED);
    }

}

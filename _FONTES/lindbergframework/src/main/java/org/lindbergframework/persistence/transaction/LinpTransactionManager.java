package org.lindbergframework.persistence.transaction;

import javax.sql.DataSource;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.exception.TransactionFailureException;
import org.lindbergframework.persistence.context.LinpContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Transaction template implementation that uses Spring transaction resources to manage transactions of database.
 * 
 * @author Victor Lindberg
 *
 */
@Bean("defaultLinpTransactionManager")
public class LinpTransactionManager extends TransactionTemplate
                              implements TransactionManager{
    
    private static final long serialVersionUID = 1L;

    public LinpTransactionManager(){
        //
    }
    
    /**
     * constructor that uses DataSourceTransactionManager as PlatformTransactionManager implementation.
     */
    public LinpTransactionManager(DataSource dataSource){
        this(new DataSourceTransactionManager(dataSource));
    }

    /**
     * Creates a LinpSpringTransactionManager with the specified PlatformTransactionManager imlementation.
     * 
     * @param transactionManager PlatformTransactionManager imlementation.
     */
    public LinpTransactionManager(PlatformTransactionManager transactionManager){
        super(transactionManager);
    }
    
    /**
     * {@inheritDoc}
     */
    public Object execute(TransactionalContext transactionalContext)
        throws TransactionFailureException {
    	if (getTransactionManager() == null){
    		DataSource definedDataSource = LinpContext.getInstance().getDataSource();
    		PlatformTransactionManager platformTransactionManager = new DataSourceTransactionManager(definedDataSource);
    		setTransactionManager(platformTransactionManager);
    	}
    	
        final TransactionalContext finalContext = transactionalContext;
        return super.execute(new TransactionCallback(){
           public Object doInTransaction(TransactionStatus status) {
               try{
                return finalContext.call();
               }catch(Throwable ex){
                   throw new TransactionFailureException(
                       "Transaction failure", ex);    
               }
            } 
        });
    }

}

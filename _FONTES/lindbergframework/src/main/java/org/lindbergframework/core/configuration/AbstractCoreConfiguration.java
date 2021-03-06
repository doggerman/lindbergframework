package org.lindbergframework.core.configuration;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.core.context.AllowIfContextActive;
import org.lindbergframework.core.context.ComponentContext;
import org.lindbergframework.core.context.CoreContext;
import org.lindbergframework.exception.InvalidConfigurationException;
import org.lindbergframework.persistence.configuration.LinpConfiguration;

/**
 * Abstract core configuration class that provides the base operations for core configuration implementations.
 * 
 * @author Victor Lindberg
 *
 */
public abstract class AbstractCoreConfiguration extends ConfigurationRepository implements CoreConfiguration{
    
    /**
     * lindberg persistence key in the values configurations repository. 
     */
    protected static final String LINP_CONFIGURATION_KEY = "linpConfiguration";
    
    public AbstractCoreConfiguration(){
        //
    }

    /**
     * {@inheritDoc}
     */
    @AllowIfContextActive
    public String getDIBasePackage() {
        return super.getPropertyValue(CONFIG_PROPERTY_DI_BASEPACKAGE);
    }

    /**
     * {@inheritDoc}
     */
    @AllowIfContextActive
    public BeanFactory getBeanFactory() {
        return super.getPropertyValue(CONFIG_PROPERTY_BEAN_FACTORY);
    }
    
    @AllowIfContextActive
    public LinpConfiguration getLinpConfiguration() {
        return super.getPropertyValue(LINP_CONFIGURATION_KEY);
    }
    
    protected void setDiBasePackage(String diBasePackage) {
        registerProperty(CONFIG_PROPERTY_DI_BASEPACKAGE, diBasePackage);
    }

    protected void setBeanFactory(BeanFactory beanFactory) {
        registerProperty(CONFIG_PROPERTY_BEAN_FACTORY, beanFactory);
    }
    
    public void setLinpConfiguration(LinpConfiguration linpConfiguration){
        registerProperty(LINP_CONFIGURATION_KEY, linpConfiguration);
    }
    
    /**
     * {@inheritDoc}
     */
    public void validate() throws InvalidConfigurationException {
        //
    }
    
    /**
	 * {@inheritDoc}
	 */
    public void initializeContext() {
        CoreContext.getInstance().initialize(this);
    }
    
    /**
	 * {@inheritDoc}
	 */
    public Configuration[] getModules() {
        Configuration linpConfiguration = getLinpConfiguration();
        if (linpConfiguration != null)
            return new Configuration[]{linpConfiguration};
        
        return new Configuration[]{};
    }
    
    public ComponentContext<?> getParentContext() {
    	return CoreContext.getInstance();
    }

}

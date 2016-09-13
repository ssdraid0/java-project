package spring.ioc;

import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.EncodedResource;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

public class IocSource
{

}

/**
 * xml读取过程。<br>
 * {@link XmlBeanDefinitionReader#loadBeanDefinitions(EncodedResource)}。<br>
 * {@link EncodedResource#getResource()}返回的可能是{@link DefaultResourceLoader.ClassPathContextResource}，
 * {@link ClassPathResource}，{@link UrlResource}。
 * 
 * <pre>
 * public int loadBeanDefinitions(EncodedResource encodedResource) throws BeanDefinitionStoreException
 * {
 *     Assert.notNull(encodedResource, "EncodedResource must not be null");
 *     if (logger.isInfoEnabled())
 *     {
 *         logger.info("Loading XML bean definitions from " + encodedResource.getResource());
 *     }
 * 
 *     Set<EncodedResource> currentResources = this.resourcesCurrentlyBeingLoaded.get();
 *     if (currentResources == null)
 *     {
 *         currentResources = new HashSet<EncodedResource>(4);
 *         this.resourcesCurrentlyBeingLoaded.set(currentResources);
 *     }
 *     if (!currentResources.add(encodedResource))
 *     {
 *         throw new BeanDefinitionStoreException(
 *                 "Detected cyclic loading of " + encodedResource + " - check your import definitions!");
 *     }
 *     try
 *     {
 *         InputStream inputStream = encodedResource.getResource().getInputStream();
 *         try
 *         {
 *             InputSource inputSource = new InputSource(inputStream);
 *             if (encodedResource.getEncoding() != null)
 *             {
 *                 inputSource.setEncoding(encodedResource.getEncoding());
 *             }
 *             // {@link doLoadBeanDefinitions}
 *             return doLoadBeanDefinitions(inputSource, encodedResource.getResource());
 *         } finally
 *         {
 *             inputStream.close();
 *         }
 *     } catch (IOException ex)
 *     {
 *         throw new BeanDefinitionStoreException(
 *                 "IOException parsing XML document from " + encodedResource.getResource(), ex);
 *     } finally
 *     {
 *         currentResources.remove(encodedResource);
 *         if (currentResources.isEmpty())
 *         {
 *             this.resourcesCurrentlyBeingLoaded.remove();
 *         }
 *     }
 * }
 * </pre>
 */
class aaa
{
    
}

/**
 * {@link XmlBeanDefinitionReader#doLoadBeanDefinitions(InputSource, Resource)}
 * 
 * <pre>
 * protected int doLoadBeanDefinitions(InputSource inputSource, Resource resource) throws BeanDefinitionStoreException
 * {
 *     try
 *     {
 *         // {@link doLoadDocument}
 *         Document doc = doLoadDocument(inputSource, resource);
 *         return registerBeanDefinitions(doc, resource);
 *     } catch (BeanDefinitionStoreException ex)
 *     {
 *         throw ex;
 *     } catch (SAXParseException ex)
 *     {
 *         throw new XmlBeanDefinitionStoreException(resource.getDescription(),
 *                 "Line " + ex.getLineNumber() + " in XML document from " + resource + " is invalid", ex);
 *     } catch (SAXException ex)
 *     {
 *         throw new XmlBeanDefinitionStoreException(resource.getDescription(),
 *                 "XML document from " + resource + " is invalid", ex);
 *     } catch (ParserConfigurationException ex)
 *     {
 *         throw new BeanDefinitionStoreException(resource.getDescription(),
 *                 "Parser configuration exception parsing XML from " + resource, ex);
 *     } catch (IOException ex)
 *     {
 *         throw new BeanDefinitionStoreException(resource.getDescription(),
 *                 "IOException parsing XML document from " + resource, ex);
 *     } catch (Throwable ex)
 *     {
 *         throw new BeanDefinitionStoreException(resource.getDescription(),
 *                 "Unexpected exception parsing XML document from " + resource, ex);
 *     }
 * }
 * </pre>
 */
class doLoadBeanDefinitions
{

}

/**
 * {@link XmlBeanDefinitionReader#doLoadDocument(InputSource, Resource)}
 */
class doLoadDocument
{
    /**
     * <pre>
     * protected Document doLoadDocument(InputSource inputSource, Resource resource) throws Exception
     * {
     *     return this.documentLoader.loadDocument(inputSource, getEntityResolver(), this.errorHandler,
     *             getValidationModeForResource(resource), isNamespaceAware());
     * }
     * </pre>
     */
}

/**
 * {@link DefaultDocumentLoader#loadDocument(InputSource, EntityResolver, ErrorHandler, int, boolean)}
 */
class loadDocument
{
    /**
     * <pre>
     * public Document loadDocument(InputSource inputSource, EntityResolver entityResolver, ErrorHandler errorHandler,
     *         int validationMode, boolean namespaceAware) throws Exception
     * {
     * 
     *     DocumentBuilderFactory factory = createDocumentBuilderFactory(validationMode, namespaceAware);
     *     if (logger.isDebugEnabled())
     *     {
     *         logger.debug("Using JAXP provider [" + factory.getClass().getName() + "]");
     *     }
     *     DocumentBuilder builder = createDocumentBuilder(factory, entityResolver, errorHandler);
     *     return builder.parse(inputSource);
     * }
     * </pre>
     */
}

Lunifera DSL Metadata Service
=============================

Returns metadata for datatypes, entities and dtos. These services are provided as OSGi-Services.

## available services

### datatypes
Get information about a datatype:
	
	public interface IDatatypesMetadataService {

	/**
	 * Returns the datatypes model for the given datatype name.
	 * 
	 * @param c
	 * @return
	 */
	LDataType getMetadata(String datatypeName);

The service will use the given qualified name of the datatype to return the proper LDataType eObject for it.  
Qualified follows the pattern "{package}.{name}" like `org.lunifera.datatypes.String` 

### entities
Get information about a entities:
	
	public interface IEntityMetadataService {

	/**
	 * Returns the entity model for the given class. 
	 * @param c
	 * @return
	 */
	LEntity getMetadata(Class<?> entityClass);
	
	/**
	 * Returns the entity model for the given class name. 
	 * @param c
	 * @return
	 */
	LEntity getMetadata(String className);

The service will use the given qualified name of the entity to return the proper LEntity eObject for it.  
Qualified follows the pattern "{package}.{name}" like `org.lunifera.carstore.entities.general.Customer`

### dtos
Get information about a entities:
	
	public interface IDtoMetadataService {

	/**
	 * Returns the dto model for the given class.
	 * 
	 * @param c
	 * @return
	 */
	LDto getMetadata(Class<?> dtoClass);

	/**
	 * Returns the dto model for the given class name.
	 * 
	 * @param c
	 * @return
	 */
	LDto getMetadata(String className);

The service will use the given qualified name of the entity to return the proper LDto eObject for it.  
Qualified follows the pattern "{package}.{name}" like `org.lunifera.carstore.general.CustomerDto`
	

## How to use
Services are provided as OSGi Service. So you can consume them by DS (declarative services), get a reference by the bundleContext or even use a ServiceTracker.

The services also allow you to navigate along cross references.

	public void foo(){
		LDto customerDto = dtoService.getMetadata(CustomerDto.class);
		
		// access the entity
		LEntity customer = customerDto.getWrappedType();
		List<LIndex> index = customer.getIndexes();
		
		// navigate along attributes
		for(LEntityAttribute attribute : customer.getAllAttributes()) {
			LDataType datatype = attribute.getDatatype();
		}
	}




 




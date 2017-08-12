package cas.ibm.ubc.ca.graphql.model;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLList.list;
import static graphql.schema.GraphQLNonNull.nonNull;
import static graphql.schema.GraphQLObjectType.newObject;

import graphql.schema.GraphQLObjectType;

public class ModelSchema {	
	public static GraphQLObjectType serviceVersion = newObject()
			.name("ServiceVersion")
			.field(newFieldDefinition()
					.name("version")
					.type(list(GraphQLString))
					.build())
			.build();
	
	public static GraphQLObjectType serviceType = newObject()
			.name("Service")
			.field(newFieldDefinition()
					.name("id")
					.type(nonNull(GraphQLString))
					.build())
			.field(newFieldDefinition()
					.name("name")
					.type(nonNull(GraphQLString))
					.build())
			.build();
	
	public static GraphQLObjectType namespaceType = newObject()
			.name("Namespace")
			.field(newFieldDefinition()
					.name("name")
					.type(nonNull(GraphQLString))
					.build())
			.field(newFieldDefinition()
					.name("services")
					.type(list(serviceType))
					.build())
			.build();
	
	public static GraphQLObjectType queryType = newObject()
		.name("query")
		.field(newFieldDefinition()
				.name("namespace")
				.type(namespaceType)
				.argument(newArgument()
						.name("name")
						.type(nonNull(GraphQLString))
						.build())
				.dataFetcher(Namespace.getNamespace())
				.build())
		.field(newFieldDefinition()
				.name("namespaces")
				.type(list(namespaceType))
				.dataFetcher(Namespace.getNamespaces())
				.build())
		.field(newFieldDefinition()
				.name("service")
				.type(serviceType)
				.argument(newArgument()
							.name("name")
							.type(nonNull(GraphQLString))
							.build())
				.dataFetcher(Service.getService())
				.build())
		.field(newFieldDefinition()
				.name("services")
				.type(list(serviceType))
				.dataFetcher(Service.getServices())
				.build())
		.build();
		
	
}

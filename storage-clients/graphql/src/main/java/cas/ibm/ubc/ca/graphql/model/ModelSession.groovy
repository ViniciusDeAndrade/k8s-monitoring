package cas.ibm.ubc.ca.graphql.model

import cas.ibm.ubc.ca.k8s.K8sClient
import cas.ibm.ubc.ca.k8s.K8sCache

class ModelSession {
	private static ModelSession instance 
	
	K8sCache k8sCache  
	
	private ModelSession() {
		k8sCache = K8sClient.k8sCache()
	}
	
	static ModelSession getInstance() {
		if(Objects.isNull(instance)) {
			instance = new ModelSession()
		}
		instance
	}
	
	void refresh() {
		k8sCache.refresh()
	}
}

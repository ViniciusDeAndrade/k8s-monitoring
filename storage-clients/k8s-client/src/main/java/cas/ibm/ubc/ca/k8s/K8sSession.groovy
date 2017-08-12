package cas.ibm.ubc.ca.k8s

import io.fabric8.kubernetes.api.model.Namespace
import io.fabric8.kubernetes.api.model.Pod
import io.fabric8.kubernetes.api.model.PodList

class K8sSession {
	private def pods
	private def namespaces

	void refresh() {
		throw new UnsupportedOperationException("Not implemented yet")
	}
	
	Namespace namespace(String name) {
		namespaces.withName(name).get()
	}
	
	List<Namespace> namespaces() {
		namespaces.list().getItems()
	}

	List<Pod> pods(String namespace) {
		pods.inNamespace(namespace).list().getItems()
	}
	
	/**
	 * 
	 * @param namespace
	 * @param serviceName the pattern of a pod name "serviceName-UUID"
	 * @return
	 */
	List<Pod> services (String namespace, String serviceName) {
		PodList podList = pods.inNamespace(namespace).list()
		
		return podList.getItems().findAll { pod ->
			pod.getMetadata().getName().contains(serviceName)
		}
	} 
	
	List<Pod> services(String namespace) {
		PodList podList = pods.inAnyNamespace().list()
		
		podList.getItems().findAll { pod ->
			pod.getMetadata().getName() == pod.getMetadata().getName()
		}
	}
	
	Pod service(String serviceName) {
		PodList podList = pods.inAnyNamespace().list()
		
		return podList.getItems().find { pod ->
			pod.getMetadata().getName().contains(serviceName)
		}
	}

	Pod pod(String namespace, String fullName) {
		pods.inNamespace(namespace).withName(fullName).get()
	}
	
	
	Pod pod(String name) {
		
		PodList podList = pods.inAnyNamespace().list()

		podList.getItems().find { pod ->
			pod.getMetadata().getName() == name
		}	
	}
	
}
	
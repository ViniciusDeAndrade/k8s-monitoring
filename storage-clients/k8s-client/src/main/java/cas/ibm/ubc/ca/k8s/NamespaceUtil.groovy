package cas.ibm.ubc.ca.k8s

import io.fabric8.kubernetes.api.model.Namespace

class NamespaceUtil {

	static String namespaceName(Namespace namespace) {
		namespace.getMetadata().getName()
	}
}

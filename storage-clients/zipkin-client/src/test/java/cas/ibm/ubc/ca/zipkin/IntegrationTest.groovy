package cas.ibm.ubc.ca.zipkin

class IntegrationTest extends GroovyTestCase {
	void testGetServiceMessagesByServiceNameAndPeriod() {
		ZipkinClient client = new ZipkinClient('10.66.66.32', 30002)

		client.getMessages('orders', '1h')

		true
	}
}

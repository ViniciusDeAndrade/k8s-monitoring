package cas.ibm.ubc.ca.zipkin

import cas.ibm.ubc.ca.zipkin.pogos.Annotation
import cas.ibm.ubc.ca.zipkin.pogos.Span
import cas.ibm.ubc.ca.zipkin.pogos.Trace

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

import org.junit.Before

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class ZipkinRequestor {
	private static final OkHttpClient httpClient = new OkHttpClient()

	final String host
	final int port

	ZipkinRequestor(String host, int port) {
		this.host = host
		this.port = port
	}
	
	private createRequest(HttpUrl url) {
		new Request.Builder()
				   .url(url)
				   .build()
	}
	
	private HttpUrl createUrl(path) {
		createUrl(path, [:])
	}
	
	private HttpUrl createUrl(path, Map parameters) {
		HttpUrl.Builder builder = new HttpUrl.Builder()
								 .scheme("http")
								 .host(host)
								 .port(port)
		                         .addPathSegments("/zipkin/api/v1/")
								 .addPathSegment(path)
		
		builder = parameters.inject(builder) { b, entry ->
			b.addQueryParameter(entry.key, entry.value.toString())
		}
		
		builder.build()
								 
	}

	List<String> getServices() {
		HttpUrl url = createUrl("services")
		Request request = createRequest(url)

		Response response = httpClient.newCall(request).execute()

		String json = response.body().string()
		
		Type type = new TypeToken<List<String>>() {}.getType()
		new Gson().fromJson(json, type)
	}
	
	List<Span> getSpans(String serviceName) {
		HttpUrl url = createUrl("spans",[serviceName:(serviceName)])
		Request request = createRequest(url)

		Response response = httpClient.newCall(request).execute()
		
		String json = response.body().string()
		
		Type type = new TypeToken<List<String>>() {}.getType()
		new Gson().fromJson(json, type)
	}
	
	/**
	 * Named argument function. You can find the arguments doc at
	 * See <a href="http://zipkin.io/zipkin-api/#/default/get_traces</a>
	 * @param args a map of arguments @see<a href="http://zipkin.io/zipkin-api/#/default/get_traces">
	 * @return
	 */
	Collection<Collection<Trace>> getTraces(Map args) {
		HttpUrl url = createUrl("traces",args)
		Request request = createRequest(url)

		Response response = httpClient.newCall(request).execute()
		
		String json = response.body().string()
		
		Type type = new TypeToken<Collection<Collection<Trace>>>(){}.getType()
		new Gson().fromJson(json, type)
	}
	
	List<Trace> getTrace(String traceId) {
		HttpUrl url = createUrl("trace", [traceId:(traceId)])
		Request request = createRequest(url)

		Response response = httpClient.newCall(request).execute()
		
		String json = response.body().string()
		
		Type type = new TypeToken<List<String>>() {}.getType()
		new Gson().fromJson(json, type)
	}
	
	List<Trace> getDependencies(Long endTs) {
		HttpUrl url = createUrl("dependencies", [endTs:(endTs)])
		Request request = createRequest(url)

		Response response = httpClient.newCall(request).execute()
		
		String json = response.body().string()
		
		Type type = new TypeToken<List<String>>() {}.getType()
		new Gson().fromJson(json, type)
	}
	
}

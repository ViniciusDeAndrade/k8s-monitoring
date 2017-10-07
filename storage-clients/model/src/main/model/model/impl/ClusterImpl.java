/**
 */
package model.impl;

import java.util.Collection;
import java.util.List;

import model.Application;
import model.Cluster;
import model.Environment;
import model.Host;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cluster</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.ClusterImpl#getApplications <em>Applications</em>}</li>
 *   <li>{@link model.impl.ClusterImpl#getHosts <em>Hosts</em>}</li>
 *   <li>{@link model.impl.ClusterImpl#getEnvironment <em>Environment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClusterImpl extends MinimalEObjectImpl.Container implements Cluster {
	/**
	 * The cached value of the '{@link #getApplications() <em>Applications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplications()
	 * @generated
	 * @ordered
	 */
	protected EList<Application> applications;

	/**
	 * The cached value of the '{@link #getHosts() <em>Hosts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHosts()
	 * @generated
	 * @ordered
	 */
	protected EList<Host> hosts;

	/**
	 * The default value of the '{@link #getEnvironment() <em>Environment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironment()
	 * @generated
	 * @ordered
	 */
	protected static final Environment ENVIRONMENT_EDEFAULT = Environment.KUBERNETES;

	/**
	 * The cached value of the '{@link #getEnvironment() <em>Environment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironment()
	 * @generated
	 * @ordered
	 */
	protected Environment environment = ENVIRONMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClusterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackageImpl.Literals.CLUSTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Application> getApplications() {
		if (applications == null) {
			applications = new EObjectEList<Application>(Application.class, this, ModelPackageImpl.CLUSTER__APPLICATIONS);
		}
		return applications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Host> getHosts() {
		if (hosts == null) {
			hosts = new EObjectEList<Host>(Host.class, this, ModelPackageImpl.CLUSTER__HOSTS);
		}
		return hosts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment getEnvironment() {
		return environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnvironment(Environment newEnvironment) {
		Environment oldEnvironment = environment;
		environment = newEnvironment == null ? ENVIRONMENT_EDEFAULT : newEnvironment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.CLUSTER__ENVIRONMENT, oldEnvironment, environment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void move(String application, String serviceId, String destinationHost) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackageImpl.CLUSTER__APPLICATIONS:
				return getApplications();
			case ModelPackageImpl.CLUSTER__HOSTS:
				return getHosts();
			case ModelPackageImpl.CLUSTER__ENVIRONMENT:
				return getEnvironment();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackageImpl.CLUSTER__APPLICATIONS:
				getApplications().clear();
				getApplications().addAll((Collection<? extends Application>)newValue);
				return;
			case ModelPackageImpl.CLUSTER__HOSTS:
				getHosts().clear();
				getHosts().addAll((Collection<? extends Host>)newValue);
				return;
			case ModelPackageImpl.CLUSTER__ENVIRONMENT:
				setEnvironment((Environment)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackageImpl.CLUSTER__APPLICATIONS:
				getApplications().clear();
				return;
			case ModelPackageImpl.CLUSTER__HOSTS:
				getHosts().clear();
				return;
			case ModelPackageImpl.CLUSTER__ENVIRONMENT:
				setEnvironment(ENVIRONMENT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackageImpl.CLUSTER__APPLICATIONS:
				return applications != null && !applications.isEmpty();
			case ModelPackageImpl.CLUSTER__HOSTS:
				return hosts != null && !hosts.isEmpty();
			case ModelPackageImpl.CLUSTER__ENVIRONMENT:
				return environment != ENVIRONMENT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (environment: ");
		result.append(environment);
		result.append(')');
		return result.toString();
	}

} //ClusterImpl
package com.registration.soap.service;

public class RegistrationServiceAPIProxy implements com.registration.soap.service.RegistrationServiceAPI {
  private String _endpoint = null;
  private com.registration.soap.service.RegistrationServiceAPI registrationServiceAPI = null;
  
  public RegistrationServiceAPIProxy() {
    _initRegistrationServiceAPIProxy();
  }
  
  public RegistrationServiceAPIProxy(String endpoint) {
    _endpoint = endpoint;
    _initRegistrationServiceAPIProxy();
  }
  
  private void _initRegistrationServiceAPIProxy() {
    try {
      registrationServiceAPI = (new com.registration.soap.service.RegistrationServiceImplementaionServiceLocator()).getRegistrationServiceImplementaionPort();
      if (registrationServiceAPI != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)registrationServiceAPI)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)registrationServiceAPI)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (registrationServiceAPI != null)
      ((javax.xml.rpc.Stub)registrationServiceAPI)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.registration.soap.service.RegistrationServiceAPI getRegistrationServiceAPI() {
    if (registrationServiceAPI == null)
      _initRegistrationServiceAPIProxy();
    return registrationServiceAPI;
  }
  
  public java.lang.String registerUser(com.registration.soap.service.RegisterUserTO arg0) throws java.rmi.RemoteException{
    if (registrationServiceAPI == null)
      _initRegistrationServiceAPIProxy();
    return registrationServiceAPI.registerUser(arg0);
  }
  
  
}
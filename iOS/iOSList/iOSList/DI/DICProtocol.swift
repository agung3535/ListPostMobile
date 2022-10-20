//
//  HomeDICProtocol.swift
//  iOSList
//
//  Created by Putra on 20/10/22.
//

import Foundation

protocol DICProtocol {
    func register<Service>(type: Service.Type, component: Any)
    func resolve<Service>(type: Service.Type) -> Service?
}

final class DIContainer: DICProtocol {
    
    static let shared = DIContainer()
    
    private init() {}
    
    var services: [String: Any] = [:]
    
    func register<Service>(type: Service.Type, component: Any) {
        services["\(type)"] = component
    }
    
    func resolve<Service>(type: Service.Type) -> Service? {
        return services["\(type)"] as? Service
    }
    
    
}

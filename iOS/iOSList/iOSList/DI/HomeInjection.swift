//
//  HomeInjection.swift
//  iOSList
//
//  Created by Putra on 20/10/22.
//

import Foundation


class HomeInjection: NSObject {
    func setHomeContainer() {
        let container = DIContainer.shared
        container.register(type: PHomeDataSource.self, component: HomeDataSource())
        container.register(type: PHomeRepository.self, component: HomeRepository(source: container.resolve(type: PHomeDataSource.self)!))
        container.register(type: PHomeInteractor.self, component: HomeInteractor(repo: container.resolve(type: PHomeRepository.self)!))
    }
    
    func provideHomeInteractor() -> PHomeInteractor {
        let homeSource: PHomeDataSource = HomeDataSource()
        let homeRepo: PHomeRepository = HomeRepository(source: homeSource)
        let homeInteractor: PHomeInteractor = HomeInteractor(repo: homeRepo)
        return homeInteractor
    }
}

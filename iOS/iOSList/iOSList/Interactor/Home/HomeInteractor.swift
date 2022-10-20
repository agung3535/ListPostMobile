//
//  HomeInteractor.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation
import Combine

class HomeInteractor: PHomeInteractor {
    
    private let repo: PHomeRepository
    
    init(repo: PHomeRepository) {
        self.repo = repo
    }
    
    func getAllPost() -> AnyPublisher<[PostModel], Error> {
        print("di panggil interactor")
        return repo.getAllPost()
    }
    
    
    
    
    
}

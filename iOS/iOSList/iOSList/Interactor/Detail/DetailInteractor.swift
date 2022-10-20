//
//  DetailInteractor.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation
import Combine

class DetailInteractor: PDetailInteractor {
    
    private var repo: PDetailRepository
    
    init(repo: PDetailRepository) {
        self.repo = repo
    }
    
    func getDetailPost(id: Int) -> AnyPublisher<PostModel, Error> {
        return repo.getDetailPost(id: id)
    }
    
    
}

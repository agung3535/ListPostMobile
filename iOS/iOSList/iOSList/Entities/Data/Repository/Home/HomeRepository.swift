//
//  HomeRepository.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation
import Combine

class HomeRepository: PHomeRepository {
    
     private let source: PHomeDataSource
    
    init(source: PHomeDataSource) {
        self.source = source
    }
    
    func getAllPost() -> AnyPublisher<[PostModel], Error> {
    
        print("dipanggil repo")
        return source.getAllPost()
            .map { Mapper.mapPosResToModel(data: $0) }.eraseToAnyPublisher()

    }
    
    
}

//
//  DetailRepository.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation
import Combine


class DetailRepository: PDetailRepository {
    
    private let remoteSource: PDetailDataSource
    
    init(remoteSource: PDetailDataSource) {
        self.remoteSource = remoteSource
    }
    
    func getDetailPost(id: Int) -> AnyPublisher<PostModel, Error> {
        
        
        return remoteSource.getDetail(id: id)
            .map { Mapper.mapPosDetailToModel(data: $0)}
            .eraseToAnyPublisher()

    }
    
    
}

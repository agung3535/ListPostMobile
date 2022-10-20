//
//  Mapper.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation


final class Mapper {
    
    
    static func mapPosResToModel(data: [PostReponseData]) -> [PostModel] {
        return data.map {
            return PostModel(userID: $0.userID, id: $0.id, title: $0.title, body: $0.body)
        }
    }
    
    static func mapPosDetailToModel(data: PostReponseData) -> PostModel {
        return PostModel(userID: data.userID, id: data.id, title: data.title, body: data.body)
    }
    
}

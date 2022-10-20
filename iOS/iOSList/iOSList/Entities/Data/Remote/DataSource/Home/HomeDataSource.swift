//
//  HomeDataSource.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation
import Combine

class HomeDataSource: PHomeDataSource {
    func getAllPost() -> AnyPublisher<[PostReponseData], Error> {
        print("dipanggil response")
        return Future<[PostReponseData], Error> { completion in
            APIService.shared.requestResource(serviceURL: RouteAPI.GetPost.url, httpMethod: .GET, parameters: [:], decode: [PostReponseData].self, completion: { response, error in
                if response != nil {
                    completion(.success(response!))
                }else if error != nil {
                    completion(.failure(error!))
                }
            })
            
        }.eraseToAnyPublisher()
    }
    
    
}

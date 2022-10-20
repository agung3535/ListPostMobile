//
//  PDetailRepository.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation
import Combine


protocol PDetailRepository: AnyObject {
    func getDetailPost(id: Int) -> AnyPublisher<PostModel, Error>
}

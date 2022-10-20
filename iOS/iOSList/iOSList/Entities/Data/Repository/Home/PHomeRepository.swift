//
//  PHomeRepository.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation
import Combine

protocol PHomeRepository: AnyObject {
    func getAllPost() -> AnyPublisher<[PostModel], Error>
}

//
//  PHomeDataSource.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation
import Combine

protocol PHomeDataSource: AnyObject {
    func getAllPost() -> AnyPublisher<[PostReponseData], Error>
}

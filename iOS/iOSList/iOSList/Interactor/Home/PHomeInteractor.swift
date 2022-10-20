//
//  PHomeInteractor.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation
import Combine

protocol PHomeInteractor: AnyObject {
    func getAllPost() -> AnyPublisher<[PostModel], Error>
}

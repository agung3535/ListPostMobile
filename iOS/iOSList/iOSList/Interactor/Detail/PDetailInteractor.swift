//
//  PDetailInteractor.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation
import Combine


protocol PDetailInteractor: AnyObject {
    func getDetailPost(id: Int) -> AnyPublisher<PostModel, Error>
}


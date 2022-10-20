//
//  PDetailDataSource.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation
import Combine

protocol PDetailDataSource:AnyObject {
    func getDetail(id: Int) -> AnyPublisher<PostReponseData, Error>
}

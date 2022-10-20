//
//  PostResponse.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation


struct PostReponseData: Codable {
    let userID, id: Int
    let title, body: String?

    enum CodingKeys: String, CodingKey {
        case userID = "userId"
        case id, title, body
    }
}

typealias PostReponse = [PostReponseData]

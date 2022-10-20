//
//  PostModel.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation


struct PostModel: Equatable, Identifiable {
    let userID, id: Int?
    let title, body: String?
}

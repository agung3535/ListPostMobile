//
//  RouteAPI.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation


enum RouteAPI {
    case GetPost
    case GetDetailPost(String)
    
    var url: String {
        switch self {
        case .GetPost:
            return "posts"
        case .GetDetailPost(let string):
            return "posts/\(string)"
        }
    }
}

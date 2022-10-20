//
//  ErrorHelper.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation


enum ErrorHelper: Error {
    case decodedFailed
    case unknownError(String)
    
    var errDesc: String? {
        switch self {
        case .decodedFailed:
            return "Error decoded object"
        case .unknownError(let string):
            return string
        }
    }
}

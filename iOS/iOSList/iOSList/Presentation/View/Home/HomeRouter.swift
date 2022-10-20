//
//  HomeRouter.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation
import SwiftUI

class HomeRouter {
    func navToDetailPage(postData: PostModel) -> some View {
        let container = DIContainer.shared
        container.register(type: PDetailDataSource.self, component: DetailDataSource())
        container.register(type: PDetailRepository.self, component: DetailRepository(remoteSource: container.resolve(type: PDetailDataSource.self)!))
        container.register(type: PDetailInteractor.self, component: DetailInteractor(repo: container.resolve(type: PDetailRepository.self)!))
        return DetailPage(detailViewModel: DetailViewModel(), postId: postData.id!)
            .navigationTitle("Detail Post")
            .navigationBarTitleDisplayMode(.inline)
           
    }
}

//
//  HomeViewModel.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation
import Combine
import SwiftUI

class HomeViewModel: ObservableObject {
    
    private var interactor: PHomeInteractor
    @Published var listPost = [PostModel]()
    @Published var errorMsg = ""
    @Published var loadingState = true
    private var cancelables = Set<AnyCancellable>()
    init(interactor: PHomeInteractor) {
        self.interactor = interactor
    }
    
    
    func getAllPos() {
        print("di panggil")
        interactor.getAllPost()
            .receive(on: RunLoop.main)
            .sink(receiveCompletion: { [weak self] completion in
                guard let self = self else {return}
                switch completion {
                case .finished:
                    self.loadingState = false
                case .failure(let error):
                    self.loadingState = false
                    self.errorMsg = String(describing: completion)
                }
            }, receiveValue: { [weak self] result in
                guard let self = self else { return }
                self.listPost = result
            }).store(in: &cancelables)
    }
    
    
    func linkBuilder<Content: View> (
        for post: PostModel,
        @ViewBuilder content: () -> Content
    ) -> some View {
        NavigationLink(destination: HomeRouter().navToDetailPage(postData: post)) {
            content()
        }
    }
    
}

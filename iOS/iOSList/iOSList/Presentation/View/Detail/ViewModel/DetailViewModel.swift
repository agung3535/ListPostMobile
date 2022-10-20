//
//  DetailViewModel.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import Foundation
import Combine

class DetailViewModel: ObservableObject {
    
    private let interactor: PDetailInteractor
    private var cancelables = Set<AnyCancellable>()
    @Published var dataPost: PostModel = PostModel(userID: nil, id: nil, title: nil, body: nil)
    @Published var loadingState = true
    @Published var errMsg = ""
    
    init(interactor: PDetailInteractor = DIContainer.shared.resolve(type: PDetailInteractor.self)!) {
        self.interactor = interactor
    }
    
    func getDetailPost(id: Int) {
        print("detail panggil = \(id)")
        interactor.getDetailPost(id: id)
            .receive(on: RunLoop.main)
            .sink(receiveCompletion: {[weak self] completion in
                guard let self = self else { return }
                switch completion {
                    
                case .finished:
                    self.loadingState = false
                case .failure(_):
                    print("masuk failure")
                    self.loadingState = false
                    self.errMsg = String(describing: completion)
                }
            }) { [weak self] result in
                guard let self = self else { return }
                self.dataPost = result
            }.store(in: &cancelables)
    }
    
    
    
    
}

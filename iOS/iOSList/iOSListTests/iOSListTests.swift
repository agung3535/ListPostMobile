//
//  iOSListTests.swift
//  iOSListTests
//
//  Created by Putra on 19/10/22.
//

import XCTest
import Combine
@testable import iOSList

class iOSListTests: XCTestCase {


    var homeInteractor: PHomeInteractor!
    var detailInteractor: PDetailInteractor!
    var cancelables: Set<AnyCancellable> = []
    
    override func setUp() {
        super.setUp()
        HomeInjection.init().setHomeContainer()
        let container = DIContainer.shared
        container.register(type: PDetailDataSource.self, component: DetailDataSource())
        container.register(type: PDetailRepository.self, component: DetailRepository(remoteSource: container.resolve(type: PDetailDataSource.self)!))
        container.register(type: PDetailInteractor.self, component: DetailInteractor(repo: container.resolve(type: PDetailRepository.self)!))
        homeInteractor = DIContainer.shared.resolve(type: PHomeInteractor.self)!
        detailInteractor = DIContainer.shared.resolve(type: PDetailInteractor.self)!
    }
    
    override class func tearDown() {
        super.tearDown()
    }
    
    func testGetAllPost() {
        let exp = expectation(description: "wait for result")
        var dataTes = [PostModel]()
        
        homeInteractor.getAllPost()
            .sink(receiveCompletion: { _ in
                exp.fulfill()
            }) { data in
                dataTes.append(data.first!)
            }.store(in: &cancelables)
        

        wait(for: [exp], timeout: 3)
        
        XCTAssertNotNil(dataTes)
        XCTAssertTrue(dataTes.count != 0)
        XCTAssertEqual(dataTes.count, 1)
    }
    
    func testDetail() {
        let exp = expectation(description: "wait for result")
        var dataTes = [PostModel]()
        detailInteractor.getDetailPost(id: 1).sink { _ in
            exp.fulfill()
        } receiveValue: { data in
            dataTes.append(data)
        }.store(in: &cancelables)
        wait(for: [exp], timeout: 3)
        
        XCTAssertNotNil(dataTes)
        XCTAssertTrue(dataTes.count != 0)
        XCTAssertEqual(dataTes.count, 1)
        XCTAssertEqual(dataTes.first?.id, 1)

    }
    

}


//
//  iOSListApp.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import SwiftUI

@main
struct iOSListApp: App {
    var body: some Scene {
        WindowGroup {
            let homeViewModel = HomeViewModel(interactor: HomeInjection.init().provideHomeInteractor())
            ContentView()
                .environmentObject(homeViewModel)
        }
    }
}

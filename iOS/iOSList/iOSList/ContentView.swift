//
//  ContentView.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import SwiftUI

struct ContentView: View {
    @EnvironmentObject var homeviewModel: HomeViewModel
    var body: some View {
        NavigationView {
            HomePage(homeViewModel: homeviewModel)
                .navigationTitle("")
                .navigationBarHidden(true)
        }
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

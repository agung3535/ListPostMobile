//
//  HomePage.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import SwiftUI

struct HomePage: View {
    @State var searchText = ""
    @State var isSearching = false
    
    @ObservedObject var homeViewModel: HomeViewModel
    var body: some View {
        ZStack {
            VStack {
                SearchComponent(searchText: $searchText, isSearching: $isSearching)
                ScrollView {
                    LazyVStack {
                        ForEach(homeViewModel.listPost.filter({(data: PostModel) -> Bool in
                            return (data.title?.lowercased().hasPrefix(searchText.lowercased()))! || searchText == ""
                        }),id: \.id) {  value in

                            self.homeViewModel.linkBuilder(for: value, content: {
                                ListPostComponent(title: value.title ?? "No title")
                            })
                        }
                    }
                }
            }
        }.onAppear {
         
            homeViewModel.getAllPos()
        }
        
    }
}

//struct HomePage_Previews: PreviewProvider {
//    static var previews: some View {
//        HomePage()
//    }
//}

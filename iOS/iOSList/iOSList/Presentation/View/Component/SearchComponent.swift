//
//  SearchComponent.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import SwiftUI

struct SearchComponent: View {
    @Binding var searchText: String
    @Binding var isSearching: Bool
    var body: some View {
        ZStack {
            HStack {
                Image(systemName: "magnifyingglass")
                    .foregroundColor(.white)
                TextField("Search title", text: $searchText) { textEdit in
                    
                    if textEdit {
                        withAnimation {
                            isSearching = true
                        }
                    }
                    
                } onCommit: {
                    withAnimation {
                        isSearching = false
                    }
                }
                .foregroundColor(.white)
                
            }
        }
        .frame(width: .infinity, height: 50)
        .background(Color.cyan)
    }
}

struct SearchComponent_Previews: PreviewProvider {
    
    static var previews: some View {
        SearchComponent(searchText: .constant(""), isSearching: .constant(false))
    }
}

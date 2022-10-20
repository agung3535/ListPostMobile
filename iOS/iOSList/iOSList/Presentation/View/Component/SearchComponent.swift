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
                    
                    if textEdit || searchText != "" {
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
                if isSearching {
                    Button(action: {
                        searchText = ""
                        isSearching = false
                        UIApplication.shared.dismissKeyboard()
                    }, label: {
                        Image(systemName: "xmark.circle.fill")
                            .resizable()
                            .foregroundColor(.white)
                            .frame(width: 30, height: 30, alignment: .center)
                            .padding(5)
                    })
                }
               
            }
        }
        .frame(height: 50)
        .background(Color.cyan)
    }
}

extension UIApplication {
    func dismissKeyboard() {
      sendAction(#selector(UIResponder.resignFirstResponder), to: nil, from: nil, for: nil)
    }
}

struct SearchComponent_Previews: PreviewProvider {
    
    static var previews: some View {
        SearchComponent(searchText: .constant(""), isSearching: .constant(false))
    }
}

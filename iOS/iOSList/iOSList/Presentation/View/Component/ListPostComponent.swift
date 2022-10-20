//
//  ListPostComponent.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import SwiftUI

struct ListPostComponent: View {
    @State var title = "Test Title"
    var body: some View {
        ZStack {
            Text(title)
                .frame(minWidth: 0, maxWidth: .infinity, alignment: .leading)
                .padding()
                .foregroundColor(Color("TextColor"))
                .background(Color("ItemBackground"))
                .background(in: RoundedRectangle(cornerRadius: 15))
                .multilineTextAlignment(.leading)
                

        }
        .clipShape(RoundedRectangle(cornerRadius: 15))
        .shadow(color: .gray, radius: 1, x: 0, y: 0)
        .padding(EdgeInsets(top: 5, leading: 15, bottom: 5, trailing: 15))
    }
}

struct ListPostComponent_Previews: PreviewProvider {
    static var previews: some View {
        ListPostComponent()
    }
}

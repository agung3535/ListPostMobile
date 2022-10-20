//
//  DetailPage.swift
//  iOSList
//
//  Created by Putra on 19/10/22.
//

import SwiftUI

struct DetailPage: View {
    @ObservedObject var detailViewModel: DetailViewModel
    @State var postId = -1
    var body: some View {
        ZStack {
            VStack(spacing: 10) {
                Text(detailViewModel.dataPost.title ?? "This Post don't have title")
                    .frame(minWidth: 0, maxWidth: .infinity, alignment: .center)
                    .background()
                Text(detailViewModel.dataPost.body ?? "No Description")
                    .font(.system(size: 12))
                    .frame(minWidth: 0, maxWidth: .infinity, alignment: .leading)
                    .padding()
                    .overlay(RoundedRectangle(cornerRadius: 10)
                        .stroke(.blue, lineWidth: 1))
                    .padding()
                Spacer()
            }.frame(minWidth: 0, maxWidth: .infinity)
        }.frame(minWidth: 0, maxWidth: .infinity)
            .onAppear {
                detailViewModel.getDetailPost(id: postId)
            }
    }
}

//struct DetailPage_Previews: PreviewProvider {
//    static var previews: some View {
//        DetailPage().environmentObject()
//    }
//}

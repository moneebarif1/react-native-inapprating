import Foundation
import StoreKit
import SwiftUI

@objc(Inapprating)
class Inapprating: NSObject {


  @objc(ratingReview:withRejecter:)
  func ratingReview(resolve:RCTPromiseResolveBlock,reject:RCTPromiseRejectBlock) -> Void {
      if #available(iOS 14.0, *) {
              if let scene = UIApplication.shared.connectedScenes.first(where: { $0.activationState == .foregroundActive }) as? UIWindowScene {
                  SKStoreReviewController.requestReview(in: scene)
                  resolve("true");
              } else {
                reject("25","SCENE_NOT_FOUND",nil);
              }
          } else if #available(iOS 10.3, *) {
              SKStoreReviewController.requestReview()
              resolve("true");
          } else {
              reject("21","ERROR_DEVICE_VERSION",nil);
          }
  }
}

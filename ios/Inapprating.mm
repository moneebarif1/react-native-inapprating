#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(Inapprating, NSObject)

RCT_EXTERN_METHOD(ratingReview:(RCTPromiseResolveBlock)resolve
                 withRejecter:(RCTPromiseRejectBlock)reject)

+ (BOOL)requiresMainQueueSetup
{
  return NO;
}

@end

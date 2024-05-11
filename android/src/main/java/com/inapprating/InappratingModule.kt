package com.inapprating

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import com.google.android.play.core.review.ReviewException
import com.google.android.play.core.review.ReviewManagerFactory
import com.google.android.play.core.review.model.ReviewErrorCode

class InappratingModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  val manager = ReviewManagerFactory.create(reactContext)

  override fun getName(): String {
    return NAME
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  fun ratingReview(promise: Promise) {
    try {
      val request = manager.requestReviewFlow()
      request.addOnCompleteListener { task ->
        if (task.isSuccessful) {
          // We got the ReviewInfo object
          val reviewInfo = task.result
          currentActivity?.let { manager.launchReviewFlow(it, reviewInfo) }?.addOnCompleteListener { _ ->
            promise.resolve("true")
          }
        } else {
          // There was some problem, log or handle the error code.
          @ReviewErrorCode val reviewErrorCode = (task.getException() as? ReviewException)?.errorCode
          promise.reject("Error")
        }
      }
    }catch(ex: Exception){
      promise.reject(ex)
    }
  }

  companion object {
    const val NAME = "Inapprating"
  }
}

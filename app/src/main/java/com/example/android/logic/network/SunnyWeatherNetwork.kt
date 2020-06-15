package com.example.android.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SunnyWeatherNetwork {
    private val placeService = ServiceCreator.create<PlaceService>() // PlaceService接口的动态代理对象

    suspend fun searchPlace(query: String) = placeService.searchPlace(query).await()

    private suspend fun <T> Call<T>.await(): T { // 利用suspendCoroutine简化回调函数

        return suspendCoroutine { continuation -> // 挂起当前协程，在普通线程中执行lambda中的逻辑
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t) // 失败调用，恢复被挂起的协程
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body) // 恢复挂起的协程
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }

            })
        }
    }
}
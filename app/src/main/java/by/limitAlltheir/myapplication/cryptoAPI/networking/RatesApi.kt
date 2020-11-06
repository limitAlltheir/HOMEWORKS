package by.limitAlltheir.myapplication.cryptoAPI.networking

import by.limitAlltheir.myapplication.cryptoAPI.dto.RatesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RatesApi {

    @GET("cryptocurrency/listings/latest")
    fun getRatesAsync(
        @Query("start")
        start: Int,
        @Query("limit")
        limit: Int,
        @Query("convert")
        convert: String
    ) : Deferred<Response<RatesResponse>>
}